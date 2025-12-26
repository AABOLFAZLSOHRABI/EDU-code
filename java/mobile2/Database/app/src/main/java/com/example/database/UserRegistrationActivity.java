package com.example.database;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class UserRegistrationActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etFamily;
    private EditText etEmail;
    private Button btnAdd;
    private Button btnShow;
    private ListView lvUsers;

    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        userDatabase = UserDatabase.getInstance(this);

        etName = findViewById(R.id.et_name);
        etFamily = findViewById(R.id.et_family);
        etEmail = findViewById(R.id.et_email);
        btnAdd = findViewById(R.id.btn_add_user);
        btnShow = findViewById(R.id.btn_show_users);
        lvUsers = findViewById(R.id.lv_users);

        btnAdd.setOnClickListener(v -&gt; addUser());
        btnShow.setOnClickListener(v -&gt; showUsers());
    }

    private void addUser() {
        final String name = etName.getText().toString().trim();
        final String family = etFamily.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(family) || TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Executors.newSingleThreadExecutor().execute(() -&gt; {
            UserModel user = new UserModel(name, family, email);
            userDatabase.userDao().insertUser(user);
            runOnUiThread(() -&gt; {
                Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etFamily.setText("");
                etEmail.setText("");
            });
        });
    }

    private void showUsers() {
        Executors.newSingleThreadExecutor().execute(() -&gt; {
            List&lt;UserModel&gt; users = userDatabase.userDao().getAllUsers();
            final List&lt;String&gt; displayList = new ArrayList&lt;&gt;();
            for (UserModel user : users) {
                displayList.add(user.getId() + " - " + user.getName() + " " + user.getFamily() + " (" + user.getEmail() + ")");
            }

            runOnUiThread(() -&gt; {
                if (displayList.isEmpty()) {
                    Toast.makeText(this, "No users found", Toast.LENGTH_SHORT).show();
                    lvUsers.setAdapter(null);
                } else {
                    ArrayAdapter&lt;String&gt; adapter = new ArrayAdapter&lt;&gt;(
                            this,
                            android.R.layout.simple_list_item_1,
                            displayList
                    );
                    lvUsers.setAdapter(adapter);
                }
            });
        });
    }
}