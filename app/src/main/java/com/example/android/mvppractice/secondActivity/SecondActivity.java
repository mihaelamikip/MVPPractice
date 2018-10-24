package com.example.android.mvppractice.secondActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.mvppractice.R;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity implements ISecondView {

    private static final String TAG = "SecondActivity";
    private ISecondPresenter secondPresenter;
    private TextView tvHelloUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondPresenter = new SecondPresenter(this);
        tvHelloUser = findViewById(R.id.tvHelloUser);

        sayHelloUser();
    }


    @Override
    public void sayHelloUser() {
        String emailPrimit = Objects.requireNonNull(getIntent().getExtras()).getString("email");
        Log.i(TAG, "sayHelloUser: emailPrimit = " + emailPrimit);
        tvHelloUser.setText(String.format("Hello %s!", emailPrimit));
    }
}
