package com.abhijit.mvvmdemofirst.di.modules;

import com.abhijit.mvvmdemofirst.ui.list.ListActivity;
import com.abhijit.mvvmdemofirst.ui.list.ViewCardActivity;
import com.abhijit.mvvmdemofirst.ui.login.LoginActivity;
import com.abhijit.mvvmdemofirst.ui.network.NetWorkActivity;
import com.abhijit.mvvmdemofirst.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract NetWorkActivity bindNetWorkActivity();

    @ContributesAndroidInjector
    abstract ListActivity bindListActivity();

    @ContributesAndroidInjector
    abstract ViewCardActivity bindViewCardActivity();
}
