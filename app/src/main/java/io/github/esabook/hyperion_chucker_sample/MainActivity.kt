package io.github.esabook.hyperion_chucker_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.willowtreeapps.hyperion.core.Hyperion
import io.github.esabook.hyperion_chucker_sample.databinding.ActivityMainBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vBinding.root)

        val client = SampleOkHttpClient(this).get()
        vBinding.buttonCreateTraffic.setOnClickListener {

            val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body()?.string()
                }
            })

        }

        vBinding.buttonOpenHyperion.setOnClickListener {
            Hyperion.open()
        }
    }
}
