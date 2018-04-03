package com.example.android.greatbarrierreef;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

//This is my Udacity quiz app on the Great Barrier Reef
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declare variables for all views
    String name;
    String toastMessage1;
    EditText nameInput;
    Button submit;
    CheckBox climate, pollution, fishing;
    RadioButton radioButton1True, RGbutton3True, RGbutton5true;
    int correctAnswers = 0;

    public void submitButton(View view) {
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE );
            imm.showSoftInput( view, InputMethodManager.SHOW_IMPLICIT );
        }
    }

    private void getToast() {
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

        //This method identifies all views and sets their listeners.
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

    private void initializeViews() {
    }

    resetAllUserInputChoices() {

    }

    //This method gets question one user input answer
    private String getQuestionOneUserInput() {
        return nameInput.getText().toString();
    }

    //This method checks answer for question one
    private void checkQuestionOneAnswers() {
        String name = nameInput.getText().toString();
        if ("Australia".equalsIgnoreCase( name )) {
            correctAnswers += 1;
        } else if (TextUtils.isEmpty( name )) {
            nameInput.setError( "Please answer question one" );

        }
    }

    //This method checks question two user choice
    private void checkQuestionTwoAnswers() {
        boolean isQuestionTwotrueChecked = radioButton1True.isChecked();
        if (isQuestionTwotrueChecked) {
            correctAnswers += 1;
        }
    }

    //This method checks question three user answer
    private void checkQuestionThreeAnswers() {
        if (climate.isChecked() && pollution.isChecked() && fishing.isChecked()) {
            correctAnswers += 1;
        }
    }

    //This method checks question four user choice
    private void checkQuestionFourAnswers() {
        RadioButton radioButton5true = findViewById( R.id.RGbutton5true );
        boolean isQuestionFivetrueChecked = radioButton5true.isChecked();
        if (isQuestionFivetrueChecked) {
            correctAnswers += 1;
        }
    }

    //This method checks question five user choice
    private void checkQuestionFiveAnswers() {
        RadioButton radioButton3true = findViewById( R.id.RGbutton3true );
        boolean isQuestionFourtrueChecked = radioButton3true.isChecked();
        if (isQuestionFourtrueChecked) {
            correctAnswers += 1;
        }
    }

    //This method checks all answers
    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    //This method checks answers, calculates score, and displays toast upon submit
    @Override
    public void onClick(View v) {
        getQuestionOneUserInput();
        checkAllQuestions();
        Toast.makeText( MainActivity.this, "Correct Answers: " + correctAnswers + "/5", Toast.LENGTH_LONG ).show();
        {
            correctAnswers = 0;
        }
    }
}


