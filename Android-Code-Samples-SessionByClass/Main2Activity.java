package com.example.eminesezer.sessiondenemesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        final SessionClass sc=(SessionClass)getApplicationContext();
        final EditText username=(EditText)findViewById( R.id.editUserName2);
        Button loginbt=(Button)findViewById(R.id.loginButton2);

        loginbt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc.setInfo(username.getText().toString().trim());
                Intent I=new Intent( getApplicationContext(), LoginChecker.class );
                startActivity( I );
            }
        } );
    }
}
