package io.coin.hawkeye.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-27
 */

class Price(
    @SerializedName("min") @Expose var min: Int,
    @SerializedName("avg") @Expose var avg: Int
)