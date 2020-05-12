package com.example.sergiobelda.materialmotion.databinding

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.sergiobelda.materialmotion.R
import com.google.android.material.card.MaterialCardView

@BindingAdapter("image_url")
fun imageUrl(imageView: ImageView, url: String) =
    Glide.with(imageView)
        .load(url)
        .into(imageView)