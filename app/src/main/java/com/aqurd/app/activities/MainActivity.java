package com.aqurd.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.aqurd.app.R;
import com.aqurd.app.database.SqliteDB;
import com.aqurd.app.models.Brand;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener{

    private static final String TAG = "MainActivity";
    SqliteDB db;
    Button returnButton, goButton;
    ListView listView;
    ArrayList<Brand> brandArrayList;
    ArrayList<String> brandNamesArrayList;
    ArrayAdapter<String> adapter;
    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new SqliteDB(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brandArrayList = db.getAllBrands();
        brandNamesArrayList = new ArrayList<String>();
        for(int i =0; i < brandArrayList.size(); i++){
            brandNamesArrayList.add(brandArrayList.get(i).getNameBrand());
        }
        selectedItem = null;
        //moze inny silmle list Layout ==??
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, brandNamesArrayList);

        listView = (ListView) findViewById(R.id.mainListView);
        listView.setAdapter(adapter);

        returnButton =(Button) findViewById(R.id.mainReturnButton);
        goButton = (Button) findViewById(R.id.mainSearchButton);

        returnButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

    }

    public void returnToMainButton(){
        super.onBackPressed();
    }

    public void search(){

    }
    @Override
    public void onClick(View view) {
        int tmpId = view.getId();

        if(tmpId==goButton.getId()){
            this.search();
        }

        if(tmpId==returnButton.getId()){
            this.returnToMainButton();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        for (int j = 0; j < adapterView.getChildCount(); j++)
            adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

        // change the background color of the selected element
        view.setBackgroundColor(Color.LTGRAY);
        selectedItem = ((ListView)view).getSelectedItem().toString();

    }
}
