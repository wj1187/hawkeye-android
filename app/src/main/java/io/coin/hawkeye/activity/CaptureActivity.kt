package io.coin.hawkeye.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.coin.hawkeye.R
import io.coin.hawkeye.fragment.CaptureFragment

class CaptureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
                .replace(R.id.container, CaptureFragment.newInstance())
                .commit()

    }

}