package com.example.postqrcode_app_17_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> data = new ArrayList<>();
    public static TextView textView_QrCode_Result;
    private Button button_Scan_QrCode;
    private Button button_Save_Scanned;
    private Button button_Show_All;
    public static EditText editText_Save_Mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_QrCode_Result = (TextView) findViewById(R.id.qrCode_TextView);
        button_Scan_QrCode = (Button) findViewById(R.id.scan_Button);
        button_Save_Scanned = (Button) findViewById(R.id.saveScan_Button);
        button_Show_All = (Button) findViewById(R.id.showAll_Button);
        editText_Save_Mail = (EditText) findViewById(R.id.saveMail_EditText);

        button_Scan_QrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Scan_Code.class);
                startActivity(intent);
            }
        });

        button_Show_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), All_Saved.class);
                startActivity(intent);
            }
        });

        button_Save_Scanned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qrCodeText = textView_QrCode_Result.getText().toString();
                data.add(qrCodeText);
            }
        });

    }
}