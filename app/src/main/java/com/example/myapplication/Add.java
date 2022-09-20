package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Add extends Activity
{
    Connection connect;
    TextInputLayout kod;
    TextInputLayout strixkod;
    TextInputLayout idadres;
    TextInputLayout name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        kod = findViewById((R.id.text_kod));
        strixkod = findViewById(R.id.text_strixkod);
        idadres = findViewById(R.id.text_idadres);
        name = findViewById(R.id.text_iname);
    }

    public void AddAdres(View view){
        Log.d("name - ", String.valueOf(Objects.requireNonNull(name.getEditText()).getText()));
        try{
            ConnectionHelp connection = new ConnectionHelp();
            connect = connection.connectionClass();
            String qu = "insert into Adres values("
                    + Integer.parseInt(String.valueOf(name.getEditText().getText()))
                    + ",\'" + Objects.requireNonNull(kod.getEditText()).getText()
                    + "\',\'" + Objects.requireNonNull(strixkod.getEditText()).getText()+
                    "\'," + Integer.parseInt(String.valueOf(name.getEditText().getText()))+
                    ")";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(qu);
            connect.close();
            Log.d("", String.valueOf((resultSet.last())));
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.d("Error - ",throwables.getMessage());
        }
    }
}
