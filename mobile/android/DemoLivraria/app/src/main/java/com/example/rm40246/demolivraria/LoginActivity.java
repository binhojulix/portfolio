package com.example.rm40246.demolivraria;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private final String PREF_NAME = "LIVRARIA";
    private final String MANTER_CONTECTADO = "MANTER_CONECTADO";


    private TextInputLayout tlNome;
    private TextInputLayout tlSenha;
    private CheckBox cbManterConectado;
    private Button btnEntrar;
    private boolean sett;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (isLogado()) {
            iniciarApp();
        }

        tlSenha = (TextInputLayout) findViewById(R.id.tl_senha);
        tlNome = (TextInputLayout) findViewById(R.id.tl_nome);
        cbManterConectado = (CheckBox) findViewById(R.id.ch_checked);
        btnEntrar = (Button) findViewById(R.id.btn_entrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (doLogin()) {
                    manterConectado();
                    iniciarApp();
                } else {
                    tlSenha.setError("Usuário ou senha inválido");
                }

            }
        });
    }


    private void iniciarApp() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean doLogin() {
        String login = tlNome.getEditText().getText().toString();
        String senha = tlSenha.getEditText().getText().toString();
        return login.equals("fabio") && senha.equals("123");
    }

    private void manterConectado() {
        SharedPreferences setting = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putBoolean(MANTER_CONTECTADO, cbManterConectado.isChecked());
        editor.commit();
    }


    private boolean isLogado() {
        SharedPreferences setting = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return setting.getBoolean(MANTER_CONTECTADO, false);
    }


}
