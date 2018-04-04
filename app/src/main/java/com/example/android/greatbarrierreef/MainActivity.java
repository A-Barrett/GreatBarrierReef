package com.example.android.greatbarrierreef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


//Udacity quiz app on the Great Barrier Reef


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * This method declares variables for all views.
     */
    String name;
    String toastMessage1;
    EditText nameInput;
    Button submit;
    CheckBox climate, pollution, fishing;
    RadioButton radioButton1True, RGbutton3True, RGbutton5true;
    int correctAnswers = 0;

    public void submitButton(View view) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

        initializeViews();
        nameInput = findViewById( R.id.nameInput );
        submit = findViewById( R.id.submitButton );
        submit.setOnClickListener( this );
        name = nameInput.getText().toString();
        climate = findViewById( R.id.climate );
        pollution = findViewById( R.id.pollution );
        fishing = findViewById( R.id.fishing );
        radioButton1True = findViewById( R.id.radioButton1True );
        RGbutton3True = findViewById( R.id.RGbutton3true );
        RGbutton5true = findViewById( R.id.RGbutton5true );
    }

    /**
     * Identifies all views and their listeners.
     */
    private void initializeViews() {
    }

    /**
     * Gets question one user input answer.
     */
    private String getQuestionOneUserInput() {
        return nameInput.getText().toString();
    }

    /**
     * Checks answer for question one.
     */
    private void checkQuestionOneAnswers() {
        String name = nameInput.getText().toString();
        if ("Australia".equalsIgnoreCase( name )) {
            correctAnswers += 20;
        } else if (TextUtils.isEmpty( name )) {
            nameInput.setError( "Please answer question one" );

        }
    }

    /**
     * Checks question two user choice.
     */
    private void checkQuestionTwoAnswers() {
        boolean isQuestionTwotrueChecked = radioButton1True.isChecked();
        if (isQuestionTwotrueChecked) {
            correctAnswers += 20;
        }
    }

    /**
     * Checks question three user answer.
     */
    private void checkQuestionThreeAnswers() {
        if (climate.isChecked() && pollution.isChecked() && fishing.isChecked()) {
            correctAnswers += 20;
        }
    }

    /**
     * Checks question four user choice.
     */
    private void checkQuestionFourAnswers() {
        RadioButton radioButton5true = findViewById( R.id.RGbutton5true );
        boolean isQuestionFivetrueChecked = radioButton5true.isChecked();
        if (isQuestionFivetrueChecked) {
            correctAnswers += 20;
        }
    }

    /**
     * Checks question five user choice.
     */
    private void checkQuestionFiveAnswers() {
        RadioButton radioButton3true = findViewById( R.id.RGbutton3true );
        boolean isQuestionFourtrueChecked = radioButton3true.isChecked();
        if (isQuestionFourtrueChecked) {
            correctAnswers += 20;
        }
    }

    /**
     * Method checks all answers.
     */
    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    /**
     * Method checks answers, calculates score, and displays toast upon submit.
     */
    @Override
    public void onClick(View v) {
        getQuestionOneUserInput();
        checkAllQuestions();
        Toast.makeText( MainActivity.this, "YOU SCORED " + correctAnswers + "%", Toast.LENGTH_LONG ).show();
        {
            correctAnswers = 0;
        }
    }
}


//TODO: Customize Toast
//TODO: Custom Theme
//TODO: Custom Icon


