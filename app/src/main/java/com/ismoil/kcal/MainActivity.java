package com.ismoil.kcal;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ismoil.kcal.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setContentView(binding.getRoot());

        initSpinner();

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kCal = binding.etCountMax.getText().toString(); // shu yerda olish kerak

                if (!kCal.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                    intent.putExtra("kCal", kCal);
                    startActivity(intent);
                }
            }
        });


    }


    private void initSpinner() {
        // Faqat zikr nomlarini olish
        List<String> list = new ArrayList<>();


        list.add("Breakfast");
        list.add("Lunch");
        list.add("Dinner");
        // Adapter yaratish
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                list
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Adapterni spinnerga ulash
        binding.spinnerZikr.setAdapter(adapter);

        // Element tanlanganda ishga tushadigan listener
        binding.spinnerZikr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = (String) parent.getItemAtPosition(position);

                // Tanlangan nomga qarab Zikrlar obyektini olish


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Hech narsa tanlanmagan holat
            }
        });
    }

}

