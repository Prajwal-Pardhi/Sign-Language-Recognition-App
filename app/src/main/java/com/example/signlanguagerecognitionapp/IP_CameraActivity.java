package com.example.signlanguagerecognitionapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class IP_CameraActivity extends AppCompatActivity {

    Button start;
    EditText etURL;
    //IPCamView ipcam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_camera);

        start=findViewById(R.id.btnStart);
        etURL = findViewById(R.id.url);

        //ipcam = findViewById(R.id.ip_cam_view);

        /*start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l = etURL.getText().toString();
                if(l!=null){
                    ipcam.setUrl(l);
                    ipcam.setInterval(5);
                    ipcam.start();

                }
                else{
                    Toast.makeText(IP_CameraActivity.this, "Enter correct URL or Check internet connection", Toast.LENGTH_LONG).show();
                }

            }
        });*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        //ipcam.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //ipcam.stop();

    }

}