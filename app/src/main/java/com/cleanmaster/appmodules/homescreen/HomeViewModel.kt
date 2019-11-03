package com.cleanmaster.appmodules.homescreen

import androidx.lifecycle.MutableLiveData
import com.cleanmaster.appmodules.base.BaseViewModel
import com.cleanmaster.model.apimodel.home.HomeResponse
import com.cleanmaster.restApi.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel : BaseViewModel() {
    @Inject
    lateinit var apiInterface: ApiInterface
    private val loadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()
    private val serviceLiveData: MutableLiveData<List<HomeResponse>>? = null
    private lateinit var observable: Disposable

    init {
        loadService()
    }


    fun onRetrieveStart() {
        loading.value = true

    }

    fun onRetrieveFinish() {
        loading.value = false
    }

    fun loadService() {
        observable = apiInterface.getServices().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onSuccess(result) },
                { onFailure() })
    }

    private fun onFailure() {
        loadError.value = false

    }

    private fun onSuccess(listService: List<HomeResponse>) {
        loadError.value = true
        serviceLiveData?.value = listService
    }


}