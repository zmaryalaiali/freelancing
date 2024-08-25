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

import net.dkr.freelancing.CreateProfileActivity;
import net.dkr.freelancing.JobActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.SaveListActivity;
import net.dkr.freelancing.SellerMainActivity;
import net.dkr.freelancing.SettingsActivity;


public class ProfileFragment extends Fragment {

    RelativeLayout relativeLayoutSetting, relativeLayoutProfile,relative_save_list ;
    RelativeLayout btnJob;
    RelativeLayout btnSellerProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        relativeLayoutSetting = view.findViewById(R.id.relative_settings);
        btnSellerProfile = view.findViewById(R.id.relative7);
        relativeLayoutProfile = view.findViewById(R.id.relative2);
        relative_save_list=view.findViewById(R.id.relative_save_list);
        btnJob = view.findViewById(R.id.btnJob);


        btnSellerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SellerMainActivity.class);
                startActivity(intent);
               getActivity().finish();
            }
        });
        btnJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), JobActivity.class);
                startActivity(intent);
            }
        });


        relativeLayoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        relativeLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreateProfileActivity.class);
                startActivity(intent);
            }
        });
        relative_save_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SaveListActivity.class);
                startActivity(intent);
            }
        });



    }
}