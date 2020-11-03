package com.abhijit.mvvmdemofirst;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;


import androidx.fragment.app.Fragment;
import androidx.multidex.MultiDex;

import com.abhijit.mvvmdemofirst.di.AppComponent;
import com.abhijit.mvvmdemofirst.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

public class App extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    private int activitiesCount;
//    private BluetoothControllerImpl bluetoothController;
//    private SettingsManager settingsManager;


    @Override
    public void onCreate() {
        super.onCreate();
//        bluetoothController = new BluetoothControllerImpl(this);
//        settingsManager = new SettingsManager(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    private static final String TAG = App.class.getSimpleName();


    private boolean isInForeground() {
        return activitiesCount > 0;
    }


}

