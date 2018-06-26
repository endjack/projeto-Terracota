package com.example.ender.terracota;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentIter extends Fragment {

    Button bttPlay;
    MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iter_fragment,container,false);

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
