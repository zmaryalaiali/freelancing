package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateProfileActivity extends AppCompatActivity {

    Button btn_create_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        btn_create_profile=findViewById(R.id.btn_create_profile);


        btn_create_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CreateProfileActivity.this, SellerCreateProfileActivity.class);
                startActivity(i);
            }
        });
    }
}