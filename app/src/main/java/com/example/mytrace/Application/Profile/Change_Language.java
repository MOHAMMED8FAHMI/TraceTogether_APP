package com.example.mytrace.Application.Profile;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.R;

import java.util.Locale;


public class Change_Language extends AppCompatActivity {

    TextView tvSelect, tvOutput, tv_changelan;
    RadioGroup rgLanguage;
    RadioButton rbEnglish, rbMalay;


    String[] item ={"M","Design","Component" ,"5.0 Lollipop"};


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pp_change_language);


        //Assign variable
        tvSelect = findViewById(R.id.tvselect);
        rgLanguage = findViewById(R.id.rg_language);
        rbEnglish = findViewById(R.id.rb_english);
        rbMalay = findViewById(R.id.rb_malay);
        tvOutput = findViewById(R.id.tv_output);
        tv_changelan = findViewById(R.id.tv_change_lan);

        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_english:
                        String language = "en";
                        setLocate(language);
                        break;

                    case R.id.rb_malay:
                        setLocate("ms");
                        break;
                }
            }
        });
    }

    private void setLocate(String language) {
        Resources resources = getResources();

        DisplayMetrics metrics = resources.getDisplayMetrics();

        Configuration config = resources.getConfiguration();

        config.locale = new Locale(language);

        resources.updateConfiguration(config, metrics);

         onConfigurationChanged(config);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        tvSelect.setText(R.string.Select_Language);
        rbEnglish.setText(R.string.english_language);
        rbMalay.setText(R.string.malay_language);
        tvOutput.setText(R.string.to_english);
        tv_changelan.setText(R.string.titlePage);

    }
}


}}

