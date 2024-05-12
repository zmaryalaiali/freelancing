package net.dkr.freelancing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomneviggation);

        getSupportFragmentManager().beginTransaction().add(new HomeFragment(),"HomeFragment").commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                if (menuItem.getItemId() ==  R.id.home)
                        fragment = new HomeFragment();
                else if (menuItem.getItemId() ==  R.id.message) {
                    fragment = new MessageFragment();
                }
                else if (menuItem.getItemId() ==  R.id.search) {
                    fragment = new SearchFragment();
                } else if (menuItem.getItemId() ==  R.id.manage_order) {
                    fragment = new ManageOrderFragment();
                } else if (menuItem.getItemId() ==  R.id.profile) {
                    fragment = new ProfileFragment();
                }
                else
                        fragment = new HomeFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
                return true;
            }
        });
    }
}