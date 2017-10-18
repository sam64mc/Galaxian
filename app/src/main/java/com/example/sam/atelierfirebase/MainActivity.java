package com.example.sam.atelierfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mDbRef = database.getReference("Joueurs");

        final EditText prenom = (EditText) findViewById(R.id.prenom);
        final EditText mdp = (EditText) findViewById(R.id.mdp);
        final EditText score = (EditText) findViewById(R.id.score);
        Button boutonEnvoyer = (Button) findViewById(R.id.envoyer);
        final Button theBest = (Button)findViewById(R.id.theBest);

        boutonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String joueurPrenom = prenom.getText().toString();
                String joueurMdp = mdp.getText().toString();
                String joueurScore = score.getText().toString();


                final UserModels joueurs = new UserModels(joueurPrenom, joueurMdp, joueurScore);


                mDbRef.push().setValue(joueurs);
            }
        });

        theBest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatabaseReference studentRef = database.getReference("Joueurs");
                studentRef.orderByChild("score").limitToLast(1)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                                    UserModels joueurs = studentSnapshot.getValue(UserModels.class);
                                    Toast.makeText(MainActivity.this, joueurs.getPrenom() + " " +joueurs.getScore(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {}
                        });

            }
        });

    }

}
