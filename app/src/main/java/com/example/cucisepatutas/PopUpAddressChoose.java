package com.example.cucisepatutas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.cucisepatutas.Model.ModelAlamat;
import com.example.cucisepatutas.adaptor.AdaptorAlamat;
import com.example.cucisepatutas.bottombar.Homeactivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PopUpAddressChoose extends Activity {

    private RecyclerView recyclerView;
    private FloatingActionButton btnAdd;
    AdaptorAlamat adaptorAlamat;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelAlamat> listAlamat;
    RecyclerView alamatTampil;
    private  FloatingActionButton btn_add;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_address_choose);
        recyclerView = findViewById(R.id.alamatTampil);
    }

    public void launchHomeMenuActivitityActivity(View view){
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }




}