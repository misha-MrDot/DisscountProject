package com.msaggik.firstlessonstorediscounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float coat = 70; // материнская плата с процессором
    byte coatSale = 77; // скидка (в процентах)
    float hat = 25; // оперативная память
    byte hatSale = 37;
    float businessSuit = 53; // SSD (постоянная память)
    byte businessSuitSale = 44;
    float shirt = 19; // башенный кулер
    byte shirtSale = 0;
    float shoes = 41; // корпус и блок питания
    byte shoesSale = 32;
    float account = 312; // счёт пользователя

    // метод подсчёта стоимости делового гардероба
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (coat * (100 - coatSale) + hat * (100 - hatSale)
                + businessSuit * (100 - businessSuitSale) + shirt * (100 - shirtSale)
                + shoes * (100 - shoesSale)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки делового гардроба
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить деловой гардероб
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить деловой гардероб
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки делового гардероба");
            balanceOut.setText(" - ");
        }
    }
}