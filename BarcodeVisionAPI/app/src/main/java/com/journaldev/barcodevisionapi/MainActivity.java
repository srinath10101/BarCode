package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTakePicture, btnScanBarcode;
    boolean exists = false;
    Participant p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Intent inten = getIntent();
        Bundle extras = inten.getExtras();
        final Button butt = (Button) findViewById(R.id.lc1);
        final Button butt2 = (Button) findViewById(R.id.lc2);
        final Button butt3 = (Button) findViewById(R.id.lc3);
        final TextView txt = (TextView) findViewById(R.id.codetosend);

        if(extras!=null){
            //Toast.makeText(this, "Back here broooo", Toast.LENGTH_SHORT).show();

            final String codetosend = extras.getString("BarCode");
                //txt.setText("Check if barcode is right: "+codetosend+"");
            if(codetosend.length()>0) {
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                FirebaseDatabase.getInstance().getReference(codetosend + "").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Toast.makeText(MainActivity.this, size + " uwotm8", Toast.LENGTH_SHORT).show();

                        p = dataSnapshot.getValue(Participant.class);
                        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                        if (p.cty.length() > 0)
                            txt.setText("Country: " + p.cty + "\n" + "Committee: " + p.com + "\n" + "Name: " + p.nam+ "\n" + "Paid: " + !p.pay  );
                        if (p.lc1){
                            butt.setBackgroundColor(Color.GREEN);
                        }
                        else{
                            butt.setBackgroundColor(Color.RED);
                        }
                        if (p.lc2){
                            butt2.setBackgroundColor(Color.GREEN);
                        }
                        else{
                            butt2.setBackgroundColor(Color.RED);
                        }
                        if (p.lc3){
                            butt3.setBackgroundColor(Color.GREEN);
                        }
                        else{
                            butt3.setBackgroundColor(Color.RED);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
                    /*

                        check if codetosend exists in firebase!!!!!!!!!!!!!!!!!!

                     */
                        //Toast.makeText(MainActivity.this, "STARTING IT HEARD A CLICK THOUGH", Toast.LENGTH_SHORT).show();
                butt.setVisibility(View.VISIBLE);
                butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                        FirebaseDatabase.getInstance().getReference(codetosend+"").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                //Toast.makeText(MainActivity.this, size + " uwotm8", Toast.LENGTH_SHORT).show();

                                p = dataSnapshot.getValue(Participant.class);
                                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                                if(p.cty.length()>0){
                                    Toast.makeText(MainActivity.this, "Day 1 lunch done? : "+p.lc1, Toast.LENGTH_LONG).show();
                                    if(!p.lc1){

                                        FirebaseDatabase.getInstance().getReference(codetosend+"").child("lc1").setValue(true);
                                        Toast.makeText(MainActivity.this, "Day 1 lunch done.", Toast.LENGTH_SHORT).show();

                                    }
                                    else{
                                        Intent i = new Intent(MainActivity.this,ToggleLunch.class);
                                        i.putExtra("code",codetosend+"");
                                        i.putExtra("day","1");
                                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(i);
                                    }

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                });
            butt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                    FirebaseDatabase.getInstance().getReference(codetosend+"").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Toast.makeText(MainActivity.this, size + " uwotm8", Toast.LENGTH_SHORT).show();

                            p = dataSnapshot.getValue(Participant.class);
                            if(p.cty.length()>0){
                                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Day 2 lunch done? : "+p.lc2, Toast.LENGTH_LONG).show();
                                if(!p.lc2){
                                    FirebaseDatabase.getInstance().getReference(codetosend+"").child("lc2").setValue(true);
                                    Toast.makeText(MainActivity.this, "Day 2 lunch done.", Toast.LENGTH_SHORT).show();

                                }
                                else{

                                    Intent i = new Intent(MainActivity.this,ToggleLunch.class);
                                    i.putExtra("code",codetosend+"");
                                    i.putExtra("day","2");
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                }

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            });
            butt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                    FirebaseDatabase.getInstance().getReference(codetosend+"").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Toast.makeText(MainActivity.this, size + " uwotm8", Toast.LENGTH_SHORT).show();

                            p = dataSnapshot.getValue(Participant.class);
                            if(p.cty.length()>0){
                                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Day 3 lunch done? : "+p.lc3, Toast.LENGTH_LONG).show();
                                if(!p.lc3){
                                    FirebaseDatabase.getInstance().getReference(codetosend+"").child("lc3").setValue(true);
                                    Toast.makeText(MainActivity.this, "Day 3 lunch done.", Toast.LENGTH_SHORT).show();

                                }
                                else{

                                    Intent i = new Intent(MainActivity.this,ToggleLunch.class);
                                    i.putExtra("code",codetosend+"");
                                    i.putExtra("day","3");
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                }

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

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
                Intent i = new Intent(MainActivity.this, PictureBarcodeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

                break;
            case R.id.btnScanBarcode:

                Intent in = new Intent(MainActivity.this, ScannedBarcodeActivity.class);
               // in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                break;
        }

    }
}
