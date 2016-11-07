package br.com.heiderlopes.androidactivityeintent;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilUsuario;
    private TextInputLayout tilSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilUsuario = (TextInputLayout) findViewById(R.id.tilUsuario);
        tilSenha = (TextInputLayout) findViewById(R.id.tilSenha);
    }

    public void fazerLogin(View v) {
        String username = tilUsuario.getEditText().getText().toString();
        String password = tilSenha.getEditText().getText().toString();

        if (!validaUsuario(username)) {
            tilUsuario.setError("Usuario invalido");
        } else if (!validaSenha(password)) {
            tilSenha.setError("Senha inválida");
        } else {
            tilUsuario.setErrorEnabled(false);
            tilSenha.setErrorEnabled(false);
            Intent i = new Intent(this, FormularioActivity.class);
            startActivity(i);
            finish();
        }
    }

    public boolean validaUsuario(String usuario) {
        return usuario.length() > 3;
    }

    public boolean validaSenha(String password) {
        return password.length() > 5;
    }
}
