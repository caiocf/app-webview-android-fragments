package br.com.mkcf.appwebview;

import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class UtilWebView  {

    public static void loadWebViewLoad(WebView  wvf, String link) {
        if(wvf != null) {
            wvf.getSettings().setJavaScriptEnabled(true);
            wvf.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            wvf.getSettings().setSupportMultipleWindows(true);
            wvf.setWebViewClient(new MyWebViewClient());
            wvf.setWebChromeClient(new WebChromeClient());
            wvf.setWebViewClient(new Callback());

            if (android.os.Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(wvf, true);
            } else {
                CookieManager.getInstance().setAcceptCookie(true);
            }

            wvf.loadUrl(link);
        }
    }

    private static class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }

    }

    private static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //your handling...
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}