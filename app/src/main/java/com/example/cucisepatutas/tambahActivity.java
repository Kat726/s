package com.example.cucisepatutas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import com.example.cucisepatutas.Model.ModelAlamat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class tambahActivity extends AppCompatActivity {
    private EditText editLabelAlamat, editAlamatLengkap;
    private Button btnSimpan;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editLabelAlamat = findViewById(R.id.labelAlamat);
        editAlamatLengkap = findViewById(R.id.alamatLengkap);
        btnSimpan = findViewById(R.id.btn_Simpan);

        progressDialog = new ProgressDialog(tambahActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Menyimpan");



        /*
        * Menambahkan data ke map, lalu dikirim ke database
        * */
        btnSimpan.setOnClickListener(v -> {
            if (editLabelAlamat.getText().length()>0 && editAlamatLengkap.getText().length()>0){
                saveData(editLabelAlamat.getText().toString(), editAlamatLengkap.getText().toString()); //ambil textnya, lalu jadikan STRING
            }else {
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void saveData(String labelAlamat, String alamatLengkap ){
        Map<String, Object> user = new HashMap<>();
        user.put("Alamat", editLabelAlamat);
        user.put("Alamat lengkap", editAlamatLengkap);

        progressDialog.show();
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

    }



}