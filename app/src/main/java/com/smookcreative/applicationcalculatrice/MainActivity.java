package com.smookcreative.applicationcalculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView ecran;
    String chiffre_1, chiffre_2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ecran = findViewById(R.id.ecran);
    }

    private void monClickNumero(View v){
        Button boutton = (Button) v;
            String texteDuBoutton = boutton.getText().toString();
                ecran.setText( ecran.getText().toString() + texteDuBoutton );
    }

    private void monCLickFonction(View v){
        Button boutton = (Button) v;
        operator = boutton.getText().toString();

        if( chiffre_1 == null ){
            chiffre_1 =  ecran.getText().toString();
        }else{
            operator = boutton.getText().toString();
            chiffre_2 =  ecran.getText().toString();

            Double resultat = null;
            switch ( operator ){
                case "x":
                    resultat = Double.parseDouble(chiffre_1) * Double.parseDouble(chiffre_2);
                    ecran.setText( String.valueOf( resultat) );
                    break;
                case "+":
                    resultat = Double.parseDouble(chiffre_1) + Double.parseDouble(chiffre_2);
                    ecran.setText( String.valueOf( resultat) );
                    break;
                case "-":
                    resultat = Double.parseDouble(chiffre_1) - Double.parseDouble(chiffre_2);
                    ecran.setText( String.valueOf( resultat) );
                    break;
                case "/":
                    if( chiffre_2.equals("0")){
                        Toast.makeText(this, "Vous ne pouvez effectuer une division par zéro", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    resultat = Double.parseDouble(chiffre_1) / Double.parseDouble(chiffre_2);
                    ecran.setText( String.valueOf( resultat) );
                    break;
            }
            chiffre_1 = String.valueOf(resultat);
            chiffre_2 = null;
        }


    }

}