package com.example.petify.ui.Presentation.Servicios

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.petify.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServiciosVM @Inject constructor(

): ViewModel(){
    val serviciosItems= mutableStateListOf<ServicioItem>(
        ServicioItem(
            titulo = "Baño para mascotitas!",
            autor = "Angelo Baldwin",
            descripcion="¡Mima a tu peludo amigo con un refrescante baño en casa! Nuestro servicio de \"Baño para Mascotitas\" ofrece:\n" +
                    "\n" +
                    "\uD83D\uDCA6 Limpieza Profunda: Eliminamos la suciedad, el exceso de pelo y los malos olores, dejando a tu mascota con un pelaje suave y brillante.\n" +
                    "\n" +
                    "\uD83E\uDDF4 Productos de Calidad: Utilizamos champús y acondicionadores suaves y seguros, especialmente formulados para el cuidado de la piel y el pelo de tu mascota.\n" +
                    "\n" +
                    "\uD83D\uDEBF Experiencia Relajante: Creamos un ambiente tranquilo y relajante para que tu mascota disfrute de su baño sin estrés.\n" +
                    "\n" +
                    "\uD83E\uDDFC Atención Personalizada: Adaptamos el baño a las necesidades específicas de tu mascota, teniendo en cuenta su raza, tamaño y tipo de pelaje.\n" +
                    "\n" +
                    "\uD83D\uDC36\uD83D\uDC31 Para Perros y Gatos: Ofrecemos baños para todas las razas y tamaños de perros y gatos.\n" +
                    "\n" +
                    "\uD83C\uDFE1 Comodidad en Casa: ¡Olvídate de los viajes al salón de belleza! Nosotros vamos a tu hogar para bañar a tu mascota en su entorno familiar.\n" +
                    "\n" +
                    "✨ ¡Y mucho más! También ofrecemos servicios adicionales como corte de uñas, limpieza de oídos y cepillado de dientes.\n" +
                    "\n" +
                    "¡Agenda ahora el baño de tu mascota y dale el cariño que se merece!",
            banner= R.drawable.servicio2,
            distance = 3.1,
            stars = 4.1
        ),
        ServicioItem(
            titulo = "Paseo de perritos",
            autor="Sebas Manin",
            descripcion="¿El trabajo, los estudios o la vida diaria te impiden darle a tu perro el ejercicio que necesita? \uD83D\uDE2B ¡No te preocupes más! En PetConnect, conectamos a dueños ocupados \uD83D\uDCBC con amantes de los animales \uD83D\uDC3E que están listos para llevar a tu perro a explorar los hermosos parques y calles de Cajamarca. \uD83C\uDF33\uD83C\uDFD9️\n" +
                    "\n" +
                    "¿Por qué somos tu mejor opción?\n" +
                    "\n" +
                    "Paseadores de confianza: Nuestros paseadores son cuidadosamente seleccionados y pasan por un riguroso proceso de verificación para garantizar la seguridad y el bienestar de tu mascota. \uD83D\uDC96\n" +
                    "Paseos personalizados: Sabemos que cada perro es único. \uD83D\uDC15\u200D\uD83E\uDDBA Por eso, adaptamos cada paseo a las necesidades y energía de tu compañero, ya sea un tranquilo paseo por el parque \uD83C\uDFDE️ o una caminata más enérgica. \uD83C\uDFC3\u200D♂️\n" +
                    "Monitoreo en tiempo real: Sigue cada paso de tu perro con nuestro sistema de seguimiento GPS en tiempo real. \uD83D\uDDFA️ Recibe fotos \uD83D\uDCF8 y actualizaciones para que siempre sepas cómo se está divirtiendo. \uD83D\uDE04\n" +
                    "Seguro y protegido: Todos nuestros paseos están cubiertos por un seguro de responsabilidad civil para tu tranquilidad. \uD83D\uDEE1️\n" +
                    "Flexibilidad y comodidad: Reserva y programa paseos con facilidad a través de nuestra app. \uD83D\uDCF1 Tú eliges el día, la hora y la duración del paseo. \uD83D\uDCC5\n" +
                    "¡Dale a tu perro la felicidad que se merece! Permítenos ser tus aliados en el cuidado de tu mascota. Descarga nuestra app y regálale a tu perro la oportunidad de explorar, jugar y socializar mientras tú te ocupas de tus tareas diarias.\n" +
                    "\n" +
                    "PetConnect: ¡Porque tu perro también merece disfrutar de Cajamarca! \uD83D\uDC3E❤️",
            banner = R.drawable.servicio1,
            distance = 2.2,
            stars = 4.5
        ),
        ServicioItem(
            titulo = "Spa de mascotitas",
            autor="Lenin Panin",
            descripcion="¿Tu mascota merece un día de mimos y cuidados especiales? \uD83D\uDC3E\uD83D\uDC96 En PetConnect, ofrecemos un oasis de bienestar para perros y gatos en Cajamarca. \uD83D\uDC36\uD83D\uDC31 Nuestros servicios de spa profesionales están diseñados para consentir a tu compañero peludo y mejorar su calidad de vida. ✨\n" +
                    "\n" +
                    "Nuestros servicios incluyen:\n" +
                    "\n" +
                    "Baños relajantes: Con agua tibia \uD83D\uDCA6, champús suaves y masajes relajantes para una experiencia placentera. \uD83D\uDE0C\n" +
                    "Peluquería canina y felina: Cortes de pelo a la moda ✂️, cepillado y desenredado para un pelaje brillante y saludable. ✨\n" +
                    "Corte de uñas: Cuidado profesional para evitar lesiones y mantener las uñas de tu mascota en perfecto estado. \uD83D\uDC3E\n" +
                    "Limpieza de oídos: Higiene profunda y segura para prevenir infecciones y molestias.\uD83D\uDC42\n" +
                    "Aromaterapia y musicoterapia: Técnicas de relajación para reducir el estrés y mejorar el bienestar emocional de tu mascota. \uD83C\uDFB6\uD83D\uDE0C\n" +
                    "Tratamientos especiales: Masajes terapéuticos, baños de barro y otros servicios adicionales para consentir a tu amigo peludo. \uD83D\uDC86\u200D♀️\n" +
                    "¿Por qué elegir nuestro Spa de Mascotitas?\n" +
                    "\n" +
                    "Profesionales expertos: Nuestro equipo de peluqueros y esteticistas caninos y felinos está altamente capacitado y ama a los animales. \uD83D\uDC69\u200D⚕️❤️\n" +
                    "Productos de calidad: Utilizamos productos de primera calidad, hipoalergénicos y respetuosos con la piel y el pelaje de tu mascota. \uD83E\uDDF4\uD83C\uDF3F\n" +
                    "Ambiente relajante: Nuestras instalaciones están diseñadas para crear un ambiente tranquilo y seguro para tu mascota. \uD83E\uDDD8\u200D♀️\n" +
                    "Atención personalizada: Nos adaptamos a las necesidades individuales de cada mascota, brindando un servicio único y especial. ✨\n" +
                    "¡Regálale a tu mascota un día de spa inolvidable! Reserva tu cita ahora a través de nuestra app y descubre cómo podemos consentir a tu mejor amigo. \uD83D\uDCF2\n" +
                    "\n" +
                    "PetConnect: ¡Porque tu mascota merece lo mejor! \uD83D\uDC3E\uD83D\uDC96",
            banner = R.drawable.servicio3,
            distance = 2.5,
            stars = 4.8
        )
    )

    val selectedItem = mutableStateOf(ServicioItem())

    fun getDetail(servicio:ServicioItem){
        selectedItem.value=servicio
    }

    fun addService(service:ServicioItem,navController: NavController){
        if(!serviciosItems.contains(service)){
            serviciosItems.add(0,service)
            navController.navigate("home")
        }
    }

}