package io.coin.hawkeye.tools

import android.app.Activity
import android.media.Image
import android.util.Log
import com.google.gson.Gson
import id.zelory.compressor.Compressor
import io.coin.hawkeye.activity.ProductActivity
import io.coin.hawkeye.api.ApiProvider
import io.coin.hawkeye.model.Product
import okhttp3.MediaType

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import okhttp3.RequestBody
import okhttp3.MultipartBody
import org.jetbrains.anko.startActivity

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

/**
 * Saves a JPEG [Image] into the specified [File].
 */
internal class ImageUploader(
    private val activity: Activity,

    /**
         * The JPEG image
         */
        private val image: Image,

    /**
         * The file we save the image into.
         */
        private val file: File
) : Runnable {

    override fun run() {
        val buffer = image.planes[0].buffer
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes)
        var output: FileOutputStream? = null
        try {
            output = FileOutputStream(file).apply {
                write(bytes)
            }
        } catch (e: IOException) {
            Log.e(TAG, e.toString())
        } finally {
            image.close()
            output?.let {
                try {
                    it.close()
                } catch (e: IOException) {
                    Log.e(TAG, e.toString())
                }
            }

            Log.d("dimidimi", "log0")

            val compressedImageFile = Compressor(activity).compressToFile(file)
            val reqFile = RequestBody.create(MediaType.parse("image/*"), compressedImageFile)
            val body = MultipartBody.Part.createFormData("image", compressedImageFile.name, reqFile)

            Log.d("dimidimi", "log1")

            val call = ApiProvider.provideApi(activity).postImage(reqFile)
            ApiProvider.request(
                call = call,
                success = {
                    Log.d("dimidimi", "log2")
                    if(it.code()==200) {
                        activity.startActivity<ProductActivity>("data" to Gson().toJson(it.body()))
                        activity.finish()
                    } else{
                        Log.d("code", it.toString())
                    }
                },
                fail = {
                    it.printStackTrace()
                }
            )
        }
    }

    companion object {
        /**
         * Tag for the [Log].
         */
        private val TAG = "ImageUploader"
    }
}
