package br.com.heiderlopes.androidactivityeintent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.heiderlopes.androidactivityeintent.model.Participante;
import br.com.heiderlopes.androidactivityeintent.utils.Constantes;

public class DetalheActivity extends AppCompatActivity {

    private Participante participante;

    private TextView tvSaudacao;
    private TextView tvEmail;
    private TextView tvSite;
    private TextView tvCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tvSaudacao = (TextView) findViewById(R.id.tvSaudacao);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvSite = (TextView) findViewById(R.id.tvSite);
        tvCelular = (TextView) findViewById(R.id.tvCelular);

        if(getIntent() != null) {
            participante = getIntent().getExtras().getParcelable(Constantes.KEY_PARTICIPANTE);
            //tvSaudacao.setText(participante.getEmail());
            tvEmail.setText(participante.getEmail());
            tvSite.setText(participante.getSite());
            tvCelular.setText(participante.getTelefone());
            tvSaudacao.setText(getString(R.string.inscrito_em, participante.getNome(), participante.getTrilha()));
        }
    }

    private void editar(String label, int requestCode) {
        Intent intent = new Intent(this, EdicaoActivity.class);
        intent.putExtra(Constantes.LABEL_EDICAO, label);
        startActivityForResult(intent, requestCode);
    }

    public void editarEmail(View v) {
        editar("E-mail", Constantes.REQUEST_CODE_EMAIL);
    }

    public void editarSite(View v) {
        editar("Site", Constantes.REQUEST_CODE_SITE);
    }

    public void editarCelular(View v) {
        editar("Celular", Constantes.REQUEST_CODE_TELEFONE);
    }

    public void ligar(View v) {
        String phone = tvCelular.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }

    public void abrirSite(View v) {
        String url = tvEmail.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void enviarEmail(View v) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{tvEmail.getText().toString()});
        email.putExtra(Intent.EXTRA_SUBJECT, "subject");
        email.putExtra(Intent.EXTRA_TEXT, "message");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Selecione o cliente de E-mail: "));
    }

    public void enviarSMS(View v)
    {
        String number = "12346556";
        Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null));
        smsIntent.putExtra("sms_body","Mensagem a ser enviada");
        startActivity(smsIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //if(resultCode == RESULT_OK && data.getExtras().containsKey("name")) {
        if(resultCode == RESULT_OK) {

            String valor = data.getExtras().getString(Constantes.VALOR_EDITADO);

            switch (requestCode) {
                case Constantes.REQUEST_CODE_EMAIL:
                    tvEmail.setText(valor);
                    break;

                case Constantes.REQUEST_CODE_NOME:
                    break;

                case Constantes.REQUEST_CODE_SITE:
                    tvSite.setText(valor);
                    break;

                case Constantes.REQUEST_CODE_TELEFONE:
                    tvCelular.setText(valor);
                    break;
            }
        }
    }
}
