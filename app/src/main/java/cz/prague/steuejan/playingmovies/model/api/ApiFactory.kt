package cz.prague.steuejan.playingmovies.model.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import cz.prague.steuejan.playingmovies.miscellaneous.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private fun setupTmdbClient(): OkHttpClient {
        //Creating Auth Interceptor to add api_key query in front of all the requests.
        val authInterceptor = Interceptor { chain ->
            val newUrl = chain.request().url
                .newBuilder()
                .addQueryParameter("api_key", Constants.tmdbApiKey)
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }

        return OkHttpClient()
            .newBuilder()
            .addInterceptor(authInterceptor)
            .build()
    }

    private fun getRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory = GsonConverterFactory.create(),
        adapterFactory: CallAdapter.Factory = CoroutineCallAdapterFactory()
    ): Retrofit =
        Retrofit.Builder()
            .client(setupTmdbClient())
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()

    val tmdbApi = getRetrofit(Constants.tmdbEndPoint)
        .create(TmdbApi::class.java)
}