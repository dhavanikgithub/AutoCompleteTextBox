package com.example.autocompletetextbox.businesslogic.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountryApi {
    @GET("dhavanikgithub/country-flags/main/countries.json")
    fun getCountries(): Single<Map<String, String>>
}