package com.paulinhocorazza.alcoolougasolina;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoGasolina;
    private EditText precoAlcool;
    private AlertDialog.Builder alerta;
    private Button btnBVerifica;
    private ImageView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolina = (EditText) findViewById(R.id.inputGasolina);
        precoAlcool = (EditText) findViewById(R.id.inputAlcool);
        info = (ImageView) findViewById(R.id.infoId);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("Fale com o desenvolvedor");
                alerta.setCancelable(false);
                alerta.setIcon(android.R.drawable.ic_dialog_email);
                alerta.setNegativeButton("Não, talvez mais tarde",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alerta.setCancelable(true);
                            }
                        });
                alerta.setPositiveButton("Sim, vamos mandar um email !",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent=new Intent(Intent.ACTION_SEND);
                                String[] recipients={"corazza.paulovinicius@gmail.com"};
                                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                intent.putExtra(Intent.EXTRA_SUBJECT,"Aplicativo GASOSA OU ALCOOL?");
                                intent.putExtra(Intent.EXTRA_TEXT,"");
                                intent.putExtra(Intent.EXTRA_CC,"corazza.paulovinicius@gmail.com");
                                intent.setType("text/html");
                                intent.setPackage("com.google.android.gm");
                                startActivity(Intent.createChooser(intent, "Send mail"));
                            }
                        });
                alerta.create();
                alerta.show();
            }
        });
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
