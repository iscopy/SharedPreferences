package com.win.sharedprefences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name, pswd, sex, age;
    private Button submit;//提交保存


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        pswd = (EditText) findViewById(R.id.pswd);
        sex = (EditText) findViewById(R.id.sex);
        age = (EditText) findViewById(R.id.age);

        submit = (Button) findViewById(R.id.submit);


        //点击事件（获取数据，存入SharedPreferences）
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入框的内容
                String names = name.getText().toString();
                String pswds = pswd.getText().toString();
                String sexs = sex.getText().toString();
                String ages = age.getText().toString();

                //在 MySharedPreferences类里定义好存取方法后，就可以调用了
                //这里将数据保存进去  注意：(name 我是定义了有返回值的，试试看)
                Boolean bool = MySharedPreferences.setName(names, MainActivity.this);
                MySharedPreferences.setPswd(pswds, MainActivity.this);
                MySharedPreferences.setSex(sexs,   MainActivity.this);
                MySharedPreferences.setAge(ages,   MainActivity.this);

                //看看保存成功没
                if(bool)
                    Toast.makeText(MainActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "保存失败！", Toast.LENGTH_SHORT).show();

                //跳转到展示界面
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });



    }
}
