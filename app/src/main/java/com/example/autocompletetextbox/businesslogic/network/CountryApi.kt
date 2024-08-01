package com.example.autocompletetextbox.businesslogic.network

import com.example.autocompletetextbox.utils.Constants.Companion.GITHUB_REPO_BRANCH
import com.example.autocompletetextbox.utils.Constants.Companion.GITHUB_REPO_NAME
import com.example.autocompletetextbox.utils.Constants.Companion.GITHUB_USERNAME
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountryApi {
    @GET("${GITHUB_USERNAME}/${GITHUB_REPO_NAME}/${GITHUB_REPO_BRANCH}/countries.json")
    fun getCountries(): Single<Map<String, String>>
}