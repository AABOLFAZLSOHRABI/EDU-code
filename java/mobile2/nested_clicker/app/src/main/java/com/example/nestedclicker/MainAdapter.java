package com.example.nestedclicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    private List<List<User>> userLists;
    private UserClickListener listener;

    public MainAdapter(Context context, List<List<User>> userLists, UserClickListener listener) {
        this.context = context;
        this.userLists = userLists;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        UserAdapter userAdapter = new UserAdapter(userLists.get(position), listener);
        holder.rvHorizontal.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rvHorizontal.setAdapter(userAdapter);
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rvHorizontal;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            rvHorizontal = itemView.findViewById(R.id.rv_horizontal);
        }
    }
}