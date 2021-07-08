package com.example.reproductionandme;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class FragmentScanAR extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan_a_r, container, false);

        ImageButton btn_panduan = (ImageButton) view.findViewById(R.id.btn_panduan);
        ImageButton btn_scan = (ImageButton) view.findViewById(R.id.btn_scan);
        ImageButton btn_video = (ImageButton) view.findViewById(R.id.btn_video);

        btn_panduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent panduan = new Intent(getActivity(), HandlerPanduanScan.class );
                startActivity(panduan);
            }
        });

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent video = new Intent(getActivity(), videoActivity.class );
                startActivity(video);
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scan = new Intent(getActivity(), HandlerScan.class );
                startActivity(scan);
            }
        });


        return view;
    }
}