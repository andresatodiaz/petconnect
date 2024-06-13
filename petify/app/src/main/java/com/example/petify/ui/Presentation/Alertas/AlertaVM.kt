package com.example.petify.ui.Presentation.Alertas

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Presentation.Emergencias.EmergenciaItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlertaVM @Inject constructor():ViewModel() {
    val alertaItems= mutableStateListOf<AlertaItem>(
        AlertaItem(
            titulo = "Perritos en necesidad de cirugía",
            descripcion = "Perritos en necesidad de cirugía \uD83D\uDC36\uD83D\uDC94: ¡Ayúdanos a cambiar sus vidas!\n" +
                    "\n" +
                    "En Cajamarca, muchos perritos sufren de enfermedades o lesiones que requieren cirugías urgentes. \uD83C\uDFE5 Estos pequeños héroes necesitan nuestra ayuda para tener una segunda oportunidad y vivir una vida plena y feliz. \uD83D\uDE4F\n" +
                    "\n" +
                    "¿Cómo puedes ayudar?\n" +
                    "\n" +
                    "Apadrina una cirugía: Tu donación puede cubrir los costos de la operación y cuidados postoperatorios de un perrito necesitado. \uD83D\uDC3E❤️\n" +
                    "Difunde la voz: Comparte nuestras publicaciones en redes sociales para que más personas conozcan la situación de estos perritos y se sumen a nuestra causa. \uD83D\uDCE3\n" +
                    "Ofrece tu hogar temporal: Si tienes espacio y tiempo, puedes brindar un hogar temporal a un perrito en recuperación. \uD83C\uDFE1\uD83D\uDC95\n" +
                    "Dona insumos: Necesitamos medicamentos, alimentos especiales, materiales de curación y otros insumos para cuidar de ellos. \uD83D\uDC8A\uD83E\uDD6B\n" +
                    "Sé voluntario: ¡Únete a nuestro equipo de voluntarios y ayúdanos a cuidar de estos perritos! \uD83D\uDE4C\n" +
                    "Cada aporte cuenta:\n" +
                    "\n" +
                    "Tu ayuda, por pequeña que parezca, puede marcar una gran diferencia en la vida de un perrito. Juntos podemos cambiar su destino y darles la oportunidad de correr, jugar y amar como se merecen. \uD83E\uDD70\n" +
                    "\n" +
                    "¡Únete a nuestra misión de salvar vidas! \uD83D\uDC3E\uD83D\uDC96\n" +
                    "\n" +
                    "#PerritosEnNecesidad #CirugíasQueSalvanVidas #AdoptaNoCompres #AmorPerruno",
            autor = "Papu Gómez",
            banner= R.drawable.alerta1,
            distance = 3.1,
            categoria = "Recaudación"
        ),
        AlertaItem(
            titulo = "Gato pérdido en CentroCAX",
            descripcion = "¡Michi perdido en Miraflores! \uD83D\uDE3F ¡Ayúdanos a encontrar a Manny!\n" +
                    "\n" +
                    "Manny, nuestro querido felino de gris y ojos verdes, se ha extraviado en el distrito de Miraflores. \uD83D\uDE3F Es un gato peludo muy cariñoso y juguetón que responde al llamado de \"nene\". \uD83D\uDC3E\n" +
                    "\n" +
                    "Se perdió cerca de [Lugar donde se perdió] el [Fecha de desaparición]. Si lo has visto o tienes alguna pista sobre su paradero, por favor comunícate con nosotros al [Número de teléfono] o [Correo electrónico]. \uD83D\uDE4F Cualquier información, por pequeña que sea, nos será de gran ayuda.\n" +
                    "\n" +
                    "¡Comparte esta publicación y ayúdanos a traer a [Nombre del gato] de vuelta a casa! \uD83C\uDFE1❤️\n" +
                    "\n" +
                    "#GatoPerdido #Miraflores #MichiExtraviado #AyúdanosAEncontrarlo",
            autor="Wazan Bandi",
            banner = R.drawable.alerta2,
            distance = 2.5,
            categoria = "Pérdida"
        )
    )
    val selectedItem = mutableStateOf(AlertaItem())

    fun getDetail(alerta: AlertaItem){
        selectedItem.value=alerta
    }

    fun addAlerta(alertaItem: AlertaItem,navController: NavController){
        if(!alertaItems.contains(alertaItem)){
            alertaItems.add(0,alertaItem)
            navController.navigate("home")
        }
    }
}