package com.study.gittest

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = this::class.java.name
    }

    private var stopTag = true

    private lateinit var thread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ss = object : Handler() {
            override fun handleMessage(msg: Message) {
            }
        }

        thread = Thread(stopTagThread)
        thread.start()

    }


    private val interruptedThread = object : Runnable {
        override fun run() {
            Thread.currentThread().isInterrupted
        }

    }

    /**
     * 标志法停止线程
     */
    private val stopTagThread = Runnable {
        while (stopTag) {
            Log.e(TAG, "stopTagThread  -- start")
            Thread.sleep(5000)
            Log.e(TAG, "stopTagThread  -- finish")
        }
        Log.e(TAG, "stopTagThread  -- stoped")
    }

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {

        }
    }

    /**
     * 线程停止的点击事件
     */
    fun stopClick(v: View) {
        try {
            thread.stop()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
            stopTag = false
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
