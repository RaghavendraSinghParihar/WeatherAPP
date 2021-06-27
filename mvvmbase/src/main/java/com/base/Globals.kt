package com.base

import io.github.inflationx.viewpump.Interceptor
import okhttp3.Response

interface Globals {

    var okHttpInterceptor: ((Interceptor.Chain) -> Response)?
    /**
     * RetroFit Intercept Headers to be Use While Invoking any Api
     * @return MutableMap of Headers
     */
    fun getInterceptorHeaders(): MutableMap<String, String>?
}