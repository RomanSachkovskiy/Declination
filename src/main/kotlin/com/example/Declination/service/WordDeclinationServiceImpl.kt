package com.example.Declination.service

import org.springframework.stereotype.Service
import com.github.demidko.aot.WordformMeaning.lookupForMeanings


@Service
class WordDeclinationServiceImpl : WordDeclinationService {

    override fun spell(word: String): List<String> {
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