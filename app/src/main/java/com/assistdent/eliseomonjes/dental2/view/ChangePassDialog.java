package com.assistdent.eliseomonjes.dental2.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.assistdent.eliseomonjes.dental2.R;

public class ChangePassDialog extends Dialog {

    private ImageView exit;
    private Button confirmPass;
    public ChangePassDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        initialization();
    }

    private void initialization() {
        exit = findViewById(R.id.exitChange);
        setupExitView();
        confirmPass = findViewById(R.id.confirmPass);
        setupConfrim();

    }

    private void setupConfrim() {
        confirmPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goExit();
            }
        });
    }

    private void setupExitView() {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goExit();
            }
        });
    }

    private void goExit() {
        dismiss();
    }
}
