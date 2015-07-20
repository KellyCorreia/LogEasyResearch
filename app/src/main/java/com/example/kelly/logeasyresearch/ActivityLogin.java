package com.example.kelly.logeasyresearch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLogin extends Activity {

    private AutoCompleteTextView mEmailView;
    private View mProgressView;
    private View mLoginFormView;
    private boolean passwordIsValid = false;
    private ClassUser user;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Getting the object user from the previous screen
        Bundle extras = getIntent().getExtras();
        user = (ClassUser) extras.getParcelable("chosenUser");

        //Setting the Label with the userName
        TextView txtViewUser = (TextView) findViewById(R.id.lblUsername);
        txtViewUser.setText(user.getUsername());

        //Setting image avatar
        ImageView imageAvatar = (ImageView) findViewById(R.id.imvUserGuide);
        if(user.getAvatar().equals("Avatar1")){
            imageAvatar.setImageResource(R.drawable.avatar1);
        }else if(user.getAvatar().equals("Avatar2")) {
            imageAvatar.setImageResource(R.drawable.avatar2);
        }else if (user.getAvatar().equals("Avatar3")){
            imageAvatar.setImageResource(R.drawable.avatar3);
        }else if (user.getAvatar().equals("Avatar4")){
            imageAvatar.setImageResource(R.drawable.avatar4);
        }

        ImageButton mEmailSignInButton = (ImageButton) findViewById(R.id.btnLogin);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mPasswordView;
                mPasswordView = (EditText) findViewById(R.id.txtPassword);
                //code to test the password
                password = mPasswordView.getText().toString();
                if(password.equals(user.getPass())){
                    passwordIsValid = true;
                    Intent intent = new Intent(ActivityLogin.this, ActivityLevels.class);
                    intent.putExtra("chosenUser", user);
                    intent.putExtra("toast", 1);
                    startActivity(intent);
                    finish();
                }else{
                    mPasswordView.setError(getString(R.string.error_invalid_password));
                }
            }
        });
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}

