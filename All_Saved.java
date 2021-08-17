package com.example.postqrcode_app_17_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class All_Saved extends AppCompatActivity {

    private Button button_Mail_List;
    private Button button_Clear_List;
    private Button button_Back;
    private ListView listView_Saved_Scanned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__saved);

        button_Mail_List = (Button) findViewById(R.id.mail_List_Button);
        button_Clear_List = (Button) findViewById(R.id.clear_List_Button);
        button_Back = (Button) findViewById(R.id.back_Button);
        listView_Saved_Scanned = (ListView) findViewById(R.id.savedScanned_ListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, MainActivity.data);

        listView_Saved_Scanned.setAdapter(arrayAdapter);

        button_Clear_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.data.size() > 0){
                    MainActivity.data.clear();
                    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(All_Saved.this,
                            android.R.layout.simple_list_item_1, MainActivity.data);

                    listView_Saved_Scanned.setAdapter(stringArrayAdapter);
                }else {
                    Toast.makeText(All_Saved.this, "nothing to clear", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Mail_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String entry : MainActivity.data){
                    stringBuffer.append(entry + "\n");
                }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, "ozerius@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, stringBuffer.toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "choose you mail"));
            }
        });

        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}