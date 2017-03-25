package com.example.mu_16jj.chatui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.mu_16jj.chatui.adapter.MsgAdapter;
import com.example.mu_16jj.chatui.bean.MsgBean;
import com.example.mu_16jj.chatui.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mu_16jj.chatui.constant.Constant.MSG_RECEIVED;

/**
 * Description：使用RecyclerView编写聊天界面
 * <p>
 * WeChat：mu-16jj
 * <p>
 * Created by mu-16jj on 2017/3/25.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.btn_send)
    Button btnSend;
    private List<MsgBean> list = new ArrayList<>();

    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDatas();

        initView();

    }

    private void initView() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);

        msgAdapter = new MsgAdapter(MainActivity.this, list);
        recycler.setAdapter(msgAdapter);
    }

    private void initDatas() {
        MsgBean msg = new MsgBean("Hollow World!", MSG_RECEIVED);
        list.add(msg);
        MsgBean msg1 = new MsgBean("Android Developer!", MSG_RECEIVED);
        list.add(msg1);
        MsgBean msg2 = new MsgBean("2017-03-25!", MSG_RECEIVED);
        list.add(msg2);
    }

    @OnClick(R.id.btn_send)
    public void onViewClicked() {
        Log.e("55555555", "onViewClicked: ");
        String inputContent = etInput.getText().toString();
        if (!TextUtils.isEmpty(inputContent)) {
            MsgBean msgBean = new MsgBean(inputContent, Constant.MSG_SEND);
            list.add(msgBean);
            // 每发一条自动回复一条
            MsgBean msg = new MsgBean(inputContent + "回复", Constant.MSG_RECEIVED);
            list.add(msg);
            // 有消息时,刷新RecyclerView中的显示
            msgAdapter.notifyItemInserted(list.size() - 1);
            // 将RecyclerView定位到最后一个位置
            recycler.scrollToPosition(list.size() - 1);
            etInput.setText("");
        }
    }

}
