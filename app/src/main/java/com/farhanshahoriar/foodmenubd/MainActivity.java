package com.farhanshahoriar.foodmenubd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText searchText;
    String [] resturantList = {"Kabar","Dhabar","Khudha","Lagche","Order's Up"};
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchText = (EditText) findViewById(R.id.search_text);
        ListView resturentListView = (ListView) findViewById(R.id.returant_list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_view_item, resturantList);
        resturentListView.setAdapter(adapter);
        resturentListView.setClickable(true);
        context = getApplicationContext();
        resturentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Ok "+position+"id: "+id,Toast.LENGTH_LONG).show();
                searchFoodItem(resturantList[position]);
            }
        });
    }

    public void onSearchFood(View view){
        String txt = searchText.getText().toString();
        searchFoodItem(txt);
    }
    public void searchFoodItem(String txt){
        Intent doSearchIntent = new Intent(this,FoodList.class);
        doSearchIntent.putExtra("key",txt);
        startActivity(doSearchIntent);
    }

}

