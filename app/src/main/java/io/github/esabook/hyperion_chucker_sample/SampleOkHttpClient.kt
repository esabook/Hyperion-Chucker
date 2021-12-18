package io.github.esabook.hyperion_chucker_sample

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient

class SampleOkHttpClient(val context: Context) {

    fun get(): OkHttpClient {

        // https://github.com/esabook/chucker/blob/develop/docs/migrating-from-chuck.md
        val chuckerInterceptor = ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context, showNotification = true))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()

        val client = OkHttpClient.Builder()
            .addInterceptor(chuckerInterceptor)
            .build()

        return client
    }

}