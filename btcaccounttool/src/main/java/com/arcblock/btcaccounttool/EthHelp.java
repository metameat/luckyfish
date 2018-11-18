package com.arcblock.btcaccounttool;

import android.app.Application;

import com.apollographql.apollo.fetcher.ApolloResponseFetchers;
import com.arcblock.corekit.ABCoreKitClient;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

import static com.arcblock.corekit.config.CoreKitConfig.ApiType.API_TYPE_ETH;

public class EthHelp extends Application {
    private ABCoreKitClient mABCoreClient;

    public static EthHelp INSTANCE = null;

    public static EthHelp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        ZXingLibrary.initDisplayOpinion(this);

        Timber.plant(new Timber.DebugTree());

        mABCoreClient = ABCoreKitClient.builder(this, API_TYPE_ETH)
                .setOpenOkHttpLog(true)
                .setDefaultResponseFetcher(ApolloResponseFetchers.CACHE_AND_NETWORK)
                .build();
    }

    @NotNull
    public ABCoreKitClient abCoreKitClient() {
        if (mABCoreClient == null) {
            throw new RuntimeException("Please init corekit first.");
        }
        return mABCoreClient;
    }

}
