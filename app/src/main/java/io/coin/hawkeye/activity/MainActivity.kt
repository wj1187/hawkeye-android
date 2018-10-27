package io.coin.hawkeye.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.coin.hawkeye.R
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity<CaptureActivity>()
        finish()
    }
}
