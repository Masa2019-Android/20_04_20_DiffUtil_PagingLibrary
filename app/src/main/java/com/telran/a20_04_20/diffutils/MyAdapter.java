package com.telran.a20_04_20.diffutils;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.telran.a20_04_20.Contact;
import com.telran.a20_04_20.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Contact> list = new ArrayList<>();

    public MyAdapter() {
        list.add(new Contact("1","Vasya","12345"));
        list.add(new Contact("2","Petya","12345"));
        list.add(new Contact("3","Sofa","12345"));
        list.add(new Contact("4","David","12345"));
        list.add(new Contact("5","Anna","12345"));
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
        Log.d("MY_TAG", "onBindViewHolder: " + position);
        Contact contact = list.get(position);
        holder.bind(contact);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
        Log.d("MY_TAG", "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "], payloads = [" + payloads + "]");
        if(payloads.isEmpty()){
            super.onBindViewHolder(holder,position,payloads);
        }else{
            Bundle bundle = (Bundle) payloads.get(0);
            for(String key : bundle.keySet()){
                if(key.equals("name")){
                    holder.nameTxt.setText(bundle.getString(key));
                }
                if(key.equals("phone")){
                    holder.phoneTxt.setText(bundle.getString(key));
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void changeData(List<Contact> data){
        DiffUtilCallback callback = new DiffUtilCallback(list, data);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback,false);
        list = data;
        result.dispatchUpdatesTo(this);
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
