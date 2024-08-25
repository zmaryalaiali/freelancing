    package net.dkr.freelancing;

    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Handler;
    import android.view.animation.Animation;
    import android.view.animation.AnimationUtils;
    import android.widget.ImageView;

    import androidx.appcompat.app.AppCompatActivity;

    import net.dkr.freelancing.util.SharedText;

    public class SplashActivity extends AppCompatActivity {

        boolean isLog = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);



           Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);

            ImageView imageView = findViewById(R.id.iv_splash);

            imageView.setAnimation(animation);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            isLog = new SharedText(SplashActivity.this).getLog();

            if (isLog){
                Intent intent ;

                if (new SharedText(SplashActivity.this).userType()){

                    intent = new Intent(SplashActivity.this, SellerMainActivity.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
            else {
                Intent intent = new Intent(SplashActivity.this, AppHomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }

        }
    },1000);

        }
    }