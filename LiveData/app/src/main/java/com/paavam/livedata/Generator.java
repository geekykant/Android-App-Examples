package com.paavam.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class Generator extends ViewModel {

    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getCurrentNumber() {
        if (num == null) {
            num = new MutableLiveData<>();
        }
        return num;
    }

    public void genNewNumber() {
        num.postValue(new Random().nextInt(100));
    }
}
