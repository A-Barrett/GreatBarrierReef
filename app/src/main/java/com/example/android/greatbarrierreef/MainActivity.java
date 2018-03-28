package com.example.android.greatbarrierreef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    EditText nameInput;
    Button submit;
    int correctAnswers = 0;

    public void submitButton(View view) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        nameInput = findViewById( R.id.nameInput );
        submit = findViewById( R.id.submitButton );
        submit.setOnClickListener( submitButtonOnClickListener );
        name = nameInput.getText().toString();
    }

    private String getQuestionOneUserInput() {
        return nameInput.getText().toString();
    }

    private void checkQuestionOneAnswers() {
        String name = nameInput.getText().toString();
        if ("Australia".equals( name )) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers() {
        RadioButton radioButton1True = findViewById( R.id.radioButton1True );
        boolean isQuestionTwotrueChecked = radioButton1True.isChecked();
        if (isQuestionTwotrueChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionThreeAnswers() {
        CheckBox questionThreeclimate = findViewById( R.id.climate );
        boolean isQuestionThreeClimateChecked = questionThreeclimate.isChecked();
        if (isQuestionThreeClimateChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers() {
        RadioButton radioButton5true = findViewById( R.id.RGbutton5true );
        boolean isQuestionFivetrueChecked = radioButton5true.isChecked();
        if (isQuestionFivetrueChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers() {
        RadioButton radioButton3true = findViewById( R.id.RGbutton3true );
        boolean isQuestionFourtrueChecked = radioButton3true.isChecked();
        if (isQuestionFourtrueChecked) {
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswer() {
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            getQuestionOneUserInput();
            checkAllQuestions();
            Toast.makeText( MainActivity.this, "Correct Answers: " + correctAnswers + "/5", Toast.LENGTH_LONG ).show();
            resetCounterCorrectAnswer();
        }
    };
}