package com.github.thebergamo.octocat.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.thebergamo.octocat.R;
import com.github.thebergamo.octocat.presentation.LoginPresenter;
import com.github.thebergamo.octocat.presentation.LoginPresenterImpl;
import com.github.thebergamo.octocat.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    protected EditText userEmail;
    protected EditText userPassword;
    protected Button btnLogin;

    private LoginPresenterImpl loginPresenter;

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
         Toast
            .makeText(getApplicationContext(), R.string.username_is_required, Toast.LENGTH_SHORT)
            .show();
    }

    @Override
    public void showPasswordIsRequired() {
        Toast
            .makeText(getApplicationContext(), R.string.password_is_required, Toast.LENGTH_SHORT)
            .show();
    }

    @Override
    public void showUsernameOrPasswordIsIncorrect() {
        Toast
            .makeText(getApplicationContext(), R.string.credentials_invalid, Toast.LENGTH_SHORT)
            .show();
    }

    @Override
    public void showLogged() {
        Toast
            .makeText(getApplicationContext(), R.string.logged, Toast.LENGTH_SHORT)
            .show();
    }
}
