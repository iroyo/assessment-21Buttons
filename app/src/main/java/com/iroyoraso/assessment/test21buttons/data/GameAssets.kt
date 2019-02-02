package com.iroyoraso.assessment.test21buttons.data

import com.google.gson.annotations.SerializedName

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
data class GameAssets(
    @SerializedName("logo")
    val logo: ImageAsset?,
    @SerializedName("cover_tiny")
    val coverTiny: ImageAsset?,
    @SerializedName("cover_small")
    val coverSmall: ImageAsset?,
    @SerializedName("cover_medium")
    val coverMedium: ImageAsset?,
    @SerializedName("cover_large")
    val coverLarge: ImageAsset?
)