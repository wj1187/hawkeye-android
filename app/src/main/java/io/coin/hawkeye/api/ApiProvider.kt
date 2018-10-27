package io.coin.hawkeye.api

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

object ApiProvider {

    private const val SERVER_ENDPOINT_PROTOCOL = "http"
    private const val SERVER_ENDPOINT_URL = "ssh.a1p4ca.com"
    private const val SERVER_ENDPOINT = "$SERVER_ENDPOINT_PROTOCOL://$SERVER_ENDPOINT_URL"

    /**
     * Provide Api with Bearer authorization
     * @param context
     */
    fun provideApi(context: Context): ApiSpec {
        val client = OkHttpClient.Builder()

//        client.addInterceptor(AuthInterceptor(context))

        return api(client.build())
    }

    private fun api(client: OkHttpClient): ApiSpec {
        return Retrofit.Builder()
                .baseUrl(SERVER_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
                .create(ApiSpec::class.java)
    }

    fun <T> request(call: Deferred<Response<T>>,
                    success: ((response: Response<T>) -> Unit)?,
                    fail: ((throwable : Throwable) -> Unit)? = null){
        GlobalScope.launch(Dispatchers.Main) {
            try{
                success?.invoke(call.await())
            } catch (t: Throwable) {
                fail?.invoke(t)
            }
        }
    }
}