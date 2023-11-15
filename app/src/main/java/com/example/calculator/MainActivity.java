package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,
    numeroSete,numeroOito,numeroNove,ponto,soma,subtracao,multiplicacao,divisao,igual,btn_limpar;

    private TextView txtExpressao,txtResultado;
    private ImageView backspace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }
                } catch (Exception e) {

                }
            }
        });


    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.num_zero);
        numeroUm = findViewById(R.id.num_um);
        numeroDois = findViewById(R.id.num_dois);
        numeroTres = findViewById(R.id.num_tres);
        numeroQuatro = findViewById(R.id.num_quatro);
        numeroCinco = findViewById(R.id.num_cinco);
        numeroSeis = findViewById(R.id.num_seis);
        numeroSete = findViewById(R.id.num_sete);
        numeroOito = findViewById(R.id.num_oito);
        numeroNove = findViewById(R.id.num_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.btn_divisao);
        igual = findViewById(R.id.igual);
        btn_limpar = findViewById(R.id.btn_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){

        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

          case R.id.num_zero:
               AcrescentarUmaExpressao("0",true);
               break;

            case R.id.num_um:
                AcrescentarUmaExpressao("1",true);
                break;

            case R.id.num_dois:
                AcrescentarUmaExpressao("2",true);
                break;

            case R.id.num_tres:
                AcrescentarUmaExpressao("3",true);
                break;

            case R.id.num_quatro:
                AcrescentarUmaExpressao("4",true);
                break;

            case R.id.num_cinco:
                AcrescentarUmaExpressao("5",true);
                break;

            case R.id.num_seis:
                AcrescentarUmaExpressao("6",true);
                break;

            case R.id.num_sete:
                AcrescentarUmaExpressao("7",true);
                break;

            case R.id.num_oito:
                AcrescentarUmaExpressao("8",true);
                break;

            case R.id.num_nove:
                AcrescentarUmaExpressao("9",true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;

            case R.id.soma:
                AcrescentarUmaExpressao("+",false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExpressao("-",false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*",false);
                break;

            case R.id.btn_divisao:
                AcrescentarUmaExpressao("/",false);
                break;






        }
    }
}