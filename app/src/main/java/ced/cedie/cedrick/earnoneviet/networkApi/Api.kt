package ced.cedie.cedrick.earnoneviet.networkApi

import ced.cedie.cedrick.earnoneviet.dataModel.DModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface Api {

    @GET("monkeymakingadvantageandisadvantages")
    fun getApi() : Single<List<DModel>>
    
}