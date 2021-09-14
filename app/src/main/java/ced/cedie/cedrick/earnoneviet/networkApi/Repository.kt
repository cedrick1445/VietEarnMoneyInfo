package ced.cedie.cedrick.earnoneviet.networkApi

import android.app.Application
import ced.cedie.cedrick.earnoneviet.dataModel.DModel
import dagger.Module
import dagger.hilt.InstallIn
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(Application::class)
class Repository {

    @Singleton
    private val api : Api = Retrofit.Builder()
        .baseUrl("http://45.66.164.9:7569/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(Api::class.java)

    fun getDApi() : Single<List<DModel>>{
        return api.getApi()
    }
}