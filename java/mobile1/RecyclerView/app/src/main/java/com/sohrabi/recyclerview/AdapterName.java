package com.sohrabi.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;

public class AdapterName extends RecyclerView.Adapter<AdapterName.NameHolder> {
    String[] names = {};
    int[] ints = {};

    public AdapterName() {
        TempListItem tempListItem = new TempListItem();
        names = tempListItem.getName();
        ints = tempListItem.getAvatar();
    }

    @NonNull
    @Override
    public NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new AdapterName.NameHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameHolder holder, int position) {
        holder.setItems(names[position], ints[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class NameHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_item;
        private TextView textView_item;

        public NameHolder(@NonNull View itemView) {
            super(itemView);
            imageView_item = itemView.findViewById(R.id.imageView);
            textView_item = itemView.findViewById(R.id.textView);

        }

        public void setItems(String name, int imageId) {
            textView_item.setText(name);
            imageView_item.setImageResource(imageId);
        }
    }
}
