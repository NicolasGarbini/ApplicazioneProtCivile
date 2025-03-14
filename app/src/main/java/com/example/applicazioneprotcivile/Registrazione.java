package com.example.applicazioneprotcivile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class Registrazione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrazione);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Collegamento con elementi grafici

        EditText nome = findViewById(R.id.txt_nome);
        EditText cognome = findViewById(R.id.txt_cognome);
        EditText email = findViewById(R.id.txt_emailRegistrazione);
        EditText password = findViewById(R.id.txt_passwordRegistrazione);





        String nomeUtente = getIntent().getStringExtra("nome");




        Button btnEffettuaRegistrazione = findViewById(R.id.btn_effettuaRegistrazione);
        btnEffettuaRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrazione.this, MainActivity.class);
                //Uso del log
                Log.d("Registrazione", "Nome: " + nome.getText().toString());
                Log.d("Registrazione", "Cognome: " + cognome.getText().toString());
                Log.d("Registrazione", "Email: " + email.getText().toString());
                Log.d("Registrazione", "Password: " + password.getText().toString());
                //Messaggio pop up che mi da una conferma di registrazione avvenuta con successo
                if (TextUtils.isEmpty(nome.getText()) || TextUtils.isEmpty(cognome.getText()) || TextUtils.isEmpty(email.getText()) || TextUtils.isEmpty(password.getText()))
                {
                    Toast.makeText(Registrazione.this, "Compilare tutti i campi", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Registrazione.this, "Registrazione avvenuta con successo", Toast.LENGTH_SHORT).show();
                Utente utente = new Utente(nome.getText().toString(), cognome.getText().toString(), email.getText().toString(), password.getText().toString());
                Gson gson = new Gson();
                String fileJson = gson.toJson(utente);
                Intent intent1 = new Intent(Registrazione.this, MainActivity.class);
                intent1.putExtra("utente", fileJson);
                startActivity(intent);

            }
        });









    }
}