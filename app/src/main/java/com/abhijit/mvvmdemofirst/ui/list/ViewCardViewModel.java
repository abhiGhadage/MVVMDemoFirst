package com.abhijit.mvvmdemofirst.ui.list;

import com.abhijit.mvvmdemofirst.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ViewCardViewModel extends BaseViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    ViewCardViewModel() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
