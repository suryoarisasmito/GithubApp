package com.dicoding.githubapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubResponse(
    var name : String,
    var birth : String,
    var city : String,
    var photo : Int
) : Parcelable
