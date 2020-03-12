package com.study.gittest;

/**
 * Date:2020/3/12
 * author:lwb
 * Desc:
 */
public class LL {

    public void test(){
        Thread thread = new Thread();
        thread.stop();

    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().isInterrupted();
//            isInterrupted()
        }
    };
}
