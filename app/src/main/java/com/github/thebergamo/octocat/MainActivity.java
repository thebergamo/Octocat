package com.github.thebergamo.octocat;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.thebergamo.octocat.R;
import com.github.thebergamo.octocat.common.login.LoginPresenter;
import com.github.thebergamo.octocat.common.login.LoginPresenterImpl;
import com.github.thebergamo.octocat.common.login.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    protected EditText userEmail;
    protected EditText userPassword;
    protected Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPresenter = new LoginPresenterImpl();

        loginPresenter.setView(this);

        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });
    }

    @Override
    public String getUsername() {
        return userEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return userPassword.getText().toString();
    }

    @Override
    public void showUsernameIsRequired() {
        Snackbar.make(findViewById(R.id.activity_main), R.string.username_is_required, Snackbar.LENGTH_SHORT)
                .show();
        
    }

    @Override
    public void showPasswordIsRequired() {
        Snackbar
                .make(findViewById(R.id.activity_main), R.string.password_is_required, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showUsernameOrPasswordIsIncorrect() {
        Snackbar
                .make(findViewById(R.id.activity_main), R.string.credentials_invalid, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showLogged() {
        Snackbar
                .make(findViewById(R.id.activity_main), R.string.logged, Snackbar.LENGTH_SHORT)
                .show();
    }
}
