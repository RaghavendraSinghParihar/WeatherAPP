package com.health.test.mvvm.koin.data.local.prefs

/**
 * Raghavendra on 10:38 2018-12-19
 */
interface PrefsHelper {

    fun getUser(): String?

    fun saveUser(user: String)
}