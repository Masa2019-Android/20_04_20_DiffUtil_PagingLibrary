package com.telran.a20_04_20.paging;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.telran.a20_04_20.Contact;

public class DataSourceFactory extends DataSource.Factory<Integer, Contact> {
    MockStore store;

    public DataSourceFactory(MockStore store) {
        this.store = store;
    }

    @NonNull
    @Override
    public DataSource<Integer, Contact> create() {
        return new MyDataSource(store);
    }
}
