package com.zhanh.utilslibrary.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zhanh.utilslibrary.base.GlideApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * 图片加载工具
 */
public class GlideUtil {

    public static void loadImage(Context context, Object url, ImageView imageView){
        GlideApp.with(context.getApplicationContext())
                .load(url)
                .into(imageView);
    }

    /**
     * 圆角
     */
    public static void loadImageRounded(Context context, Object url, ImageView imageView){
        GlideApp.with(context.getApplicationContext())
                .load(url)
                .centerCrop()
                //默认淡入淡出动画
                .transition(DrawableTransitionOptions.withCrossFade())
                //缓存策略,跳过内存缓存【此处应该设置为false，否则列表刷新时会闪一下】
                .skipMemoryCache(false)
                .transform(new RoundedCorners(ScreenUtil.dpToPx(10)))
                .into(imageView);
    }

    /**
     * 圆形
     */
    public static void loadImageCircle(Context context, Object url, ImageView imageView){
        GlideApp.with(context.getApplicationContext())
                .load(url)
                .centerCrop()
                //默认淡入淡出动画
                .transition(DrawableTransitionOptions.withCrossFade())
                //缓存策略,跳过内存缓存【此处应该设置为false，否则列表刷新时会闪一下】
                .skipMemoryCache(false)
                .transform(new CircleCrop())
                .into(imageView);
    }





}
