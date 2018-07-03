package com.example.ender.terracota;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FragmentIter extends Fragment {

    Button bttPlay;
    MediaPlayer mediaPlayer;
    ImageView gifView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iter_fragment,container,false);

//      Gif animação do sound
        gifView = view.findViewById(R.id.gifView);
        Glide.with(getActivity())
                .load(R.drawable.sounds)
                .asGif()
                .into(gifView);

        bttPlay = view.findViewById(R.id.bttPlay);
        bttPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.birds);
                }

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }else{
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.birds);
                    mediaPlayer.start();
                }
            }
        });


        return view;
    }

}
