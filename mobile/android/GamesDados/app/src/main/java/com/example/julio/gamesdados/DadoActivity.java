package com.example.julio.gamesdados;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DadoActivity extends AppCompatActivity implements View.OnClickListener {

    int images[] = {R.mipmap.dado0, R.mipmap.dado1,
            R.mipmap.dado2, R.mipmap.dado3, R.mipmap.dado4,
            R.mipmap.dado5, R.mipmap.dado6};

    ImageView currentImage;
    TextView txtPlayer1, txtPlayer2, txtTurn;
    Button btnPlayer1, btnPlayer2, btnReset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentImage = (ImageView) findViewById(R.id.img_default);
        txtPlayer1 = (TextView) findViewById(R.id.txt_player1);
        txtPlayer2 = (TextView) findViewById(R.id.txt_player2);
        txtTurn = (TextView) findViewById(R.id.txt_turn);

        currentImage.setImageResource(images[0]);

        btnPlayer1 = (Button) findViewById(R.id.btn_player1);

        btnPlayer2 = (Button) findViewById(R.id.btn_player2);


        btnReset = (Button) findViewById(R.id.btn_reset);

        btnPlayer1.setOnClickListener(this);
        btnPlayer2.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        if ((v.getId() == R.id.btn_player1)
                || (v.getId() == R.id.btn_player2 )) {
            changeStatus();
            displayResut();

        } else {
            reset();

        }

    }


    private void changeStatus() {

        if (btnPlayer1.isEnabled()) {
            btnPlayer1.setEnabled(!btnPlayer1.isEnabled());
            btnPlayer2.setEnabled(true);
            txtTurn.setText("Player2 turn");
            String valorDoDado = changeImage(txtPlayer1).toString();
            txtPlayer1.setText(valorDoDado);

        } else {
            btnPlayer2.setEnabled(!btnPlayer2.isEnabled());
            btnPlayer1.setEnabled(true);
            txtTurn.setText("Player1 turn");
            String valorDoDado = changeImage(txtPlayer2).toString();
            txtPlayer2.setText(valorDoDado);
        }

    }


    private void reset() {
        txtPlayer1.setText("0");
        txtPlayer2.setText("0");
        txtTurn.setText("x");
        currentImage.setImageResource(images[0]);
        btnPlayer1.setEnabled(true);
        btnPlayer2.setEnabled(false);
    }

    private Integer getResult(TextView text) {
        String valor = text.getText().toString();
        Integer currentResult = Integer.parseInt(valor);
        return currentResult;
    }

    private Integer changeImage(TextView textView) {

        Random r = new Random();
        Integer n = r.nextInt(5) + 1;
        currentImage.setImageResource(images[n]);
        textView.setText(n.toString());
        return n;
    }

    private void displayResut() {
        Integer player1Point = getResult(txtPlayer1);
        Integer player2Point = getResult(txtPlayer2);

        if ((player1Point > 0) && (player2Point) > 0) {

            if (player1Point > player2Point) {
                Toast.makeText(this, "Player1 ganhou", Toast.LENGTH_LONG).show();

            } else if (player1Point == player2Point) {
                Toast.makeText(this, "empate", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Player2 ganhou", Toast.LENGTH_LONG).show();
            }

        }

    }


}
