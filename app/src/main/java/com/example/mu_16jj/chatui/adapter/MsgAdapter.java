package com.example.mu_16jj.chatui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mu_16jj.chatui.R;
import com.example.mu_16jj.chatui.bean.MsgBean;
import com.example.mu_16jj.chatui.constant.Constant;

import java.util.List;

/**
 * Description：RecyclerView适配器
 * <p>
 * WeChat：mu-16jj
 * <p>
 * Created by mu-16jj on 2017/3/25.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MyViewHolder> {

    private Context mcontext;
    private List<MsgBean> list;

    public MsgAdapter(Context mcontext, List<MsgBean> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (list.get(position).getMsgType() == Constant.MSG_RECEIVED) {
            // 接收到的消息
            holder.llRight.setVisibility(View.GONE);
            holder.llLeft.setVisibility(View.VISIBLE);
            holder.tvLeftMsg.setText(list.get(position).getContent());
        } else {
            holder.llLeft.setVisibility(View.GONE);
            holder.llRight.setVisibility(View.VISIBLE);
            holder.tvRightMsg.setText(list.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llLeft;
        LinearLayout llRight;
        TextView tvLeftMsg, tvRightMsg;

        public MyViewHolder(View itemView) {
            super(itemView);
            llLeft = (LinearLayout) itemView.findViewById(R.id.ll_left);
            llRight = (LinearLayout) itemView.findViewById(R.id.ll_right);
            tvLeftMsg = (TextView) itemView.findViewById(R.id.tv_left_msg);
            tvRightMsg = (TextView) itemView.findViewById(R.id.tv_right_msg);
        }
    }

}
