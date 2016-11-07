package br.com.heiderlopes.androidactivityeintent.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Participante implements Parcelable{

    private String nome;
    private String email;
    private String site;
    private String telefone;
    private String trilha;


    public static final Creator<Participante> CREATOR = new Creator<Participante>() {
        @Override
        public Participante createFromParcel(Parcel in) {
            return new Participante(in);
        }

        @Override
        public Participante[] newArray(int size) {
            return new Participante[size];
        }
    };


    public Participante() {

    }

    public Participante(Parcel in) {
        nome = in.readString();
        email = in.readString();
        site = in.readString();
        telefone = in.readString();
        trilha = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(site);
        dest.writeString(telefone);
        dest.writeString(trilha);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTrilha() {
        return trilha;
    }

    public void setTrilha(String trilha) {
        this.trilha = trilha;
    }
}
