package com.github.thebergamo.octocat.presentation;

import com.github.thebergamo.octocat.view.LoginView;

/**
 * Created by thebergamo on 19/01/17.
 */

public interface LoginPresenter {
    void login();

    void setView (LoginView view);
}
