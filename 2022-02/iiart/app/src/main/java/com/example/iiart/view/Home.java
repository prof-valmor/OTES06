package com.example.iiart.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.iiart.R;

public class Home extends Fragment {
    public Home() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btBuscar = getActivity().findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt = getActivity().findViewById(R.id.txtTitle);
                txt.setText("BUSCAR...");

                Intent intent = new Intent();
                intent.setAction("navegar");
                intent.putExtra("qual", "listing");
                getActivity().sendBroadcast(intent);
            }
        });
    }
}