package ced.cedie.cedrick.earnoneviet.dataViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ced.cedie.cedrick.earnoneviet.dataModel.DModel
import ced.cedie.cedrick.earnoneviet.networkApi.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class DViewModel : ViewModel() {

    private val repo = Repository()
    private val disposable = CompositeDisposable()
    private var DList = ArrayList<DModel>()

    val dataD = MutableLiveData<List<DModel>>()
    val error = MutableLiveData<Boolean>()
    val load = MutableLiveData<Boolean>()
    val data: LiveData<List<DModel>> get() = dataD


    fun homeData() { getHome() }
    private fun getHome() {
        DList.clear()
        disposable.add(repo.getDApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<DModel>>() {
                override fun onSuccess(stream: List<DModel>?) {
                    DList = ArrayList(stream!!.filter { it.status == "make money" })
                    dataD.value = DList
                    error.value = false
                    load.value = false }
                override fun onError(e: Throwable?) {
                    error.value = true
                    load.value = true
                } })) }


    fun advData() { getAdv() }
    private fun getAdv() {
        DList.clear()
        disposable.add(repo.getDApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<DModel>>() {
                override fun onSuccess(stream: List<DModel>?) {
                    DList = ArrayList(stream!!.filter { it.status == "AdvantageV" })
                    dataD.value = DList
                    error.value = false
                    load.value = false }
                override fun onError(e: Throwable?) {
                    error.value = true
                    load.value = true
                } })) }


    fun dAdvData() { getDAdv() }
    private fun getDAdv() {
        DList.clear()
        disposable.add(repo.getDApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<DModel>>() {
                override fun onSuccess(stream: List<DModel>?) {
                    DList = ArrayList(stream!!.filter { it.status == "DisadvantageV" })
                    dataD.value = DList
                    error.value = false
                    load.value = false }
                override fun onError(e: Throwable?) {
                    error.value = true
                    load.value = true
                } })) }

}
