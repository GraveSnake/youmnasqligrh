package ma.ensao.youmna.tabs.fragment;

import ma.ensao.youmna.R;
import ma.ensao.youmna.util.Constants;
import ma.ensao.youmna.util.NetworkUtils;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Home Fragment
 */
public class HomeFragment extends Fragment {
	
	ProgressDialog progressDialog;
	private Integer number = 0; 
	private Integer numberMgrs = 0;
	private String Nom;
	private String Prenom;
	private String Role;
	private String ID;
	private TextView stats;
	
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//		
////		if(NetworkUtils.CheckReachability()){
//        CountThread count = new CountThread(getActivity());
//        count.execute();
////		}
//	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView bienvenue = (TextView) rootView.findViewById(R.id.bienvenue);
        stats = (TextView) rootView.findViewById(R.id.stats);
        
        Nom = AccountManager.get(getActivity()).getUserData(NetworkUtils.account, Constants.LAST_NAME_KEY);
        Prenom = AccountManager.get(getActivity()).getUserData(NetworkUtils.account, Constants.FIRST_NAME_KEY);
        Role = AccountManager.get(getActivity()).getUserData(NetworkUtils.account, Constants.USER_AUTHORITY);
        ID = AccountManager.get(getActivity()).getUserData(NetworkUtils.account, Constants.USER_ID_KEY);
        
		progressDialog = ProgressDialog.show(getActivity(), "", "Chargement...", true, true);
        
        bienvenue.setText("Bienvenue : "+Nom+" "+Prenom);
        if((Constants.ROLE_MAN).equals(Role))
		{
          CountThread count = new CountThread(getActivity(), ID);
          count.execute();
//			number = NetworkUtils.getRestObject(Integer.class, "/count?mode={query}", ID);
//			stats.setText("");
			stats.append("Nombre des Collaborateurs gérés : "+number);
		}
		else if((Constants.ROLE_ADMIN).equals(Role)){
//			stats.setText("");
	        CountThread count = new CountThread(getActivity(), "ALL");
	        count.execute();
	        stats.append("Nombre Total des Collaborateurs : "+number);
			stats.append("\nNombre Total des Managers : "+numberMgrs);
		}
//        CountThread count = new CountThread(getActivity());
//        count.execute();
        return rootView;
    }
    
    
	private class CountThread extends AsyncTask<String, Integer, Integer> {

	    private final Context context;
	    private String mode;
	    
		public CountThread(Context context, String mode) {
			this.context = context;
			this.mode = mode;
		}

		
		@Override
		protected Integer doInBackground(String... params) {
			
			try {
				if("ALL".equals(mode))
				{
					numberMgrs = NetworkUtils.getRestObject(Integer.class, "/count?mode={query}", "MAN");
					number = NetworkUtils.getRestObject(Integer.class, "/count?mode={query}", "ALL");
				}
				else
					number = NetworkUtils.getRestObject(Integer.class, "/count?mode={query}", mode);
			} catch (Exception e) {
//				Toast.makeText(context, "Connexion au serveur échouée", Toast.LENGTH_SHORT).show();
				return 1;
			}
			return 0;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Integer number) {
			progressDialog.dismiss();
		}

	}
}