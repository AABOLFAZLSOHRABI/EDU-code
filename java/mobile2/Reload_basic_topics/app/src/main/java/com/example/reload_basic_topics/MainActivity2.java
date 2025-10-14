package com.example.reload_basic_topics;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> arrayList;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = findViewById(R.id.listView);
        prefs = getSharedPreferences("name", MODE_PRIVATE);

        Set<String> savedSet = prefs.getStringSet("myList", new HashSet<>());
        arrayList = new ArrayList<>(savedSet);

        String newItem = getIntent().getStringExtra("name");
        if (newItem != null) {
            arrayList.add(newItem);
        }

        prefs.edit().putStringSet("myList", new HashSet<>(arrayList)).apply();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = arrayList.get(position);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("selected_item", selectedItem);
                editor.apply();

                Toast.makeText(MainActivity2.this, "saved item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
