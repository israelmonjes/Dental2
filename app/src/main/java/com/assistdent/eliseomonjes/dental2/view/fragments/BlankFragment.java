package com.assistdent.eliseomonjes.dental2.view.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.assistdent.eliseomonjes.dental2.R;
import com.assistdent.eliseomonjes.dental2.view.ChangePassDialog;


public class BlankFragment extends Fragment {

    private LinearLayout myPassword;



    public BlankFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_account, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialization(view);
    }

    private void initialization(View view) {
        myPassword = view.findViewById(R.id.myPassword);
        setupMypasswrd();

    }
    private void setupMypasswrd() {
        myPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePassDialog dialog = new ChangePassDialog(getActivity());
                dialog.show();
            }
        });
    }

}
