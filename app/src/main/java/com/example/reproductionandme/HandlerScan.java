package com.example.reproductionandme;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.ArrayList;

public class HandlerScan extends AppCompatActivity {


    private ArFragment arFragment;
    private ArrayList<Integer> imagesPath = new ArrayList<Integer>();
    private ArrayList<String> namesPath = new ArrayList<>();
    private ArrayList<String> modelNames = new ArrayList<>();
    AnchorNode anchorNode;
    private Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handlerscan);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        btnRemove = (Button)findViewById(R.id.remove);
        getImages();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(this, Uri.parse(Common.model))
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable));

        });


        btnRemove.setOnClickListener(view -> removeAnchorNode(anchorNode));
    }

    private void getImages() {

        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);
        imagesPath.add(R.drawable.uterus);

        namesPath.add("Tahap 1");
        namesPath.add("Tahap 2");
        namesPath.add("Tahap 3");
        namesPath.add("Tahap 4");
        namesPath.add("Tahap 5");
        namesPath.add("Tahap 6");
        namesPath.add("Tahap 7");
        namesPath.add("Tahap 8");
        namesPath.add("Tahap 9");


        modelNames.add("fase1.sfb");
        modelNames.add("fase1a.sfb");
        modelNames.add("fase2.sfb");
        modelNames.add("fase2a.sfb");
        modelNames.add("fase3.sfb");
        modelNames.add("fase3a.sfb");
        modelNames.add("fase4.sfb");
        modelNames.add("fase4a.sfb");
        modelNames.add("fase4b.sfb");


        initaiteRecyclerview();
    }

    private void initaiteRecyclerview() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this,namesPath,imagesPath,modelNames);
        recyclerView.setAdapter(adapter);

    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {

        anchorNode = new AnchorNode(anchor);
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setParent(anchorNode);
        node.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        node.select();
    }

    public void removeAnchorNode(AnchorNode nodeToremove) {
        if (nodeToremove != null) {
            arFragment.getArSceneView().getScene().removeChild(nodeToremove);
            nodeToremove.getAnchor().detach();
            nodeToremove.setParent(null);
            nodeToremove = null;
        }
    }
}
