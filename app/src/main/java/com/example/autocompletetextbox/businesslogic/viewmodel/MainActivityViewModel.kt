package com.example.autocompletetextbox.businesslogic.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.autocompletetextbox.businesslogic.pojo.Country
import com.example.autocompletetextbox.businesslogic.repository.SuggestionRepository
import com.example.autocompletetextbox.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val application: Application,
    private val repository: SuggestionRepository
) : AndroidViewModel(application){
    private val disposables = CompositeDisposable()
    val querySubject = BehaviorSubject.create<String>()

    val query = MutableLiveData<String>()

    val suggestions = MutableLiveData<List<Country>>()

    init {
        querySubject
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMapSingle { query ->
                repository.getSuggestion(query)
            }
            .subscribeBy(onNext = { results ->
                suggestions.postValue(results)
            }, onError = {
                Logger.e("AndroidViewModel",it.message)
            })
            .addTo(disposables)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    fun onItemClick(countryName:String)
    {
        query.postValue(countryName)
        suggestions.postValue(emptyList())
    }

}