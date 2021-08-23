package br.com.mkcf.appwebview;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ChangeLinkListener {

    WebView wvf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onLinkChange(String link) {
        System.out.println("Listener");
        if (findViewById(R.id.fragPage) != null) {
            wvf=(WebView)findViewById(R.id.fragPageWeb);

            UtilWebView.loadWebViewLoad(wvf,link);
        }
        else {
            System.out.println("Start Activity");
            Intent i = new Intent(this, WebViewActivity.class);
            i.putExtra("link", link);
            startActivity(i);
        }
    }



}