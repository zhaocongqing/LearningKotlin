package com.zcq.learning.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zcq.learning.R;
import com.zcq.learning.base.CustomViewHolder;
import com.zcq.learning.entity.MineLabelInfo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Create by zcq at 2023/7/2 16:08
 */
public class MineLabelAdapter extends BaseQuickAdapter<MineLabelInfo, CustomViewHolder> {

    public MineLabelAdapter(@Nullable List<MineLabelInfo> data) {
        super(R.layout.item_mine_label, data);
    }

    @Override
    protected void convert(@NotNull CustomViewHolder holder, MineLabelInfo info) {
        holder.setImageResource(R.id.icon, info.getIconInt())
                .setText(R.id.tvLabel, info.getLabelName());
    }
}
