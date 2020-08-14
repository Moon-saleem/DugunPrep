package com.example.dugunprep;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Music> myArrayList;
    private MediaPlayer mediaPlayer;
    private boolean flag= true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> myArrayLst) {
        this.context = context;
        this.layout = layout;
        this.myArrayLst = myArrayLst;
    }

    private ArrayList<Music> myArrayLst;

    @Override
    public int getCount() {
        return myArrayLst.size();
    }

    @Override
    public Object getItem(int position) {
        return myArrayLst.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        ImageView imageView_play,imageView_stop;
        private View convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        public ViewHolder() {
            convertView = layoutInflater.inflate(layout, null);
            imageView_play = convertView.findViewById(R.id.play_btn);
            imageView_stop = convertView.findViewById(R.id.play_stop);


        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView= viewHolder.convertView;
        }
        else {

        }
        final Music music=myArrayLst.get(position);
        viewHolder.imageView_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    mediaPlayer=MediaPlayer.create(context,music.getSongs());
                    flag=false;
                }
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    viewHolder.imageView_play.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                }
                else
                {
                    mediaPlayer.start();
                    viewHolder.imageView_play.setImageResource(R.drawable.ic_baseline_pause_24);

                }
                mediaPlayer.start();

            }
        });
        viewHolder.imageView_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                viewHolder.imageView_stop.setImageResource(R.drawable.ic_baseline_stop_24);
            }
        });


        return convertView;
    }
}
