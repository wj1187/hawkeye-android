package io.coin.hawkeye.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

class Info(
        @SerializedName("name") @Expose var name: String,
        @SerializedName("price") @Expose var price: String,
        @SerializedName("img") @Expose var img: String,
        @SerializedName("star") @Expose var rate: Int,
        @SerializedName("mall") @Expose var mall: Int,
        @SerializedName("rater") @Expose var rater: Int
)