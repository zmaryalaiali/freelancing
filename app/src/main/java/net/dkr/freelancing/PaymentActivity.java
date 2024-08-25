package net.dkr.freelancing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.dkr.freelancing.model.PaymentModel;
import net.dkr.freelancing.model.PaymentResponse;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PaymentActivity extends AppCompatActivity {
    WebView webView ;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        webView = findViewById(R.id.webPayment);
        progressBar = findViewById(R.id.pro_payment);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("https://commerce.coinbase.com/pay/5b8f3113-0e20-410f-9f70-fceac9595757");
//webView.loadUrl("https://medium.com/android-news/webview-load-from-string-the-good-way-the-working-way-665c62d418b");
        String amount = getIntent().getStringExtra("amount");
        String orderId = getIntent().getStringExtra("orderId");
        String currency = "USD";

        String urlString = "http://mysuperwebsite";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://commerce.coinbase.com/pay/5b8f3113-0e20-410f-9f70-fceac9595757"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        startActivity(intent);

        PaymentModel model = new PaymentModel(amount,orderId,currency);

        Retrofit retrofit = RestSingleTon.getRetrofit();
        RestApi api = retrofit.create(RestApi.class);
        Call<PaymentResponse> call = api.payment(new SharedText(this).getCookie(),model);
        call.enqueue(new Callback<PaymentResponse>() {
            @Override
            public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
                if (response.isSuccessful()){
                    webView.loadUrl(response.body().getHostedUrl());
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(response.body().getHostedUrl()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.android.chrome");
                    startActivity(intent);
                    finish();
                    Toast.makeText(PaymentActivity.this, "done", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PaymentActivity.this, "some error "+response.errorBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PaymentResponse> call, Throwable throwable) {
                Toast.makeText(PaymentActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private class MyClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
        }
    }
}