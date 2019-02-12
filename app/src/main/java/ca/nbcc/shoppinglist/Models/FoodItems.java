package ca.nbcc.shoppinglist.Models;

import java.io.Serializable;

public class FoodItems implements Serializable {
    public int itemCount;
    public String itemName;

    public FoodItems(){

    }

    public int getCount() {
        return itemCount;
    }
    public void setCount(int amount) {
        this.itemCount = amount;
    }
    public String getName() {
        return itemName;
    }
    public void setName(String name) {
        this.itemName = name;
    }

    public FoodItems(String name, int count){
        this.itemCount = count;
        this.itemName = name;
    }
}
