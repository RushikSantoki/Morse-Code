package com.aswdc_morsecode.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.aswdc_morsecode.R;
import com.aswdc_morsecode.util.Constant;

import static android.content.Context.MODE_PRIVATE;

public class PopMenu extends AppCompatActivity {

    SwitchCompat sound,vibrate,flash;
    public BaseActivity b;
    public static final String SHARED_PREFS = "sharedPrefs";

    private Button saveButton;
    private String text;
    private boolean switchOnOff;
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";
    public static final String SWITCH2 = "switch2";
    public static final String SWITCH3 = "switch3";

//    public PopMenu(BaseActivity c) {
//        super(c);
//        this.b=c;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_menu);

        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

        sound=findViewById(R.id.sound);
        vibrate=findViewById(R.id.vibrate);
        flash=findViewById(R.id.flashlight);

sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(SWITCH1, isChecked).apply();
    }
});

                saveData();


    }

    public void saveData() {
        boolean isSwitchOn = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE).getBoolean(SWITCH1,false);
        sound.setChecked(isSwitchOn);

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }


}
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//    }
