package com.win.sharedprefences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button obtain;//获取数据
    private TextView one, two, three, four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        obtain = (Button) findViewById(R.id.obtain);

        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);
        three = (TextView) findViewById(R.id.three);
        four = (TextView) findViewById(R.id.four);

        //获取保存好的数据并展示出来
        obtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过MySharedPreferences类里定义好的存取方法，获取保存在里面的数据
                String names = (String) MySharedPreferences.getName(Main2Activity.this);
                String pswds = (String) MySharedPreferences.getPswd(Main2Activity.this);
                String sexs =  (String)  MySharedPreferences.getSex(Main2Activity.this);
                String ages =  (String)  MySharedPreferences.getAge(Main2Activity.this);

                //将数据放到 TextView 展示出来
                one.setText("账号：" + names);
                two.setText("密码：" + pswds);
                three.setText("性别：" + sexs);
                four.setText("年龄：" + ages);
            }
        });
    }
}
