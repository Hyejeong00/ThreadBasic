package com.example.threadbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    WorkerThread wt;
    boolean running = true;
    String TAG2 = "THREAD2";
    String TAG = "Thread";

    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                }
                Log.v(TAG, "Thread time=" + i);
            }
        }
    }

    class WorkerRunnable implements Runnable {
        public void run() {
            running = true;
            int i=0;
            for(i=0;i<20&&running;i++){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                }
                Log.v("THREAD", "Runnable time" + i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;
        wr = new Thread(new WorkerRunnable());
        wr.run();
        /*wt = new WorkerThread();
        wr=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                for(i=0;i<20&&running;i++){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                    }
                    Log.v("THREAD", "Runnable time" + i);
                }
            }
        });
        wt.start();
        wr.start();*/
        Log.v(TAG2, "Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;

        Log.v(TAG2, "Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG2, "Now I am in onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG2, "Now I am in onResume");
    }
}