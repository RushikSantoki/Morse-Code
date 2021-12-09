package com.aswdc_morsecode.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;

import com.aswdc_morsecode.R;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {

    private Button button1, button2, button3,
            buttonDelete;
    ImageView image_dot, image_dash, image_space, image_backspace;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    public MyKeyboard(Context context) {
        this(context, null, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        image_dot = (ImageView) findViewById(R.id.image_dot);
        image_dot.setOnClickListener(this);
        image_dash = (ImageView) findViewById(R.id.image_dash);
        image_dash.setOnClickListener(this);
        image_space = (ImageView) findViewById(R.id.image_space);
        image_space.setOnClickListener(this);
        image_backspace = (ImageView) findViewById(R.id.image_backspace);
        image_backspace.setOnClickListener(this);

        keyValues.put(R.id.image_dot, ".");
        keyValues.put(R.id.image_dash, "-");
        keyValues.put(R.id.image_space, " ");
        keyValues.put(R.id.image_backspace, "4");
    }

    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.image_backspace) {
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }


    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;
    }
}
