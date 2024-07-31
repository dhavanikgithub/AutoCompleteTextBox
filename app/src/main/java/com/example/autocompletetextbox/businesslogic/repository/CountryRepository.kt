package com.example.autocompletetextbox.businesslogic.repository

import com.example.autocompletetextbox.businesslogic.network.CountryApi
import com.example.autocompletetextbox.businesslogic.pojo.Country
import io.reactivex.rxjava3.core.Single
import me.xdrop.fuzzywuzzy.FuzzySearch
import javax.inject.Inject
import javax.inject.Singleton


class CountryRepository @Inject constructor(
    private val countryApi: CountryApi
) {

    fun getCountries(): Single<List<Country>> {
        return countryApi.getCountries()
            .map { item ->
                item.map { Country(it.key, it.value) }
            }
    }
}