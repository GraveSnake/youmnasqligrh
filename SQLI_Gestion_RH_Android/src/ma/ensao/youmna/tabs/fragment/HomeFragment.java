package ma.ensao.youmna.tabs.fragment;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ma.ensao.youmna.R;
import ma.ensao.youmna.util.Constants;
import ma.ensao.youmna.util.NetworkUtils;

import org.springframework.web.client.ResourceAccessException;

import android.accounts.AccountManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Home Fragment
 */
public class HomeFragment extends Fragment {

	private Integer number = 0;
	private Integer numberMgrs = 0;
	private String Nom;
	private String Prenom;
	private String Role;
	private TextView stats;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);
		TextView bienvenue = (TextView) rootView.findViewById(R.id.bienvenue);
		stats = (TextView) rootView.findViewById(R.id.stats);

		Nom = AccountManager.get(getActivity()).getUserData(
				NetworkUtils.account, Constants.LAST_NAME_KEY);
		Prenom = AccountManager.get(getActivity()).getUserData(
				NetworkUtils.account, Constants.FIRST_NAME_KEY);
		Role = AccountManager.get(getActivity()).getUserData(
				NetworkUtils.account, Constants.USER_AUTHORITY);
		
		bienvenue.setText("Bienvenue : " + Prenom + " " +Nom );
		if ((Constants.ROLE_MAN).equals(Role)) {

			CountThread count = new CountThread(getActivity(), Nom);
			count.execute();
			try {
				count.get(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
			if(number!=null) stats.setText("Nombre des Collaborateurs gérés : " + number);
			
		} else if ((Constants.ROLE_ADMIN).equals(Role)) {

			CountThread count = new CountThread(getActivity(), "ALL");
			count.execute();
			try {
				count.get(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
			if(number!=null) stats.setText("Nombre Total des Collaborateurs : " + number);
			if(numberMgrs!=null) stats.append("\nNombre Total des Managers : " + numberMgrs);
			
		}

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
				if ("ALL".equals(mode)) {
					numberMgrs = NetworkUtils.callWebService(Integer.class, "/count?mode={query}", "MAN");

					number = NetworkUtils.callWebService(Integer.class,
							"/count?mode={query}", "ALL");
				} else {
					number = NetworkUtils.callWebService(Integer.class,
							"/count?mode={query}", mode);
				}
			} catch (ResourceAccessException exc) {
				return Constants.TIMEOUT;
			} catch (Exception e) {
				Log.i("error", "connexion :" + e.getMessage());
				return Constants.EXCEPTION;
			}
			return Constants.SUCCESS;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Integer status) {
			switch (status) {
			case Constants.SUCCESS:
				break;
			case Constants.TIMEOUT:
				Toast.makeText(context, R.string.serverError,
						Toast.LENGTH_SHORT).show();
				break;
			case Constants.EXCEPTION:
				Toast.makeText(context, R.string.serverError,
						Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}

	}
}