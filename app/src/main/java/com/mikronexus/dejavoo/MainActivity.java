package com.mikronexus.dejavoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView datetime;
    RelativeLayout switchbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datetime = findViewById(R.id.datetime);
        switchbtn = findViewById(R.id.switchbtn);



        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");


        String currentDateAndTime = sdf.format(new Date());


        datetime.setText(currentDateAndTime);
        switchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("com.mikronexus.cfa");
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {

                }
            }
        });
    }
}