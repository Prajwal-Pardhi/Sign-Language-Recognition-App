package com.example.signlanguagerecognitionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
Button btnOfSpeak;
EditText textEnter;
TextToSpeech textToSpeech;
String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        btnOfSpeak=(Button)findViewById(R.id.btn_Speak);
        textEnter=(EditText)findViewById(R.id.et_Text);

        //Text To Speech code starts
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS)
                {
                    int language= textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        btnOfSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s= textEnter.getText().toString();
               int speech = textToSpeech.speak(s,textToSpeech.QUEUE_FLUSH,null);

            }
        });

        //ToolBar Code start
        //step 1
        setSupportActionBar(toolbar);

        //step 2
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Sign Recognition");
        }
        //ToolBar Code Ends

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    //Operations on options in toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if(itemId==R.id.opt_buy)
        {
            Toast.makeText(this, "Buy Subscription", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.opt_learn)
        {
            Toast.makeText(this, "Learn Sign language", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==android.R.id.home)
        {
            super.onBackPressed();
        }
        else
        {
            Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,About_Us.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}