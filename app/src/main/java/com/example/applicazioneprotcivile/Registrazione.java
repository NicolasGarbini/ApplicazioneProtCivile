package com.example.applicazioneprotcivile;

import android.content.Intent;
import android.os.Bundle;
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
                Toast.makeText(Registrazione.this, "Registrazione avvenuta con successo", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });









    }
}