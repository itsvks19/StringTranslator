package com.itsvks.stringtranslator.classes.application;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.google.android.material.color.DynamicColors;
import com.itsvks.stringtranslator.classes.CrashHandler;

public class StringTranslator extends Application {

    private static StringTranslator sIstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sIstance = this;
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(getContext()));
        if (isAtLeastS() && DynamicColors.isDynamicColorAvailable()) {
            DynamicColors.applyToActivitiesIfAvailable(this);
        }
    }
    
    public static Context getContext() {
        return sIstance.getApplicationContext();
    }

    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S;
    }
}
