package com.pixotech.sample;

import android.os.Bundle;
import android.widget.TextView;

import com.pixotech.android.scanner.library.ScannerActivity;
import com.pixotech.android.scanner.library.Utility;


public class ScanActivity extends ScannerActivity {

    private TextView vinTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addLayout(R.layout.activity_scan);
        vinTextView = (TextView)findViewById(R.id.vinTextView);
    }

    @Override
    public void handleDecode(String s) {
        vibrate();
        vinTextView.setText(s);
    }
}
