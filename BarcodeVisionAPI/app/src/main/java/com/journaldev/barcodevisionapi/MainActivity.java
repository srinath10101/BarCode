package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTakePicture, btnScanBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Intent inten = getIntent();
        Bundle extras = inten.getExtras();
        Button butt = (Button) findViewById(R.id.pushtofirebase);
        TextView txt = (TextView) findViewById(R.id.codetosend);
        if(extras!=null){
            final String codetosend = extras.getString("BarCode");
            txt.setText("Check if barcode is right: "+codetosend+"");
            butt.setVisibility(View.VISIBLE);
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*

                        ADD codetosend TO FIREBASE!!!!!!!!!!!!!!!!!!

                     */

                    //Toast.makeText(MainActivity.this, "Pushing "+codetosend+" to firebase", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initViews() {
        btnTakePicture = findViewById(R.id.btnTakePicture);
        btnScanBarcode = findViewById(R.id.btnScanBarcode);
        btnTakePicture.setOnClickListener(this);
        btnScanBarcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnTakePicture:
                startActivity(new Intent(MainActivity.this, PictureBarcodeActivity.class));
                break;
            case R.id.btnScanBarcode:
                startActivity(new Intent(MainActivity.this, ScannedBarcodeActivity.class));
                break;
        }

    }
}
