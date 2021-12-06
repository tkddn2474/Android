package com.example.ssw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_my extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


       Bundle bundle = getArguments();

        String U_id = bundle.getString("U_id");





        return inflater.inflate(R.layout.frag_my,container,false);


    }
}
