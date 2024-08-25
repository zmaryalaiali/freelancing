package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.dkr.freelancing.adapter.AdapterSaveList;
import net.dkr.freelancing.db.Doa;
import net.dkr.freelancing.db.SaveListDb;
import net.dkr.freelancing.db.SaveListModel;

import java.util.List;

public class SaveListActivity extends AppCompatActivity {

    RecyclerView rv_saved_list;
    List<SaveListModel>saveList;
    AdapterSaveList adapterSaveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_list);

        rv_saved_list=findViewById(R.id.rv_Save_gig_list);
//        saved_list=new ArrayList<>();
        rv_saved_list.setLayoutManager(new LinearLayoutManager(this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                SaveListDb db = SaveListDb.getDb(SaveListActivity.this);
                Doa doa = db.doa();
                saveList = doa.saveListsGet();
                adapterSaveList = new AdapterSaveList(saveList,SaveListActivity.this);
                rv_saved_list.setAdapter(adapterSaveList);
            }
        }).start();

//        saved_list.add(new GigModel(R.drawable.busone,"3.3","111",true,11,"create, edit,redesign minimalist bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.one,"2.2","111",true,99,"create, edit,redesign minimalist bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.two,"4.3","111",true,34,"create,minimalist bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.three,"1.3","111",true,22,"create, edit,redesign minimalist bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.four,"2.3","111",true,55,"create, card,redesign  bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.cardone,"5.3","21",true,99,"create, edit,redesign minimalist bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.cardfour,"6.3","111",true,888,"create, edit,bussnise ..."));
//        saved_list.add(new GigModel(R.drawable.cardthree,"7.3","131",true,99,"create, minimalist bussnise ..."));
//        adapterGig_saved_gig=new AdapterGig(this,saved_list);
//        rv_saved_list.setAdapter(adapterGig_saved_gig);


//
    }
}