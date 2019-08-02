package com.example.fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewFragment extends Fragment {
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_viewer,container,false);
        imageView = (ImageView) rootView.findViewById(R.id.imageView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setImage(int index){

        if(index==0){
            imageView.setImageResource(R.drawable.ljy);
        }
        else if(index==1){
            imageView.setImageResource(R.drawable.pht);
        }
        else if(index==2){
            imageView.setImageResource(R.drawable.sjs);
        }

    }

}
