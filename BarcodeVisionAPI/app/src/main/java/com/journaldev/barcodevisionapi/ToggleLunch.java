package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class ToggleLunch extends AppCompatActivity {
    boolean hadlunch = false;
    int check=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_lunch);
        Intent inten = getIntent();
        Bundle extras = inten.getExtras();
        Button toggle = (Button) findViewById(R.id.butttoggle);
        if (extras != null) {
            final String code = inten.getStringExtra("code");
            final String day = inten.getStringExtra("day");

            if(day.equals("1")){
                toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check++;
                        if(check%2==0)
                            hadlunch = true;
                        else
                            hadlunch = false;

                        FirebaseDatabase.getInstance().getReference(code+"").child("lc1").setValue(hadlunch);
                        Toast.makeText(ToggleLunch.this, "Day 1 lunch done.", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(ToggleLunch.this,MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();

                    }
                });

            }
            else if(day.equals("2")){
                toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check++;
                        if(check%2==0)
                            hadlunch = true;
                        else
                            hadlunch = false;

                        FirebaseDatabase.getInstance().getReference(code+"").child("lc2").setValue(hadlunch);
                        Toast.makeText(ToggleLunch.this, "Day 2 lunch done.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ToggleLunch.this,MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                    }
                });

            }
            else if(day.equals("3")){
                toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check++;
                        if(check%2==0)
                            hadlunch = true;
                        else
                            hadlunch = false;

                        FirebaseDatabase.getInstance().getReference(code+"").child("lc3").setValue(hadlunch);
                        Toast.makeText(ToggleLunch.this, "Day 3 lunch done.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ToggleLunch.this,MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                    }
                });

            }
        }
    }
}
