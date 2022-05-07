package com.smookcreative.applicationcalculatrice;

import android.os.Bundle;
import android.util.Log;
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
        Button clearBtn = findViewById(R.id.boutton_clear);
        Button sqrtBtn = findViewById(R.id.sqrt);
        Button minus = findViewById(R.id.minus);


        clearBtn.setOnClickListener( view -> {
            chiffre_1 = null;
            chiffre_2 = null;
            operator = null;
            ecran.setText("");
            ecran.setHint("0");
        });


        sqrtBtn.setOnClickListener( view -> {
            if( chiffre_1 == null ){
                chiffre_1 = String.valueOf(Math.sqrt( Double.parseDouble( ecran.getText().toString() ) ) );
                ecran.setText( chiffre_1 );
            }else{
                chiffre_2 = String.valueOf(Math.sqrt( Double.parseDouble( ecran.getText().toString() ) ) );
                ecran.setText( chiffre_2 );
            }
        });

        minus.setOnClickListener( view -> {
            String num;
            if( ecran.getText().toString().isEmpty()) return;
            if( ecran.getText().toString().startsWith("-")){
               num =ecran.getText().toString().replaceAll("-", "");
            }else{
               num = "-"+ecran.getText().toString();
            }
            ecran.setText( num );
        });

    }

    public void monClickNumero(View v){
        Button boutton = (Button) v;
            String texteDuBoutton = boutton.getText().toString();
                ecran.setText( ecran.getText().toString() + texteDuBoutton );
    }

    public void monCLickFonction(View v){

        Button boutton = (Button) v;
        operator = boutton.getText().toString();

        if( chiffre_1 == null ){
            chiffre_1 =  ecran.getText().toString();
        }else{
           monCLickResult(v);
        }

        ecran.setText("");
        ecran.setHint("0");
    }

    public void monCLickResult(View view) {
        chiffre_2 =  ecran.getText().toString();
        Double resultat = null;
        //Log.d("chiffre 1", chiffre_1);
        //Log.d("chiffre 2", chiffre_2);
        switch ( operator ){
            case "*":
                resultat = Double.parseDouble(chiffre_1) * Double.parseDouble(chiffre_2);
                break;
            case "+":
                resultat = Double.parseDouble(chiffre_1) + Double.parseDouble(chiffre_2);
                break;
            case "-":
                resultat = Double.parseDouble(chiffre_1) - Double.parseDouble(chiffre_2);
                break;
            case "/":
                if( chiffre_2.equals("0")){
                    Toast.makeText(this, "Vous ne pouvez effectuer une division par zéro", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultat = Double.parseDouble(chiffre_1) / Double.parseDouble(chiffre_2);
                break;
            case "X^Y":{
                resultat = Math.pow( Double.parseDouble(chiffre_1),  Double.parseDouble(chiffre_2));
                ecran.setText( String.valueOf( resultat) );
            }
        }
        ecran.setText( String.valueOf( resultat) );
        chiffre_1 = null;
        chiffre_2 = null;

    }


}