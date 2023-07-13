package com.example.simpleasynctask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*** L'application SimpleAsyncTask contient un bouton qui lance une AsyncTask* qui dort dans le thread asynchrone pendant une durée aléatoire.*/
public class MainActivity extends AppCompatActivity {

    // Le TextView où nous afficherons les résultats
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView1);

        if(savedInstanceState!=null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        // Placer un message dans la vue texte
        mTextView.setText(R.string.napping);
        // Démarre l'AsyncTask.
        new SimpleAsyncTask(mTextView).execute();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        // Enregistre l'état de TextView
        outState.putString(TEXT_STATE,mTextView.getText().toString());
    }
}