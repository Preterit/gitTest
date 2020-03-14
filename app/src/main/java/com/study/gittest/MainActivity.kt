package com.study.gittest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
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
    private lateinit var interruptThread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ss = object : Handler() {
            override fun handleMessage(msg: Message) {
                println(TAG)
            }
        }

        thread = Thread(stopTagThread)
//        thread.start()

        interruptThread = Thread(interruptedRunnable)
//        interruptThread.start()

    }


    /**
     * interrupted 方式停止线程
     */
    private val interruptedRunnable = object : Runnable {
        override fun run() {
//            while (true) {
//                try {
//                    Log.e(TAG, "interruptedThread -- ${Thread.currentThread().isInterrupted}")
//                    Thread.sleep(50000)
//                    Log.e(TAG, "interruptedThread -- 睡眠结束")
//                } catch (e: Exception) {
//                    Log.e(TAG, "catch -- ${Thread.currentThread().isInterrupted}")
////                    break
//                } finally {
//                }
//            }
            while (!Thread.currentThread().isInterrupted) {
                Log.e(TAG, " -- ${Thread.currentThread().isInterrupted}")
                Thread.sleep(10000)
            }
            Log.e(TAG, "interruptedThread -- stop")
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
     * interrupt 方法中断线程
     */
    fun interruptClick(v: View) {
        interruptThread.interrupt()
    }

    /**
     * 跳转新activity
     */
    fun skip(v: View) {
        startActivity(Intent(this,HorScrActivity::class.java))
    }
}
