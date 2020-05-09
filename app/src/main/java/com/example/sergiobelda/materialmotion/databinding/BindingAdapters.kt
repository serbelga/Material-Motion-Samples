package com.example.sergiobelda.materialmotion.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image_url")
fun imageUrl(imageView: ImageView, url: String) =
    Glide.with(imageView)
        .load(url)
        .into(imageView)