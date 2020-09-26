package com.example.task09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeriesInfo extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView series;
    TextView x1Eq,dEq,nEq,SnEq;
    Intent res;
    int choice;
    double a1,d_m;
    String [] seriesV=new String[20];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_info);

        series=(ListView) findViewById(R.id.series);
        x1Eq=(TextView)findViewById(R.id.x1Eq);
        dEq=(TextView)findViewById(R.id.dEq);
        nEq=(TextView)findViewById(R.id.nEq);
        SnEq=(TextView)findViewById(R.id.SnEq);

        res=getIntent();
        choice=res.getIntExtra("choice",-10);
        a1=res.getDoubleExtra("a1",-99999);
        d_m=res.getDoubleExtra("d_m",-999);

        series.setOnItemClickListener(this);
        series.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, seriesV);
        series.setAdapter(adp);

        FillArray();
        seriesV[0]=String.valueOf(a1);

        x1Eq.setText(String.valueOf(a1));
        dEq.setText(String.valueOf(d_m));


    }

    public void FillArray(){
        if(choice==1){
            for (int i=1;i<20;i++){
                seriesV[i]=String.valueOf(a1*(Math.pow(d_m,i)));
            }
        }
        else if(choice==2){
            for (int i=1;i<20;i++){
                seriesV[i]=String.valueOf(a1+d_m*(i));
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        nEq.setText(String.valueOf(l));
        if(choice==1){
            double sum=Math.pow(d_m,i+1);
            SnEq.setText(String.valueOf((a1*sum-a1)/(d_m-1)));
        }
        else{
            double sum=2*a1+d_m*(i+1)-d_m;
            SnEq.setText(String.valueOf(((i+1)*sum)/2));
        }


    }
}