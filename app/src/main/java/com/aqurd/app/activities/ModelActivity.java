package com.aqurd.app.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aqurd.app.R;
import com.aqurd.app.database.SqliteDB;

public class ModelActivity extends AppCompatActivity implements View.OnClickListener {


    Button returnButton, searchButton;
    private SqliteDB sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqldb = new SqliteDB(this);
        setContentView(R.layout.model_activity);

        returnButton =(Button) findViewById(R.id.modelReturnButton);
        searchButton = (Button) findViewById(R.id.modelSearchButton);

        returnButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }


    public void returnToMainButton(){
        super.onBackPressed();
    }

    public void search(){

    }

    @Override
    public void onClick(View v) {
        int tmpId = v.getId();

        if(tmpId==searchButton.getId()){
            this.search();
        }

        if(tmpId==returnButton.getId()){
            this.returnToMainButton();
        }

    }

}
