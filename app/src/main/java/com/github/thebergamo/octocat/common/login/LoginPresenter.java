package com.github.thebergamo.octocat.common.login;

/**
 * Created by thebergamo on 19/01/17.
 */

public interface LoginPresenter {
    void login();

    void setView (LoginView view);
}
