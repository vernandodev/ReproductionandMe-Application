package com.example.reproductionandme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

       /* Fragment in Fragment
       btn_pengertian = view.findViewById(R.id.btn_pengertian);

        btn_pengertian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new ScrollingFragment1());
                transaction.commit();
            }
        });
        */

        ImageButton btn_1 = (ImageButton) view.findViewById(R.id.btn_pengertian);
        ImageButton btn_2 = (ImageButton) view.findViewById(R.id.btn_siklusn);
        ImageButton btn_3 = (ImageButton) view.findViewById(R.id.btn_siklust);
        ImageButton btn_4 = (ImageButton) view.findViewById(R.id.btn_gangguan);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pengertian = new Intent(getActivity(), PengertianActivity.class );
                startActivity(pengertian);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siklusn = new Intent(getActivity(), SiklusnActivity.class );
                startActivity(siklusn);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siklust = new Intent(getActivity(), GangguanActivity.class );
                startActivity(siklust);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gangguan = new Intent(getActivity(), PencegahanActivity.class );
                startActivity(gangguan);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageSlider imageSlider = (ImageSlider) view.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}

