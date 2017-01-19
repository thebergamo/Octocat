package com.github.thebergamo.octocat.view;

/**
 * Created by thebergamo on 18/01/17.
 */

public interface LoginView {
    /*
    This view must have an username and password field.
     */

    String getUsername();
    String getPassword();

    void showUsernameIsRequired();
    void showPasswordIsRequired();

    void showUsernameOrPasswordIsIncorrect();

    void showLogged();
}
