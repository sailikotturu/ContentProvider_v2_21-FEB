package com.example.sailik.contentprovidertask_20_feb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saili.k on 21-02-2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private List<Music> musicList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView albumName,trackName;

        public MyViewHolder(View view) {
            super(view);
            albumName = (TextView) view.findViewById(R.id.albumname_tv);
            trackName = (TextView) view.findViewById(R.id.trackname_tv);
            //year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MusicAdapter(List<Music> musicList) {
        this.musicList = musicList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Music music = musicList.get(position);
        holder.albumName.setText(music.getAlbumName());
        holder.trackName.setText(music.getTrackName());
        //holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
