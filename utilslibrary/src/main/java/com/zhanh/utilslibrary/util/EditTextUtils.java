package com.zhanh.utilslibrary.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

/**
 * 登录 注册等页面，监听EditText都有内容，Button 才能被点击等功能
 */
public class EditTextUtils {
    private Button button;
    private EditText[] editTexts;
    private IEditTextChangeListener mChangeListener;

    public EditTextUtils(){
    }
    public EditTextUtils(Button button){
        this.button = button;
    }

    /**
     * 检测输入框是否都输入了内容
     * 从而改变按钮的是否可点击
     * 以及输入框后面的X的可见性，X点击删除输入框的内容
     */
    public void addAllEditText(EditText...editTexts){
        this.editTexts = editTexts;
        initEditListener();
    }

    private void initEditListener() {
        for (EditText editText:editTexts){
            editText.addTextChangedListener(new textChange());
        }
    }

    /**
     * edit输入的变化来改变按钮的是否点击
     */
    private class textChange implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (checkAllEdit()){
                mChangeListener.textChange(true);
                if (button != null){
                    button.setEnabled(true);
                }
            }else {
                mChangeListener.textChange(false);
                if (button != null){
                    button.setEnabled(false);
                }
            }
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    }

    /**
     * 检查所有的edit是否输入了数据
     */
    private boolean checkAllEdit() {
        for (EditText editText:editTexts){
            if (TextUtils.isEmpty(editText.getText().toString().trim())){
                return false;
            }
        }
        return true;
    }

    public interface IEditTextChangeListener{
        void textChange(boolean isAllHaveText);
    }

    public void setChangeListener(IEditTextChangeListener changeListener) {
        mChangeListener = changeListener;
    }
}
