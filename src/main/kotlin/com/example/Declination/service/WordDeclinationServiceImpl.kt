package com.example.Declination.service

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.morpher.ws3.Client
import ru.morpher.ws3.russian.DeclensionResult
import com.github.demidko.aot.WordformMeaning.lookupForMeanings


@Service
class WordDeclinationServiceImpl : WordDeclinationService {

    override fun spell(word: String): List<String> {
//        val russianDeclensionResult: DeclensionResult = client.russian().declension(word)
        val wordCase = lookupForMeanings(word);

        return listOf(
            wordCase[0].transformations[0].toString(),
            wordCase[0].transformations[1].toString(),
            wordCase[0].transformations[2].toString(),
            wordCase[0].transformations[3].toString(),
            wordCase[0].transformations[4].toString(),

            if (wordCase[0].transformations[5].morphology.toString()
                    .contains("тв")
            ) wordCase[0].transformations[6].toString()
            else wordCase[0].transformations[5].toString()
        )

    }

}