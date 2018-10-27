package io.coin.hawkeye

import android.content.Context
import io.coin.hawkeye.api.ApiProvider
import io.coin.hawkeye.api.ApiSpec

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-27
 */

val Context.api: ApiSpec
    get() = ApiProvider.provideApi(this)