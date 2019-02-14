package ca.nbcc.shoppinglist.Models;

import java.io.Serializable;
import java.util.HashMap;

public class FoodItems implements Serializable {

    HashMap<String, Integer> listItems = new HashMap<>();

    public void SetListItems(String item){
       if(listItems.containsKey(item)){
            listItems.put(item,listItems.get(item)+1);
       }
       else{
           listItems.put(item,1);
       }
    }

    public HashMap<String,Integer> GetListItems(){

        return listItems;
    }
}
