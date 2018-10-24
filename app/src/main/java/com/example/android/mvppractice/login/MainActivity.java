package com.example.android.mvppractice.login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mvppractice.R;
import com.example.android.mvppractice.secondActivity.SecondActivity;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginFragmentView, View.OnClickListener{

    private static final String TAG = "MainActivity";
    private EditText etUser;
    private EditText etPassword;
    private Button btnSignIn;
    private LoginFragmentPresenter mainPresenter;
    private Button btnCuloare;
    private Button btnInviz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        initViews();
        btnSignIn.setOnClickListener(this);
        btnCuloare.setOnClickListener(this);
        btnInviz.setOnClickListener(this);
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_login, LoginFragment.newInstance()).commit();


    }

    private void initViews() {
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPass);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnCuloare = findViewById(R.id.btnCuloare);
        btnInviz = findViewById(R.id.btnInvizibil);

        mainPresenter = new LoginFragmentPresenterImpl(this, new LoginFragmentInteractorImpl());
    }

    @Override
    public void onLoginSuccessful() {
        Toasty.success(getApplicationContext(), "succes", Toast.LENGTH_SHORT).show();
        sendEmailToActivity(etUser.getText().toString());
    }

    @Override
    public void onLoginError(int errorCode) {
        String message;
        switch (errorCode){
            case 0:
                message = getResources().getString(R.string.valid_email);
                break;
            case 1:
                message = getResources().getString(R.string.valid_email);
                break;
            case 2:
                message = getResources().getString(R.string.valid_email);
                break;
            default:
                message = "bla";
                break;

        }
        Toasty.error(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendEmailToActivity(String email) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void schimbaCuloareBtn() {
        btnCuloare.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void devineInvizibilBtn() {
        btnInviz.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                Log.i(TAG, "onClick:  email=" + etUser.getText().toString()
                        + " password=" + etPassword.getText().toString());
                mainPresenter.onLogin(etUser.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.btnCuloare:
                mainPresenter.schimbareCuloare();
                break;
            case R.id.btnInvizibil:
                mainPresenter.devineInvizibil();
                break;
            default:
                break;
        }
    }
}
