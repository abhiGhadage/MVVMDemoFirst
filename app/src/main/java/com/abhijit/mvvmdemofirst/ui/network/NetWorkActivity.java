package com.abhijit.mvvmdemofirst.ui.network;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.lifecycle.ViewModelProviders;

import com.abhijit.mvvmdemofirst.R;
import com.abhijit.mvvmdemofirst.di.utils.ViewModelFactory;
import com.abhijit.mvvmdemofirst.ui.Navigator;
import com.abhijit.mvvmdemofirst.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class NetWorkActivity extends BaseActivity<NetWorkViewModel> {

    @Inject
    ViewModelFactory<NetWorkViewModel> viewModelFactory;

    private NetWorkViewModel viewModel;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NetWorkViewModel.class);

        if (getIntent() != null)
            TAG = getIntent().getStringExtra("ACTIVITY_TAG");

        setStatusBarColor(R.color.colorBackgroundWhite);

    }

    @OnClick(R.id.ingBack)
    public void onClickBack() {
        if (isOnline()) {
            onBackPressed();
            leftTorightAnimated();
        }
    }

    @OnClick(R.id.tryAgainButton)
    public void onClickTryAgain() {
        if (isOnline()) {
            onBackPressed();
            leftTorightAnimated();
        }
    }

    @Override
    public NetWorkViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void onBackPressed() {
        if (isOnline()) {
            super.onBackPressed();
            leftTorightAnimated();
        }
    }
}

