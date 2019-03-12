package com.farhanshahoriar.foodmenubd;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FoodList extends AppCompatActivity {

    private TextView keyText;
    private String key = null;

    private RecyclerView fRecyclerView;
    private FoodMenuAdapter foodAdapter;

    final int dataSize=5;
    //public FoodItemData[] foodItemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        keyText = (TextView) findViewById(R.id.search_key);
        fRecyclerView = (RecyclerView) findViewById(R.id.rv_food_menu);

        Intent searchIntent = getIntent();
        if(searchIntent.hasExtra("key")){
            key = searchIntent.getStringExtra("key");
            Toast.makeText(this,key, Toast.LENGTH_LONG).show();
            keyText.setText("Search Key:\n"+key);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        fRecyclerView.setLayoutManager(layoutManager);
        fRecyclerView.setHasFixedSize(true);
        foodAdapter = new FoodMenuAdapter();
        fRecyclerView.setAdapter(foodAdapter);

        AssetManager assetManager = getAssets();
       // String [] files = assetManager.list("");
        //File dataFile = new
        InputStream inputfs = null;
        //System.out.println("OK");

        try {
            inputfs = assetManager.open("fooddata.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner fsc = new Scanner(inputfs);

        ArrayList<FoodItemData> foodItemList = new ArrayList<>();
        String inputstr;
        int in=0;
        while (fsc.hasNext()){
            inputstr = fsc.nextLine();

            if(inputstr.toLowerCase().contains(key.toLowerCase())) {
                //keyText.append(inputstr+"\n");
                FoodItemData foodItemData = new FoodItemData();
                foodItemData.setDatadata(inputstr);

                foodItemList.add(foodItemData);
            }
        }

//        foodItemData[0].setValues("Burger",12,"Mughol");
//        foodItemData[1].setValues("Fried Rice",8,"Order's Up");
//        foodItemData[2].setValues("Chiken Fry",19,"Axyz");

        keyText.append("\n\nFood Name  Resturent  Price\n");

        FoodItemData[] foodArray = null;
                foodArray= foodItemList.toArray(new FoodItemData[foodItemList.size()]);
        //keyText.setText("size"+foodItemList.size());
        Arrays.sort(foodArray);

        foodAdapter.setData(foodArray);
    }

}

