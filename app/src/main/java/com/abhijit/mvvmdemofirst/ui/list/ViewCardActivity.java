package com.abhijit.mvvmdemofirst.ui.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhijit.mvvmdemofirst.R;
import com.abhijit.mvvmdemofirst.di.utils.ViewModelFactory;
import com.abhijit.mvvmdemofirst.domain.model.ListViewModel;
import com.abhijit.mvvmdemofirst.ui.base.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class ViewCardActivity extends BaseActivity<ViewCardViewModel> {

    @Inject
    ViewModelFactory<ViewCardViewModel> viewModelFactory;

    private ViewCardViewModel viewModel;

    @BindView(R.id.txt_stud_name) TextView txt_stud_name;
    @BindView(R.id.txt_stud_phone) TextView txt_stud_phone;
    @BindView(R.id.txt_stud_rollNo) TextView txt_stud_rollNo;
    @BindView(R.id.txt_stud_gender) TextView txt_stud_gender;
    @BindView(R.id.txt_stud_class) TextView txt_stud_class;
    @BindView(R.id.txt_stud_add) TextView txt_stud_add;
    @BindView(R.id.img_view) ImageView img_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_view_card);


        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewCardViewModel.class);


        ListViewModel listViewModel = getIntent().getParcelableExtra("LIST_VIEW_MODEL");

        if (listViewModel != null) {
            txt_stud_name.setText(listViewModel.getName());
            txt_stud_phone.setText(listViewModel.getPhone());
            txt_stud_rollNo.setText(listViewModel.getRollNo());
            txt_stud_class.setText(listViewModel.getClassDiv());
            txt_stud_gender.setText(listViewModel.getGender());
            txt_stud_add.setText(listViewModel.getAddress());

            Picasso.get().load(listViewModel.getImages())
                    .placeholder(R.drawable.id_profil)
                    .error(R.drawable.id_profil)
                    .into(img_view);
        }

    }

    @Override
    protected ViewCardViewModel getViewModel() {
        return viewModel;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        leftTorightAnimated();
        finish();
    }
}
