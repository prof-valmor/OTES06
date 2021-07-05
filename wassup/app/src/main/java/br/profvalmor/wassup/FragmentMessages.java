package br.profvalmor.wassup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMessages extends Fragment {
    private NavegarInterface navegador;

    public FragmentMessages(NavegarInterface navegador) {
        this.navegador = navegador;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);;

        TextView txt = view.findViewById(R.id.txtNome);
        txt.setText("NOVO Fragmento");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialogo_de_alerta)
                .setPositiveButton("OKAY", null)
                .setNeutralButton("NAO SEI", null)
                .setNegativeButton("Cancel", (DialogInterface dialog, int which) -> {
                    this.navegador.navegar(0);
                });

        builder.create().show();

    }
}
