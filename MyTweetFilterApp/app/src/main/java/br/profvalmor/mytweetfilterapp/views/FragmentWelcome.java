package br.profvalmor.mytweetfilterapp.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.profvalmor.mytweetfilterapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWelcome extends Fragment {

    public FragmentWelcome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).navegar(FragmentFilter.class.getSimpleName());
                this.cancel();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 5000);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

}