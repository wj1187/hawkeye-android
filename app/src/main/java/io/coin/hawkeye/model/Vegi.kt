package io.coin.hawkeye.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-27
 */

class Vegi(
    @SerializedName("vegi") @Expose var vegi: String,
    @SerializedName("category") @Expose var category: String,
    @SerializedName("calorie") @Expose var calorie: String,
    @SerializedName("season") @Expose var season: String,
    @SerializedName("purchase") @Expose var purchase: String,
    @SerializedName("store_day") @Expose var store_day: String,
    @SerializedName("store_how") @Expose var store_how: String,
    @SerializedName("trim") @Expose var trim: String,
    @SerializedName("eat") @Expose var eat: String,
    @SerializedName("relative") @Expose var relative: String,
    @SerializedName("diet") @Expose var diet: String,
    @SerializedName("effect") @Expose var effect: String
)