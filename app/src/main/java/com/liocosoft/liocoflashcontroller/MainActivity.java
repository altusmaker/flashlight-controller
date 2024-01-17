package com.liocosoft.liocoflashcontroller;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import ir.tapsell.plus.AdRequestCallback;
import ir.tapsell.plus.AdShowListener;
import ir.tapsell.plus.TapsellPlus;
import ir.tapsell.plus.TapsellPlusBannerType;
import ir.tapsell.plus.TapsellPlusInitListener;
import ir.tapsell.plus.model.AdNetworkError;
import ir.tapsell.plus.model.AdNetworks;
import ir.tapsell.plus.model.TapsellPlusAdModel;
import ir.tapsell.plus.model.TapsellPlusErrorModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAPSELL_KEY = "fisjcocdfthgijafllskglfhjtmmomgjpsnnpnebnaeliddcrccgnbjnggrrtsrsjqojgp";
    private static final String TAPSELL_STANDARD_BANNER = "655e399fad1b022511b20672";
    private static final String TAPSELL_INTERSTITIAL_BANNER = "656b88b7a43c9077186d507a";
    private static final String TAG = "StandardActivity";
    private String bannerResponseId;
    private String interstitialResponseId;
    Thread showBannerAd;
    Thread showInterstitialAd;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ad service here
        TapsellPlus.initialize(this, TAPSELL_KEY,
                new TapsellPlusInitListener() {
                    @Override
                    public void onInitializeSuccess(AdNetworks adNetworks) {
                        Log.d("onInitializeSuccess", adNetworks.name());
                    }

                    @Override
                    public void onInitializeFailed(AdNetworks adNetworks,
                                                   AdNetworkError adNetworkError) {
                        Log.e("onInitializeFailed", "ad network: " + adNetworks.name() + ", error: " + adNetworkError.getErrorMessage());
                    }
                });
        TapsellPlus.setGDPRConsent(this, true);
        TapsellPlus.setDebugMode(Log.DEBUG);

        //Start Banner Ad
        requestBannerAd();
        showBannerAd = new Thread(() -> {
            while (bannerResponseId == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            showBannerAd();
            stopBannerAdThread();
        });
        showBannerAd.start();

        //Start Interstitial Ad
        requestInterstitialAd();
        showInterstitialAd = new Thread(() -> {
            while (interstitialResponseId == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            showInterstitialAd();
            stopInterstitialAdThread();
        });
        showInterstitialAd.start();

        //To change between tabs
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }

    private void stopBannerAdThread() {
        if (showBannerAd != null) {
            try {
                showBannerAd.join();
            } catch (InterruptedException e) {
                showBannerAd.interrupt();
            } finally {
                showBannerAd = null;
            }
        }
    }

    private void stopInterstitialAdThread() {
        if (showInterstitialAd != null) {
            try {
                showInterstitialAd.join();
            } catch (InterruptedException e) {
                showInterstitialAd.interrupt();
            } finally {
                showInterstitialAd = null;
            }
        }
    }

    private void requestBannerAd() {
        TapsellPlus.requestStandardBannerAd(
                this, TAPSELL_STANDARD_BANNER,
                TapsellPlusBannerType.BANNER_320x50,
                new AdRequestCallback() {
                    @Override
                    public void response(TapsellPlusAdModel tapsellPlusAdModel) {
                        super.response(tapsellPlusAdModel);
                        if (isDestroyed())
                            return;
                        Log.d(TAG, "banner response");
                        bannerResponseId = tapsellPlusAdModel.getResponseId();
                    }

                    @Override
                    public void error(@NonNull String message) {
                        if (isDestroyed())
                            return;
                        Log.e(TAG, "banner request error " + message);
                    }
                });
    }

    private void requestInterstitialAd() {
        TapsellPlus.requestInterstitialAd(
                this,
                TAPSELL_INTERSTITIAL_BANNER,
                new AdRequestCallback() {
                    @Override
                    public void response(TapsellPlusAdModel tapsellPlusAdModel) {
                        super.response(tapsellPlusAdModel);
                        if (isDestroyed())
                            return;
                        Log.d(TAG, "interstitial response");
                        interstitialResponseId = tapsellPlusAdModel.getResponseId();
                    }

                    @Override
                    public void error(String message) {
                        if (isDestroyed())
                            return;
                        Log.e(TAG, "interstitial error " + message);
                    }

                });
    }

    private void showBannerAd() {
        if (bannerResponseId != null)
            TapsellPlus.showStandardBannerAd(this, bannerResponseId,
                    findViewById(R.id.standardBanner),
                    new AdShowListener() {
                        @Override
                        public void onOpened(TapsellPlusAdModel tapsellPlusAdModel) {
                            super.onOpened(tapsellPlusAdModel);
                            Log.d(TAG, "Banner Opened");
                        }

                        @Override
                        public void onError(TapsellPlusErrorModel tapsellPlusErrorModel) {
                            super.onError(tapsellPlusErrorModel);
                            Log.e(TAG, tapsellPlusErrorModel.toString());
                        }
                    });
    }

    private void showInterstitialAd() {
        if (interstitialResponseId != null)
            TapsellPlus.showInterstitialAd(this, interstitialResponseId,
                    new AdShowListener() {
                        @Override
                        public void onOpened(TapsellPlusAdModel tapsellPlusAdModel) {
                            super.onOpened(tapsellPlusAdModel);
                            Log.d(TAG, "Interstitial Opened");
                        }

                        @Override
                        public void onClosed(TapsellPlusAdModel tapsellPlusAdModel) {
                            super.onClosed(tapsellPlusAdModel);
                            Log.d(TAG, "Interstitial Closed");
                        }

                        @Override
                        public void onError(TapsellPlusErrorModel tapsellPlusErrorModel) {
                            super.onError(tapsellPlusErrorModel);
                            Log.e(TAG, tapsellPlusErrorModel.toString());
                        }
                    });
    }

    private void destroyBannerAd() {
        TapsellPlus.destroyStandardBanner(this, bannerResponseId, findViewById(R.id.standardBanner));
    }
}