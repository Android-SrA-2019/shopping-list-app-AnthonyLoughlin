package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import ca.nbcc.shoppinglist.Models.FoodItems;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private FoodItems[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new FoodItems[10];
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("ShoppingList", items);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {

            }
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Launching second activity!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent,TEXT_REQUEST);
    }
}