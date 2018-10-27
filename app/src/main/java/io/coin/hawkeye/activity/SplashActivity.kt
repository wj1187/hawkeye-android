package io.coin.hawkeye.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import io.coin.hawkeye.R
import org.jetbrains.anko.startActivity
import android.view.animation.AnimationUtils
import io.coin.hawkeye.ui.BounceInterpolator
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        val interpolator = BounceInterpolator(0.2, 30.toDouble())
        myAnim.interpolator = interpolator

        Handler().postDelayed({
            logo.startAnimation(myAnim)
        }, ANIMATION_INTERVAL)

        Handler().postDelayed({
            startActivity<MainActivity>()
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }

    companion object {
        private const val ANIMATION_INTERVAL: Long = 500
        private const val SPLASH_DISPLAY_LENGTH: Long = 2500
    }
}