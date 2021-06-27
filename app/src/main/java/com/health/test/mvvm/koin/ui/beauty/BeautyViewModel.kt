package com.health.test.mvvm.koin.ui.beauty

import com.health.test.mvvm.koin.base.BaseViewModel
import com.health.test.mvvm.koin.data.DataManager
import com.utils.SchedulerProvider


class BeautyViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
    : BaseViewModel<BeautyNavigator>(dataManager, schedulerProvider) {
    //var dbManager: DbManager? = null
 /*   fun addData() {
        try {
            getNavigator().showProgress()
            dbManager!!.open()
            val cur = dbManager!!.selectQuery("select * from  " + Constants.tbl_ayurveda + "")
            if (cur.count > 0) while (!cur.isAfterLast) {
                val ayurvedaTipsResponse = AyurvedaTipsResponse()
                ayurvedaTipsResponse.storyTitle = cur.getString(1)
                ayurvedaTipsResponse.storyDescription = cur.getString(2)
                arrayListAyurvedaTips.add(ayurvedaTipsResponse)
                cur.moveToNext()
            }
            cur.close()
            dbManager!!.close()
            getNavigator().hideProgress()
        } catch (e: Exception) {
            getNavigator().hideProgress()
            e.printStackTrace()
        }
    }*/


}