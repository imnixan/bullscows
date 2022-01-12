package com.example.bullscows;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BullsCows extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> answers = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    EditText input;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulls_cows);
        number = getRandomNumber();
        ListView listView = findViewById(R.id.answers);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, answers);
        listView.setAdapter(arrayAdapter);
        input = findViewById(R.id.input);
        input.setTransformationMethod(null);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String answer = input.getText().toString();
        System.out.println(answer);
        String result = checkAnswer(answer);
        answers.add(result);
        arrayAdapter.notifyDataSetChanged();
    }

    private String checkAnswer(String answer)
    {
        String[] realNumber = number.split("");
        String[] userAnswer = answer.split("");
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if(realNumber[i].equals(userAnswer[i])){

                    bulls++;
                    System.out.println(realNumber[i] + " Is bull now count on " + bulls);
                    break;
                }
                else if(realNumber[i].equals(userAnswer[j])){
                    cows++;
                    continue;
                }

            }
        }
        if (bulls == 4){
            Intent intent = new Intent(BullsCows.this, Win.class);
            intent.putExtra("number", number);
            startActivity(intent);
            finish();
            return "";
        }
        return answer + " быки: " + bulls + " коровы: " + cows;

    }

    private String getRandomNumber(){
        String randomNumber ="";
        for (int i = 0; i <4; i++ ){
            randomNumber+=Integer.toString(0 + (int)(Math.random() * 10));
        }
        System.out.println(randomNumber);
        return randomNumber;
    }

}
