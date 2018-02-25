package com.edopore.ezcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String num1 = "", num2 = "";
    Button B1, B2, B3, B4, B5, B6, B7, B8, B9, B0, b1, b2, b3, b4, b5, b6, b7;
    EditText E1;
    int flg = 0, op = 0, op1 = 1;
    boolean fli = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = findViewById(R.id.bUno);
        B2 = findViewById(R.id.bDos);
        B3 = findViewById(R.id.bTres);
        B4 = findViewById(R.id.bCuatro);
        B5 = findViewById(R.id.bCinco);
        B6 = findViewById(R.id.bSeis);
        B7 = findViewById(R.id.bSiete);
        B8 = findViewById(R.id.bOcho);
        B9 = findViewById(R.id.bNueve);
        B0 = findViewById(R.id.bCero);
        b1 = findViewById(R.id.bBorrar);
        b2 = findViewById(R.id.bMas);
        b3 = findViewById(R.id.bMenos);
        b4 = findViewById(R.id.bPor);
        b5 = findViewById(R.id.bEntre);
        b6 = findViewById(R.id.bIgual);
        b7 = findViewById(R.id.bComa);
        E1 = findViewById(R.id.tResultado);
    }

    public void OnButtonClicked(View view) {
        int id = view.getId();
        float n1, n2, suma, resta, mult, divi;
        String str;
        if (op1 == 0) {
            E1.setText("");
            op1 = 1;
        }
        str = E1.getText().toString();
        switch (id) {
            case R.id.bUno:
                E1.setText(str + "1");
                break;
            case R.id.bDos:
                E1.setText(str + "2");
                break;
            case R.id.bTres:
                E1.setText(str + "3");
                break;
            case R.id.bCuatro:
                E1.setText(str + "4");
                break;
            case R.id.bCinco:
                E1.setText(str + "5");
                break;
            case R.id.bSeis:
                E1.setText(str + "6");
                break;
            case R.id.bSiete:
                E1.setText(str + "7");
                break;
            case R.id.bOcho:
                E1.setText(str + "8");
                break;
            case R.id.bNueve:
                E1.setText(str + "9");
                break;
            case R.id.bCero:
                E1.setText(str + "0");
                break;
            case R.id.bBorrar:
                flg = 0;
                E1.setText("");
                num1 = num2 = "";
                Toast.makeText(this, R.string.Borra, Toast.LENGTH_SHORT).show();
                break;
            case R.id.bMas:
                flg = 0;
                op = 1;
                num1 = str;
                E1.setText("");
                break;
            case R.id.bMenos:
                flg = 0;
                op = 2;
                num1 = str;
                E1.setText("");
                break;
            case R.id.bPor:
                flg = 0;
                op = 3;
                num1 = str;
                E1.setText("");
                break;
            case R.id.bEntre:
                flg = 0;
                op = 4;
                num1 = str;
                E1.setText("");
                break;
            case R.id.bIgual:
                flg = 0;
                op1 = 0;
                num2 = E1.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {

                } else {
                    n1 = Float.parseFloat(num1);
                    n2 = Float.parseFloat(num2);
                    switch (op) {
                        case 1:
                            suma = n1 + n2;
                            if (suma % 1 == 0) {
                                E1.setText(String.valueOf((int) suma));
                            } else {
                                E1.setText(String.valueOf(suma));
                            }
                            break;
                        case 2:
                            resta = n1 - n2;
                            if (resta % 1 == 0) {
                                E1.setText(String.valueOf((int) resta));
                            } else {
                                E1.setText(String.valueOf(resta));
                            }
                            break;
                        case 3:
                            mult = n1 * n2;
                            if (mult % 1 == 0) {
                                E1.setText(String.valueOf((int) mult));
                            } else {
                                E1.setText(String.valueOf(mult));
                            }
                            break;
                        case 4:
                            if (n2 == 0) {
                                Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
                                E1.setText(R.string.error1);
                            } else {
                                divi = n1 / n2;
                                if (divi % 1 == 0) {
                                    E1.setText(String.valueOf((int) divi));
                                } else {
                                    E1.setText(String.valueOf(divi));
                                }
                            }
                            break;
                    }
                }
                num1 = num2 = "";
                break;
            case R.id.bComa:
                if (flg == 0) {
                    E1.setText(str + ".");
                    flg++;
                }
                break;
        }
    }
}