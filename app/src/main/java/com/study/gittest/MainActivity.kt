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
     * master的方法
     */
    fun gitMethod() {
        println("master分支 --- 准备开分支")
        println("master分支 --- 准备开启新的分支")
        println("dev分支 --- 垃圾")
        println("dev分支 --- ")
        println("master分支 --- 1")
    }
}
