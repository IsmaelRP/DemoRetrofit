package com.practica.ismael.retrofitdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.practica.ismael.retrofitdemo.R;
import com.practica.ismael.retrofitdemo.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.flContent,
                   new MainFragment(), MainFragment.class.getSimpleName());
        }
    }
}
