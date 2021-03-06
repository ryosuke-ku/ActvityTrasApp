package com.example.activitytransapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SubActivity extends AppCompatActivity {

    private EditText editText;
    private String user_name;
    private String user_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // to get message from MainActivity
        Intent intent = getIntent();
        user_name = intent.getStringExtra("userName");
        user_code = intent.getStringExtra("userCode");


        System.out.println("User Name: " + user_name + "User Code: " + user_code);

        TextView textView = findViewById(R.id.text_view);
        textView.setText(user_name);

        editText = findViewById(R.id.edit_text);

        // back to MainActivity
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                if (editText.getText() != null) {
                    String str = user_name + editText.getText().toString();
                    intent.putExtra(MainActivity.EXTRA_MESSAGE, str);
                }

                editText.setText("");

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}
