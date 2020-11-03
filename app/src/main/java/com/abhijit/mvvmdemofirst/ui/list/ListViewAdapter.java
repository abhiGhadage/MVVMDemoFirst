package com.abhijit.mvvmdemofirst.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abhijit.mvvmdemofirst.R;
import com.abhijit.mvvmdemofirst.domain.model.ListViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ListViewModel> listViewModelArrayList;
    private AdapterOnClickListener onClickListener;

    public ListViewAdapter(Context mContext, ArrayList<ListViewModel> listViewModelArrayList) {
        this.mContext = mContext;
        this.listViewModelArrayList = listViewModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_row_item_adapter, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ListViewModel listViewModel = listViewModelArrayList.get(position);

        String name = listViewModel.getName();

        holder.txt_stud_name.setText(name);
        holder.txt_stud_rollNo.setText(listViewModel.getRollNo());
        holder.txt_stud_class.setText(listViewModel.getClassDiv());
        Picasso.get().load(listViewModel.getImages())
                .placeholder(R.drawable.id_profil)
                .error(R.drawable.id_profil)
                .into(holder.img_the_face_photo);

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onAdapterClick(listViewModel,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listViewModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_stud_name,txt_stud_rollNo,txt_stud_class;
        ImageView img_the_face_photo;
        CardView card_view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            card_view = itemView.findViewById(R.id.card_view);
            txt_stud_name = itemView.findViewById(R.id.txt_stud_name);
            txt_stud_rollNo = itemView.findViewById(R.id.txt_stud_rollNo);
            txt_stud_class = itemView.findViewById(R.id.txt_stud_class);
            img_the_face_photo = itemView.findViewById(R.id.img_the_face_photo);
        }
    }

    public interface AdapterOnClickListener {
        void onAdapterClick(ListViewModel listViewModel, int position);
    }
    public void setOnClickListener(AdapterOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}