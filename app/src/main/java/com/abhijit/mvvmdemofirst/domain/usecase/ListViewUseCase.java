package com.abhijit.mvvmdemofirst.domain.usecase;

import com.abhijit.mvvmdemofirst.network.TipsGoApiService;

import javax.inject.Inject;


public class ListViewUseCase {
    private final TipsGoApiService tipsGoApiService;

    @Inject
    ListViewUseCase(TipsGoApiService tipsGoApiService) {
        this.tipsGoApiService = tipsGoApiService;
    }

  /*  public Single<JsonElement> listData(String userName, String password) {
        return tipsGoApiService.listData(userName,password);

    }*/

}
