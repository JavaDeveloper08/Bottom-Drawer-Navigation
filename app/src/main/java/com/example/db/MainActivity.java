package com.example.db;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame;
    DrawerLayout drawer;
    NavigationView navigation;
    BottomNavigationView bootom;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame=findViewById(R.id.frame);
        drawer=findViewById(R.id.drawer);
        navigation=findViewById(R.id.navigation);
        bootom=findViewById(R.id.bootom);

        replace(new PoojaFragment());

toggle=new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
drawer.addDrawerListener(toggle);
toggle.syncState();
getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bootom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.mummy:
                        replace(new MummyFragment());
                        break;

                    case R.id.papa:
                        replace(new PapaFragment());
                        break;

                    case R.id.bhaiya:
                        replace(new BhaiyaFragment());
                        break;

                    case R.id.ankit:
                        replace(new AnkitFragment());
                        break;
                }
                return false;
            }
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        replace(new homeFragment());
                        break;

                    case R.id.contact:
                        replace(new ContactFragment());
                        break;

                    case R.id.help:
                        replace(new HelpFragment());
                        break;

                    case R.id.feed:
                        replace(new FeedFragment());
                        break;

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    void replace(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        toggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
