package com.example.exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Button btSend = findViewById(R.id.btSend);
        TextView edtName = findViewById(R.id.edtName);
        TextView edtEmail = findViewById(R.id.edtEmail);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, edtEmail.getText());
                intent.putExtra(Intent.EXTRA_SUBJECT, "send to " + edtName.getText());
                intent.putExtra(Intent.EXTRA_TEXT, "Olah " + edtName.getText() );

                startActivity(intent);

            }
        });
    }
}