package net.dkr.freelancing.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import net.dkr.freelancing.AppHomeActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.SellerActivity;
import net.dkr.freelancing.Seller_Earning_Activity;
import net.dkr.freelancing.SettingsActivity;
import net.dkr.freelancing.util.SharedText;

public class seller_Profile_Fragment extends Fragment {


    RelativeLayout relativeSellerEarnings, relativeSellerMyProfile
            ,relativeSellerSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller__profile_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        relativeSellerEarnings =view.findViewById(R.id.relative_seller_Earnings);
        relativeSellerMyProfile =view.findViewById(R.id.relative_seller_my_profile);
        relativeSellerSetting = view.findViewById(R.id.relative_seller_settings);




        relativeSellerEarnings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Seller_Earning_Activity.class);
                startActivity(intent);


            }
        });
        relativeSellerMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SellerActivity.class);
                SharedText sharedText = new SharedText(getContext());
                intent.putExtra("userId",sharedText.getUserId());
                startActivity(intent);
            }
        });

        relativeSellerSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}