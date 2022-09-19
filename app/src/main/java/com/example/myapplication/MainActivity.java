package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.util.Log;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Connection connection;
    String ConnectionResult="";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

     }
     SimpleAdapter ad;
 public void GetList(View v)
 {
     ListView lstv=(ListView)  findViewById(R.id.listview1);

     List<Map<String, String>> Mydatalist = null;
     ListItem MyData= new ListItem();
     Mydatalist = MyData.getlist();

     String[] From={"Kod","IName","IdAdres","StrixKod"};
     int[ ] Tow= { R.id.Kod,R.id.IName,R.id.IdAdres,R.id.StrixKod};
     ad = new SimpleAdapter(MainActivity.this,Mydatalist,R.layout.listlayoutetemplate,From,Tow);
     lstv.setAdapter((ad));

 }

}