package net.dkr.freelancing.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import net.dkr.freelancing.R;
import net.dkr.freelancing.adapter.AdapterMessage;
import net.dkr.freelancing.adapter.AdapterMessageUser;
import net.dkr.freelancing.model.ChatResponse;
import net.dkr.freelancing.model.MessageModel;
import net.dkr.freelancing.model.MessageUserModel;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MessageFragment extends Fragment {
    private Context context;
    List<ChatResponse> messageUserModelList;
    AdapterMessageUser adapterMessageUser;
    RecyclerView rvUsers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvUsers = view.findViewById(R.id.rv_message_userList);
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        //all users chat list
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = RestSingleTon.getRetrofit();
                String userId = new SharedText(getContext()).getUserId();
                RestApi api = retrofit.create(RestApi.class);
                Call<ChatResponse[]> call = api.getChats(userId);
                call.enqueue(new Callback<ChatResponse[]>() {
                    @Override
                    public void onResponse(Call<ChatResponse[]> call, Response<ChatResponse[]> response) {
                        if (response.isSuccessful()){
                            messageUserModelList = new ArrayList<>(Arrays.asList(response.body()));
                            adapterMessageUser = new AdapterMessageUser(getContext(),messageUserModelList);
                            rvUsers.setAdapter(adapterMessageUser);

                        }
                    }

                    @Override
                    public void onFailure(Call<ChatResponse[]> call, Throwable throwable) {
                        Toast.makeText(context, "Error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();






    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }
}