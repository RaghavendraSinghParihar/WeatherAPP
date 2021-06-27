package com.health.test.mvvm.koin.ui.details
import com.health.test.mvvm.koin.api.NetworkApis
import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.base.BaseViewModel
import com.health.test.mvvm.koin.api.ApiClient
import com.health.test.mvvm.koin.model.weather.WeatherApiResponse
import com.health.test.mvvm.koin.model.weather.WeatherReport
import com.utils.SchedulerProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.create

/**
 * Raghavendra on 10:13 2018-12-19
 */
class DetailsActivityViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
        BaseViewModel<DetailsActivityNavigator>(dataManager, schedulerProvider) {
    var apiService: NetworkApis = ApiClient.getClientMVVMBaseUrl().create<NetworkApis>()
    val weatherReportList: ArrayList<WeatherReport> = ArrayList()
    fun getDataFromServer(lat: String, lon: String, appId: String) {
        val genderResponse = apiService.getWeatherData(lat, lon, appId)
        genderResponse.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<WeatherApiResponse> {
                    override fun onSuccess(weatherApiResponse: WeatherApiResponse) {
                        if (weatherApiResponse != null) {
                            for (i in 0 until weatherApiResponse.list?.size!! - 1) {
                                val weatherReport = WeatherReport()
                                weatherReport.tem = weatherApiResponse.list?.get(i)?.main?.temp
                                weatherReport.humidity = weatherApiResponse.list?.get(i)?.main?.humidity
                                weatherReport.weatherStatus = weatherApiResponse.list?.get(i)?.weather?.get(0)?.main
                                weatherReport.datetime = weatherApiResponse.list?.get(i)?.dtTxt
                                weatherReportList.add(weatherReport)
                            }
                            getNavigator().setData(weatherReportList)
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                        getNavigator().hideProgress()
                    }

                    override fun onError(e: Throwable) {
                        getNavigator().hideProgress()
                        e.printStackTrace()
                    }
                })
    }


}