package com.zpi.jogasimple.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zpi.jogasimple.R
import java.util.concurrent.Executors
import com.zpi.jogasimple.data.ExerciseDao

@Database(entities = [Exercise::class], version = 2, exportSchema = false)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao

    companion object {
        @Volatile
        private var instance: ExerciseDatabase? = null

        fun getInstance(context: Context): ExerciseDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ExerciseDatabase {
            return Room.databaseBuilder(context, ExerciseDatabase::class.java, "exerciseBase")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            instance?.let {
                                populateDatabase(it.exerciseDao())
                            }
                        }
                    }
                })
                .allowMainThreadQueries()
                .build()
        }


        fun populateDatabase(exerciseDao: ExerciseDao) {
            //BEGINNER - MORNING
            var newExercise = Exercise(R.drawable.beg_m_1,"Muktasana jest idealna pozą do chwili odpoczynku i medytacji. Ćwiczenie to ma na celu stopniowe rozbudzenie naszego organizmu po śnie i przygotowanie go do ruchu w następnych ćwiczeniach.W czasie trzech minut tego ćwiczenia skup się na głębokim i spokojnym oddechu.  Pamiętaj również o wyprostowanych plecach.",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_2,"Z pozycji przyjętego wcześniej siadu wykonuj rekoma naprzemiennie skłony w lewy i prawy bok. Nie spiesz się, dokładność rozciągnięcia jest ważniejsza. Ćwiczenie to pomoże nam rozciągnąć ramiona i ręce, które często cierpną w nocy przez spanie w nieodpowiednich pozycjach.",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_3,"Setu bandhasana, inaczej pozycja mostka. Łopatki oraz góra pleców leżą na ziemi, podczas gdy biodra i zgięte w kolanach nogi podnoszą się ku górze. Ćwiczenie należy wykonywać powtórzeniami, uwzględniając przerwy pomiędzy nimi. W ramach przerw należy poleżeć przez parę sekund. Asana ta działa pozytywnie na plecy, miednicę, nogi i klatkę piersiowa. Przygotowuje nas idealnie na czekający dzień - pomaga usunąć napięcie z barków, uśmierzyć ból pleców.",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_4,"Klęknięcie na jedną nogę z wyrokiem w przód (Anjaneyasana). W ćwiczeniu należy pozostać dłuższą chwilę, po czym zmieniać kolejność na drugą nogę. Pamiętaj o prostych plecach i spokojnym oddechu. Ćwiczenie wspiera prawidłowe funkcjonowanie kolan.",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_m_5,"Asana psa z głową w dół (Adho Mukha Svanasana).Osoby początkujące mogą stać na czubkach palców, ale w miarę postępów należy dążyć do postawienia stóp całkowicie na ziemi. Jest to jedna z najbardziej znanych póz jogi - używa się jej często jako relaksacyjnego przerywnika między sekwencjami ćwiczeń. Wpływa pozytywnie na krążenie krwi, wzmacnia ramiona i poprawia elastyczność stawów.",50,"Beginner", "Morning")
            exerciseDao.addExercise(newExercise)

            //BEGINNER - NIGHT

            newExercise = Exercise(R.drawable.beg_n_1,"Adho mukhna virasana - skłon do przodu. Pozycja ta jest jedna z lepszych jeśli chodzi o odprężenie ciała i regenerację po ciężkim dniu. Ćwiczenie pomaga uelastycznić kręgosłup, rozluźnia mięśnie szyi i intensywnie rozciąga kolana",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_2,"Siad klęczny z odchyleniem w tył. Należy przyjąć tą samą pozycję przez cały czas trwania ćwiczenia. Ćwiczenie pomaga rozluźnić mięśnie karku, ramion i wzmacnia zasięg odchylania pleców.",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_3,"Siad klęczny z wyciągnięciem do przodu. Ćwiczenie należy wykonywać powtórzeniami z krótkimi przerwami pomiędzy. Pamiętaj żeby podczas ćwiczenia próbować sięgnąć jak najdalej. Ćwiczenie wspomaga ramiona, rozluźnia plecy i mięśnie karku.",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_4,"Pozycja kota (Marjarysana). Wygięcia grzbietu należy utrzymywać przez dłuższą chwilę i uwzględniać chwile rozluźnienia między powtórzeniami. Ćwiczenie rewelacyjnie działa na kręgosłup wzmacniając go i rozluźniając przy tym plecy.",50,"Beginner", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.beg_n_5,"lalala",50,"Skręt w Svastikasanie. Ćwiczenie należy wykonywać naprzemiennie sięgnięciami za siebie. Należy pamiętać o prostych plecach i zsynchronizowaniu oddychania z wykonywanymi skrętami.\n" +
                    "Ćwiczenie wpływa pozytywnie na mięśnie ramion i ich rozciągnięcie.", "Night")
            exerciseDao.addExercise(newExercise)

            //ADVANCED - MORNING
            newExercise = Exercise(R.drawable.adv_m_1,"Wykonaj pozycję Psa z głową do dołu, ułóż dłonie 15 cm od ściany. Zdecyduj, która noga będzie nogą dominującą, z której wykonasz wyskok. Ugnij drugą nogę do góry, przyciągając piętę do pośladka. Na wdechu zegnij dominującą nogę i podskocz na niej do góry. Możesz podskoczyć kilkakrotnie przymierzając się do skoku. Kiedy będziesz już gotowy, a dominująca noga będzie w górze, w tym samym czasie przesuń ku sufitowi drugą nogę.",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_2,"Stań w Tadasanie. Przenieś ciężar ciała na lewą stopę, pamiętaj o wdechu. Zegnij prawą nogę i przesuń kolano do tyłu, tak aby stopa znalazła się tuż za pośladkiem. Zwróć prawą pietę do sufitu. Sięgnij do tyłu prawą dłonią i chwyć nią środkową część prawej stopy.",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_3,"Uklęknij na podłodze i rozstaw kolana na szerokość bioder. Przesuń prawą stopę do przodu w taki sposób, aby tylko pięta dotykała maty. Następnie zegnij tułów do przodu i dotknij podłogi opuszkami palców. Przesuń lewe kolano delikatnie do tyłu, próbując delikatnie wyprostować nogę. To samo zrób z nogą prawą. Wyprostuj swoje plecy.",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_4,"Połóż się na brzuchu twarzą do podłogi. Początkowo czoło pozostaje oparte na podłodze. Na wdechu pociągnij stopy do tyłu, odsuwając je od pośladków. Staraj się unieść uda wysoko nad podłogę. Na wydechu unieś głowę i klatkę piersiową. Patrz w kierunku podłogi.",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_m_5,"Usiądź wygodnie w siadzie skrzyżnym, wyprostuj plecy. Prawą goleń ułóż na lewym, tak by były równoległe do miednicy i przylegały do podłogi. Wykonaj pięć oddechów i zmień ułożenie nóg: lewy goleń ułóż na prawym. ",50,"Advanced", "Morning")
            exerciseDao.addExercise(newExercise)

            //ADVANCED - NIGHT
            newExercise = Exercise(R.drawable.adv_n_1,"Stań w Tadasanie. Weź głęboki wdech i z wydechem przejdź do szerokiego rozkroku. Następnie obróć prawą stopę na zewnątrz o około 90 stopni, a lewą stopę do wewnątrz o około 15 stopni. Unieś ręce do boku, tak aby znajdowały się na wysokości ramion i ułóż je równolegle do podłogi. Następnie weź głęboki wdech i zegnij prawe kolano. Delikatnie obróć głowę i spójrz w prawo.",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_2,"Połóż przedramiona na ziemi. Łokcie i ramiona powinny być w tej samej linii. Podnieś swoje plecy i biodra, a głowę schowaj pomiędz rękami. Utrzymaj ramiona z daleka od uszu. Weź trzy wdechy.\n",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_3,"Opuść górną część ciała do przodu, jednocześnie unosząc prawą nogę, utrzymując stopę zgiętą. Twoje ciało powinno przypominać literę „T”. Rozpocznij rozciąganie ciała w przeciwnych kierunkach, ciągnąc do tyłu uniesioną nogę i wyciągając do przodu górną część ciała. Opuść nogę i powtórz ćwiczenie z drugiej strony.",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_4,"Zegnij łokcie i unieś dłonie nad głowę, umieszczając je pod ramionami, tak aby czubki palców były skierowane w stronę stóp. Zrób wdech i unieś ramiona i biodra z podłogi. ",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)

            newExercise = Exercise(R.drawable.adv_n_5,"Siedząc na podłodze, wyprostuj nogi przed sobą. Połóż dłonie nieco za biodrami na podłodze. Podnieś do górnej części mostka i delikatnie odchyl się do tyłu, uważając, aby nie zgiąć pleców. Twoja waga powinna być równomiernie rozłożona na kości siedzące i kość ogonową.",50,"Advanced", "Night")
            exerciseDao.addExercise(newExercise)
        }
    }}