package com.paavam.livedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class Fragment1 extends Fragment {

    private View view;
    private TextView tx;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);

        init();

        Generator generator = ViewModelProviders.of(getActivity()).get(Generator.class);

        // Create the observer which updates the UI.
        Observer<Integer> numObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tx.setText(integer + "");
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        generator.getCurrentNumber().observe(getViewLifecycleOwner(), numObserver);

        return view;
    }

    private void init() {
        tx = view.findViewById(R.id.textView);
        tx.setText("-1");
    }

}
