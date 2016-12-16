package com.mingwei.aptdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mingwe.myanno.BindView;
import com.mingwei.myapi.Injector;
import com.mingwei.myapi.ViewInjector;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    public TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInjector.inject(this);
        mText.setText("newqqqqqqqqq");
    }
}
