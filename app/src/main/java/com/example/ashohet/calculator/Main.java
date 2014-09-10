package com.example.ashohet.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main extends Activity {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonDot;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonEquals;
    Button buttonClear;

    boolean delete=false;
    String chosenAction="";
    double num1;
    double num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all buttons and fields
        init();

    }

    private void init(){
        textView=(TextView)findViewById(R.id.textView);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button0 = (Button)findViewById(R.id.button0);
        buttonDot = (Button)findViewById(R.id.buttonDot);
        buttonPlus = (Button)findViewById(R.id.buttonPlus);
        buttonMinus = (Button)findViewById(R.id.buttonMinus);
        buttonMultiply = (Button)findViewById(R.id.buttonMultiply);
        buttonDivide = (Button)findViewById(R.id.buttonDivide);
        buttonEquals = (Button)findViewById(R.id.buttonEquals);
        buttonClear = (Button)findViewById(R.id.buttonClear);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick(".");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick("Plus");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick("Minus");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick("Multiply");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick("Divide");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalsClick();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAll();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void numberClick(String num){

        if (delete == false)
            textView.setText(textView.getText() + num);
        else {
            textView.setText(num);
            delete=false;
        }
    }

    private void actionClick(String action){
        //If this is the first action
        if (chosenAction == "")
            num1= Double.parseDouble(textView.getText().toString());

        else{
            num2=Double.parseDouble(textView.getText().toString());
            calculate(num1,num2,chosenAction);
        }

        chosenAction = action;
        delete=true;

    }

    private void equalsClick(){
        if (textView.getText().toString()!="") {
            num2 = Double.parseDouble(textView.getText().toString());
            calculate(num1, num2, chosenAction);
            chosenAction = "";
            delete = true;
        }
    }

    private void calculate (double num1 ,double num2,String action){
        if (action=="Plus")
            textView.setText(String.valueOf(num1+num2));
        if (action=="Minus")
            textView.setText(String.valueOf(num1-num2));
        if (action=="Multiply")
            textView.setText(String.valueOf(num1*num2));
        if (action=="Divide")
            textView.setText(String.valueOf(num1/num2));

        num1=Double.parseDouble(textView.getText().toString());
    }

    private void clearAll (){
        num1=Double.NaN;
        num2=Double.NaN;
        chosenAction="";
        textView.setText("");
    }

}
