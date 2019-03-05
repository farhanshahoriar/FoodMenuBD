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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        keyText = (TextView) findViewById(R.id.search_key);

        Intent searchIntent = getIntent();
        if(searchIntent.hasExtra("key")){
            key = searchIntent.getStringExtra("key");
            Toast.makeText(this,key, Toast.LENGTH_LONG).show();
            keyText.setText("Search Key:\n"+key);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        
    }

    int dataSize=3;
    public FoodItemData[] foodItemData = new FoodItemData[dataSize];
    static public class FoodItemData {
        public String foodName,foodtype,resName;
        public int foodID;

        void setValues(String fname, int id, String rest) {
            foodName = fname;
            foodID =id;
            resName = rest;
        }

        public void SetDatadata(String str) {
            int s=0,ln=str.length(),dcnt=0;
            String dParts[] =new String [5];

            for(int i=0;i<ln;i++) {
                if(str.charAt(i)==',') {
                    dParts[dcnt]= str.substring(s, i);
                    s=i+1;
                    //System.out.println("X"+dParts[dcnt]+"Y");
                    dcnt++;
                }
            }

            FoodItemData data =new FoodItemData();
            setValues(dParts[0],Integer.parseInt(dParts[1]), dParts[2]);
        }

        void printData() {
            //System.out.println(name+" "+id+" "+address);
        }
    }
}

