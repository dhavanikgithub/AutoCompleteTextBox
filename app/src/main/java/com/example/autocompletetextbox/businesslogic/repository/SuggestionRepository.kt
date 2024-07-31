package com.example.autocompletetextbox.businesslogic.repository

import com.example.autocompletetextbox.businesslogic.pojo.Country
import io.reactivex.rxjava3.core.Single
import me.xdrop.fuzzywuzzy.FuzzySearch
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.max

@Singleton
class SuggestionRepository @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun getSuggestion(query: String): Single<List<Country>> {
        if (query.isEmpty()) return Single.just(emptyList())

        return countryRepository.getCountries()
            .map { countries ->
                val scoredCountries = mutableMapOf<Country, Int>()

                // Calculate partialRatio and add to scoredCountries map
                countries.forEach { country ->

                    val ratioScore = FuzzySearch.ratio(query.lowercase(), country.name.lowercase())

                    if (ratioScore > 0) {
                        scoredCountries[country] = ratioScore
                    }
                }
                // Sort by score in descending order and limit to top 5 results
                scoredCountries.entries
                    .sortedByDescending { it.value }
                    .take(5)
                    .map { it.key }
            }
    }


}
