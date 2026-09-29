// Package de notre application
package com.example.myapp;


// Import de Intent
// Intent permet de passer d'une Activity à une autre
import android.content.Intent;

// Import de Bundle
// Bundle permet de transporter des données entre les Activities
import android.os.Bundle;

// Import de Button
// Permet d'utiliser les boutons
import android.widget.Button;

// Import de TextView
// Permet d'afficher du texte
import android.widget.TextView;

// Classe de base pour créer une Activity Android
import androidx.appcompat.app.AppCompatActivity;


// Activity qui affiche les voitures disponibles
public class CarsActivity extends AppCompatActivity {


    // --------------------------------------------------
    // DÉCLARATION DES COMPOSANTS
    // --------------------------------------------------

    // TextView qui va afficher l'email de l'utilisateur
    TextView tvUser;

    // Bouton pour choisir la BMW
    Button btnCar1;

    // Bouton pour choisir la Mercedes
    Button btnCar2;


    // --------------------------------------------------
    // MÉTHODE ONCREATE
    // --------------------------------------------------

    // Méthode appelée lorsque CarsActivity est créée
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Appelle la méthode onCreate() de la classe parent
        super.onCreate(savedInstanceState);


        // Charge l'interface graphique activity_cars.xml
        setContentView(R.layout.activity_cars);


        // --------------------------------------------------
        // RÉCUPÉRER LES ÉLÉMENTS DU XML
        // --------------------------------------------------

        // Récupère le TextView avec l'id tvUser
        tvUser = findViewById(R.id.tvUser);

        // Récupère le bouton BMW
        btnCar1 = findViewById(R.id.btnCar1);

        // Récupère le bouton Mercedes
        btnCar2 = findViewById(R.id.btnCar2);


        // --------------------------------------------------
        // RECEVOIR LES DONNÉES DE LOGINACTIVITY
        // --------------------------------------------------

        // Récupère l'Intent qui a lancé CarsActivity
        Intent intent = getIntent();


        // Récupère le Bundle envoyé par LoginActivity
        // "user_data" est la clé utilisée pour identifier le Bundle
        Bundle bundle = intent.getBundleExtra("user_data");


        // Vérifie si le Bundle existe
        if (bundle != null) {


            // Récupère l'email qui se trouve dans le Bundle
            // "user_email" est la clé utilisée dans LoginActivity
            String email = bundle.getString(
                    "user_email",
                    ""
            );


            // Affiche l'email dans le TextView
            // Exemple : Welcome user@gmail.com
            tvUser.setText("Welcome " + email);
        }


        // --------------------------------------------------
        // BOUTON BMW
        // --------------------------------------------------

        // Détecte le clic sur le bouton BMW
        btnCar1.setOnClickListener(v -> {

            // Appelle la méthode openBooking()
            // avec :
            // BMW Serie 3 = nom de la voiture
            // 120 = prix par jour
            openBooking(
                    "BMW Serie 3",
                    120
            );
        });


        // --------------------------------------------------
        // BOUTON MERCEDES
        // --------------------------------------------------

        // Détecte le clic sur le bouton Mercedes
        btnCar2.setOnClickListener(v -> {

            // Appelle la méthode openBooking()
            // avec :
            // Mercedes Class A = nom de la voiture
            // 150 = prix par jour
            openBooking(
                    "Mercedes Class A",
                    150
            );
        });
    }


    // --------------------------------------------------
    // MÉTHODE OPENBOOKING
    // --------------------------------------------------

    // Cette méthode permet d'envoyer les informations
    // de la voiture vers BookingActivity
    private void openBooking(String carName, int price) {


        // Création d'un Bundle
        // Il va contenir les informations de la voiture
        Bundle carBundle = new Bundle();


        // Ajoute le nom de la voiture dans le Bundle
        // carName contient par exemple "BMW Serie 3"
        carBundle.putString(
                "car_name",
                carName
        );


        // Ajoute le prix dans le Bundle
        // price contient par exemple 120
        carBundle.putInt(
                "car_price",
                price
        );


        // --------------------------------------------------
        // CRÉATION DE L'INTENT
        // --------------------------------------------------

        // Création d'un Intent
        // Départ : CarsActivity
        // Destination : BookingActivity
        Intent intent = new Intent(
                CarsActivity.this,
                BookingActivity.class
        );


        // Ajoute le Bundle dans l'Intent
        // "car_data" est la clé permettant
        // de récupérer ce Bundle dans BookingActivity
        intent.putExtra(
                "car_data",
                carBundle
        );


        // Lance BookingActivity
        startActivity(intent);
    }
}