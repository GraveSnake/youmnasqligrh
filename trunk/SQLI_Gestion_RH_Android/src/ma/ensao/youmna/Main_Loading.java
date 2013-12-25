package ma.ensao.youmna;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Main_Loading extends Activity {
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_loading);

        Traitement trait = new Traitement();
        trait.execute();
    }

    private class Traitement extends AsyncTask<Void, Integer, Void>
    {
        private ProgressBar mProgressBar = (ProgressBar) findViewById( R.id.progressBar );

        @Override
        protected void onProgressUpdate( Integer... values ) {
            super.onProgressUpdate( values );
            // Mise à jour de la barre de progression
            mProgressBar.setProgress( values[0] );
        }

        @Override
        protected Void doInBackground( Void... arg0 ) {

            // json1 = getServerData( URLCATEGORIE );
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

            int progress;
            for ( progress = 0; progress <= 1000; progress++ )
            {
                for ( int i = 0; i < 100; i++ ) {
                }
                // la méthode publishProgress met à jour l'interface en
                // invoquant la méthode onProgressUpdate
                publishProgress( progress );
                progress++;
            }
            return null;
        }

        @Override
        protected void onPostExecute( Void result ) {
            final Intent intent = new Intent( Main_Loading.this, Main_Login.class );
            startActivity( intent );
            finish();
        }
    }
    
}
