package com.itca.healthapplication.DbHealth;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DB";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: Creating database and table");
        db.execSQL(Users_table.SQL_CREATE);
        db.execSQL(Article_table.SQL_CREATE);
        preLoadData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(Article_table.SQL_DELETE);
        db.execSQL(Users_table.SQL_DELETE);
        onCreate(db);
    }

    private void preLoadData(SQLiteDatabase db) {

        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('Beneficios del ejercicio físico', 'Hacer actividad física regularmente es una de las cosas más importantes que puedes hacer por tu salud Todos pueden beneficiarse de la actividad física, no importa su edad, habilidades, etnicidad o la forma y tamaño de su cuerpo Si no estás seguro de cómo comenzar o aumentar tu nivel de actividad física porque tienes miedo a lastimarte, hay buenas noticias la actividad aeróbica moderada, como caminar rápidamente, en general es segura para la mayoría de las personas.');");
        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('La alimentación en la salud cardiovascular', 'Una dieta adecuada puede retrasar y ayudar a controlar los principales factores de riesgo cardiovascular: obesidad, hipertensión, diabetes e hipercolesterolemia. ,practicar ejercicio moderado, evitando así el sedentarismo, es un hábito de vida cardiosaludable, capaz de evitar el desarrollo de las enfermedades cardiovasculares en pacientes que ya han padecido un accidente cardiovascular, la alimentación adecuada es esencial para mejorar su pronóstico y evitar recaídas o complicaciones ,la obesidad, el colesterol y la hipertensión son algunos de los principales factores de riesgo que intervienen en las enfermedades cardiovasculares y que pueden controlarse a través de la alimentación. \n" +
                "Los buenos hábitos de vida, entre los que la influencia de la alimentación resulta fundamental, previenen las enfermedades del corazón. “Las pautas alimentarias cardiosaludables incluyen la ingesta de fruta y verdura diaria, aceite de oliva, pescados y productos bajos en grasa: aves sin piel ni grasa, carnes magras”, señala la Dra. Nieves Tarín, cardióloga de la Fundación Española del Corazón (FEC), en el marco de las XIII Jornadas Nacionales de Nutrición Práctica que se celebran estos días en el Colegio de Médicos de Madrid y que analizan las últimas tendencias en nutrición y alimentación.');");
        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('Técnicas de manejo de estrés y ansiedad:', 'Reconozca las cosas que no puede cambiar. Aceptar que no puede cambiar ciertas cosas le permite dejarlas ir y no alterarse. Por ejemplo, no puede cambiar el hecho de que debe conducir durante la hora pico. Pero puede buscar maneras de relajarse en el trayecto, como escuchar un podcast o un audiolibro.\n" +
                "    Evite las situaciones estresantes. Siempre que le sea posible, aléjese de la fuente del estrés. Por ejemplo, si su familia discute en los días festivos, dese un descanso y salga a caminar o a dar una vuelta en el auto.\n" +
                "    Haga ejercicio. Realizar actividades físicas todos los días es la mejor y más fácil manera de lidiar con el estrés. Al hacer ejercicio, su cerebro libera químicos que lo hacen sentir bien. También puede ayudarle con su energía reprimida o su frustración. Busque algo que disfrute, ya sea caminar, montar en bicicleta, jugar softball, nadar o bailar, y hágalo por al menos 30 minutos la mayoría de los días.\n" +
                "    Cambie su perspectiva. Intente desarrollar una actitud más positiva ante los desafíos. Puede hacerlo reemplazando los pensamientos negativos con pensamientos más positivos. Por ejemplo, en lugar de pensar, \"¿por qué siempre todo sale mal?\", cambie esa idea por, \"puedo encontrar una manera de superar esto\". Puede parecer difícil o tonto en un principio, pero podría descubrir que esto le ayuda a dar un giro a su perspectiva.\n" +
                "    Haga algo que disfrute. Cuando el estrés lo tenga decaído, haga algo que disfrute para ayudar a ponerlo de pie de nuevo. Puede ser algo tan simple como leer un buen libro, escuchar música, ver su película favorita o salir a cenar con un amigo. O comience un nuevo pasatiempo o clase. Sin importar lo que elija, intente hacer al menos una cosa al día que sea solo para usted.\n" +
                "    Aprenda nuevas maneras para relajarse. La práctica de técnicas de relajación es una gran manera de lidiar con el estrés del día a día. Las técnicas de relajación le ayudan a disminuir el ritmo cardíaco y reducir la presión sanguínea. Existen muchos tipos, desde respiraciones profundas y meditación hasta yoga y taichí. Tome una clase o intente aprender de libros, videos o recursos en línea.\n" +
                "    Conéctese con sus seres queridos. No deje que el estrés se interponga entre usted y su vida social. Pasar tiempo con familiares y amigos puede ayudarle a sentirse mejor y olvidarse del estrés. Confiar sus problemas a un amigo también puede ayudarle a resolverlos.\n" +
                "    Duerma lo suficiente. Descansar suficientemente durante la noche puede ayudarle a pensar con más claridad y a tener más energía. Esto hará que sea más fácil manejar cualquier problema que pueda surgir. Intente dormir entre 7 y 9 horas todas las noches.\n" +
                "    Mantenga una dieta saludable. Comer alimentos saludables ayuda a darle energía a su cuerpo y su mente. Evite los refrigerios con altos contenidos de azúcar y consuma muchas verduras, frutas, granos integrales, lácteos reducidos o libres de grasas y proteínas magras.\n" +
                "    Aprenda a decir que no. Si su estrés viene de realizar demasiadas tareas en casa o en el trabajo, aprenda a establecer límites. Pida ayuda a los demás cuando la necesite. ');");
        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('Importancia del sueño para la salud general', 'La falta de sueño puede aumentar el riesgo de tener problemas de salud, como enfermedad cardiaca, presión arterial alta y obesidad. También puede afectar la concentración y la memoria.\n" +
                "\n" +
                "No dormir lo suficiente puede causar problemas graves para las personas con cáncer, como una calidad de vida más baja, depresión y la falta de capacidad de realizar las actividades diarias.');");

        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('Prevención de enfermedades infecciosas', '\"Prevenir infecciones mediante vacunas es una práctica fundamental en salud pública. Inmunización contra enfermedades infecciosas: Las vacunas son herramientas importantes para prevenir enfermedades infecciosas, como el sarampión, la poliomielitis, la influenza, la hepatitis, entre otras. Estas enfermedades pueden ser graves e incluso mortales en algunos casos, pero la vacunación puede ayudar a prevenirlas.\n"  +

                "\"1.Funcionamiento de las vacunas: Las vacunas contienen partes debilitadas o inactivadas de los patógenos que causan enfermedades. Al introducir estas partes en el cuerpo, el sistema inmunológico reconoce los antígenos y produce una respuesta inmunitaria, que incluye la producción de anticuerpos. Estos anticuerpos permiten al cuerpo reconocer y combatir el patógeno en caso de exposición futura, lo que previene la infección o reduce su gravedad.\n"  +

                "\"2.Inmunidad colectiva (o inmunidad de rebaño): La vacunación no solo protege a la persona vacunada, sino que también contribuye a proteger a la comunidad en su conjunto. Cuando una gran proporción de la población está vacunada contra una enfermedad, se reduce la propagación del patógeno, lo que proporciona protección a las personas que no pueden recibir la vacuna, como aquellos con sistemas inmunológicos debilitados o alergias a los componentes de la vacuna.\n"  +

                "\"3.Calendario de vacunación: Cada país tiene un calendario de vacunación recomendado que especifica cuándo se deben administrar diferentes vacunas a lo largo de la vida, desde la infancia hasta la edad adulta. Es importante seguir este calendario para asegurar una protección óptima contra enfermedades infecciosas.\n"  +

                "\"4.Seguridad y eficacia: Las vacunas pasan por rigurosos ensayos clínicos para garantizar su seguridad y eficacia antes de ser aprobadas para su uso. Los organismos reguladores de la salud, como la Administración de Alimentos y Medicamentos (FDA) en Estados Unidos, supervisan el proceso de desarrollo y autorizan el uso de vacunas que cumplen con los estándares de seguridad y eficacia.\n" +

                "\"5.Educación y conciencia: La educación pública sobre la importancia de la vacunación y la desmitificación de mitos y falsas creencias sobre las vacunas son fundamentales para aumentar las tasas de vacunación y prevenir enfermedades infecciosas.\"');");

        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('Actividad física en la tercera edad', 'Dentro de los beneficios para la salud que se pueden obtener con la práctica de ejercicio físico en la tercera edad se encuentran: \n" +
                "\n" +
                "    Disminuye el riesgo de caídas y lesiones músculo-esqueléticas \n" +
                "    Se conserva y mantiene la salud y fuerza muscular, haciendo que se mantenga la independencia y la actividad diaria\n" +
                "    Reduce los niveles de estrés y ansiedad \n" +
                "    Ayuda a mantener un peso saludable \n" +
                "    Ayuda a mantener o mejorar las funciones cognitivas\n" +
                "    Enlentece el proceso de perdida de masa muscular \n" +
                "    Mejora la calidad del sueño \n" +
                "    Facilita la realización de diversas actividades de la vida diaria\n');");
        db.execSQL("INSERT INTO " + Article_table.TABLE_NAME + " (" +
                Article_table.COLUMN_TITULO + ", " + Article_table.COLUMN_CONSEJO + ") " +
                "VALUES ('Importancia del descanso adecuado', 'Dormir le da al cuerpo y al cerebro tiempo para recuperarse del estrés del día. Después de una buena noche de sueño, usted se desempeña mejor y es mejor para tomar decisiones. Dormir lo ayuda a sentirse más alerta, optimista y a tener una mejor relación con las personas. Dormir también ayuda al cuerpo a combatir enfermedades.\n" +
                "Cuántas horas de sueño necesita\n" +
                "\n" +
                "Diferentes personas necesitan diferentes cantidades de horas de sueño. La mayoría de los adultos necesitan de 7 a 8 horas de sueño por noche para una buena salud y funcionamiento mental. Algunos adultos necesitan hasta 9 horas de sueño por noche.');");

    }
}
