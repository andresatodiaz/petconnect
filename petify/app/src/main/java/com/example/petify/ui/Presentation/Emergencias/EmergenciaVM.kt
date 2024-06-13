package com.example.petify.ui.Presentation.Emergencias

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.petify.R
import com.example.petify.ui.Presentation.Servicios.ServicioItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmergenciaVM @Inject constructor():ViewModel() {
    val emergenciaItems= mutableStateListOf<EmergenciaItem>(
        EmergenciaItem(
            titulo = "Veterinario Manux",
            descripcion = "Veterinario Manux \uD83D\uDC3E\uD83E\uDE7A: ¡Salud y bienestar para tus peludos amigos en Cajamarca!\n" +
                    "\n" +
                    "¿Buscas atención veterinaria de calidad y confianza para tu mascota? \uD83D\uDC36\uD83D\uDC31\uD83D\uDC30 En Veterinario Manux, nos apasiona cuidar de la salud y el bienestar de tus compañeros peludos. \uD83D\uDC96\n" +
                    "\n" +
                    "Nuestros servicios incluyen:\n" +
                    "\n" +
                    "Consultas generales y especializadas: Vacunas \uD83D\uDC89, desparasitación \uD83D\uDC8A, chequeos preventivos \uD83E\uDE7A y diagnóstico de enfermedades.\n" +
                    "Cirugías: Procedimientos quirúrgicos seguros y profesionales para mejorar la calidad de vida de tu mascota.\n" +
                    "Hospitalización: Atención 24/7 ⏰ para mascotas que requieren cuidados intensivos.\n" +
                    "Laboratorio clínico: Análisis de sangre \uD83D\uDD2C, orina y otros exámenes para un diagnóstico preciso.\n" +
                    "Imagenología: Rayos X \uD83E\uDE7B y ecografías para una evaluación completa.\n" +
                    "Vacunación y desparasitación: Protección contra enfermedades infecciosas y parásitos.\n" +
                    "¿Por qué elegir a Veterinario Manux?\n" +
                    "\n" +
                    "Profesionales altamente calificados: Nuestro equipo de veterinarios cuenta con amplia experiencia y está comprometido con el bienestar de tu mascota. \uD83D\uDC69\u200D⚕️\uD83D\uDC68\u200D⚕️\n" +
                    "Tecnología de vanguardia: Contamos con equipos modernos para brindar un diagnóstico y tratamiento preciso. \uD83D\uDD2C\n" +
                    "Amor por los animales: Tratamos a cada mascota como si fuera nuestra, con cariño y dedicación. ❤️\n" +
                    "Atención personalizada: Nos tomamos el tiempo de escuchar tus preocupaciones y responder a todas tus preguntas. \uD83D\uDCAC\n" +
                    "Precios accesibles: Ofrecemos servicios de calidad a precios justos.\n" +
                    "¡Confía la salud de tu mascota a los expertos! Agenda una cita en Veterinario Manux y dale a tu amigo peludo la atención que se merece. \uD83D\uDC3E\uD83D\uDC96\n" +
                    "\n" +
                    "Veterinario Manux: ¡Tu veterinario de confianza en Cajamarca! \uD83D\uDCCD",
            autor = "Angelo Baldwin",
            banner= R.drawable.emergencia1,
            distance = 3.1,
            stars = 4.1,
            horario = "24 horas"
        ),
        EmergenciaItem(
            titulo = "Veterinario Evanon",
            descripcion = "Veterinario Evanon \uD83D\uDC36\uD83D\uDC31: ¡Tu oasis de salud y bienestar animal en Cajamarca!\n" +
                    "\n" +
                    "¿Buscas un lugar donde tu mascota sea tratada como un rey o una reina? \uD83D\uDC51 En Veterinario Evanon, entendemos que tu peludo amigo es parte de tu familia y merece lo mejor. \uD83D\uDC96 ¡Nuestro equipo de expertos veterinarios está aquí para cuidar de su salud y felicidad!\n" +
                    "\n" +
                    "Descubre un mundo de cuidados para tu mascota:\n" +
                    "\n" +
                    "Consultas y chequeos: ¡Mantén a tu amigo peludo en plena forma! \uD83E\uDE7A Ofrecemos consultas generales y especializadas para cuidar de su salud en cada etapa de su vida.\n" +
                    "Vacunas y desparasitación: Protege a tu mascota de enfermedades y parásitos con nuestros programas de vacunación y desparasitación. \uD83D\uDC89\uD83D\uDEE1️\n" +
                    "Cirugías y procedimientos: Contamos con tecnología de punta y profesionales experimentados para realizar cirugías seguras y efectivas. \uD83C\uDFE5\n" +
                    "Hospitalización y cuidados intensivos: Si tu mascota necesita atención especial, nuestro equipo estará disponible las 24 horas para brindarle los mejores cuidados. \uD83C\uDF19\n" +
                    "Laboratorio y diagnóstico: Realizamos análisis clínicos y pruebas de diagnóstico para detectar cualquier problema de salud a tiempo. \uD83D\uDD2C\n" +
                    "Nutrición y bienestar: Te asesoramos sobre la mejor alimentación y cuidados para que tu mascota tenga una vida larga y saludable. \uD83E\uDD57\n" +
                    "En Veterinario Evanon, tu mascota es nuestra prioridad:\n" +
                    "\n" +
                    "Profesionalismo y experiencia: Nuestro equipo de veterinarios altamente capacitados está comprometido con la salud y el bienestar de tu mascota. \uD83D\uDC69\u200D⚕️\uD83D\uDC68\u200D⚕️\n" +
                    "Amor y dedicación: Tratamos a cada animal con amor, paciencia y respeto, creando un ambiente relajado y seguro. \uD83E\uDD70\n" +
                    "Tecnología avanzada: Utilizamos equipos de última generación para ofrecer diagnósticos precisos y tratamientos efectivos. \uD83D\uDD2C\n" +
                    "Atención personalizada: Escuchamos tus inquietudes y te brindamos toda la información que necesitas para tomar las mejores decisiones para tu mascota. \uD83E\uDD1D\n" +
                    "¡Ven a conocernos y descubre por qué somos la mejor opción para tu mascota! En Veterinario Evanon, nos preocupamos por su salud y felicidad tanto como tú. \uD83D\uDE0A\n" +
                    "\n" +
                    "Veterinario Evanon: ¡Tu compañero en el cuidado de tu mascota! \uD83D\uDC3E❤️",
            autor="Lenin Panin",
            banner = R.drawable.emergencia2,
            distance = 2.5,
            stars = 4.8,
            horario = "6:00-23:00"
        )
    )
    val selectedItem = mutableStateOf(EmergenciaItem())

    fun getDetail(emergencia: EmergenciaItem){
        selectedItem.value=emergencia
    }

    fun addEmergencia(emergencia: EmergenciaItem,navController: NavController){
        if(!emergenciaItems.contains(emergencia)){
            emergenciaItems.add(0,emergencia)
            navController.navigate("home")
        }
    }
}