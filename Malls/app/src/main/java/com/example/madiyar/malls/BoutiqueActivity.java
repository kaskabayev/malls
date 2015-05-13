package com.example.madiyar.malls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class BoutiqueActivity extends Activity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    String[][] values = new String[][] { {"Aport", "The choice of Kaskelen's people"}, {"MEGA", "The most popular mall in KZ"},
            {"Dostyk Plaza", "The new one, and good one"}};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
    public static int [] prgmImages={R.drawable.no,R.drawable.ok,R.drawable.ok,R.drawable.icon_bear,R.drawable.ok,R.drawable.no,R.drawable.icon_bear,R.drawable.no,R.drawable.ok};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
        gv=(GridView) findViewById(R.id.gridView);
        gv.setAdapter(new MyGridAdapter(this, prgmNameList, prgmImages));


        gv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BoutiqueActivity.this, ItemActivity.class);
                Bundle bun = new Bundle();
                bun.putInt("position", position);
                intent.putExtras(bun);
                startActivity(intent);
            }
        });


        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        TextView titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText(values[position][0]);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_boutique, menu);
        return true;
    }
}