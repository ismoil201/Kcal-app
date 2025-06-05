package com.ismoil.kcal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ismoil.kcal.databinding.ActivityCongrantBinding;

public class CongrantActivity extends AppCompatActivity {

    private ActivityCongrantBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityCongrantBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CongrantActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}