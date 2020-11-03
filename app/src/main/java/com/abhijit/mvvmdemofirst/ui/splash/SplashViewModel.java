package com.abhijit.mvvmdemofirst.ui.splash;

import com.abhijit.mvvmdemofirst.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashViewModel extends BaseViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    SplashViewModel(){
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
