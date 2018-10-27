package io.coin.hawkeye.api

import io.coin.hawkeye.model.Product
import kotlinx.coroutines.experimental.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

interface ApiSpec {

    @GET("/push/me")
    fun getProduct(): Deferred<Response<Product>>

    @Multipart
    @POST("/")
    fun postImage(@Part("file\"; filename=\"temp.jpeg\" ") image: RequestBody): Deferred<Response<Product>>

}