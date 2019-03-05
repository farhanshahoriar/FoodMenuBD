package com.farhanshahoriar.foodmenubd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodList extends AppCompatActivity {

    private TextView keyText;
    private String key = null;

    private RecyclerView fRecyclerView;
    private FoodMenuAdapter foodAdapter;

    final int dataSize=5;
    public FoodItemData[] foodItemData;

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

        foodItemData = new FoodItemData[dataSize];

        for(int i=0;i<foodItemData.length;i++){
            foodItemData[i] = new FoodItemData();
        }
        foodItemData[0].setValues("Burger",12,"Mughol");
        foodItemData[1].setValues("Fried Rice",8,"Order's Up");
        foodItemData[2].setValues("Chiken Fry",19,"Axyz");
        foodAdapter.setData(foodItemData);
    }

}

