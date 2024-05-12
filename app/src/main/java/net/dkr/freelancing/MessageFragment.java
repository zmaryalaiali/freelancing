package net.dkr.freelancing;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.dkr.freelancing.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    private Context context;
    List<String> listMessages;

    List<MessageModel> messageModelList ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        messageModelList = new ArrayList<>();
        listMessages = new ArrayList<>();
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
        listMessages.add("hello");
    }
}