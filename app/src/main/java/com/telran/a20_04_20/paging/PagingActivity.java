package com.telran.a20_04_20.paging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.telran.a20_04_20.Contact;
import com.telran.a20_04_20.R;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        RecyclerView rv = findViewById(R.id.myrv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final PLAdapter adapter = new PLAdapter(diffCallback);
        rv.setAdapter(adapter);

//        MyDataSource dataSource = new MyDataSource(new MockStore());

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .setInitialLoadSizeHint(5)
                .build();

//        PagedList<Contact> pagedList = new PagedList.Builder<>(dataSource,config)
//                .setFetchExecutor(Executors.newSingleThreadExecutor())
//                .setNotifyExecutor(new Executor() {
//                    Handler handler = new Handler(Looper.getMainLooper());
//                    @Override
//                    public void execute(Runnable command) {
//                        handler.post(command);
//                    }
//                }).build();

        DataSourceFactory factory = new DataSourceFactory(new MockStore());
        LiveData<PagedList<Contact>> pagedListLiveData = new LivePagedListBuilder<>(factory,config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build();

        pagedListLiveData.observe(this, new Observer<PagedList<Contact>>() {
            @Override
            public void onChanged(PagedList<Contact> contacts) {
                adapter.submitList(contacts);
            }
        });

    }


    DiffUtil.ItemCallback<Contact> diffCallback = new DiffUtil.ItemCallback<Contact>() {
        @Override
        public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.name().equals(newItem.name()) && oldItem.phone().equals(newItem.phone());
        }
    };
}
