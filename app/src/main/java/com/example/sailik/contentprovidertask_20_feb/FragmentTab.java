package com.example.sailik.contentprovidertask_20_feb;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab extends AppCompatActivity implements View.OnClickListener{
//    private Button mAddButton;
//    DbHelper dbHelper;
//    private ListView listView;
//    String albumname;
//    String trackname;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_fragment_tab);
//        mAddButton = (Button) findViewById(R.id.add_button);
//        mAddButton.setOnClickListener(this);
//
//
//
//    }
//    @Override
//    protected void onStart(){
//        super.onStart();
//
//    }
//
//
//    @Override
//    protected void onResume(){
//        super.onResume();
//        dbHelper = new DbHelper(this);
//        Intent intent = getIntent();
//        final Cursor cursor;
//        if(intent != null){
//            albumname=intent.getStringExtra("albumName");
//            trackname=intent.getStringExtra("trackName");
//            if(albumname!=""&&trackname!=""){
//                dbHelper.insertMusicItem(albumname,trackname);
//                getIntent().removeExtra("albumName");
//                getIntent().removeExtra("trackName");
//
//            }
//        }
//
//        if(dbHelper.getAllMusicItems()==null) {
//
//        }
//        else {
//            cursor = dbHelper.getAllMusicItems();
//            String[] columns = new String[]{
//                    DbHelper.COLUMN_ID,
//                    DbHelper.COLUMN_ALBUM,
//                    DbHelper.COLUMN_TRACK
//            };
//            int[] widgets = new int[]{
//                    R.id.itemID,
//                    R.id.albumname_tv,
//                    R.id.trackname_tv
//            };
//
//            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.music_item_info,
//                    cursor, columns, widgets, 0);
//            listView = (ListView) findViewById(R.id.listview);
//            listView.setAdapter(cursorAdapter);
//        }
//
//
//    }
//
//
//
//    public void toAdd(){
//        Intent i = new Intent(FragmentTab.this,AddItem.class);
//        startActivity(i);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Intent i = new Intent(FragmentTab.this,AddItem.class);
//        startActivity(i);
//    }
    private List<Music> musicList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicAdapter mAdapter;
    private FloatingActionButton mfabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);
        mfabButton = (FloatingActionButton)findViewById(R.id.fab);
        mfabButton.setOnClickListener(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        mfabButton = (FloatingActionButton)findViewById(R.id.fab);
//        mfabButton.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MusicAdapter(musicList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Music music = new Music("Album 1", "Track 1");
        musicList.add(music);

        music = new Music("Album 2", "Track 2");
        musicList.add(music);

        music = new Music("Album 3", "Track 3");
        musicList.add(music);
        music = new Music("Album 4", "Track 4");
        musicList.add(music);
        music = new Music("Album 5", "Track 5");
        musicList.add(music);
        music = new Music("Album 6", "Track 6");
        musicList.add(music);
        music = new Music("Album 7", "Track 7");
        musicList.add(music);
        music = new Music("Album 8", "Track 8");
        musicList.add(music);
        music = new Music("Album 9", "Track 9");
        musicList.add(music);
        music = new Music("Album 10", "Track 10");
        musicList.add(music);
        music = new Music("Album 11", "Track 11");
        musicList.add(music);
        music = new Music("Album 12", "Track 12");
        musicList.add(music);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab:
                Intent i = new Intent(FragmentTab.this,AddItem.class);
                startActivity(i);
                break;
        }
    }
}
