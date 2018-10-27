package io.coin.hawkeye.ui

/**
 * @author kimwoojae <jaykim></jaykim>@jaykim.xyz>
 * @since 2018-10-27
 */

class BounceInterpolator(amplitude: Double, frequency: Double) :
    android.view.animation.Interpolator {
    private var mAmplitude = 1.0
    private var mFrequency = 10.0

    init {
        mAmplitude = amplitude
        mFrequency = frequency
    }

    override fun getInterpolation(time: Float): Float {
        return (-1.0 * Math.pow(Math.E, -time / mAmplitude) *
                Math.cos(mFrequency * time) + 1).toFloat()
    }
}