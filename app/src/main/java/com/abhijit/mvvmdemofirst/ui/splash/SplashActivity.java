package com.abhijit.mvvmdemofirst.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;

import com.abhijit.mvvmdemofirst.R;
import com.abhijit.mvvmdemofirst.di.utils.ViewModelFactory;
import com.abhijit.mvvmdemofirst.domain.pref.SharedPref;
import com.abhijit.mvvmdemofirst.ui.Navigator;
import com.abhijit.mvvmdemofirst.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class SplashActivity extends BaseActivity<SplashViewModel> {

    @Inject
    ViewModelFactory<SplashViewModel> viewModelFactory;

    private SplashViewModel viewModel;

    @Inject
    Navigator navigator;

    @Inject
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        setStatusBarColor(R.color.colorBlack);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);

        initialize();

    }

    private void initialize() {
        int SPLASH_DELAY_MILLIS = 3000;
        new Handler().postDelayed(this::goToNextScreen, SPLASH_DELAY_MILLIS);
    }

    @Override
    protected SplashViewModel getViewModel() {
        return viewModel;
    }

    private void goToNextScreen() {
//        if (sharedPref.getLogin().equals("false")) {
//            navigator.navigateToLoginScreen(this);
//            rightToLeftAnimated();
//        } else {
            navigator.navigateToListScreen(this);
            rightToLeftAnimated();
//        }
    }
}
