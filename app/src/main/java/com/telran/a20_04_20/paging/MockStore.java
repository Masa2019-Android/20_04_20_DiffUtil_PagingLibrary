package com.telran.a20_04_20.paging;

import android.os.Handler;
import android.os.Looper;

import com.telran.a20_04_20.Contact;

import java.util.ArrayList;
import java.util.List;

public class MockStore {
    private List<Contact> list = new ArrayList<>();
    Handler handler = new Handler(Looper.getMainLooper());

    public MockStore() {
        for (int i = 0; i < 200; i++) {
            list.add(new Contact("Name " + i,String.valueOf((int)(Math.random()*10_000_000)),i));
        }
    }

    public List<Contact> getPart(int start, int count){
        if(start > list.size()-1){
            return new ArrayList<>();
        }else if(start+count > list.size()){
            return list.subList(start,list.size());
        }
//        return list.subList(start, start+count).stream().filter(c -> c.key() % 2 == 0).collect(Collectors.toList());
        return list.subList(start,start+count);
    }


//    public void subscribe(Runnable runnable){
//        handler.postDelayed(runnable,5000);
//    }
}
