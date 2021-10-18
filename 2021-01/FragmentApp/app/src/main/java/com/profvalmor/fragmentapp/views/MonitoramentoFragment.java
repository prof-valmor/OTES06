package com.profvalmor.fragmentapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import com.profvalmor.fragmentapp.R;
import com.profvalmor.fragmentapp.model.Geladeira;

public class MonitoramentoFragment extends Fragment {

    private TextView mTextView;

    public MonitoramentoFragment() {
        super(R.layout.activity_monitoramento);
    }

    @Override
    public void onStart() {
        super.onStart();
        //
        EditText edtText = getView().findViewById(R.id.edtStatus);
        //
        String texto = "C: " + Geladeira.getInstance().getCongelador().getState().name();
        texto += "\n";
        texto += "R: " + Geladeira.getInstance().getRefrigerador().getState().name();
        edtText.setText(texto);

//        Button btBack = findViewById(R.id.btBack);

//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SelecaoDeTemperatura.class);
//                startActivity(intent);
//            }
//        });
    }
}