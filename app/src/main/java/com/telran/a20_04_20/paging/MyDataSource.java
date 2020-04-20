package com.telran.a20_04_20.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.telran.a20_04_20.Contact;

import java.util.List;

public class MyDataSource extends PositionalDataSource<Contact> {
    MockStore store;

    public MyDataSource(MockStore store) {
        this.store = store;
//        store.subscribe(new Runnable() {
//            @Override
//            public void run() {
//                invalidate();
//            }
//        });
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Contact> callback) {
        Log.d("MY_TAG", "loadInitial: start: " + params.requestedStartPosition + " size: " + params.requestedLoadSize);
        List<Contact> result = store.getPart(params.requestedStartPosition,params.requestedLoadSize);
        callback.onResult(result,0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Contact> callback) {
        Log.d("MY_TAG", "loadRange: start: " + params.startPosition + " size: " + params.loadSize);
        List<Contact> result = store.getPart(params.startPosition,params.loadSize);

        callback.onResult(result);
    }
}
