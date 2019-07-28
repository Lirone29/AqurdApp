package com.aqurd.app.activities;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.aqurd.app.R;
import com.aqurd.app.database.SqliteDB;

public class ConnectionActivity extends AppCompatActivity implements View.OnTouchListener {
    private SqliteDB sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqldb = new SqliteDB(this);
        setContentView(R.layout.model_activity);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
