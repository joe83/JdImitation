package com.young.jdmall.ui.adaper;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.young.jdmall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 25505 on 2017/7/31.
 */

public class FlashRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_LAST = 1;
    private Activity mActivity;

    public FlashRvAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        // TODO: 2017/7/31
        //最后一个的布局
        if (position == 19) {
            return TYPE_LAST;
        } else {
            return TYPE_NORMAL;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL) {
            View goodsView = LayoutInflater.from(mActivity).inflate(R.layout.item_goods, parent, false);
            return new GoodsViewHolder(goodsView);
        } else {
            View lastView = LayoutInflater.from(mActivity).inflate(R.layout.item_goods_last, parent, false);
            return new LastViewHolder(lastView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position != 19) {  //判断为最后一个条目
            ((GoodsViewHolder) holder).bindView();
        } else {
            ((LastViewHolder) holder).bindView();
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class GoodsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.flash_container)
        LinearLayout mFlashContainer;
        @BindView(R.id.tv_old_price)
        TextView mTvOldPrice;

        GoodsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindView() {
            mTvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }

    class LastViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_last)
        TextView mTvLast;

        LastViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindView() {

        }
    }
}
