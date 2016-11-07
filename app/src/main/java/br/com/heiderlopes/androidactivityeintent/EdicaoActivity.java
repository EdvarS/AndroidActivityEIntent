package br.com.heiderlopes.androidactivityeintent;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.heiderlopes.androidactivityeintent.utils.Constantes;

public class EdicaoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout tilValor;
    private Button btOk;
    private Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        tilValor = (TextInputLayout) findViewById(R.id.tilValor);
        btOk = (Button) findViewById(R.id.btOk);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        btOk.setOnClickListener(this);
        btCancelar.setOnClickListener(this);

        if(getIntent() == null) {
            tilValor.setHint("");
        } else {
            tilValor.setHint(getIntent().getStringExtra(Constantes.LABEL_EDICAO));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        switch (v.getId()) {

            case R.id.btOk:
                String name = tilValor.getEditText().getText().toString();
                intent.putExtra(Constantes.VALOR_EDITADO, name);
                setResult(RESULT_OK, intent);
                break;

            case R.id.btCancelar:
                setResult(RESULT_CANCELED, intent);
                break;
        }
        finish();
    }
}