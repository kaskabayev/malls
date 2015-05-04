package com.example.madiyar.malls;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class BoutiqueActivity extends Activity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
    public static int [] prgmImages={R.drawable.no,R.drawable.ok,R.drawable.ok,R.drawable.icon_bear,R.drawable.ok,R.drawable.no,R.drawable.icon_bear,R.drawable.no,R.drawable.ok};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
        gv=(GridView) findViewById(R.id.gridView);
        gv.setAdapter(new MyGridAdapter(this, prgmNameList, prgmImages));

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        Toast.makeText(this, "You selected IN BOUTIQUE: " + position, Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_boutique, menu);
        return true;
    }
}