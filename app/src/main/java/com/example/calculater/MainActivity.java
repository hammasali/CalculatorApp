package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView,textHistory;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button dot,plus,minus,multiply,divide,close,equal,percentage;
    boolean dotCheck;
    double num1, num2, result;
    char sign;

    public void setSign(char c){
        if(sign!=c){
            num1=Double.parseDouble(textView.getText().toString());
            sign=c;
            dotCheck=false;
            textView.setText("0");}}

    public void setTextView(String s){
        if(textView.getText().toString()=="0")
            textView.setText(s);
        else
            textView.setText(textView.getText()+s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textHistory=findViewById(R.id.textHistory);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        dot=findViewById(R.id.dot);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        percentage=findViewById(R.id.percentage);
        equal=findViewById(R.id.equal);
        close=findViewById(R.id.close);
        textView.setText("0");
        Toast.makeText(this,"Opening Calculator",Toast.LENGTH_SHORT).show();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setTextView("1");
                }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 setTextView("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView("0");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSign('+');
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSign('-');
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setSign('*');}
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSign('/');
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSign('%');
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    num2 = Double.parseDouble(textView.getText().toString());
                    dotCheck=false;

                    switch (sign){
                        case '+' :
                            result=num1+num2;
                           textView.setText(result+"");break;
                        case '-' :
                            result=num1-num2;
                            textView.setText(result+"");break;
                        case '*' :
                            result=num1*num2;
                            textView.setText(result+"");break;
                        case '/' :
                            result=num1/num2;
                            textView.setText(result+"");break;
                        case '%' :
                            result=(num1/num2)*100;
                            textView.setText(result+"");
                    }

                    String histroy= textHistory.getText().toString();
                    textHistory.setText(histroy+ num1+""+sign+""+num2+"="+result+"\n");
                    sign='F';
                    }});

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!dotCheck) {
                    textView.setText(textView.getText() + ".");
                    dotCheck=true;
                }}});

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Reset",Toast.LENGTH_SHORT).show();
                dotCheck=false;
                sign='F';
                num1=0;
                num2=0;
                textView.setText("0");
            }
        });
    }
}