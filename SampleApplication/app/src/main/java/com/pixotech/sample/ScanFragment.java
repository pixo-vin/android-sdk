package com.pixotech.sample;

import android.widget.TextView;

public class ScanFragment extends com.pixotech.android.scanner.library.ScannerFragment {

    public ScanFragment() {
        // Required empty public constructor
    }

    public static ScanFragment newInstance() {
        ScanFragment fragment = new ScanFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        addLayout(R.layout.activity_scan);
    }

    @Override
    public void handleDecode(String s) {
        vibrate();
        TextView t = (TextView)getView().findViewById(R.id.vinTextView);
        t.setText(s);
        startScan();
    }
}
