package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.dkr.freelancing.auth.SignupActivity;
import net.dkr.freelancing.util.SharedText;

public class ChosserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosser);
    }

    public void seller(View view) {
//        SharedText sharedText = new SharedText(this);
//        sharedText.setLog("log");
//        sharedText.setUserText(true);
        Intent i=new Intent(ChosserActivity.this, SignupActivity.class);
        i.putExtra("isSeller",true);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void buyer(View view) {

        Intent i=new Intent(ChosserActivity.this, SignupActivity.class);
        i.putExtra("isSeller",false);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}