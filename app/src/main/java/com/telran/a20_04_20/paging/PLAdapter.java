package com.telran.a20_04_20.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.telran.a20_04_20.Contact;
import com.telran.a20_04_20.R;

public class PLAdapter extends PagedListAdapter<Contact, PLAdapter.MyViewHolder> {


    protected PLAdapter(@NonNull DiffUtil.ItemCallback<Contact> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = getItem(position);
        holder.bind(contact);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt, phoneTxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.nameTxt);
            phoneTxt = itemView.findViewById(R.id.phoneTxt);
        }

        public void bind(Contact contact){
            nameTxt.setText(contact.name());
            phoneTxt.setText(contact.phone());
        }
    }
}
