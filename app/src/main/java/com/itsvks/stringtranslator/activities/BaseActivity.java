package com.itsvks.stringtranslator.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.itsvks.stringtranslator.classes.CrashHandler;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(this));
    }
}
