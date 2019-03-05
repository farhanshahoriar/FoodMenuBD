package com.farhanshahoriar.foodmenubd;

public class FoodItemData {
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

        setValues(dParts[0],Integer.parseInt(dParts[1]), dParts[2]);
    }

    void printData() {
        System.out.println(foodName+" "+foodID+" "+resName);
    }
}