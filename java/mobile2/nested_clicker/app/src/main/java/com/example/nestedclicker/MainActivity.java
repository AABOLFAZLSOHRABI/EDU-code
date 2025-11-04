package com.example.nestedclicker;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserClickListener {

    private RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv_main);

        List<List<User>> userLists = new ArrayList<>();
        userLists.add(User.getUsers());
        userLists.add(User.getUsers());
        userLists.add(User.getUsers());
        userLists.add(User.getUsers());
        userLists.add(User.getUsers());

        MainAdapter mainAdapter = new MainAdapter(this, userLists, this);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(mainAdapter);
    }

    @Override
    public void onUserClick(User user) {
        Toast.makeText(this, "Clicked on " + user.getName(), Toast.LENGTH_SHORT).show();
    }
}
