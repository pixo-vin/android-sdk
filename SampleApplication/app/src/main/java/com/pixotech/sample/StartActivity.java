package com.pixotech.sample;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void scanVIN(View view) {
        startActivity(new Intent(this, ScanActivity.class));
    }
}
