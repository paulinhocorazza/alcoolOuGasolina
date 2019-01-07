package com.example.paulinhocorazza.alcoolougasolina;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoGasolina;
    private EditText precoAlcool;
    private AlertDialog.Builder alerta;
    private Button btnBVerifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolina = (EditText) findViewById(R.id.inputGasolina);
        precoAlcool = (EditText) findViewById(R.id.inputAlcool);
        btnBVerifica = (Button) findViewById(R.id.btnVerifica);
        btnBVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();
                
                if (precoGasolina.getText().toString().isEmpty() || precoAlcool.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Dados nao preenchido", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Converte valores string para numeros
                    Double valorAlcool = Double.parseDouble( textoPrecoAlcool );
                    Double valorGasolina = Double.parseDouble( textoPrecoGasolina );

                    Double resultado = valorAlcool/valorGasolina;
                    if(resultado <= 0.7){
                        alerta = new AlertDialog.Builder(MainActivity.this);
                        alerta.setTitle("Aqui está o seu resultado !");
                        alerta.setMessage("Nesse posto compensa abastecer com Alcool .");
                        alerta.setCancelable(false);
                        alerta.setIcon(android.R.drawable.ic_dialog_alert);
                        alerta.setNegativeButton("",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alerta.setCancelable(true);
                                    }
                                });
                        alerta.setPositiveButton("Ok, Recalcular ...",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        alerta.create();
                        alerta.show();

                    }
                    else{
                        alerta = new AlertDialog.Builder(MainActivity.this);
                        alerta.setTitle("Aqui está o seu resultado !");
                        alerta.setMessage("Nesse posto compensa abastecer com Gasolina .");
                        alerta.setCancelable(false);
                        alerta.setIcon(android.R.drawable.ic_dialog_alert);
                        alerta.setNegativeButton("",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alerta.setCancelable(true);
                                    }
                                });
                        alerta.setPositiveButton("Ok, Recalcular ...",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        alerta.create();
                        alerta.show();

                    }
                }

            }
        });

    }
}
