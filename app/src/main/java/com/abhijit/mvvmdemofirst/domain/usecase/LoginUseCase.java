package com.abhijit.mvvmdemofirst.domain.usecase;

import com.abhijit.mvvmdemofirst.network.TipsGoApiService;
import com.google.gson.JsonElement;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoginUseCase {
    private final TipsGoApiService tipsGoApiService;

    @Inject
    LoginUseCase(TipsGoApiService tipsGoApiService) {
        this.tipsGoApiService = tipsGoApiService;
    }

    public Single<JsonElement> loginUser(String userName,String password) {
        return tipsGoApiService.loginUser(userName,password,7,"fskfjsk");

    }

}
