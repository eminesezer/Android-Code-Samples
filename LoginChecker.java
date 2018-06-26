package com.example.eminesezer.sessiondenemesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoginChecker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_checker );
        final SessionClass sc=(SessionClass)getApplicationContext();
        final TextView username=(TextView) findViewById( R.id.usernameTextView3);
        final TextView username2=(TextView) findViewById( R.id.usernameTextView4);
        username.setText( sc.getUsername().toString() );
        username2.setText( sc.getInfo().toString() );
    }
}
