package io.coin.hawkeye.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-27
 */

class Product(
        @SerializedName("name") @Expose var name: String,
        @SerializedName("category") @Expose var category: String,
        @SerializedName("maker") @Expose var maker: String,
        @SerializedName("price") @Expose var price: Price,
        @SerializedName("imageUrl") @Expose var imageUrl: String,
        @SerializedName("rate") @Expose var rate: Double,
        @SerializedName("mallsCount") @Expose var mallsCount: Int,
        @SerializedName("reviewersCount") @Expose var reviewersCount: Int,
        @SerializedName("review") @Expose var review: List<Review>
)