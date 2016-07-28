package com.example.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.a_main_frame, new LoginFragment())
                .commit();
    }

    public static class WelcomeFragment extends Fragment {

        private TextView mWelcomeTextView;

        public WelcomeFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_welcome,
                    container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            mWelcomeTextView = (TextView) view.findViewById(R.id.f_welcome_txt);
            mWelcomeTextView.setText("Welcome " + mName + "!");
        }
    }

    public static class LoginFragment extends Fragment {

        private EditText mLoginEditText;
        private Button mLoginButton;

        public LoginFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_login,
                    container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            mLoginButton = (Button) view.findViewById(R.id.f_login_btn);
            mLoginEditText = (EditText) view.findViewById(R.id.f_login_user);

            mLoginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mName = mLoginEditText.getText().toString();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.a_main_frame, new WelcomeFragment())
                            .commit();
                }
            });
        }
    }
}
