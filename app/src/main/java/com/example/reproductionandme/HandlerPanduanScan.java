package com.example.reproductionandme;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HandlerPanduanScan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_panduan_scan);

        ImageSlider imageSlider = findViewById(R.id.panduan1);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.langkah1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah6, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah7, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.langkah8, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }


}