package com.ismoil.kcal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ismoil.kcal.databinding.ActivityFoodBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private ActivityFoodBinding binding;
    private FoodAdapter adapter;
    private List<Food> foodList1;
    private List<Food> foodList2;
    private List<Food> foodList3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData300();
        loadData500();

        foodList3 = new ArrayList<>();
        foodList3.addAll(foodList2);
        foodList3.addAll(foodList1);

        // RecyclerView uchun LayoutManager o‘rnatish

        String kCal = getIntent().getStringExtra("kCal");
        getIntent().removeExtra("kCal");

        if (kCal != null) {
            try {
                int kCal2 = Integer.parseInt(kCal.trim());

                Toast.makeText(this, " $kCal2"+kCal2, Toast.LENGTH_SHORT).show();
                if (kCal2 > 0 && kCal2 <= 300) {
                    adapter = new FoodAdapter(foodList1, new FoodAdapter.CallBack() {
                        @Override
                        public void itemClick(Food theme, int position) {

                        }
                    });
                    binding.recyclerView.setAdapter(adapter);


                } else if (kCal2 >= 301 && kCal2 <= 500) {
                    // Boshqa shartga mos elementlar bo'lsa shu yerda yozing
                    // Hozircha bo'sh

                    adapter = new FoodAdapter(foodList2, new FoodAdapter.CallBack() {
                        @Override
                        public void itemClick(Food theme, int position) {

                        }
                    });
                    binding.recyclerView.setAdapter(adapter);
                }

            } catch (NumberFormatException e) {
                Log.e("FoodActivity", "Invalid kCal value: " + kCal);
            }
        } else {
            adapter = new FoodAdapter(foodList3, new FoodAdapter.CallBack() {
                @Override
                public void itemClick(Food theme, int position) {

                }
            });
            binding.recyclerView.setAdapter(adapter);
        }
    }

    private void loadData300() {
        foodList1 = new ArrayList<>();

        foodList1.add(new Food(R.drawable.img2, "Sliced meat", "sliced meat and potatoes", "249 kcal"));
        foodList1.add(new Food(R.drawable.img3, "Garlic Ginger", "Savory beef and crunchy vegetables", "300 kcal"));
        foodList1.add(new Food(R.drawable.img4, "Minxdary", "High in protein, balanced diet", "290 kcal"));
        foodList1.add(new Food(R.drawable.img5, "Protein dish", "Rich in protein, fiber, vitamins", "250 kcal"));
        foodList1.add(new Food(R.drawable.img5, "Sliced meat", "sliced meat and potatoes", "234 kcal"));
        foodList1.add(new Food(R.drawable.img6, "Balanced Meal", "Protein, veggies, carbs", "300 kcal"));
        foodList1.add(new Food(R.drawable.img7, "Complete Plate", "Protein, carbs, vegetables", "300 kcal"));
        foodList1.add(new Food(R.drawable.img9, "Keto meat", "Light and healthy meal", "250 kcal"));
    }



    private void loadData500(){

        foodList2 =  new ArrayList<>();

        foodList1.add(new Food(R.drawable.rasm1, "Grilled Chicken Salad", "Protein-rich salad with veggies", "320 kcal"));
        foodList1.add(new Food(R.drawable.rasm2, "Avocado Toast", "Whole grain toast with avocado", "350 kcal"));
        foodList1.add(new Food(R.drawable.rasm3, "Beef Stir Fry", "Stir-fried beef with vegetables", "430 kcal"));
        foodList1.add(new Food(R.drawable.rasm4, "Oatmeal Bowl", "Oats with banana and honey", "380 kcal"));
        foodList1.add(new Food(R.drawable.rasm5, "Sushi Platter", "Mixed sushi with fresh fish", "400 kcal"));
        foodList1.add(new Food(R.drawable.rasm6, "Pasta Primavera", "Pasta with mixed vegetables", "390 kcal"));
        foodList1.add(new Food(R.drawable.rasm7, "Veggie Sandwich", "Sandwich with fresh vegetables", "370 kcal"));
        foodList1.add(new Food(R.drawable.rasm8, "Keto Egg Muffins", "Low-carb eggs with cheese", "400 kcal"));




    }
}
