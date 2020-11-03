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
        listViewModelArrayList.add(new ListViewModel("Sachin Patil","2301","Male","At/Post- Shreepur Tal - Malashiras Dist - Solapur","BCA-I","1234567890","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=Kx2xsWTPYZCe8M"));
        listViewModelArrayList.add(new ListViewModel("Dayanand Ghadage","2302","Male","At/Post- Nevare Tal - Malashiras Dist - Solapur","BCA-I","1234567889","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=0WCMHJOqQ0-MmM"));
        listViewModelArrayList.add(new ListViewModel("Sagar Kadam","2303","Male","At/Post- Nandure Tal - Pandharpur Dist - Solapur","BCA-I","1234567878","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=eRWFwGusAo6U9M&imgdii=4N6gh5D1c6qiBM"));
        listViewModelArrayList.add(new ListViewModel("Sonali Mane","2304","Female","At/Post- Karkamb Tal - Malashiras Dist - Solapur","BCA-I","1234567867","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=eRWFwGusAo6U9M"));
        listViewModelArrayList.add(new ListViewModel("Rahul Vyavhare","2305","Male","At/Post- Mahalung Tal - Malashiras Dist - Solapur","BCA-I","1234567856","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=_MmPcr2Zhm1JTM&imgdii=juOeed4qdwe4tM"));
        listViewModelArrayList.add(new ListViewModel("Ram Vasekar","2306","Male","At/Post- Pandharpur Tal - Pandharpur Dist - Solapur","BCA-I","1234567845","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=juOeed4qdwe4tM&imgdii=F5wmmaCdyjhaoM"));
        listViewModelArrayList.add(new ListViewModel("Dipali Shinde","2307","Female","At/Post- Akluj Tal - Malashiras Dist - Solapur","BCA-I","1234567834","https://www.google.com/search?q=user&rlz=1C1CHBD_ruIN903IN903&sxsrf=ALeKk03DL4uuXL4U08rD-NaQRxtEs9_cCw:1604343306209&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjB3PTGxOTsAhV0wzgGHRgNCbAQ_AUoAXoECB8QAw&biw=1366&bih=625#imgrc=Kx2xsWTPYZCe8M&imgdii=VvgvfIp8tZ5HZM"));
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
