package com.ibrahim.myrecipes.presentation.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.view.isVisible
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.ibrahim.myrecipes.databinding.AdUnifiedBinding

@Composable
fun NativeAdComposable(
    adUnitId: String,
    modifier: Modifier
) {
    AndroidViewBinding(factory = AdUnifiedBinding::inflate, modifier = modifier) {
        val adView = root.also { adview ->
            adview.bodyView = this.adBody
            adview.callToActionView = this.adCallToAction
            adview.headlineView = this.adHeadline
            adview.iconView = this.adImage
        }

        val adContainer = this.adContainer
        val adParent = this.nativeAdView

        val adLoader = AdLoader.Builder(adView.context, adUnitId)
            .forNativeAd { nativeAd ->
                nativeAd.advertiser?.let { advertiser ->

                }
                nativeAd.body?.let { body ->
                    this.adBody.text = body
                }
                nativeAd.callToAction?.let { adCallToAction ->
                    this.adCallToAction.text = adCallToAction
                }
                nativeAd.icon?.let { icon ->
                    this.adImage.setImageDrawable(icon.drawable)
                }
                adView.setNativeAd(nativeAd)

            }.withAdListener(object : AdListener() {
                override fun onAdLoaded() {
                    adContainer.isVisible = true
                    super.onAdLoaded()
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    adParent.isVisible = false
                    super.onAdFailedToLoad(error)
                }
            }).withNativeAdOptions(
                NativeAdOptions.Builder().setAdChoicesPlacement(
                    NativeAdOptions.ADCHOICES_TOP_RIGHT
                ).build()
            ).build()
        adContainer.isVisible = true
        adLoader.loadAd(AdRequest.Builder().build())
    }
}