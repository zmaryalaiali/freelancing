package net.dkr.freelancing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.dkr.freelancing.adapter.AdapterInspire;
import net.dkr.freelancing.adapter.AdapterPopular;
import net.dkr.freelancing.adapter.AdapterRecent;
import net.dkr.freelancing.model.InspireModel;
import net.dkr.freelancing.model.PopularServiceModel;
import net.dkr.freelancing.model.RecentModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView rvPopular,rvRecent,rvInspire;
    List<PopularServiceModel> listPopular;
    List<RecentModel>listRecent;
    List<InspireModel> listInspire;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listRecent = new ArrayList<>();
        listInspire = new ArrayList<>();
        listPopular = new ArrayList<>();

        getAllList();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPopular = view.findViewById(R.id.rv_popular_view);
        rvRecent = view.findViewById(R.id.rv_recent_view);
        rvInspire = view.findViewById(R.id.rv_inspire_view);

        rvInspire.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) );
        rvRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) );
        rvPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) );

        AdapterInspire adapterInspire = new AdapterInspire(getContext(),listInspire);
        AdapterRecent adapterRecent = new AdapterRecent(getContext(),listRecent);
        AdapterPopular adapterPopular = new AdapterPopular(getContext(),listPopular);

        rvPopular.setAdapter(adapterPopular);
        rvRecent.setAdapter(adapterRecent);
        rvInspire.setAdapter(adapterInspire);

    }

    private void getAllList(){
        listInspire.add(new InspireModel(R.drawable.busone,R.drawable.star,R.drawable.heart,"inspired model"));
        listInspire.add(new InspireModel(R.drawable.bustwo,R.drawable.star,R.drawable.heart,"Logo Design"));
        listInspire.add(new InspireModel(R.drawable.busthree,R.drawable.star,R.drawable.heart,"Ali"));
        listInspire.add(new InspireModel(R.drawable.busone,R.drawable.star,R.drawable.heart,"Development"));
        listInspire.add(new InspireModel(R.drawable.bustwo,R.drawable.star,R.drawable.heart,"Logo Design"));
        listInspire.add(new InspireModel(R.drawable.busthree,R.drawable.star,R.drawable.heart,"Greating"));

        listRecent.add(new RecentModel(R.drawable.cardone,R.drawable.favorite,"MainText"));
        listRecent.add(new RecentModel(R.drawable.cardtwo,R.drawable.favorite,"MainText"));
        listRecent.add(new RecentModel(R.drawable.cardthree,R.drawable.favorite,"MainText"));
        listRecent.add(new RecentModel(R.drawable.cardfour,R.drawable.favorite,"MainText"));
        listRecent.add(new RecentModel(R.drawable.cardone,R.drawable.favorite,"MainText"));

        listPopular.add(new PopularServiceModel(R.drawable.one," Logo Design"));
        listPopular.add(new PopularServiceModel(R.drawable.two," Development"));
        listPopular.add(new PopularServiceModel(R.drawable.three," Logo Design"));
        listPopular.add(new PopularServiceModel(R.drawable.four,"development"));
        listPopular.add(new PopularServiceModel(R.drawable.five," Logo Design"));


    }
}