package com.zpi.jogasimple.data

import com.zpi.jogasimple.ExerciseAdvanced
import com.zpi.jogasimple.R

class ExerciseAll {

    companion object {
        fun getAllExercise(): List<Exercise> {
            return listOf(
                Exercise(R.drawable.beg_m_1, "Muktasana jest idealna pozą do chwili odpoczynku i medytacji. Ćwiczenie to ma na celu stopniowe rozbudzenie naszego organizmu po śnie i przygotowanie go do ruchu w następnych ćwiczeniach.\n" +
                        "\n" +
                        "W czasie trzech minut tego ćwiczenia skup się na głębokim i spokojnym oddechu.  Pamiętaj również o wyprostowanych plecach.\n", 20),
                Exercise(R.drawable.beg_m_2, "Z pozycji przyjętego wcześniej siadu wykonuj rekoma naprzemiennie skłony w lewy i prawy bok. Nie spiesz się, dokładność rozciągnięcia jest ważniejsza. \n" +
                        "\n" +
                        "Ćwiczenie to pomoże nam rozciągnąć ramiona i ręce, które często cierpną w nocy przez spanie w nieodpowiednich pozycjach.", 20),
                Exercise(R.drawable.beg_m_3, "Setu bandhasana, inaczej pozycja mostka. \n" +
                         "Łopatki oraz góra pleców leżą na ziemi, podczas gdy biodra i zgięte w kolanach nogi podnoszą się ku górze.\n" +
                        "Ćwiczenie należy wykonywać powtórzeniami, uwzględniając przerwy pomiędzy nimi. W ramach przerw należy poleżeć przez parę sekund.\n" +
                        "\n", 20),
                Exercise(R.drawable.beg_m_4,"Klęknięcie na jedną nogę z wyrokiem w przód (Anjaneyasana)\n" +
                        "\n" +
                        "W ćwiczeniu należy pozostać dłuższą chwilę, po czym zmieniać kolejność na drugą nogę.\n" +
                        "\n" +
                        "Pamiętaj o prostych plecach i spokojnym oddechu.\n" +
                        "Ćwiczenie wspiera prawidłowe funkcjonowanie kolan.",45),
                Exercise(R.drawable.beg_m_5,"Asana psa z głową w dół (Adho Mukha Svanasana).\n" +
                        "Osoby początkujące mogą stać na czubkach palców, ale w miarę postępów należy dążyć do postawienia stóp całkowicie na ziemi.\n" +
                        "\n" +
                        "Jest to jedna z najbardziej znanych póz jogi - używa się jej często jako relaksacyjnego przerywnika między sekwencjami ćwiczeń.\n" +
                        "\n" +
                        "Wpływa pozytywnie na krążenie krwi, wzmacnia ramiona i poprawia elastyczność stawów.",45)
            )
        }
    }
}


