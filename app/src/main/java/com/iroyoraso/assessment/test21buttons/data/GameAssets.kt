package com.iroyoraso.assessment.test21buttons.data

import com.google.gson.annotations.SerializedName

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
data class GameAssets(
    @SerializedName("logo")
    val logo: ImageAsset,
    @SerializedName("cover-tiny")
    val coverTiny: ImageAsset,
    @SerializedName("cover-small")
    val coverSmall: ImageAsset,
    @SerializedName("cover-medium")
    val coverMedium: ImageAsset,
    @SerializedName("cover-large")
    val coverLarge: ImageAsset
)