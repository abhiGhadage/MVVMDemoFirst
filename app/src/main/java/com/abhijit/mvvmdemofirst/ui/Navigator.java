package com.abhijit.mvvmdemofirst.ui;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.abhijit.mvvmdemofirst.domain.model.ListViewModel;
import com.abhijit.mvvmdemofirst.domain.pref.SharedPref;
import com.abhijit.mvvmdemofirst.ui.list.ViewCardActivity;
import com.abhijit.mvvmdemofirst.ui.login.LoginActivity;
import com.abhijit.mvvmdemofirst.ui.network.NetWorkActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class Navigator {

    @Inject
    SharedPref sharedPref;

    @Inject
    public Navigator() {

    }

    public void navigateInternetConnectErrorScreen(@NonNull Activity context) {
        Intent intent = new Intent(context, NetWorkActivity.class);
        context.startActivity(intent);
    }

    public void navigateToWelcomeScreen(@NonNull Activity context) {
        Intent intent;
        intent = new Intent(context, NetWorkActivity.class);
        context.startActivity(intent);
        context.finish();
    }

    public void navigateToLoginScreen(@NonNull Activity context) {
        Intent intent;
        intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        context.finishAffinity();
    }

    public void navigateToListScreen(@NonNull Activity context) {
        Intent intent;
        intent = new Intent(context, ListActivity.class);
        context.startActivity(intent);
        context.finish();
//        context.finishAffinity();
    }

    public void navigateToCardViewScreen(@NonNull Activity context, ListViewModel listViewModel) {
        Intent intent;
        intent = new Intent(context, ViewCardActivity.class);
        intent.putExtra("LIST_VIEW_MODEL", listViewModel);
        context.startActivity(intent);
//        context.finish();
//        context.finishAffinity();
    }

 /*   public void navigateToSignUpScreen(@NonNull Activity context, String emailPhone) {
        Intent intent;
        intent = new Intent(context, SignUpActivity.class);
        intent.putExtra("EMAIL_PHONE", emailPhone);
        context.startActivity(intent);
        context.finish();
    }*/

}

