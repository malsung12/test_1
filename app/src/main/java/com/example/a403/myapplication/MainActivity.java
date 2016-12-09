package com.example.a403.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a403.myapplication.R.id.imageView9;
import static com.example.a403.myapplication.R.id.switch2;

public class MainActivity extends AppCompatActivity {
    TextView  textView22;
    Switch  switch2;
    Chronometer chronometer4;
    LinearLayout lay1;
    Button button7,button8,button9;
    RadioGroup rg;
    RadioButton radioButton16, radioButton17, radioButton18;
    ImageView imageView9;
    EditText editText17, editText18, editText19;
    TextView textView34, textView35, textView36;
    FrameLayout frame;
    int sum, num1, num2, num3, pay;
    double dis1=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("놀이동산 예약시스템");

        frame = (FrameLayout) findViewById(R.id.frame);
        editText17 = (EditText) findViewById(R.id.editText17);
        editText18 = (EditText) findViewById(R.id.editText18);
        editText19 = (EditText) findViewById(R.id.editText19);
        textView22 = (TextView) findViewById(R.id.textView22);
        switch2 = (Switch) findViewById(R.id.switch2);
        chronometer4 = (Chronometer) findViewById(R.id.chronometer4);
        lay1 = (LinearLayout) findViewById(R.id.lay1);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        rg = (RadioGroup) findViewById(R.id.rg);
        radioButton16 = (RadioButton) findViewById(R.id.radioButton16);
        radioButton17 = (RadioButton) findViewById(R.id.radioButton17);
        radioButton18 = (RadioButton) findViewById(R.id.radioButton18);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        textView34 = (TextView) findViewById(R.id.textView34);
        textView35 = (TextView) findViewById(R.id.textView35);
        textView35 = (TextView) findViewById(R.id.textView35);

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    chronometer4.setBase(SystemClock.elapsedRealtime());
                    chronometer4.start();
                    chronometer4.setTextColor(Color.BLUE);
                    frame.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.VISIBLE);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton16){
                    frame.setVisibility(View.VISIBLE);
                    imageView9.setVisibility(View.VISIBLE);
                    imageView9.setImageResource(R.drawable.aaa);
                    dis1 = 0.05;
                }
                else if(checkedId == R.id.radioButton17){
                    imageView9.setVisibility(View.VISIBLE);
                    imageView9.setImageResource(R.drawable.asd);
                    dis1 = 0.1;
                }
                else if(checkedId == R.id.radioButton18);
                imageView9.setVisibility(View.VISIBLE);
                imageView9.setImageResource(R.drawable.bbb);
                dis1 = 0.2;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText17 == null && editText18 == null && editText19 == null){
                    Toast.makeText(getApplicationContext(),"인원이 부족합니다", Toast.LENGTH_SHORT).show();
                }
                num1 = Integer.parseInt(editText17.getText().toString());
                num2 = Integer.parseInt(editText18.getText().toString());
                num3 = Integer.parseInt(editText19.getText().toString());

                sum = num1 + num2 + num3;
                pay = num1*15000+num2*12000+num3*8000;
                dis1 = sum * dis1;

                textView34.setText("총 명수: " +sum+dis1); ;
                textView35.setText("할인금액: " +dis1);
                textView36.setText("결제금액: " +pay);
            }
        });

    }
}
