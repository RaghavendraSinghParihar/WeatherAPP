package com.health.test.mvvm.koin.ui.home

import androidx.fragment.app.Fragment

/**
 * Raghavendra on 10:15 2018-12-19
 */
interface HomeNavigator {
    fun replaceFragment(fragment: Fragment)
    fun hideProgress()
}