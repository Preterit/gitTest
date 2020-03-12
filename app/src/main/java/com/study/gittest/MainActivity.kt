package com.study.gittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ss = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
            }
        }

    }

    /**
     * dev的方法
     */
    fun gitMethod() {
        println("dev分支 --- 打印")
        println("dev分支 --——- 打印2")
    }
}
