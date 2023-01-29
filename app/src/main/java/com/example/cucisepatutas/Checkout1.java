package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cucisepatutas.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Checkout1 extends AppCompatActivity {
    //TextView btn_pck_addres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout1);

       /*btn_pck_addres = findViewById(R.id.btn_pck_address);
        btn_pck_addres = findViewById(R.id.btn_pck_address);

                btn_pck_addres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PopUpAddressChoose.class);
                startActivity(i);
            }
        });



        */
    }

    public void launchDeepClean2PilihTreatmentDeskripsiActivity(View view) {
        Intent intent = new Intent(this, DeepClean2PilihTreatmentDeskripsiActivity.class);
        startActivity(intent);
    }




}