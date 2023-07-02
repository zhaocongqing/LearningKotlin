package com.zcq.learning.base;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.IdRes;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zcq.learning.utils.GlideUtils;
import com.zcq.learning.widgets.RTextView;

/**
 * Create by zcq at 2023/7/2 11:29
 */
public class CustomViewHolder extends BaseViewHolder {

    public CustomViewHolder(View view){
        super(view);
    }

    public CustomViewHolder setImageUrl(Context context, @IdRes int viewId, String url){
        ImageView imageView = getView(viewId);
        GlideUtils.loadImageFromUrl(context, url, imageView);
        return this;
    }

    public CustomViewHolder setImageUrl(Context context, @IdRes int viewId, String url, int defaultImg){
        ImageView imageView =getView(viewId);
        GlideUtils.loadImageFromUrl(context, url, imageView, defaultImg);
        return this;
    }

    public CustomViewHolder setAnimImageUrl(Context context, @IdRes int viewId, String url, int defaultImg){
        ImageView imageView =getView(viewId);
        GlideUtils.loadAnimImage(context, url, imageView, defaultImg);
        return this;
    }

    public CustomViewHolder setAnimateImageUrl(Context context, @IdRes int viewId, String url, int defaultImg){
        ImageView imageView =getView(viewId);
        GlideUtils.loadAnimateImage(context, url, imageView, defaultImg);
        return this;
    }

    public CustomViewHolder setImageUrl(Context context, @IdRes int viewId, String url, int radius, int defaultImg){
        ImageView imageView = getView(viewId);
        GlideUtils.loadRoundRectImage(context, url, imageView, radius, defaultImg);
        return this;
    }

    public CustomViewHolder setImageCircle(Context context, @IdRes int viewId, String url, int defaultImg){
        ImageView imageView = getView(viewId);
        GlideUtils.loadCircleImage(context, url, imageView, defaultImg);
        return this;
    }

    public CustomViewHolder setCornerRadius(@IdRes int viewId, float cornerRadius){
        RTextView rTextView = getView(viewId);
        rTextView.setCornerRadius(cornerRadius);
        return this;
    }

    public CustomViewHolder setBackgroundColorNormal(@IdRes int viewId, int colorNormal){
        RTextView rTextView = getView(viewId);
        rTextView.setBackgroundColorNormal(colorNormal);
        return this;
    }

    public CustomViewHolder setBackgroundColorPressed(@IdRes int viewId, int colorPressed){
        RTextView rTextView = getView(viewId);
        rTextView.setBackgroundColorPressed(colorPressed);
        return this;
    }

    public CustomViewHolder setBackgroundColorUnable(@IdRes int viewId, int colorUnable){
        RTextView rTextView = getView(viewId);
        rTextView.setBackgroundColorUnable(colorUnable);
        return this;
    }

    public CustomViewHolder setBorderColorNormal(@IdRes int viewId, int colorNormal){
        RTextView rTextView = getView(viewId);
        rTextView.setBorderColorNormal(colorNormal);
        return this;
    }

    public CustomViewHolder setBorderColorPressed(@IdRes int viewId, int colorPressed){
        RTextView rTextView = getView(viewId);
        rTextView.setBorderColorPressed(colorPressed);
        return this;
    }

    public CustomViewHolder setBorderColorUnable(@IdRes int viewId, int colorUnable){
        RTextView rTextView = getView(viewId);
        rTextView.setBorderColorUnable(colorUnable);
        return this;
    }

    public CustomViewHolder setBorderWidthNormal(@IdRes int viewId, int width){
        RTextView rTextView = getView(viewId);
        rTextView.setBorderWidthNormal(width);
        return this;
    }

    public CustomViewHolder setBorderWidthPressed(@IdRes int viewId, int width){
        RTextView rTextView = getView(viewId);
        rTextView.setBorderWidthPressed(width);
        return this;
    }

    public CustomViewHolder setBorderWidthUnable(@IdRes int viewId, int width){
        RTextView rTextView = getView(viewId);
        rTextView.setBorderWidthUnable(width);
        return this;
    }

    public CustomViewHolder setTextColorNormal(@IdRes int viewId, int colorNormal){
        RTextView rTextView = getView(viewId);
        rTextView.setTextColorNormal(colorNormal);
        return this;
    }

    public CustomViewHolder setTextColorUnable(@IdRes int viewId, int colorUnable){
        RTextView rTextView = getView(viewId);
        rTextView.setTextColorNormal(colorUnable);
        return this;
    }

    public CustomViewHolder setPressedTextColor(@IdRes int viewId, int colorPressed){
        RTextView rTextView = getView(viewId);
        rTextView.setTextColorNormal(colorPressed);
        return this;
    }

    public CustomViewHolder setOnCheckBoxChangedListener(@IdRes int viewId, CompoundButton.OnCheckedChangeListener listener){
        CheckBox checkBox = getView(viewId);
        checkBox.setOnCheckedChangeListener(listener);
        return this;
    }

    public CustomViewHolder setMax(@IdRes int viewId, int pro){
        ProgressBar progress = getView(viewId);
        progress.setMax(pro);
        return this;
    }

    public CustomViewHolder setProgress(@IdRes int viewId, int pro){
        ProgressBar progress = getView(viewId);
        progress.setMax(pro);
        return this;
    }
}
