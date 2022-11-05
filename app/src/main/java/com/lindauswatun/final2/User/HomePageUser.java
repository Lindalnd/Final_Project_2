package com.lindauswatun.final2.User;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.lindauswatun.final2.AboutActivity;
import com.lindauswatun.final2.R;
import com.lindauswatun.final2.User.ui.main.SectionsPagerAdapter;
import com.lindauswatun.final2.databinding.ActivityHomePageUserBinding;

import java.util.Objects;

public class HomePageUser extends AppCompatActivity {

    String uid;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    private ActivityHomePageUserBinding binding; // View Binding

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View Binding
        binding = ActivityHomePageUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // uid
        uid = getIntent().getStringExtra("uid");

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        binding.viewPager.setAdapter(sectionsPagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);

        // Floating Action Button
        binding.fab.setOnClickListener(view -> startActivity(new Intent(HomePageUser.this, AboutActivity.class)));

        // Log Out
        binding.keluarAkunUser.setOnClickListener(view -> {

            startActivity(new Intent(HomePageUser.this, LoginUser.class));
            Toast.makeText(HomePageUser.this, "Keluar Akun", Toast.LENGTH_SHORT).show();
        });
    }
}