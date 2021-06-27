package com.health.test.mvvm.koin.di

import com.health.test.mvvm.koin.persitence.AppDataBase
import org.koin.dsl.module

val roomModule = module {
    single { AppDataBase.getInstance(get()) }
    single { get<AppDataBase>().getRecipeDao() }
}