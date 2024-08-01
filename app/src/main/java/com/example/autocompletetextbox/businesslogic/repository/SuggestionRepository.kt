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
                countries.map { country ->
                    val ratio = FuzzySearch.ratio(query.lowercase(), country.name.lowercase())
                    val partialRatio = FuzzySearch.partialRatio(query.lowercase(), country.name.lowercase())
                    country to maxOf(ratio,partialRatio)
                }
                    .sortedByDescending { (_,score) -> score }
                    .map { (country,_) -> country }
                    .take(5)
            }
    }
}
