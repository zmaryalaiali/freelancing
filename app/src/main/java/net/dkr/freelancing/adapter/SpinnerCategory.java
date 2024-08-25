package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.dkr.freelancing.R;
import net.dkr.freelancing.model.SearchModel;

import java.util.ArrayList;

public class SpinnerCategory extends ArrayAdapter {

    ArrayList<SearchModel.Category> list;
    Context context;
    public SpinnerCategory( Context context, ArrayList<SearchModel.Category> list) {
        super(context, R.layout.view_spinner,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        convertView.get
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.view_spinner,parent,false);
        }
       TextView tv = convertView.findViewById(R.id.tv_spinner);
       tv.setText(list.get(position).getName());
        return convertView;
    }
}
