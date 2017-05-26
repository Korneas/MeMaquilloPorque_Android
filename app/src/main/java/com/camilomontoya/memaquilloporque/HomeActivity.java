package com.camilomontoya.memaquilloporque;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.camilomontoya.memaquilloporque.other.Cliente;

import org.w3c.dom.Text;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    private EditText name;
    private TextView content;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = (EditText) findViewById(R.id.name_home);
        content = (TextView) findViewById(R.id.content_home);

        start = (Button) findViewById(R.id.start_home);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Montserrat-Regular.ttf");

        name.setTypeface(type);
        content.setTypeface(type);
        start.setTypeface(type);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Cliente.getInstance().enviar(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
