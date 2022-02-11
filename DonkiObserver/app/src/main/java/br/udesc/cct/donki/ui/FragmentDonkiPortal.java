package br.udesc.cct.donki.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.udesc.cct.donki.R;

public class FragmentDonkiPortal extends Fragment {
    public FragmentDonkiPortal() {
        super(R.layout.fragment_portal);
    }

    @Override
    public void onStart() {
        super.onStart();

        ListView listaDeServicos = getView().findViewById(R.id.list_services);

        final String[] services = new String[]{ "Geomagnetic Storm",
         "Interplanetary Shock",
         "Solar Flare"};

        final List<String> services_list = new ArrayList<>(Arrays.asList(services));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (getContext(), android.R.layout.simple_list_item_1, services_list);

        listaDeServicos.setAdapter(arrayAdapter);
        listaDeServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(view != null) {
                    TextView txt = (TextView) view;
                    String s = txt.getText().toString();
                    if(s.contains("Geomagnetic")) {
                        getActivity().sendBroadcast(new Intent("geomagnetic"));
                    }
                }
            }
        });
    }
}
