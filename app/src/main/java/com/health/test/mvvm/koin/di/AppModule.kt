package com.health.test.mvvm.koin.di

import AppDataManager

import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.data.local.prefs.AppPrefsHelper
import com.health.test.mvvm.koin.data.local.prefs.PrefsHelper
import com.health.test.mvvm.koin.ui.beauty.BeautyViewModel

import com.health.test.mvvm.koin.ui.details.DetailsActivityViewModel
import com.health.test.mvvm.koin.ui.home.HomeViewModel
import com.health.test.mvvm.koin.ui.other.OtherHihi
import com.utils.SchedulerProvider
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    single { SchedulerProvider() }

    single { AppPrefsHelper(get(), "Raghavendra", get()) as PrefsHelper }

    single { AppDataManager(get()) as DataManager }

    factory { OtherHihi(get(), get()) }
}

//define list view model
val viewModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { DetailsActivityViewModel(get(), get()) }
    viewModel { BeautyViewModel(get(), get()) }
  }


val mvvmModule = listOf(appModule, viewModule, roomModule, networkModule, repositoryModule)