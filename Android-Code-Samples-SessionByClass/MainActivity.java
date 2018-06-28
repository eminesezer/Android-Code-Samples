package com.example.eminesezer.sessiondenemesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        final SessionClass sc=(SessionClass)getApplicationContext();
        final EditText username=(EditText)findViewById( R.id.editUserName);
        Button loginbt=(Button)findViewById(R.id.loginButton);
        Button loginbt2=(Button)findViewById(R.id.loginButton2);
          loginbt2.setOnClickListener( new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(getApplicationContext(), sc.getUsername()+" ben username "+sc.getInfo()+" ben info",Toast.LENGTH_LONG).show();
              }
          } );
        loginbt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc.setUsername(username.getText().toString().trim());
                Intent I=new Intent( getApplicationContext(), Main2Activity.class );
                startActivity( I );
            }
        } );
    }
}
