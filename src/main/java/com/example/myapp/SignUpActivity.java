// Package de notre application
package com.example.myapp;


// Intent permet de passer d'une Activity à une autre
import android.content.Intent;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


// Activity d'inscription
public class SignUpActivity extends AppCompatActivity {

    EditText fullName;


    EditText email;
    EditText phone;
    EditText password;
    EditText confirmPassword;

    Button btnSignUp;

    // Cette méthode est appelée lorsque SignUpActivity
    // est créée
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Appelle la méthode onCreate() de la classe parent
        super.onCreate(savedInstanceState);


        // l'activité utilsie l'interface activity_signup.xml
        setContentView(R.layout.activity_signup);



        // recupere de l'xml à java
        fullName = findViewById(R.id.fullName);

        // Récupère le champ Email
        email = findViewById(R.id.email);

        // Récupère le champ Phone
        phone = findViewById(R.id.phone);

        // Récupère le champ Password
        password = findViewById(R.id.password);

        // Récupère le champ Confirm Password
        confirmPassword = findViewById(R.id.confirmPassword);

        // Récupère le bouton SIGN UP
        btnSignUp = findViewById(R.id.btnSignUp);



        // lorsque l'utilisateur clique le code entre code s'execute
        btnSignUp.setOnClickListener(v -> {

            // trim() supprime les espaces inutiles
            String name =
                    fullName.getText().toString().trim();


            // Récupère l'email saisi
            String emailText =
                    email.getText().toString().trim();


            // Récupère le numéro de téléphone
            String phoneText =
                    phone.getText().toString().trim();


            // Récupère le mot de passe
            String passwordText =
                    password.getText().toString();


            // Récupère la confirmation du mot de passe
            String confirmText =
                    confirmPassword.getText().toString();


            // Vérifie si au moins un champ est vide
            if (name.isEmpty() ||
                    emailText.isEmpty() ||
                    phoneText.isEmpty() ||
                    passwordText.isEmpty() ||
                    confirmText.isEmpty()) {


                // Affiche un message à l'utilisateur
                Toast.makeText(
                        this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT//temporaire
                ).show();


                // Arrête l'exécution du code
                return;
            }

            // Vérifie si le mot de passe
            // est différent de sa confirmation
            if (!passwordText.equals(confirmText)) {


                // Affiche un message d'erreur
                Toast.makeText(
                        this,
                        "Passwords do not match",
                        Toast.LENGTH_SHORT
                ).show();


                // Arrête l'exécution du code
                return;
            }

            // Le Bundle va transferer les donnés d'une activité d'une acrivité à une autre
            Bundle bundle = new Bundle();


            // Ajoute le nom dans le Bundle
            // KEY_NAME = "name"
            bundle.putString(
                    LoginActivity.KEY_NAME,
                    name
            );


            // Ajoute l'email dans le Bundle
            // KEY_EMAIL = "email"
            bundle.putString(
                    LoginActivity.KEY_EMAIL,
                    emailText
            );



            // Création d'un Intent
            // Activity actuelle : SignUpActivity
            // Activity destination : LoginActivity
            Intent intent = new Intent(
                    SignUpActivity.this,
                    LoginActivity.class
            );



            // Ajoute le Bundle dans l'Intent
            // EXTRA_BUNDLE permet d'identifier les données
            intent.putExtra(
                    LoginActivity.EXTRA_BUNDLE,
                    bundle
            );


            // ==================================================
            // LANCER LOGINACTIVITY
            // ==================================================

            // Ouvre LoginActivity
            startActivity(intent);


            // Ferme SignUpActivity
            // L'utilisateur ne revient pas sur la page
            // d'inscription avec le bouton retour
            finish();
        });
    }
}