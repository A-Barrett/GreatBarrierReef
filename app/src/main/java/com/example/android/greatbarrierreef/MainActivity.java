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


/**
 * Udacity quiz app on the Great Barrier Reef
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * This method declares variables for all views.
     */
    String name;
    EditText nameInput;
    Button submit;
    CheckBox climate, pollution, fishing;
    RadioButton radioButton1True, RGbutton3True, RGbutton5true, northern, black, crown;
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
        northern = findViewById( R.id.northern );
        black = findViewById( R.id.black );
        crown = findViewById( R.id.crown );

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
            correctAnswers += 15;
        } else if (TextUtils.isEmpty( name )) {
            nameInput.setError( getString( R.string.answer_question ) );

        }
    }

    /**
     * Checks question two user choice.
     */
    private void checkQuestionTwoAnswers() {
        boolean isQuestionTwotrueChecked = radioButton1True.isChecked();
        if (isQuestionTwotrueChecked) {
            correctAnswers += 15;
        }
    }

    /**
     * Checks question three user answer.
     */
    private void checkQuestionThreeAnswers() {
        if (climate.isChecked() && pollution.isChecked() && fishing.isChecked()) {
            correctAnswers += 25;
        }
    }

    /**
     * Checks question four user choice.
     */
    private void checkQuestionFourAnswers() {
        boolean isQuestionFivetrueChecked = RGbutton5true.isChecked();
        if (isQuestionFivetrueChecked) {
            correctAnswers += 15;
        }
    }

    /**
     * Checks question five user choice.
     */
    private void checkQuestionFiveAnswers() {
        boolean isQuestionFourtrueChecked = RGbutton3True.isChecked();
        if (isQuestionFourtrueChecked) {
            correctAnswers += 15;
        }
    }

    /**
     * Checks question six user choice.
     */
    private void checkQuestionSixAnswers() {
        if (crown.isChecked()) {
            correctAnswers += 15;
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
        checkQuestionSixAnswers();
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

//TODO: Finish Styles and Theme
//TODO: Implement Pop_Up Window



