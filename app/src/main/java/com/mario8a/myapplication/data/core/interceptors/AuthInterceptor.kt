package com.mario8a.myapplication.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    // chain es la llamada que hace retrofit
    override fun intercept(chain: Interceptor.Chain): Response {
        // Esta es la peticion que va llegar al servidor
        val request = chain.request().newBuilder().header("Authorization", "asdasds").build()
        // Ahora en cada llamada siempre se van estar enviando el header escrito
        return chain.proceed(request)
    }
}