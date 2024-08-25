package net.dkr.freelancing.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.adapter.AdapterSellerLanguage;
import net.dkr.freelancing.adapter.AdapterSellerSkill;
import net.dkr.freelancing.R;
import net.dkr.freelancing.model.SellerLanguageModel;
import net.dkr.freelancing.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SellerAboutFragment extends Fragment {

    RecyclerView rvLanguage, rvSkill;
    AdapterSellerLanguage adapterSellerLanguage;
    AdapterSellerSkill adapterSellerSkill;

    TextView tvUserInfo, tvUserDesc, tvUserFrom, tvUserMember;
    String userId;

    public SellerAboutFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvLanguage = view.findViewById(R.id.rv_seller_languages);
        rvSkill = view.findViewById(R.id.rv_seller_skills);
        tvUserDesc = view.findViewById(R.id.tv_activity_seller_desc);
        tvUserInfo = view.findViewById(R.id.tv_activity_seller_info);
        tvUserFrom = view.findViewById(R.id.tv_activity_seller_from);
        tvUserMember = view.findViewById(R.id.tv_activity_seller_member);

        new Thread(() -> {
            Retrofit retrofit = RestSingleTon.getRetrofit();
            RestApi api = retrofit.create(RestApi.class);
            String url = AllURL.BASE_URL + "users/" + userId;
            Call<UserModel> call = api.getUser(url);
            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getProfile() != null) {
                            UserModel model = response.body();
                            tvUserInfo.setText(model.getProfile().getProfileTitle());
                            tvUserDesc.setText(model.getProfile().getWorkExperience().get(0).getDescription());
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                                SimpleDateFormat format =new SimpleDateFormat("dd mm yyyy");
//                                 LocalDate  localDate = LocalDate.parse(model.getCreatedAt());
//                                DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy mm dd",lo)
//                                tvUserMember.setText(localDate.format(format));

//                            }
                            tvUserMember.setText(model.getCreatedAt());
                            tvUserFrom.setText(model.getCountry());
                            adapterSellerLanguage = new AdapterSellerLanguage(getContext(), model.getProfile().getLanguages());
                            adapterSellerSkill = new AdapterSellerSkill(getContext(), model.getProfile().getSkills());
                            rvLanguage.setAdapter(adapterSellerLanguage);
                            rvSkill.setAdapter(adapterSellerSkill);


                        }
                    } else {
                        tvUserInfo.setText("some error " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable throwable) {
                    tvUserInfo.setText(" dont Done " + throwable.getMessage());

                }
            });
        }).start();


        rvSkill.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvLanguage.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


    }
}