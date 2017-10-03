package com.example.wendt.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CoolGuy> toughies;
    private ListView toughieListView;
    public static final String EXTRA_NAME = "nameValue";
    public static final String EXTRA_DESCRIPTION = "descriptionValue";
    public static final String EXTRA_IMAGE = "imageValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createCoolGuys();
        setAdapter();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_delete:
                Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_list, menu);
    }

    private void setAdapter() {
        ArrayAdapter<CoolGuy> adapter = new ArrayAdapter<CoolGuy>(this, R.layout.list_item_toughie, toughies);
        toughieListView.setAdapter(adapter);
        toughieListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name = toughies.get(position).getName();
                String description = toughies.get(position).getDescription();
                int imageResource = toughies.get(position).getImageResourceID();
                Intent toughieProfile = new Intent(MainActivity.this, ProfileActivity.class);
                toughieProfile.putExtra(EXTRA_NAME, name);
                toughieProfile.putExtra(EXTRA_DESCRIPTION, description);
                toughieProfile.putExtra(EXTRA_IMAGE, imageResource);
                startActivity(toughieProfile);
            }
        });

        registerForContextMenu(toughieListView);
    }

    private void createCoolGuys() {
        toughies = new ArrayList<>();
        toughies.add(new CoolGuy("Joe Cool", "Ate cereal without any milk", getResources().getIdentifier("joe_cool", "drawable", getPackageName())));
        toughies.add(new CoolGuy("Bodybuilder Billy", "Opened a pickle jar", getResources().getIdentifier("bodybuilder_billy", "drawable", getPackageName())));
        toughies.add(new CoolGuy("Godd Howard", "Tells lies for a living", getResources().getIdentifier("godd_howard", "drawable", getPackageName())));
    }

    private void wireWidgets() {
        toughieListView = (ListView) findViewById(R.id.listview_toughie);
    }
}
