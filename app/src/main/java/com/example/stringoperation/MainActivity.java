package com.example.stringoperation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView inp_str, out_str;
    RadioButton uppercase, lowercase, right, left;
    Button click;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
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

        inp_str = findViewById(R.id.editText);
        out_str = findViewById(R.id.OutputText);
        uppercase = findViewById(R.id.uppercase);
        lowercase = findViewById(R.id.lowercase);
        right = findViewById(R.id.right5char);
        left = findViewById(R.id.left5char);
        click = findViewById(R.id.btn_click);

        click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(inp_str.getText().toString().isEmpty())
            Toast.makeText(this,"String Enter kar na bro",Toast.LENGTH_LONG).show();

        if(!inp_str.getText().toString().isEmpty() && uppercase.isChecked())
            out_str.setText(inp_str.getText().toString().toUpperCase());
        else if(!inp_str.getText().toString().isEmpty() && lowercase.isChecked())
            out_str.setText(inp_str.getText().toString().toLowerCase());
        else if(!inp_str.getText().toString().isEmpty() && right.isChecked())
            out_str.setText(inp_str.getText().toString().substring(0,5));
        else if(!inp_str.getText().toString().isEmpty() && left.isChecked())
            out_str.setText(inp_str.getText().toString().substring(inp_str.length()>5?inp_str.length()-5:inp_str.length()));
    }
}