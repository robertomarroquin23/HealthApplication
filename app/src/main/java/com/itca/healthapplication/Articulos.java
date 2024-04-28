package com.itca.healthapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Articulos extends AppCompatActivity {


    TextView titulo , parrafo;
    ImageView imagenart;

   ImageView btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

titulo= findViewById(R.id.titulo);
parrafo = findViewById(R.id.parrafo);
imagenart = findViewById(R.id.imagenart);
btn_regresar= findViewById(R.id.btn_regresar);

        Intent intent = getIntent();
        String Articulo = intent.getStringExtra("Articulo");
        String parrafos = intent.getStringExtra("Consejo");
        String llenadoparrafo= " ";
       switch (Articulo)
       {
           case "Beneficios del ejercicio físico":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.ejercicio);
               llenadoparrafo = "Hacer actividad física regularmente es una de las cosas más importantes que puedes hacer por tu salud.\n" +
                       "\n" +
                       "Todos pueden beneficiarse de la actividad física, no importa su edad, habilidades, etnicidad o la forma y tamaño de su cuerpo.\n" +
                       "\n" +
                       "Si no estás seguro de cómo comenzar o aumentar tu nivel de actividad física porque tienes miedo a lastimarte, hay buenas noticias:\n" +
                       "la actividad aeróbica moderada, como caminar rápidamente, en general es segura para la mayoría de las personas.";

              parrafo.setText(llenadoparrafo);
               break;

           case "La alimentación en la salud cardiovascular":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.dieta);
               llenadoparrafo = "Una dieta adecuada puede retrasar y ayudar a controlar los principales factores de riesgo cardiovascular: obesidad, hipertensión, diabetes e hipercolesterolemia.\n" +
                       "\n" +
                       "Practicar ejercicio moderado, evitando así el sedentarismo, es un hábito de vida cardiosaludable, capaz de evitar el desarrollo de las enfermedades cardiovasculares.\n" +
                       "\n" +
                       "En pacientes que ya han padecido un accidente cardiovascular, la alimentación adecuada es esencial para mejorar su pronóstico y evitar recaídas o complicaciones. \n" +
                       "\n" +
                       "La obesidad, el colesterol y la hipertensión son algunos de los principales factores de riesgo que intervienen en las enfermedades cardiovasculares y que pueden controlarse a través de la alimentación.\n" +
                       "\n" +
                       "Los buenos hábitos de vida, entre los que la influencia de la alimentación resulta fundamental, previenen las enfermedades del corazón. “Las pautas alimentarias cardiosaludables incluyen la ingesta de fruta y verdura diaria, aceite de oliva, pescados y productos bajos en grasa: aves sin piel ni grasa, carnes magras”, señala la Dra. Nieves Tarín, cardióloga de la Fundación Española del Corazón (FEC), en el marco de las XIII Jornadas Nacionales de Nutrición Práctica que se celebran estos días en el Colegio de Médicos de Madrid y que analizan las últimas tendencias en nutrición y alimentación.";

               parrafo.setText(llenadoparrafo);
               break;
           case "Técnicas de manejo de estrés y ansiedad:":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.manejoestres);
               llenadoparrafo = "1.Practicar ejercicio físico\n" +
                       "\n" +
                       "Coincido plenamente con John F. Kennedy cuando afirmaba que «la salud física no es solo una de las más importantes claves para un cuerpo saludable, sino el fundamento de la actividad intelectual creativa y dinámica». El desarrollo y el mantenimiento de un buen estado físico tiene efectos muy positivos en la prevención del estrés. Para ello es aconsejable la realización de ejercicio de manera habitual ya que, además de aumentar la resistencia física del individuo a los efectos del estrés, potencia la resistencia psicológica.\n"+"\n 2. Dieta adecuada\n" +
                       "\n" +
                       "El desarrollo de buenos hábitos alimenticios que condicionan el estado nutricional del individuo constituye una medida aconsejable para la prevención del estrés. Las demandas energéticas que recibimos actualmente de nuestro entorno determinan la necesidad de mantener un equilibrio energético adecuado para responder a esas demandas y no desarrollar problemas carenciales.\n"+"\n 3. Desensibilización sistemática\n" +
                       "\n" +
                       "Con esta técnica se intenta controlar las reacciones de ansiedad o miedo ante situaciones que resultan amenazadoras para un individuo. Se fundamenta en la relajación progresiva de Jacobson, que consiste en adiestrar al individuo en la realización de ejercicios físicos de contracción-relajación. Esta acción le permitirá conocer el estado de tensión de cada parte de su cuerpo y tener recursos para relajar dichas zonas cuando se tensen.\n"+"\n 4. Técnicas de relajación física\n" +
                       "\n" +
                       "Las más utilizadas son la relajación progresiva de Jacobson y el entrenamiento autógeno de Schultz. Estas técnicas intentan aprovechar la conexión directa entre el cuerpo y la mente, la existencia de una interdependencia entre la tensión psicológica y la física. Dicho de otro modo, no es posible estar relajado físicamente mientras se sufre tensión emocional. Según las teorías que inspiran estas técnicas, las personas pueden aprender a reducir sus niveles de tensión psicológica (emocional) a través de la relajación física, aun cuando persista la situación que origina la tensión.\n"+"5. Técnicas de control de la respiración\n" +
                       "\n" +
                       "Las situaciones de estrés provocan habitualmente una respiración rápida y superficial, lo que implica un uso reducido de la capacidad funcional de los pulmones, una peor oxigenación, un mayor gasto y un aumento de la tensión general del organismo. Las técnicas de control de la respiración facilitan al individuo el aprendizaje de una forma adecuada de respirar bien para que, en una situación de estrés, pueda controlar la respiración de manera automática.\n"+"\n6. Técnicas de relajación mental y meditación\n" +
                       "\n" +
                       "La práctica de la meditación estimula cambios fisiológicos de gran valor para el organismo. Pretenden que la persona sea capaz de desarrollar sistemáticamente una serie de actividades, perceptivas y/o conductuales, que le permitan concentrar su atención en esas actividades y desconectar de la actividad mental cotidiana del individuo aquello que puede resultarle una fuente de estrés.";

               parrafo.setText(llenadoparrafo);
               break;


           case "Importancia del sueño para la salud general":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.dormir);
               llenadoparrafo = "Por qué necesita dormir\n" +
                       "\n" +
                       "Dormir le da al cuerpo y al cerebro tiempo para recuperarse del estrés del día. Después de una buena noche de sueño, usted se desempeña mejor y es mejor para tomar decisiones. Dormir lo ayuda a sentirse más alerta, optimista y a tener una mejor relación con las personas. Dormir también ayuda al cuerpo a combatir enfermedades.\n" +
                       "Cuántas horas de sueño necesita\n" +
                       "\n" +
                       "Diferentes personas necesitan diferentes cantidades de horas de sueño. La mayoría de los adultos necesitan de 7 a 8 horas de sueño por noche para una buena salud y funcionamiento mental. Algunos adultos necesitan hasta 9 horas de sueño por noche.\n" +
                       "Por qué podría no estar durmiendo lo suficiente\n" +
                       "\n" +
                       "Existen muchas razones por las cuales las horas de sueño son escasas.\n" +
                       "\n" +
                       "    Agenda ocupada. Las actividades nocturnas, ya sean laborales o sociales, son una de las razones principales por las que la gente no duerme lo suficiente.\n" +
                       "    Mal entorno para dormir. Es mucho más difícil obtener una buena noche de sueño en un dormitorio con mucho ruido o luz, o que es muy frío o caliente.\n" +
                       "    Electrónicos. Las tabletas y los teléfonos móviles que emiten sonidos durante la noche pueden afectar el sueño. También pueden hacer imposible desconectarse del mundo de la vigilia.\n" +
                       "    Afecciones médicas. Algunos problemas de salud pueden evitar que se consiga un sueño profundo. Estos incluyen artritis, dolor de espalda, enfermedad del corazón, y afecciones como el asma que dificultan la respiración. La depresión, la ansiedad y el abuso de sustancias también pueden dificultar que se concilie el sueño. Algunos medicamentos afectan el sueño.\n" +
                       "    Estrés por dormir. Después de varias noches de dar vueltas en la cama, el simple hecho de estar en la cama puede hacerlo sentir ansioso y despierto, incluso si se siente muy cansado. \n" +
                       "\n" +
                       "Trastornos del sueño\n" +
                       "\n" +
                       "Los problemas para dormir son una de las principales razones por las que las personas no consiguen suficientes horas de sueño. El tratamiento puede ayudar en muchos casos.\n" +
                       "\n" +
                       "    El insomnio sucede cuando usted tiene problemas para quedarse dormido o dormir toda la noche. Es el trastorno del sueño más común. El insomnio puede durar una noche, un par de semanas o meses antes de desaparecer.\n" +
                       "    La apnea del sueño es una afección en la cual la respiración se detiene durante la noche. Incluso si no lo despierta por completo, la apnea del sueño puede interrumpir el sueño profundo.\n" +
                       "    El síndrome de las piernas inquietas puede mantenerlo despierto con ganas de mover las piernas en cualquier momento de descanso. A menudo el síndrome de las piernas inquietas puede venir acompañado de sensaciones incómodas como ardor, hormigueo, comezón o una sensación de que algo avanza lentamente por las piernas.";

               parrafo.setText(llenadoparrafo);
               break;

           case "Prevención de enfermedades infecciosas":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.vacunacion);
               llenadoparrafo = "Prevenir infecciones mediante vacunas es una práctica fundamental en salud pública.\n"+"    Inmunización contra enfermedades infecciosas: Las vacunas son herramientas importantes para prevenir enfermedades infecciosas, como el sarampión, la poliomielitis, la influenza, la hepatitis, entre otras. Estas enfermedades pueden ser graves e incluso mortales en algunos casos, pero la vacunación puede ayudar a prevenirlas.\n" +
                       "\n" +
                       "    1.Funcionamiento de las vacunas: Las vacunas contienen partes debilitadas o inactivadas de los patógenos que causan enfermedades. Al introducir estas partes en el cuerpo, el sistema inmunológico reconoce los antígenos y produce una respuesta inmunitaria, que incluye la producción de anticuerpos. Estos anticuerpos permiten al cuerpo reconocer y combatir el patógeno en caso de exposición futura, lo que previene la infección o reduce su gravedad.\n" +
                       "\n" +
                       "    2.Inmunidad colectiva (o inmunidad de rebaño): La vacunación no solo protege a la persona vacunada, sino que también contribuye a proteger a la comunidad en su conjunto. Cuando una gran proporción de la población está vacunada contra una enfermedad, se reduce la propagación del patógeno, lo que proporciona protección a las personas que no pueden recibir la vacuna, como aquellos con sistemas inmunológicos debilitados o alergias a los componentes de la vacuna.\n" +
                       "\n" +
                       "    3.Calendario de vacunación: Cada país tiene un calendario de vacunación recomendado que especifica cuándo se deben administrar diferentes vacunas a lo largo de la vida, desde la infancia hasta la edad adulta. Es importante seguir este calendario para asegurar una protección óptima contra enfermedades infecciosas.\n" +
                       "\n" +
                       "    4.Seguridad y eficacia: Las vacunas pasan por rigurosos ensayos clínicos para garantizar su seguridad y eficacia antes de ser aprobadas para su uso. Los organismos reguladores de la salud, como la Administración de Alimentos y Medicamentos (FDA) en Estados Unidos, supervisan el proceso de desarrollo y autorizan el uso de vacunas que cumplen con los estándares de seguridad y eficacia.\n" +
                       "\n" +
                       "    5.Educación y conciencia: La educación pública sobre la importancia de la vacunación y la desmitificación de mitos y falsas creencias sobre las vacunas son fundamentales para aumentar las tasas de vacunación y prevenir enfermedades infecciosas.";

               parrafo.setText(llenadoparrafo);
               break;

           case "Actividad física en la tercera edad":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.ejercicioanciano);
               llenadoparrafo = "La actividad física en la tercera edad tiene una serie de beneficios importantes para la salud y el bienestar de las personas mayores. Aquí hay algunos de los principales beneficios:\n" +
                       "\n" +
                       "    1.Mejora la salud cardiovascular: La actividad física regular ayuda a fortalecer el corazón y los vasos sanguíneos, lo que reduce el riesgo de enfermedades cardíacas, hipertensión arterial y accidentes cerebrovasculares.\n" +
                       "\n" +
                       "    2.Fortalece los músculos y huesos: El ejercicio de resistencia, como levantar pesas o hacer ejercicios de fuerza, ayuda a mantener la masa muscular y ósea, lo que puede prevenir la pérdida de masa muscular (sarcopenia) y la osteoporosis.\n" +
                       "\n" +
                       "    3.Mejora la movilidad y la flexibilidad: El estiramiento y los ejercicios de flexibilidad ayudan a mantener la movilidad de las articulaciones y la flexibilidad muscular, lo que reduce el riesgo de caídas y lesiones relacionadas con la edad.\n" +
                       "\n" +
                       "    4.Controla el peso corporal: La actividad física regular ayuda a quemar calorías y mantener un peso corporal saludable, lo que reduce el riesgo de obesidad y enfermedades relacionadas, como la diabetes tipo 2.\n" +
                       "\n" +
                       "    5.Mejora la salud mental y emocional: El ejercicio libera endorfinas, sustancias químicas en el cerebro que actúan como analgésicos naturales y mejoran el estado de ánimo. También puede reducir el estrés, la ansiedad y la depresión, y mejorar la calidad del sueño.\n" +
                       "\n" +
                       "    6.Mantiene la función cognitiva: La actividad física regular se ha asociado con un menor riesgo de deterioro cognitivo y demencia en la tercera edad. El ejercicio estimula el flujo sanguíneo al cerebro, promueve la formación de nuevas conexiones neuronales y mejora la función cognitiva.\n" +
                       "\n" +
                       "    7.Fomenta la socialización: Participar en actividades físicas grupales, como clases de ejercicios o caminatas, puede proporcionar oportunidades para socializar, hacer nuevos amigos y mantenerse activo socialmente, lo que contribuye al bienestar emocional y mental.\n" +
                       "\n" +
                       "    8.Mejora la calidad de vida: En general, la actividad física en la tercera edad ayuda a mejorar la calidad de vida al aumentar la independencia funcional, promover un envejecimiento activo y saludable, y permitir a las personas mayores participar en actividades que disfrutan y les brindan satisfacción.";

               parrafo.setText(llenadoparrafo);
               break;

           case "La Salud bucal en la salud general":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.dental);
               llenadoparrafo = "La salud bucal tiene una relación directa con la salud general del organismo. Aquí hay algunas razones por las cuales la salud bucodental es importante para mantener una buena salud en general:\n" +
                       "\n1. Prevención de enfermedades sistémicas\n" +
                       "\n" +
                       "La boca es una puerta de entrada al cuerpo, y las bacterias orales pueden ingresar al torrente sanguíneo y propagarse a otras partes del organismo, causando inflamación y daño a los órganos internos.\n" +
                       "\n" +
                       "Estudios científicos han demostrado que la enfermedad periodontal, una condición grave de las encías, se ha relacionado con enfermedades sistémicas como enfermedades cardíacas, diabetes, enfermedades respiratorias y complicaciones durante el embarazo. Mantener una buena salud bucodental puede ayudar a prevenir estas enfermedades y promover una mejor salud general.\n" +
                       "\n2. Mejora la digestión y la nutrición\n" +
                       "\n" +
                       "Los dientes y las encías sanos son fundamentales para una buena digestión y nutrición. Los dientes son necesarios para masticar los alimentos correctamente, lo que facilita su digestión. Además, una boca sana permite el disfrute de una variedad de alimentos, incluyendo frutas y verduras, lo cual es esencial para una dieta equilibrada y una nutrición adecuada. Las enfermedades dentales pueden dificultar la masticación y la ingesta de alimentos, lo que puede tener un impacto negativo en la nutrición y la salud en general.\n" +
                       "\n3. Mejora la calidad de vida\n" +
                       "\n" +
                       "Una boca sana contribuye a una mejor calidad de vida. Los problemas dentales como el dolor de dientes, las infecciones y las encías inflamadas pueden afectar la capacidad de hablar, comer y disfrutar de los alimentos. Además, problemas estéticos como dientes manchados, mal aliento o falta de dientes pueden tener un impacto negativo en la confianza y autoestima de una persona, afectando su bienestar emocional y social. Mantener una buena salud bucodental puede ayudar a prevenir estos problemas y mejorar la calidad de vida en general.\n" +
                       "\n4. Ahorro a largo plazo\n" +
                       "\n" +
                       "La prevención y el tratamiento temprano de problemas dentales suelen ser más económicos que el tratamiento de problemas avanzados. Un mantenimiento adecuado de la salud bucodental, como cepillarse y usar hilo dental regularmente, visitar al dentista de manera periódica para chequeos y limpiezas, y seguir una alimentación equilibrada, puede ayudar a prevenir la aparición de problemas dentales graves que requieran procedimientos costosos, como empastes, endodoncias o tratamientos de ortodoncia. Además, mantener una boca sana puede prevenir complicaciones de salud sistémica que podrían resultar en gastos médicos adicionales.\n" +
                       "\n5. Promoción de una buena salud general\n" +
                       "\n" +
                       "Una boca sana es un componente clave de un estilo de vida saludable en general. Mantener una buena higiene oral, junto con hábitos saludables como una dieta equilibrada, ejercicio regular y evitar el consumo de tabaco y alcohol en exceso, puede contribuir a una mejor salud general. Además, una boca sana puede mejorar la calidad del sueño, ya que los problemas dentales como el bruxismo (rechinar de dientes) y la apnea del sueño pueden afectar negativamente la calidad del descanso. Una buena salud bucodental puede tener un efecto positivo en la salud general y el bienestar en general.\n" +
                       "Dale importancia a tu salud bucal\n" +
                       "\n" +
                       "La salud bucal es un aspecto importante de la salud general del organismo. Mantener una boca sana no solo implica tener una sonrisa bonita, sino que también tiene un impacto significativo en la prevención de enfermedades sistémicas, mejora la digestión y la nutrición, contribuye a una mejor calidad de vida, ahorra costes a largo plazo y promueve una buena salud en general.";

               parrafo.setText(llenadoparrafo);
               break;

           case "Importancia del descanso adecuado":

               titulo.setText(Articulo);
               imagenart.setImageResource(R.drawable.descanso);
               llenadoparrafo = "Cuando pensamos en entrenar, lo primero que nos viene a la cabeza es el ejercicio físico y el esfuerzo. Esto es cierto, y es que el ejercicio físico es clave en cualquier entrenamiento, e indispensable para conseguir los mejores resultados.\n" +
                       "\n" +
                       "Pero la realidad es que el ejercicio físico no es lo único que debemos tener en cuenta, y es que el descanso es tan importante como el ejercicio en un entrenamiento, y se muestra fundamental para favorecer la recuperación de los músculos y para conseguir un estado muscular en perfectas condiciones.\n" +
                       "\n" +
                       "Por ello, más allá de llevar a cabo una rutina de ejercicios a lo largo de la semana, el descanso desempeña un papel protagonista en cualquier entrenamiento. Es un hecho que cuanto más descansado esté nuestro cuerpo, más rendiremos en nuestros entrenamientos. Asimismo, cuanto más entrenamos y más constantes seamos, descansaremos mejor.\n"+"¿Por qué el descanso es tan importante en tu entrenamiento?\n" +
                       "\n" +
                       "Después de un duro entrenamiento, nuestro cuerpo ha consumido una gran cantidad de energía y de fuerza, y para conseguir volver a la normalidad el descanso es totalmente necesario. Y no solo eso, sino que además, cuanto más intenso sea tu entrenamiento, más descanso necesitará tu cuerpo.\n" +
                       "\n" +
                       "De hecho, después de un intenso entrenamiento, si no descansamos lo necesario, al día siguiente no rendiremos al 100%. Esto se debe principalmente a que de lo contrario, el cuerpo no conseguirá recuperarse y estará sufriendo un sobre entrenamiento la próxima vez que volvamos a entrenar, lo que aumentará enormemente las posibilidades de sufrir una lesión.\n" +
                       "\n" +
                       "Es tan importante, que muchos expertos aseguran que es mejor estar un día sin entrenar, que entrenar sin haber descansado lo suficiente, ya que de lo contrario el entrenamiento no nos dejará satisfecho, pues nos sentiremos mucho más débiles. Esto hará que no obtengamos los resultados que esperábamos, y que además tengamos un mayor riesgo a lesionarnos.";

               parrafo.setText(llenadoparrafo);
               break;
       }
       btn_regresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Articulos.this, Consejos.class);



               startActivity(intent);
           }
       });

    }




}