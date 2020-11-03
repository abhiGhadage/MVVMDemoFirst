package com.abhijit.mvvmdemofirst.ui.login;

import androidx.lifecycle.MutableLiveData;

import com.abhijit.mvvmdemofirst.domain.usecase.LoginUseCase;
import com.abhijit.mvvmdemofirst.network.entities.ApiResponse;
import com.abhijit.mvvmdemofirst.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final LoginUseCase loginUseCase;
    private final MutableLiveData<ApiResponse> apiResponse = new MutableLiveData<>();


    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    void loginUser(String userName,String password) {
        showLoading(true);
        disposables.add(loginUseCase.loginUser(userName,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(data -> apiResponse.setValue(ApiResponse.loading()))
                .subscribe(data -> {
                    showLoading(false);
                    apiResponse.setValue(ApiResponse.success(data));
                }, error -> {
                    showLoading(false);
                    apiResponse.setValue(ApiResponse.error(error));
                }));

    }

    MutableLiveData<ApiResponse> getLoginResponse() {
        return apiResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }

}
