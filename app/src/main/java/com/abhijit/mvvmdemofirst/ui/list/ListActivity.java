package com.abhijit.mvvmdemofirst.ui.list;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.abhijit.mvvmdemofirst.R;
import com.abhijit.mvvmdemofirst.di.utils.ViewModelFactory;
import com.abhijit.mvvmdemofirst.domain.model.ListViewModel;
import com.abhijit.mvvmdemofirst.ui.Navigator;
import com.abhijit.mvvmdemofirst.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class ListActivity extends BaseActivity<ListDetailsViewModel> {

    @Inject
    ViewModelFactory<ListDetailsViewModel> viewModelFactory;


    @Inject
    Navigator navigator;

    private ListDetailsViewModel viewModel;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context mContext;

    ListViewAdapter listViewAdapter;
    ArrayList<ListViewModel> listViewModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_list);


        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListDetailsViewModel.class);

        seUpView();

    }

    private void seUpView() {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        setData();

        listViewAdapter = new ListViewAdapter(this, listViewModelArrayList);
        recyclerView.setAdapter(listViewAdapter);

        listViewAdapter.setOnClickListener(new ListViewAdapter.AdapterOnClickListener() {
            @Override
            public void onAdapterClick(ListViewModel listViewModel, int position) {
                navigator.navigateToCardViewScreen(ListActivity.this,listViewModel);
                rightToLeftAnimated();
            }
        });
    }

    private void setData() {
        listViewModelArrayList.add(new ListViewModel("Sachin Patil","2301","Male","At/Post- Shreepur Tal - Malashiras Dist - Solapur","BCA-I","1234567890","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        listViewModelArrayList.add(new ListViewModel("Dayanand Ghadage","2302","Male","At/Post- Nevare Tal - Malashiras Dist - Solapur","BCA-I","1234567889","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));
        listViewModelArrayList.add(new ListViewModel("Sagar Kadam","2303","Male","At/Post- Nandure Tal - Pandharpur Dist - Solapur","BCA-I","1234567878","https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"));
        listViewModelArrayList.add(new ListViewModel("Sonali Mane","2304","Female","At/Post- Karkamb Tal - Malashiras Dist - Solapur","BCA-I","1234567867","https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"));
        listViewModelArrayList.add(new ListViewModel("Rahul Vyavhare","2305","Male","At/Post- Mahalung Tal - Malashiras Dist - Solapur","BCA-I","1234567856","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        listViewModelArrayList.add(new ListViewModel("Ram Vasekar","2306","Male","At/Post- Pandharpur Tal - Pandharpur Dist - Solapur","BCA-I","1234567845","https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"));
        listViewModelArrayList.add(new ListViewModel("Dipali Shinde","2307","Female","At/Post- Akluj Tal - Malashiras Dist - Solapur","BCA-I","1234567834","https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"));
    }

    @Override
    protected ListDetailsViewModel getViewModel() {
        return viewModel;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        leftTorightAnimated();
        finish();
    }
}
