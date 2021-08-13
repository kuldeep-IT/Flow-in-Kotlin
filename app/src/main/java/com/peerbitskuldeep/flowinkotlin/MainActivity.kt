package com.peerbitskuldeep.flowinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //flow is a replacement of liveData
        val flow = flow<String> {
            for (i in 1..10) {
                emit("Kuldeep $i")
                delay(1000L)
            }
        }


        GlobalScope.launch {

           flow.collect {

               println(it)
//                delay(2000L)

           }

        }

    }
}