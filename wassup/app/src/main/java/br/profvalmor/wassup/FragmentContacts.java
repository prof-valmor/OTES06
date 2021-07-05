package br.profvalmor.wassup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


/**
 * A fragment representing a list of Items.
 */
public class FragmentContacts extends Fragment {
    private static final String TAG = FragmentContacts.class.getSimpleName();

    private NavegarInterface navegador;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentContacts(NavegarInterface navegador) {
        this.navegador = navegador;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        ListView list = view.findViewById(R.id.listContatos);
        list.setAdapter(new FragmentContactsAdapter(getLayoutInflater()));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: " + position + " long id: " + id + " vieww: " + view);
                navegador.navegar(1);
                //
//                Toast t = Toast.makeText(getContext(), "Mudando para a conversa", Toast.LENGTH_LONG);
//                t.show();
                Snackbar snack = Snackbar.make(view, "Texto qualquer", Snackbar.LENGTH_SHORT);
                snack.show();
            }
        });
        return view;
    }

}