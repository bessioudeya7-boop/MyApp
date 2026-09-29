// Package dans lequel se trouve notre classe MainActivity
package com.example.myapp;


// Import de Intent
// Intent permet de passer d'une Activity à une autre
import android.content.Intent;
import android.os.Bundle;

// Import de Button
// Button permet de manipuler les boutons de l'interface
import android.widget.Button;
// Elle permet de créer une Activity Android
import androidx.appcompat.app.AppCompatActivity;

// MainActivity hérite de AppCompatActivity
public class MainActivity extends AppCompatActivity {


    Button btnLogin;

    Button btnSignUp;


    // Méthode appelée lorsque l'Activity est créée
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Appelle la méthode onCreate() de la classe parent
        super.onCreate(savedInstanceState);


        // Charge le fichier XML de l'interface principale
        // Ici, on utilise activity_main.xml
        setContentView(R.layout.activity_main);


        // Récupère le bouton LOGIN depuis le fichier XML
        // R.id.btnLogin correspond à l'id du bouton dans XML
        btnLogin = findViewById(R.id.btnLogin);


        // Récupère le bouton SIGN UP depuis le fichier XML
        // R.id.btnSignUp correspond à l'id du bouton dans XML
        btnSignUp = findViewById(R.id.btnSignUp);



        // Détecte lorsque l'utilisateur clique sur LOGIN
        btnLogin.setOnClickListener(v -> {


            // Création d'un Intent
            // Il permet de passer de MainActivity
            // vers LoginActivity
            Intent intent = new Intent(
                    MainActivity.this,     // Activity actuelle
                    LoginActivity.class   // Activity destination
            );


            // Lance LoginActivity
            startActivity(intent);
        });
        // Détecte lorsque l'utilisateur clique sur SIGN UP
        btnSignUp.setOnClickListener(v -> {


            // Création d'un Intent
            // Il permet de passer de MainActivity
            // vers SignUpActivity
            Intent intent = new Intent(
                    MainActivity.this,     // Activity actuelle
                    SignUpActivity.class  // Activity destination
            );


            // Lance SignUpActivity
            startActivity(intent);
        });
    }
}