package com.ismoil.kcal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.ismoil.kcal.databinding.ItemFoodBinding;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.Vh> {

    private List<Food> themeList;

    private CallBack callback;

    public FoodAdapter(List<Food> themeList, CallBack callback) {
        this.themeList = themeList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFoodBinding binding = ItemFoodBinding.inflate(inflater, parent, false);
        return new Vh(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        holder.onBind(themeList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return themeList.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        ItemFoodBinding binding;

        public Vh(ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(final Food theme, final int position) {
            Context context = binding.getRoot().getContext();

            // Har xil ranglar ro‘yxati
            int[] colors = {
                    ContextCompat.getColor(context, R.color.bg1),
                    ContextCompat.getColor(context, R.color.bg2),
                    ContextCompat.getColor(context, R.color.bg3),
                    ContextCompat.getColor(context, R.color.bg4),
                    ContextCompat.getColor(context, R.color.bg5)
            };

            // Har bir itemga navbatdagi rangni belgilash (modulo bilan)
            int color = colors[position % colors.length];

            binding.ivImageBg.setBackgroundColor(color);
            binding.ivCounterImage.setImageResource(theme.getImage());
            binding.tvRegister2.setText(theme.getName());
            binding.tvTitle2.setText(theme.getBio());
            binding.tvCalory.setText(theme.getkCal());
        }

    }

    public interface CallBack {
        void itemClick(Food theme, int position);
    }
}
