package io.coin.hawkeye.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import io.coin.hawkeye.R
import io.coin.hawkeye.model.Product
import io.coin.hawkeye.ui.ProductAdapter
import kotlinx.android.synthetic.main.activity_product.*
import org.jetbrains.anko.startActivity

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val data = Gson().fromJson(intent.extras!!["data"] as String, Product::class.java)

        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)

        rv.layoutManager = LinearLayoutManager(rv.context)

        val adapter = ProductAdapter(this@ProductActivity, data)
        rv.adapter = adapter
    }

    override fun onBackPressed() {
        startActivity<CaptureActivity>()
        finish()
    }
}
