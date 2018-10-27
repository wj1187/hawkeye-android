package io.coin.hawkeye.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.coin.hawkeye.R

class VegiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegi)

        val data = mutableMapOf("a" to 6F, "b" to 1F, "c" to 3F, "d" to 2F, "e" to 4F, "f" to 5F)
        val result = data.toList().sortedBy { (_, value) -> value}.toMap()

        for (entry in result) {
            print("Key: " + entry.key)
            println(" Value: " + entry.value)
        }
    }
}
