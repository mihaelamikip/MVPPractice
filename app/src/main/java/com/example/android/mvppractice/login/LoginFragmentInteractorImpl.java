package com.example.android.mvppractice.login;

import android.text.TextUtils;
import android.util.Patterns;

public class LoginFragmentInteractorImpl implements LoginFragmentInteractor {

    @Override
    public int getDataType(String email, String password) {
        if (TextUtils.isEmpty(email))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1;
        else if (password.length() <= 6)
            return 2;
        else
            return -1;
    }
}
