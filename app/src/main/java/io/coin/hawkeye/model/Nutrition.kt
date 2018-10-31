package io.coin.hawkeye.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-27
 */

class Nutrition(
    @SerializedName("calorie") @Expose var min: Int,
    @SerializedName("salt") @Expose var salt: Int,
    @SerializedName("carbonhydrate") @Expose var carbonhydrate: Int,
    @SerializedName("fat") @Expose var fat: Int,
    @SerializedName("cholesterol") @Expose var cholesterol: Int,
    @SerializedName("protein") @Expose var protein: Int
)