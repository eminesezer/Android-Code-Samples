package com.example.eminesezer.createnavigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        dl=(DrawerLayout)findViewById( R.id.drawerlayout );
        abdt=new ActionBarDrawerToggle( this, dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled( true );
        dl.addDrawerListener( abdt );
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
       final  NavigationView nav_view=findViewById( R.id.nav_view );
        nav_view.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch(id){
                    case R.id.profile:
                        Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_LONG).show();
                        break;
                        default:
                            break;
                }
                return true;
            }
        } );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected( item )||super.onOptionsItemSelected( item );
    }
}
