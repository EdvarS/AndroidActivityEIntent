package br.com.heiderlopes.androidactivityeintent;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import org.w3c.dom.Text;

import br.com.heiderlopes.androidactivityeintent.model.Participante;
import br.com.heiderlopes.androidactivityeintent.utils.Constantes;

public class FormularioActivity extends AppCompatActivity {

    private TextInputLayout tilNome;
    private TextInputLayout tilEmail;
    private TextInputLayout tilSite;
    private TextInputLayout tilCelular;
    private Spinner spTrilha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        tilNome = (TextInputLayout) findViewById(R.id.tilNome);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilSite = (TextInputLayout) findViewById(R.id.tilSite);
        tilCelular = (TextInputLayout) findViewById(R.id.tilCelular);
        spTrilha = (Spinner) findViewById(R.id.spTrilha);
    }

    public void inscrever(View v) {
        Intent detalheIntent = new Intent(this, DetalheActivity.class);

        Participante p = new Participante();
        p.setEmail(tilEmail.getEditText().getText().toString());
        p.setNome(tilNome.getEditText().getText().toString());
        p.setSite(tilSite.getEditText().getText().toString());
        p.setTelefone(tilCelular.getEditText().getText().toString());
        p.setTrilha(spTrilha.getSelectedItem().toString());

        detalheIntent.putExtra(Constantes.KEY_PARTICIPANTE, p);

        startActivity(detalheIntent);
    }
}
