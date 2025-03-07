package com.example.applicazioneprotcivile;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String password;


    Utente(String nome, String cognome, String email, String password)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }


    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
