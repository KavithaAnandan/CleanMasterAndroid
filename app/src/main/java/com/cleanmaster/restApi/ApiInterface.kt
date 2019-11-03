package com.cleanmaster.restApi

import com.cleanmaster.model.apimodel.home.HomeResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface ApiInterface {
    /**
     * Get the list of the pots from the API
     */

    @GET("/services")
    fun getServices(): Observable<List<HomeResponse>>
}