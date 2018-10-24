package com.example.android.mvppractice.secondActivity;

public class SecondPresenter implements ISecondPresenter {

    ISecondView view;

    public SecondPresenter(ISecondView view) {
        this.view = view;
    }
}
