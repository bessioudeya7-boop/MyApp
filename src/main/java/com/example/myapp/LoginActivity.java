package com.example.myapp;


// Intent permet de passer d'une Activity à une autre
import android.content.Intent;

// Bundle permet de transporter des données entre les Activities
import android.os.Bundle;

// Button représente un bouton
import android.widget.Button;

// EditText représente un champ de saisie
import android.widget.EditText;

// TextView représente un texte dans l'interface
import android.widget.TextView;

// Toast permet d'afficher un petit message à l'écran
import android.widget.Toast;

// Classe de base pour notre Activity
import androidx.appcompat.app.AppCompatActivity;


// Activity de connexion
public class LoginActivity extends AppCompatActivity {


    // --------------------------------------------------
    // CONSTANTES POUR LE BUNDLE
    // --------------------------------------------------

    // Nom utilisé pour identifier le Bundle envoyé
    public static final String EXTRA_BUNDLE = "user_bundle";

    // Clé utilisée pour stocker le nom
    public static final String KEY_NAME = "name";

    // Clé utilisée pour stocker l'email
    public static final String KEY_EMAIL = "email";


    // Champ Email
    EditText email;

    // Champ Password
    EditText password;

    // Bouton Login
    Button btnLogin;

    // Texte "Sign Up"
    TextView txtSignUp;

    // Texte de bienvenue
    TextView tvWelcome;


    // --------------------------------------------------
    // MÉTHODE ONCREATE
    // --------------------------------------------------

    // Cette méthode est appelée lorsque LoginActivity est créée
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Appelle la méthode onCreate() de la classe parent
        super.onCreate(savedInstanceState);


        // Charge le fichier XML de LoginActivity
        setContentView(R.layout.activity_login);


        // --------------------------------------------------
        // RÉCUPÉRER LES COMPOSANTS DU XML
        // --------------------------------------------------

        // Récupère le champ Email
        email = findViewById(R.id.email);

        // Récupère le champ Password
        password = findViewById(R.id.password);

        // Récupère le bouton LOGIN
        btnLogin = findViewById(R.id.btnLogin);

        // Récupère le texte SIGN UP
        txtSignUp = findViewById(R.id.txtSignUp);

        // Récupère le TextView de bienvenue
        tvWelcome = findViewById(R.id.tvWelcome);


        // --------------------------------------------------
        // RECEVOIR LES DONNÉES DE SIGNUPACTIVITY
        // --------------------------------------------------

        // Récupère l'Intent qui a lancé LoginActivity
        Intent intent = getIntent();


        // Récupère le Bundle envoyé avec l'Intent
        Bundle bundle = intent.getBundleExtra(EXTRA_BUNDLE);


        // Vérifie si un Bundle a bien été reçu
        if (bundle != null) {


            // Récupère le nom contenu dans le Bundle
            String name = bundle.getString(
                    KEY_NAME,
                    ""
            );


            // Récupère l'email contenu dans le Bundle
            String emailText = bundle.getString(
                    KEY_EMAIL,
                    ""
            );


            // Affiche le nom dans le message de bienvenue
            tvWelcome.setText("Welcome " + name);


            // Remplit automatiquement le champ Email
            email.setText(emailText);
        }


        // --------------------------------------------------
        // BOUTON LOGIN
        // --------------------------------------------------

        // Détecte lorsque l'utilisateur clique sur LOGIN
        btnLogin.setOnClickListener(v -> {


            // Récupère l'email saisi par l'utilisateur
            // trim() supprime les espaces au début et à la fin
            String emailText =
                    email.getText().toString().trim();


            // Récupère le mot de passe saisi
            String passwordText =
                    password.getText().toString();


            // Vérifie si l'un des deux champs est vide
            if (emailText.isEmpty() ||
                    passwordText.isEmpty()) {


                // Affiche un message à l'utilisateur
                Toast.makeText(
                        this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                ).show();


                // Arrête l'exécution du code ici
                return;
            }


            // --------------------------------------------------
            // CRÉER UN BUNDLE POUR L'UTILISATEUR
            // --------------------------------------------------

            // Création d'un nouveau Bundle
            Bundle userBundle = new Bundle();


            // Ajoute l'email dans le Bundle
            // "user_email" est la clé
            // emailText est la valeur
            userBundle.putString(
                    "user_email",
                    emailText
            );


            // --------------------------------------------------
            // ALLER VERS CARS ACTIVITY
            // --------------------------------------------------

            // Création d'un Intent
            // Départ : LoginActivity
            // Destination : CarsActivity
            Intent carsIntent = new Intent(
                    LoginActivity.this,
                    CarsActivity.class
            );


            // Ajoute le Bundle à l'Intent
            carsIntent.putExtra(
                    "user_data",
                    userBundle
            );


            // Lance CarsActivity
            startActivity(carsIntent);
        });


        // --------------------------------------------------
        // BOUTON / TEXTE SIGN UP
        // --------------------------------------------------

        // Détecte le clic sur "Sign Up"
        txtSignUp.setOnClickListener(v -> {


            // Création d'un Intent
            // Départ : LoginActivity
            // Destination : SignUpActivity
            Intent signupIntent = new Intent(
                    LoginActivity.this,
                    SignUpActivity.class
            );


            // Ouvre SignUpActivity
            startActivity(signupIntent);
        });
    }
}