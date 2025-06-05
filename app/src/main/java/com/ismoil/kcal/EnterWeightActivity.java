package com.ismoil.kcal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ismoil.kcal.databinding.ActivityEnterWeightBinding;

public class EnterWeightActivity extends AppCompatActivity {

    private ActivityEnterWeightBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding =  ActivityEnterWeightBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnterWeightActivity.this, CongrantActivity.class));
                finish();
            }
        });
    }
}