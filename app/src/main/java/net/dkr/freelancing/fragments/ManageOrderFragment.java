package net.dkr.freelancing.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import net.dkr.freelancing.R;
import net.dkr.freelancing.adapter.AdapterManageOrdersFragment;

public class ManageOrderFragment extends Fragment {
    ViewPager viewPager;
BottomNavigationView bottomNavigationView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView = view.findViewById(R.id.bottom_orderManagement);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
               if (R.id.menu_seller_manageOrder_active == menuItem.getItemId()){
                   fragment = new ActiveOrdersFragment();
                   Toast.makeText(getContext(), "active", Toast.LENGTH_SHORT).show();

               }
               else if (R.id.menu_seller_manageOrder_cancel == menuItem.getItemId()){
                   fragment = new CanceledOrdersFragment();
                   Toast.makeText(getContext(), "Cancel", Toast.LENGTH_SHORT).show();

               }
               else if (R.id.menu_seller_manageOrder_complete == menuItem.getItemId()){
                   fragment = new CompletedOrdersFragment();
                   Toast.makeText(getContext(), "Complete", Toast.LENGTH_SHORT).show();

               }

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.orderFrame,fragment).commit();

                return true;
            }
        });

//        tabLayout=view.findViewById(R.id.tab_order_layout);
        getActivity().getSupportFragmentManager().beginTransaction().add(new ActiveOrdersFragment(),"Active").replace(R.id.orderFrame,new ActiveOrdersFragment()).commit();

//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    private void setUpViewPager(ViewPager viewPager) {

        AdapterManageOrdersFragment adapter=new AdapterManageOrdersFragment(getChildFragmentManager());
        adapter.addFragment(new ActiveOrdersFragment(),"Active");
        adapter.addFragment(new CompletedOrdersFragment(),"Completed");
        adapter.addFragment(new CanceledOrdersFragment(),"Canceled");
        viewPager.setAdapter(adapter);

    }
}