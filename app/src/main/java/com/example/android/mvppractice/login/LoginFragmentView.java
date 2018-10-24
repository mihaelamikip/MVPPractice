package com.example.android.mvppractice.login;

public interface LoginFragmentView {
    void onLoginSuccessful();
    void onLoginError(int errorCode);
    void sendEmailToActivity(String email);
    void schimbaCuloareBtn();
    void devineInvizibilBtn();
}
