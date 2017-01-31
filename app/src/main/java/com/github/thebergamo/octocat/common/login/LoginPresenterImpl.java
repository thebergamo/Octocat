package com.github.thebergamo.octocat.common.login;

/**
 * Created by thebergamo on 19/01/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView view;

    @Override
    public void login() {
        if (view.getUsername().trim().equals("")) {
            view.showUsernameIsRequired();
        } else if (view.getPassword().trim().equals("")) {
            view.showPasswordIsRequired();
        } else {
            if (view.getUsername().trim().equals("mark") &&
                view.getPassword().trim().equals("bergamo")) {
                view.showLogged();
            } else {
                view.showUsernameOrPasswordIsIncorrect();
            }
        }
    }

    @Override
    public void setView(LoginView view) {
        this.view = view;
    }
}
