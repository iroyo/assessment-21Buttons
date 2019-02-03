package com.iroyoraso.assessment.test21buttons.net

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.iroyoraso.assessment.test21buttons.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit


/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class ApiProvider {

    companion object {

        private const val BASE_URL = "https://www.speedrun.com/api/v1/"

        private const val TIMEOUT_CONNECTION = 20L // SECONDS
        private const val TIMEOUT_READ = 20L // SECONDS

        private fun getCache(context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

        private fun getOkHttp(cache: Cache) : OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }

            val builder = OkHttpClient().newBuilder()
            builder.connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            builder.readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            builder.addInterceptor(loggingInterceptor)
            builder.cache(cache)
            return builder.build()
        }

        private fun getGson(): Gson {
            val builder = GsonBuilder()
            builder.excludeFieldsWithModifiers(Modifier.STATIC)
            builder.disableHtmlEscaping()
            builder.setPrettyPrinting()
            builder.serializeNulls()
            return builder.create()
        }


        private fun createRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit {
            val converter = GsonConverterFactory.create(gson)

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converter)
                .client(httpClient)
                .build()
        }

        fun get(context: Context) : ApiService {
            return createRetrofit(getGson(), getOkHttp(getCache(context))).create(ApiService::class.java)
        }
    }
}