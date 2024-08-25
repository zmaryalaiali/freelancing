package net.dkr.freelancing.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import net.dkr.freelancing.R;
import net.dkr.freelancing.Seller_Earning_Activity;

import java.util.ArrayList;
import java.util.List;

public class SellerHomeFragment extends Fragment {
    TextView tvEarningClick;

    List<PieEntry> pieEntryList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvEarningClick = view.findViewById(R.id.tv_seller_home_earningClick);
//        seekBar = view.findViewById(R.id.seekbar_seller_home_response_rate);
//        pieChart = view.findViewById(R.id.pie_seller_home_level);
//        seekBar.setEnabled(false);
//        setPieChart();
//        PieDataSet dataSet = new PieDataSet(pieEntryList,"new score");
//        dataSet.setColor(R.color.primary);
//
//        PieData pieData = new PieData(dataSet);
//
//        pieChart.setData(pieData);

        tvEarningClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Seller_Earning_Activity.class);
                getContext().startActivity(intent);
            }
        });
    }



    private void setPieChart(){

        pieEntryList = new ArrayList<>();
        pieEntryList.add(new PieEntry(80,"New Level"));
        pieEntryList.add(new PieEntry(50,"Score Level"));
        pieEntryList.add(new PieEntry(30,"Rating"));
        pieEntryList.add(new PieEntry(23,"money"));

    }
}