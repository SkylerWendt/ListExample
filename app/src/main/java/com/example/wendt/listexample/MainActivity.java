package com.example.wendt.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CoolGuy> toughies;
    private ListView toughieListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createCoolGuys();
        setAdapter();
    }

    private void setAdapter() {
        ArrayAdapter<CoolGuy> adapter = new ArrayAdapter<CoolGuy>(this, R.layout.list_item_toughie, toughies);
        toughieListView.setAdapter(adapter);
    }

    private void createCoolGuys() {
        toughies = new ArrayList<>();
        toughies.add(new CoolGuy("Joe Cool", "Ate cereal without any milk", 0));
        toughies.add(new CoolGuy("Bodybuilder Billy", "Opened a pickle jar", 0));
        toughies.add(new CoolGuy("Edgar J. Fitz", "Able to eat pineapple pizza", 0));
    }

    private void wireWidgets() {
        toughieListView = (ListView) findViewById(R.id.listview_toughie);
    }
}
