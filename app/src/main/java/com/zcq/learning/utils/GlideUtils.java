package com.zcq.learning.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;

/**
 * Create by zcq at 2023/7/2 16:05
 */
public class GlideUtils {

    public static void loadImageFromUrl(Context context, String imageUrl, ImageView imageView){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        Glide.with(context).load(imageUrl).dontAnimate().into(imageView);
    }

    //加载图片
    public static void loadImageFromUrl(Context context, String imageUrl, ImageView imageView, int defaultImg){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        Glide.with(context).load(imageUrl).dontAnimate().placeholder(defaultImg).error(defaultImg).into(imageView);
    }

    //加载动图 如：gif
    public static void loadAnimateImage(Context context, String imageUrl, ImageView imageView, int defaultImg){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        Glide.with(context).load(imageUrl).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                if (resource instanceof GifDrawable){
                    GifDrawable gifDrawable = (GifDrawable) resource;
                    gifDrawable.setLoopCount(1); //设置播放次数
                    imageView.setImageDrawable(resource);
                    gifDrawable.start();
                }
                return false;
            }
        }).placeholder(defaultImg).error(defaultImg).into(imageView);
    }

    public static void loadAnimImage(Context context, String imageUrl, ImageView imageView, int defaultImg){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        //.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        Glide.with(context).load(imageUrl).placeholder(defaultImg).error(defaultImg).into(imageView);
    }

    public static void loadAnimImage(Context context, String imageUrl, ImageView imageView){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        Glide.with(context).load(imageUrl).into(imageView);
    }

    //加载圆角图片
    public static void loadRoundRectImage(Context context, String imageUrl, ImageView imageView, int radius, int defaultImg){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        Glide.with(context).load(imageUrl).dontAnimate().placeholder(defaultImg).error(defaultImg)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(radius))).into(imageView);

    }

    //加载圆形图片
    public static void loadCircleImage(Context context, String imageUrl, ImageView imageView, int defaultImg){
        if (context == null) return;
        if (StringUtils.isEmpty(imageUrl)) {
            imageUrl = "";
        }
        Glide.with(context)
                .load(imageUrl)
                .dontAnimate()
                .placeholder(defaultImg)
                .error(defaultImg)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }

    public static void loadImageFromPath(Context context, String path, ImageView imageView) {
        if (context != null) {
            Glide.with(context)
                    .load(new File(path))
                    .into(imageView);
        }
    }

    public static void loadImageFromPath(Context context, String path, ImageView imageView, int radius) {
        if (context != null) {
            Glide.with(context)
                    .load(new File(path))
                    .apply(new RequestOptions().transform(new RoundedCorners(radius)))
                    .into(imageView);
        }
    }

    public static void loadImageFromDrawable(Context context, Drawable drawable, ImageView imageView) {
        if (context != null) {
            Glide.with(context)
                    .load(drawable)
                    .into(imageView);
        }
    }

    public static void loadImageFromDrawable(Context context, Drawable drawable, ImageView imageView, int radius) {
        if (context != null) {
            Glide.with(context)
                    .load(drawable)
                    .apply(new RequestOptions().transform(new RoundedCorners(radius)))
                    .into(imageView);
        }
    }

    public static void loadImageFromResId(Context context, int resId, ImageView imageView) {
        if (context != null) {
            Glide.with(context)
                    .load(resId)
                    .into(imageView);
        }
    }

    public static void loadImageFromResId(Context context, int resId, ImageView imageView, int radius) {
        if (context != null) {
            Glide.with(context)
                    .load(resId)
                    .apply(new RequestOptions().transform(new RoundedCorners(radius)))
                    .into(imageView);
        }
    }

    public static void loadImageFromBitmap(Context context, Bitmap bitmap, ImageView imageView) {
        if (context != null) {
            Glide.with(context)
                    .load(bitmap)
                    .into(imageView);
        }
    }

    public static void loadCircleImageFromBitmap(Context context, Bitmap bitmap, ImageView imageView) {
        if (context != null) {
            Glide.with(context)
                    .load(bitmap)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(imageView);
        }
    }
}
