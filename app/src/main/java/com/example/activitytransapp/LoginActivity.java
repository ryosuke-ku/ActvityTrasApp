package com.example.activitytransapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // the key constant
    public static final String EXTRA_MESSAGE
//            = "com.example.testactivitytrasdata.MESSAGE";
            = "YourPackageName.MESSAGE";

    private TextView textView;
    static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editText_name = findViewById(R.id.username);
        final EditText editText_code = findViewById(R.id.usercode);

        Button button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), LoginCompleteActivity.class);
                if(editText_name.getText() != null){
                    String name = editText_name.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, name);
                }else if(editText_code.getText() != null){
                    String code = editText_code.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, code);
                }
                startActivityForResult( intent, RESULT_SUBACTIVITY );

                // in order to clear the edittext
                editText_name.setText("");
            }
        });
    }

    // SubActivity からの返しの結果を受け取る
    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY &&
                null != intent) {
            String res = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
            System.out.println(res);
            textView.setText(res);
        }
    }
}
