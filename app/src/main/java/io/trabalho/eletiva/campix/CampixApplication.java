package io.trabalho.eletiva.campix;

import android.app.Application;

import timber.log.Timber;

public class CampixApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
