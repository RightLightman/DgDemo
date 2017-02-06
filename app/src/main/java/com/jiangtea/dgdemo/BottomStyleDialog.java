
package com.jiangtea.dgdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class BottomStyleDialog extends Dialog implements OnItemClickListener {
    private String[] mNames = new String[] {
            "我是条目1", "我是条目2", "我是条目3", "我是条目4", "我是条目5","我是条目6","我是条目7"
    };

    private ListView mLv;

    private ArrayList<StyleItem> mList = new ArrayList<StyleItem>();

    private StyleAdapter mAdapter;

    public BottomStyleDialog(Context context) {
        // 在构造方法里, 传入主题
        super(context, R.style.BottomDialogStyle);
        // 拿到Dialog的Window, 修改Window的属性
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 获取Window的LayoutParams
        LayoutParams attributes = window.getAttributes();
        attributes.width = LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        // 一定要重新设置, 才能生效
        window.setAttributes(attributes);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dialog);
        initView();
        initData();
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv_view_dialog);
        mLv.setOnItemClickListener(this);
    }

    private void initData() {
        // 填充数据集合
        for (int i = 0; i < mNames.length; i++) {
            StyleItem styleItem = new StyleItem();
            styleItem.mName = mNames[i];
            mList.add(styleItem);
        }
        mAdapter = new StyleAdapter(getContext(), mList);
        mLv.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mAdapter.notifyDataSetChanged();
    }

}
