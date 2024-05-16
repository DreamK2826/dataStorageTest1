package com.dreamk.datastoragetest1;

import android.content.Context;
import android.content.SharedPreferences;
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
    EditText et1;
    Button btn1,btn2;

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

        //判断是否保存过
        boolean flag1 = sp.getBoolean("isSaved",false);
        if(flag1){
            String str = sp.getString("value1","");
            et1.setText(str);
        }


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
    }
}