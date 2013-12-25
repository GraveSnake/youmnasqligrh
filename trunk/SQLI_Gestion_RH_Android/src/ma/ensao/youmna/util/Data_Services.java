package ma.ensao.youmna.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Data_Services {

    public JSONObject getServerData( String URL ) {
        InputStream is = null;
        String result = "";
        JSONObject jArray = null;

        // Envoyer la requÃªte au script PHP.
        // Envoie de la commande http
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost( URL );
            HttpResponse response = httpclient.execute( httppost );
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

        } catch ( Exception e ) {
            Log.e( "log_tag", "Error in http connection " + e.toString() );
        }

        // Convertion de la requete en string
        try {
            // InputStreamReader contient un tampon d'octets lus a  partir du
            // flux source et
            // les convertit en caracteres si ncessaire. La taille du tampon
            // est 8K.
            BufferedReader reader = new BufferedReader( new InputStreamReader(
                    is, "iso-8859-1" ), 8 );
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ( ( line = reader.readLine() ) != null ) {
                sb.append( line + "\n" );
            }
            is.close();
            result = sb.toString();
            Log.e( "log_tag", "Resultat du fichier php" + result );
            // Toast.makeText(AccueilGridActivity.this, "nb regs : "+i,
            // Toast.LENGTH_LONG).show();

        } catch ( Exception e ) {
            Log.e( "log_tag", "Error converting result " + e.toString() );
        }
        // Parse les donnes JSON
        try {
            jArray = new JSONObject( result );
        } catch ( JSONException e ) {
            Log.e( "log_tag", "Error parsing data " + e.toString() );
        }

        return jArray;

    }

}
