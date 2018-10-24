package com.example.android.mvppractice.login;

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

    //view instance to be manipulated
    private LoginFragmentView view;
    private LoginFragmentInteractor interactor;

    public LoginFragmentPresenterImpl(LoginFragmentView view, LoginFragmentInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onLogin(String email, String password) {
        int code = interactor.getDataType(email, password);
        if (code == -1) {
            view.onLoginSuccessful();
        } else {
            view.onLoginError(code);
        }
    }

    @Override
    public void schimbareCuloare() {
        view.schimbaCuloareBtn();
    }

    @Override
    public void devineInvizibil() {
        view.devineInvizibilBtn();
    }
}
