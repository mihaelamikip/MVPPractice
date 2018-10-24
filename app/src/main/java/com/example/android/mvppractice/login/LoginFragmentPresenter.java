package com.example.android.mvppractice.login;

public interface LoginFragmentPresenter {
    void onLogin(String email, String password);

    void schimbareCuloare();
    void devineInvizibil();
}
