package com.dreamk.datastoragetest1;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText et1,et_id,et_username,et_uNumber,et_uColor,et_uMessage,et_permitted,et_value1;
    Button btn1,btn2,btn3,btn5,btn4,clear_all_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp = getSharedPreferences("config1", Context.MODE_PRIVATE);

        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        clear_all_et = findViewById(R.id.clear_all_et);

        et_value1 = findViewById(R.id.et_value1);
        et_permitted = findViewById(R.id.et_permitted);
        et_uMessage = findViewById(R.id.et_uMessage);
        et_uColor = findViewById(R.id.et_uColor);
        et_uNumber = findViewById(R.id.et_uNumber);
        et_username = findViewById(R.id.et_username);
        et_id = findViewById(R.id.et_id);

        //判断是否保存过
        boolean flag1 = sp.getBoolean("isSaved",false);
        if(flag1){
            String str = sp.getString("value1","");
            et1.setText(str);
        }

        clear_all_et.setOnClickListener(v -> {
            et_value1.setText("");
            et_permitted.setText("");
            et_uMessage.setText("");
            et_uColor.setText("");
            et_uNumber.setText("");
            et_username.setText("");
            et_id.setText("");
        });


        btn1.setOnClickListener(v -> {
            String string = et1.getText().toString();

            if(!string.isEmpty()){
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("value1", string);
                editor.putBoolean("isSaved", true);
                editor.apply();
            }

        });

        btn2.setOnClickListener(v -> {

        });
        //创建数据库按键
        btn3.setOnClickListener(v -> {

            SQLiteOpenHelper helper = MySqliteOpenHelper.getmInstance(this);
            SQLiteDatabase writableDatabase = helper.getWritableDatabase();

            writableDatabase.close();
            helper.close();

        });

        btn4.setOnClickListener(v -> {

            //插入数据库按键,不细写了~
            SQLiteOpenHelper helper = MySqliteOpenHelper.getmInstance(this);
            SQLiteDatabase writableDatabase = helper.getWritableDatabase();

            if(writableDatabase.isOpen()){
//                String str_id = et_id.getText().toString();
                String str_username = et_username.getText().toString();
                String str_uNumber = et_uNumber.getText().toString();
//                String str_ = et_id.getText().toString();
//                String str_id = et_id.getText().toString();
//                String str_id = et_id.getText().toString();
//                String str_id = et_id.getText().toString();
                int index0;

//                if(!str_id.isEmpty()){
//                    index0 = Integer.getInteger(str_id);
//                }

//                String sql1 = "insert into myTable1(username,uNumber) values('" + str_username + "','" + str_uNumber + "')";
                String sql1 = "insert into myTable1(username,uNumber,uColor,uMessage,permitted,rvalue1) values('"
                        + "test111111111111111111111111" + "','" + "吉A114514asviklasfhj" + "','"
                        + 100 + "','" + "这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦这里是测试文字哦" + "','" + 10 +  "','" + 222 +"')";
                writableDatabase.execSQL(sql1);

            }

            writableDatabase.close();
            helper.close();
        });

        btn5.setOnClickListener(v -> {
            //读取数据库按键

            SQLiteOpenHelper helper = MySqliteOpenHelper.getmInstance(this);
            SQLiteDatabase db = helper.getReadableDatabase();


            if(db.isOpen()){
                String str_id = et_id.getText().toString();
//                int _idEt;
                int username_index;
                int uNumber_index;
                int uColor_index;
                int uMessage_index;
                int permitted_index;
                int rvalue1_index;
                String username,uNumber,uColor,uMessage2,permitted,rvalue1;

                try {
                    Cursor cursor = db.rawQuery("select * from myTable1 where _id = " + str_id,null);
                    while (cursor.moveToNext()){

                        username_index = cursor.getColumnIndex("username");
                        uNumber_index = cursor.getColumnIndex("uNumber");
                        uColor_index = cursor.getColumnIndex("uColor");
                        uMessage_index = cursor.getColumnIndex(" uMessage ");
                        permitted_index = cursor.getColumnIndex("permitted");
                        rvalue1_index = cursor.getColumnIndex("rvalue1");



                        if(username_index >= 0){
                            username = cursor.getString(username_index);
                        } else {
                            username = "null";
                        }

                        if(uNumber_index >= 0){
                            uNumber = cursor.getString(uNumber_index);
                        } else {
                            uNumber = "null";
                        }
                        if(uColor_index >= 0){
                            uColor = String.valueOf(cursor.getInt(uColor_index));
                        } else {
                            uColor = "null";
                        }
//                        if(uMessage_index >= 0){
                            uMessage2 = cursor.getString(4);
//                        } else {
//                            uMessage2 = "null";
//                        }
                        if(permitted_index >= 0){
                            permitted = String.valueOf(cursor.getInt(permitted_index));
                        } else {
                            permitted = "null";
                        }
                        if(rvalue1_index >= 0){
                            rvalue1 = String.valueOf(cursor.getInt(rvalue1_index));
                        } else {
                            rvalue1 = "null";
                        }



                        clear_all_et.callOnClick();
                        et_username.setText(username);
                        et_uNumber.setText(uNumber);
                        et_uColor.setText(uColor);
                        et_uMessage.setText(uMessage2);
                        et_permitted.setText(permitted);
                        et_value1.setText(rvalue1);


                    }
                    cursor.close();
                } catch (Exception ignored){

                    ToastUtil.show(this,"Error!");
                }

                db.close();
            }



        });



    }
}