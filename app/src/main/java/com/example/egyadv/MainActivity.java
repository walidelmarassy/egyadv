package com.example.egyadv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splashlauncher splashlauncher=new splashlauncher();
        splashlauncher.start();



    }
    private class splashlauncher extends Thread{
        @Override
        public void run() {
            try {
                sleep(4000);

            }
            catch (InterruptedException e){
                e.printStackTrace();

            }
            Intent intent=new Intent(MainActivity.this,SigninActivity.class);
            startActivity(intent);
            MainActivity.this.finish();

        }
    }

}
