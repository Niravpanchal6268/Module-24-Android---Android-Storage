package com.example.managements;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    NavigationView view;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        view = findViewById(R.id.navigation_id);
        toolbar = findViewById(R.id.tool_bar_id);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerlayout_id);
        drawerLayout.setDrawerListener(toggle);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new AddStdFragment()).commit();
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.add_students_m_id:
                        fragment = new AddStdFragment();
                        break;
                    case R.id.view_student_m_id:
                        fragment = new View_stdFragment();
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
}