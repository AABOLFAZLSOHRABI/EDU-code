package com.example.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRowAdapter extends RecyclerView.Adapter&lt;UserRowAdapter.UserViewHolder&gt; {

    private final List&lt;UserModel&gt; users;
    private final OnUserClickListener listener;

    public UserRowAdapter(List&lt;UserModel&gt; users, OnUserClickListener listener) {
        this.users = users;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel user = users.get(position);
        holder.ivUserImage.setImageResource(user.getImageResId());
        holder.tvUserName.setText(user.getName());
        holder.tvUserAge.setText(String.valueOf(user.getAge()));

        holder.itemView.setOnClickListener(v -&gt; listener.onUserClick(user));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView ivUserImage;
        TextView tvUserName;
        TextView tvUserAge;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ivUserImage = itemView.findViewById(R.id.iv_user_image);
            tvUserName = itemView.findViewById(R.id.tv_user_name);
            tvUserAge = itemView.findViewById(R.id.tv_user_age);
        }
    }
}