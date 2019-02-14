package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import ca.nbcc.shoppinglist.Models.FoodItems;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private FoodItems FoodList = new FoodItems();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        AssignTextView();
        if (savedInstanceState != null) {
            HashMap<String, Integer> items = (HashMap<String, Integer>) savedInstanceState.getSerializable("listItems");
            TextView textView = findViewById(R.id.listItems);
            textView.setText("");
            for (String key : items.keySet()) {
                String list = "- " + key + " " + items.get(key).toString() + "\n";
                textView.setText(list + textView.getText());
                FoodList.SetListItems(key);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("listItems", FoodList.GetListItems());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String listItem = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                FoodList.SetListItems(listItem);
                AssignTextView();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void AssignTextView() {
        TextView textView = findViewById(R.id.listItems);
        textView.setText("");
        HashMap<String, Integer> items = FoodList.GetListItems();
        for (String key : items.keySet()) {
            String list = "- " + key + " " + items.get(key).toString() + "\n";
            textView.setText(list + textView.getText());
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Launching second activity!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}