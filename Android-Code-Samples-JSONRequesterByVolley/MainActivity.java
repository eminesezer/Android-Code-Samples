package com.example.eminesezer.requesterwithvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.eminesezer.requesterwithvolley.patternpackage.RequesterQue;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.index_layout );
        final EditText username=(EditText)findViewById( R.id.editUserName);
        final EditText password=(EditText)findViewById( R.id.editPasssword);
        Button loginbt=(Button)findViewById(R.id.loginButton);
        loginbt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> postParam= new HashMap<String, String>();
                postParam.put("user", username.getText().toString());
                postParam.put("pass", password.getText().toString());
                JSONRequester( postParam );
            }
        } );
    }
    public JSONObject[] JSONRequester(Map<String,String> jsonmap){
        final JSONObject[] res = {new JSONObject()};
        final JSONObject js= new JSONObject( jsonmap );
        JsonObjectRequest jor = new JsonObjectRequest( Request.Method.POST, "https://www.trmyrobot.com/api/logs.php",js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText( getApplicationContext(), response.getString("method"), Toast.LENGTH_LONG ).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e( "Volley", error.toString() );
            }
        } ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        RequesterQue.getInstance( MainActivity.this ).addToRequestQueue( jor );
        return res;
    }
}
