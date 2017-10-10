/*
 * Copyright (C) 2017 Morecmbodia.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.morecambodia.admobcore

import android.content.Context
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd

/**
 * Created by nemo on 10/10/2017.
 */
open class MCAdmob : AdListener() {
    var mInterstitialAd: InterstitialAd? = null
    companion object {
        private var instance: MCAdmob? = null
        fun getInstances(): MCAdmob {
            if (instance == null)
                instance = MCAdmob()
            return instance!!
        }
    }

    /**
     * Init Admob
     * @param context: type context from activity
     * @param adListener: AdListener
     * @param adView: AdView
     * @param adUnitID: Unit ID for mInterstitialAd
     * @param live: true as live ads , false as testing
     *
     */
    fun onInit(context: Context, adListener: AdListener, adView: AdView, adUnitID: String, live: Boolean) {

        val adRequest: AdRequest

        if (mInterstitialAd == null) {
            mInterstitialAd = InterstitialAd(context)
            mInterstitialAd?.adUnitId = adUnitID
            mInterstitialAd?.loadAd(AdRequest.Builder().build())
            mInterstitialAd?.adListener = adListener
        }
        if (live) {
            adRequest = AdRequest.Builder()
                    .build()
        } else {
            adRequest = AdRequest.Builder()
                    .addTestDevice("0FA20932AFE1095798444FD9AAB7D425")
                    .build()
        }
        if (adView != null) {
            adView.loadAd(adRequest)
        }
    }

    /**
     * show interstitial ad
     */
    fun showInterstitialAd() {
        if (mInterstitialAd?.isLoaded!!) {
            mInterstitialAd?.show();
        }
    }
}