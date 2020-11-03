package com.abhijit.mvvmdemofirst.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;

import com.abhijit.mvvmdemofirst.R;
import com.abhijit.mvvmdemofirst.di.utils.ViewModelFactory;
import com.abhijit.mvvmdemofirst.domain.pref.SharedPref;
import com.abhijit.mvvmdemofirst.ui.Navigator;
import com.abhijit.mvvmdemofirst.ui.base.BaseActivity;

import org.json.JSONObject;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity<LoginViewModel> {
    @Inject
    ViewModelFactory<LoginViewModel> viewModelFactory;

    private LoginViewModel loginViewModel;

    @Inject
    Navigator navigator;

    @Inject
    SharedPref sharedPref;

    @BindView(R.id.content_parent)
    ConstraintLayout content_parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        setStatusBarColor(R.color.colorAppBack);

        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);

//        edtEmail.setText(sharedPref.getUserEmail());

        bindViewModel();
    }

    @Override
    protected LoginViewModel getViewModel() {
        return loginViewModel;
    }


    @OnClick(R.id.btn_login)
    public void OnClickLogin() {
        loginUser();
    }

    private void loginUser() {
//        String email = edtEmail.getText().toString().trim();
        String username = "ehsutp";
        String password = "123456";

//        if (TextUtils.isEmpty(email)) {
//            edtEmail.setError("Please Enter Email !!");
//            edtEmail.requestFocus();
//        } else if (!email.matches(EMAIL_PATTERN)) {
//            edtEmail.setError("Please Enter Valid Email !!");
//            edtEmail.requestFocus();
//        } else {

        if (isOnline()) {
            loginViewModel.loginUser(username,password);
        } else {
            navigator.navigateInternetConnectErrorScreen(this);
            rightToLeftAnimated();
        }
//        }
    }


    private void bindViewModel() {
        loginViewModel.getLoginResponse()
                .observe(this, forgotPass -> {
                    assert forgotPass != null;
                    switch (forgotPass.status) {
                        case SUCCESS:
                            try {
                                String response = String.valueOf(forgotPass.responce);
                                JSONObject jsonObject = new JSONObject(response);


                                navigator.navigateToListScreen(this);
                                rightToLeftAnimated();


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case ERROR:
                            onErrorMessage(content_parent, forgotPass.error);
                            break;
                    }
                });
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigator.navigateToWelcomeScreen(this);
        leftTorightAnimated();
        finish();
    }

}
