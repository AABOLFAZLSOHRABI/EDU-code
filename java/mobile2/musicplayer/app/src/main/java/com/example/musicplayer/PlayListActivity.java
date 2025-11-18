package com.example.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.v2.R;

import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity {
    public static List<Song> songList = new ArrayList<>();
    private static final int PICK_AUDIO_REQUEST = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        songList.add(new Song("Batel Shod", R.raw.batel_shod));
        songList.add(new Song("Spazz", R.raw.spazz));
        songList.add(new Song("Rock A Chock", R.raw._rock_a_chock));

        SongAdapter adapter = new SongAdapter(this, songList);
        recyclerView.setAdapter(adapter);

        Button selectButton = findViewById(R.id.selectMusicButton);
        selectButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("audio/*");
            startActivityForResult(intent, PICK_AUDIO_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_AUDIO_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri audioUri = data.getData();
            if (audioUri != null) {
                // Optional: Persist permission for this URI
                getContentResolver().takePersistableUriPermission(audioUri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION);

                // Create a new song with the selected URI
                // Note: This is a simplified approach. In a real app, you'd need to handle URI permissions
                // and possibly store the URI for later use
                Song selectedSong = new Song("Selected Audio", audioUri.hashCode());
                songList.add(selectedSong);
                
                // Update the adapter
                SongAdapter adapter = (SongAdapter) recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                
                // Start PlayerActivity with the selected song
                Intent playerIntent = new Intent(this, PlayerActivity.class);
                playerIntent.putExtra("index", songList.size() - 1);
                startActivity(playerIntent);
            } else {
                Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}