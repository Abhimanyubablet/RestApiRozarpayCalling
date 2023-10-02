package com.example.corotineapicalling

import android.annotation.SuppressLint
import android.media.session.PlaybackState.CustomAction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.ListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.nio.charset.StandardCharsets


class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         listView = findViewById(R.id.listView)

    }

    override fun onStart() {
        super.onStart()
        val credential = Credentials.basic("rzp_test_eycPpy8iPUSB5i", "BTfxmL1XyVfmkyQCOM87I73g")

        val headerMap =
            hashMapOf<String, String>(
                "Authorization" to credential
            )

        ApiCalling.create().getUser(headerMap)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { result ->

                listView.adapter = customAdapter(this,result.items)
//                CoroutineScope(Dispatchers.IO).launch {
//
//                    result.items.forEach { dataModel ->
//                        Log.d(
//                            "UserDataModel",
//                            "Name: ${dataModel.name}, Email: ${dataModel.email}"
//                        )
//
//
//                    }
//                }
            }
    }


}


