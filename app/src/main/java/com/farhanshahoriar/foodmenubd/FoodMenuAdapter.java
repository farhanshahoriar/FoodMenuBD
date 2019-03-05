package com.farhanshahoriar.foodmenubd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.FoodItemViewHolder> {

    public FoodList.FoodItemData[] foodItemData = null;
    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder foodItemViewHolder, int pos) {
        String strData= foodItemData[pos].foodName+" "+foodItemData[pos].resName;
        foodItemViewHolder.menuItemTextView.setText(strData);
    }

    @Override
    public int getItemCount() {
        if(foodItemData == null)return 0;
        else return foodItemData.length;
    }

    public class FoodItemViewHolder extends RecyclerView.ViewHolder{
        TextView menuItemTextView;

        public FoodItemViewHolder(View view){
            super(view);
            menuItemTextView = (TextView) view.findViewById(R.id.tv_item_text);
        }

    }
    @Override
    public FoodItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.menu_item, viewGroup,false);
        return new FoodItemViewHolder(view);
    }

    public void setData(FoodList.FoodItemData[] data){
        foodItemData = data;
        notifyDataSetChanged();
    }
}

