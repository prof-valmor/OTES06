package com.profvalmor.fragmentapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.profvalmor.fragmentapp.R;

public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    public HomeFragment() {
        super(R.layout.activity_home);
    }

    @Override
    public void onStart() {
        super.onStart();
        //Acessar um objeto da tela.
        Button btOkay = getActivity().findViewById(R.id.btOkay);
        btOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}