package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1; //A
    TextView textView2; //to do
    TextView textView3; //B

    Button button1;    //кнопка 1
    Button button2;    //кнопка 2
    Button button3;    //кнопка 3
    Button button4;    //кнопка 4
    Button button5;    //кнопка 5
    Button button6;    //кнопка 6
    Button button7;    //кнопка 7
    Button button8;    //кнопка 8
    Button button9;    //кнопка 9
    Button button0;    //кнопка 0
    Button buttonCE;    //кнопка CE
    Button ButtonDivision;    //кнопка /
    Button ButtonMultiplication;    //кнопка *
    Button ButtonSubtraction;    //кнопка -
    Button ButtonResult;    //кнопка =
    Button ButtonPut;    //кнопка .
    Button ButtonAddition;    //кнопка +

    int status = 0;  //Что изменяется: 0-первое число, 1-действие, 2-второе число
    boolean statusPut1 = false;  //Пишется ли точка
    boolean statusPut3 = false;  //Пишется ли точка

    double counter1 = 0;    //первое число
    String counter2 = "";   //действие
    double counter3 = 0;    //второе число

    int counterPut1 = 0;
    int counterPut3 = 0;

    //выполниться в самом начале один раз
    //здесь задаются переменные, зависимости и т.п.
    //а далее метод не используется
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); //показ экрана

        textView1 = findViewById(R.id.textView1);   //выводимая информация
        button0 = findViewById(R.id.button0); //кнопка 0
        button1 = findViewById(R.id.button1); //кнопка 1
        button2 = findViewById(R.id.button2); //кнопка 2
        button3 = findViewById(R.id.button3); //кнопка 3
        button4 = findViewById(R.id.button4); //кнопка 4
        button5 = findViewById(R.id.button5); //кнопка 5
        button6 = findViewById(R.id.button6); //кнопка 6
        button7 = findViewById(R.id.button7); //кнопка 7
        button8 = findViewById(R.id.button8); //кнопка 8
        button9 = findViewById(R.id.button9); //кнопка 9
        buttonCE = findViewById(R.id.buttonCE); //кнопка CE
        ButtonDivision = findViewById(R.id.ButtonDivision); //кнопка /
        ButtonMultiplication = findViewById(R.id.ButtonMultiplication); //кнопка *
        ButtonSubtraction = findViewById(R.id.ButtonSubtraction); //кнопка -
        ButtonResult = findViewById(R.id.ButtonResult); //кнопка =
        ButtonPut = findViewById(R.id.ButtonPut); //кнопка .
        ButtonAddition = findViewById(R.id.ButtonAddition); //кнопка +

    }

    //начнется после onCreate
    @Override
    protected void onStart() {
        super.onStart();
    }

    //обычное состояние
    //начнется после onRestart
    @Override
    protected void onResume() {
        super.onResume();
    }

    //приложение перекрывается неполностью
    //то, что будет при низком заряде
    @Override
    protected void onPause() {
        super.onPause();
    }

    //приложение перекрывается полностью
    //звонок, переход в другое окно
    @Override
    protected void onStop() {
        super.onStop();
    }

    //выполняется сразу после onStop
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    //выполняется при закрытии приложения
    @Override
    protected void onDestroy() {
        super.onDestroy();
        status = 0;
    }

    public void OnClick(final View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                switch (view.getId()) {
                    case R.id.button0:
                        Button(0);
                        break;
                    case R.id.button1:
                        Button(1);
                        break;
                    case R.id.button2:
                        Button(2);
                        break;
                    case R.id.button3:
                        Button(3);
                        break;
                    case R.id.button4:
                        Button(4);
                        break;
                    case R.id.button5:
                        Button(5);
                        break;
                    case R.id.button6:
                        Button(6);
                        break;
                    case R.id.button7:
                        Button(7);
                        break;
                    case R.id.button8:
                        Button(8);
                        break;
                    case R.id.button9:
                        Button(9);
                        break;
                    case R.id.buttonCE:
                        ButtonCE();
                        break;
                    case R.id.ButtonDivision:
                        ButtonDivision();
                        break;
                    case R.id.ButtonMultiplication:
                        ButtonMultiplication();
                        break;
                    case R.id.ButtonSubtraction:
                        ButtonSubtraction();
                        break;
                    case R.id.ButtonResult:
                        ButtonResult();
                        break;
                    case R.id.ButtonPut:
                        ButtonPut();
                        break;
                    case R.id.ButtonAddition:
                        ButtonAddition();
                        break;
                }
            }
        }).start();
    }


    //методы кнопок
    //Кнопка 0
    public void Button(double i) {
        if (status == 0) {
            if (statusPut1 == false) {
                counter1 *= 10;
                counter1 += i;
            } else if (statusPut1 == true) {
                counterPut1++;
                counter1 += i / Math.pow(10, (counterPut1));
            }
        } else if (status > 0) {
            if (statusPut3 == false) {
                counter3 *= 10;
                counter3 += i;
            } else {
                counterPut3++;
                counter3 += i / Math.pow(10, (counterPut3));
            }
        }
        View();
    }


    //Кнопка /
    public void ButtonDivision() {
        if (status == 0) {
            status++;
        }
        counter2 = "/";
        View();
    }

    //Кнопка *
    public void ButtonMultiplication() {
        if (status == 0) {
            status++;
        }
        counter2 = "*";
        View();
    }

    //Кнопка -
    public void ButtonSubtraction() {
        if (status == 0) {
            status++;
        }
        counter2 = "-";
        View();
    }

    //Кнопка +
    public void ButtonAddition() {
        if (status == 0) {
            status++;
        }
        counter2 = "+";
        View();
    }

    //Кнопка .
    public void ButtonPut() {
        if (status == 0) {
            if (statusPut1) {
                statusPut1 = false;
            } else {
                statusPut1 = true;
            }
        } else {
            if (statusPut3) {
                statusPut3 = false;
            } else {
                statusPut3 = true;
            }
        }
        View();
    }

    //Кнопка CE
    public void ButtonCE() {
        statusPut1 = false;
        statusPut3 = false;
        counterPut1 = 0;
        counterPut3 = 0;
        counter1 = 0;
        counter2 = "";
        counter3 = 0;
        status = 0;
        textView1.setText("Enter");
    }

    //Кнопка =
    public void ButtonResult() {
        String s = sView();
        double d = 0;
        String sd = "";
        switch (counter2) {
            case "*": {
                d = counter1 * counter3;
                break;
            }
            case "/": {
                if (counter3 == 0) {
                    d = 0;
                } else {
                    d = counter1 / counter3;
                }
                break;
            }
            case "+": {
                d = counter1 + counter3;
                break;
            }
            case "-": {
                d = counter1 - counter3;
                break;
            }
        }
        sd = Double.toString(d);
        sd = sd.substring(sd.indexOf(".") + 1);
        if (Integer.parseInt(sd) == 0) {
            int i = (int) Math.round(d);
            s += " = " + i;
        } else {
            s += " = " + Double.toString(d);
        }
        textView1.setText(s);
    }

    //отображение
    public void View() {
        String s = sView();
        textView1.setText(s);
    }

    public String sView() {
        String s = "";
        if (statusPut1) {
            s += Double.toString(counter1);
        } else {
            s += Integer.toString((int) counter1);
        }

        s += " " + counter2 + " ";

        if (statusPut3 && status == 1) {
            s += Double.toString(counter3);
        } else if (status == 1) {
            s += Integer.toString((int) counter3);
        }

        return s;
    }


}
