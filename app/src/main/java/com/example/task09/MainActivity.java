package com.example.task09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ToggleButton kind;
    EditText first,dif_mult;
    double a1,d_m;
    int choice;
    String con;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kind=(ToggleButton) findViewById(R.id.kind);
        first=(EditText)findViewById(R.id.first);
        dif_mult=(EditText)findViewById(R.id.dif_mult);


    }



    public void SubInitiate(View view) {
        con=first.getText().toString();
        if(con.equals("")){
            Toast.makeText(this,"have to enter initiate",Toast.LENGTH_SHORT).show();
        }
        else{
            a1=Double.parseDouble(con);
        }
    }

    public void SubDifMult(View view) {
        con=dif_mult.getText().toString();
        if(con.equals("")){
            Toast.makeText(this,"have to enter initiate",Toast.LENGTH_SHORT).show();
        }
        else{
            d_m=Double.parseDouble(con);
        }
    }

    public void Result(View view) {
        if(dif_mult.getText().toString().equals("")||first.getText().toString().equals("")){
            Toast.makeText(this,"nothing submitted",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent res=new Intent(this,SeriesInfo.class);
            res.putExtra("choice",choice);
            res.putExtra("a1",a1);
            res.putExtra("d_m",d_m);
            startActivity(res);
        }
    }

    public void Register(View view) {
        if(kind.isChecked()){
            choice=1;
        }
        else{
            choice=2;
        }
    }
}