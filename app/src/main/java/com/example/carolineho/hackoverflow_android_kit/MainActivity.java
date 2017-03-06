package com.example.carolineho.hackoverflow_android_kit;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mContact;
    private EditText mEmail;
    private EditText mEvent;
    private EditText mTopic;
    private EditText mSignature;
    private RadioButton mCasual;
    private RadioButton mBusiness;
    private RadioButton mCoffee;
    private RadioButton mKeepInTouch;
    private Button mSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);

        mContact = (EditText) findViewById(R.id.contact);
        mEmail = (EditText) findViewById(R.id.email);
        mEvent = (EditText) findViewById(R.id.event);
        mTopic = (EditText) findViewById(R.id.topic);
        mSignature = (EditText) findViewById(R.id.signature);
        mCasual = (RadioButton) findViewById(R.id.casual);
        mBusiness = (RadioButton) findViewById(R.id.business);
        mCoffee = (RadioButton) findViewById(R.id.coffee);
        mKeepInTouch = (RadioButton) findViewById(R.id.keepInTouch);
        mSendEmail = (Button) findViewById(R.id.sendEmail);

        View.OnClickListener sendEmailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!mCasual.isChecked() && !mBusiness.isChecked()) || (!mCoffee.isChecked() && !mKeepInTouch.isChecked())
                        || mContact.getText().length() == 0 || mEmail.getText().length() == 0 || mEvent.getText().length() == 0
                        || mTopic.getText().length() == 0 || mSignature.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
                } else {
                    String greeting;
                    String recap;
                    String request;
                    String closing;

                    if (mCasual.isChecked()) {
                        greeting = "Hi " + mContact.getText().toString() + ",\n\n";
                        recap = "It was great to meet you at " + mEvent.getText().toString() +
                                "! I really enjoyed talking with you about " + mTopic.getText().toString() + ". ";
                        if (mCoffee.isChecked())
                            request = "Let me know if you're ever free to grab coffee!\n\n";
                        else
                            request = "Let's keep in touch!\n\n";
                        closing = "Best,\n" + mSignature.getText().toString();
                    } else {
                        greeting = "Dear " + mContact.getText().toString() + ",\n\n";
                        recap = "It was a pleasure to meet you at " + mEvent.getText().toString() +
                                " – I really enjoyed talking with you about " + mTopic.getText().toString() + ". ";
                        if (mCoffee.isChecked())
                            request = "If you have time in the coming weeks, I would love to take you to coffee to talk further.\n\n";
                        else
                            request = "I hope to keep in touch.\n\n";
                        closing = "Many thanks,\n" + mSignature.getText().toString();
                    }

                    String message = greeting + recap + request + closing;

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{mEmail.getText().toString()});
                    i.putExtra(Intent.EXTRA_SUBJECT, "Following up from " + mEvent.getText().toString());
                    i.putExtra(Intent.EXTRA_TEXT, message);
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        mSendEmail.setOnClickListener(sendEmailListener);
    }
}
