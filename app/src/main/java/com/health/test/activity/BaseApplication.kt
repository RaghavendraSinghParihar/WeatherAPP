package com.health.test.activity

import android.content.Context
import androidx.multidex.MultiDexApplication

import com.health.test.mvvm.koin.di.mvvmModule
import com.utils.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.EmptyLogger


abstract class BaseApplication : MultiDexApplication() {
   /* val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepo(database.wordDao()) }*/
    private var sAppContext: Context? = null
    override fun onCreate() {
        super.onCreate()
        sAppContext = applicationContext

        Logger.init(true)
        startKoin {
            androidContext(this@BaseApplication)
            modules(mvvmModule)
            logger(EmptyLogger())
        }

    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }


}