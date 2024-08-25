package net.dkr.freelancing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.dkr.freelancing.fragments.ManageOrderFragment;
import net.dkr.freelancing.fragments.MessageFragment;
import net.dkr.freelancing.fragments.SellerHomeFragment;
import net.dkr.freelancing.fragments.seller_Profile_Fragment;

public class SellerMainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_main);

        bottomNavigationView = findViewById(R.id.bottomneviggationOfSeller);

        getSupportFragmentManager().beginTransaction().add(new seller_Profile_Fragment(),"seller_Profile_Fragment").replace(R.id.frameLayout_seller,new SellerHomeFragment()).commit();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                if (menuItem.getItemId() ==  R.id.seller_profile) {
                    fragment = new seller_Profile_Fragment();
                }
                else if (menuItem.getItemId() ==  R.id.seller_order) {
                    fragment =  new ManageOrderFragment();
                }
                else if (menuItem.getItemId() ==  R.id.seller_massage) {
                    fragment = new MessageFragment();
                }
                else if (menuItem.getItemId() ==  R.id.seller_home){
                    fragment = new SellerHomeFragment();
                }
                else
                {
                    fragment = new seller_Profile_Fragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_seller,fragment).commit();
                return true;
            }
        });
    }
}