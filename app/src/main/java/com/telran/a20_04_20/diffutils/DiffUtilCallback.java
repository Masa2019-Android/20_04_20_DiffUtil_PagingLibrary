package com.telran.a20_04_20.diffutils;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.telran.a20_04_20.Contact;

import java.util.List;

public class DiffUtilCallback extends DiffUtil.Callback {
    List<Contact> oldList;
    List<Contact> newList;

    public DiffUtilCallback(List<Contact> oldList, List<Contact> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldItem = oldList.get(oldItemPosition);
        Contact newItem = newList.get(newItemPosition);
        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldItem = oldList.get(oldItemPosition);
        Contact newItem = newList.get(newItemPosition);
        return oldItem.name().equals(newItem.name()) && oldItem.phone().equals(newItem.phone());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Contact oldItem = oldList.get(oldItemPosition);
        Contact newItem = newList.get(newItemPosition);
        Bundle bundle = new Bundle();
        if(!oldItem.phone().equals(newItem.phone())){
            bundle.putString("phone",newItem.phone());
        }
        if(!oldItem.name().equals(newItem.name())){
            bundle.putString("name",newItem.name());
        }

        if(bundle.size() == 0){
            return null;
        }
        return bundle;
    }
}
