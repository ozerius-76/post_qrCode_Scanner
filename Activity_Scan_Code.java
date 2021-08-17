package com.example.postqrcode_app_17_08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Activity_Scan_Code extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private int MY_PERMISSION_REQUEST_CAMERA = 1;
    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
    }

    @Override
    public void handleResult(Result result) {
        MainActivity.textView_QrCode_Result.setText(result.getText());
        MainActivity.editText_Save_Mail.setText("scanned: \n" + result.getText());
        onBackPressed();
    }

    @Override
    protected void onPause(){
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    protected void onPostResume(){
        super.onPostResume();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSION_REQUEST_CAMERA);
        }
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
}