package com.abhijit.mvvmdemofirst.ui.network;

import com.abhijit.mvvmdemofirst.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NetWorkViewModel  extends BaseViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    NetWorkViewModel() {

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }

}