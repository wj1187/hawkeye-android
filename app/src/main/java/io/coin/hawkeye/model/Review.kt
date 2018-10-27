package io.coin.hawkeye.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

class Review(
    @SerializedName("nickname") @Expose var nickname: String,
    @SerializedName("date") @Expose var date: String,
    @SerializedName("review") @Expose var review: String,
    @SerializedName("star") @Expose var star: Int
//        @SerializedName("mall") @Expose var mall: String
)