# cmadmob
Kotlin: 
  ```
   MCAdmob.getInstances().onInit(context,callback,adview,mInterstitialAd_id,lived)
  ```
  ```
  @Override protected void onCreate(Bundle savedInstanceState) {
        var adView = findViewById<AdView>(R.id.adView)
        MCAdmob.getInstances().onInit(this,
                        object : MCAdmob() {
            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdClosed() {
                super.onAdClosed()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }

            override fun onAdFailedToLoad(p0: Int) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }
        }, adView, "ca-app-pub-444444444444", false)
    }

    # How to use InterstitialAd
    MCAdmob.getInstances().showInterstitialAd();
