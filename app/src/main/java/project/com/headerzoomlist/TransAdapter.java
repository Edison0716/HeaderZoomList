package project.com.headerzoomlist;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by ${巴黎没有摩天轮Li} on 2017/7/3.
 */

public class TransAdapter extends BaseQuickAdapter<ItemBean,BaseViewHolder> {
    public TransAdapter(@LayoutRes int layoutResId, @Nullable List<ItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemBean item) {
        helper.setText(R.id.tv_name,item.getName());
    }
}
