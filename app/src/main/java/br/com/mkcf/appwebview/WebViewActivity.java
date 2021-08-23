package br.com.mkcf.appwebview;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;


public class WebViewActivity extends FragmentActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);
        webview=(WebView)findViewById(R.id.webPage);

        Intent i = this.getIntent();
        String link = i.getExtras().getString("link");
        Log.d("SwA", "URL ["+link+"]");

        UtilWebView.loadWebViewLoad(webview,link);
    }
}
