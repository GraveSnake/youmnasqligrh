package ma.ensao.youmna;

import ma.ensao.youmna.util.Constants;
import ma.ensao.youmna.util.NetworkUtils;
import ma.ensao.youmna.util.User;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * Login Activity
 *
 */
public class LoginActivity extends Activity {

	private ProgressDialog progressDialog;
	public static final String PARAM_AUTHTOKEN_TYPE = Constants.AUTHTOKEN_TYPE;
	public static final String PARAM_ACCOUNT_TYPE = Constants.ACCOUNT_TYPE;
	private static AccountManager accountManager = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		accountManager = AccountManager.get(getApplicationContext());
		getActionBar().hide();
		if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE
				| (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
			getActionBar().show();
		}
		Account[] accounts = accountManager
				.getAccountsByType(PARAM_ACCOUNT_TYPE);
		Log.i("size", "" + accounts.length);
		if (accounts.length > 0) {

			NetworkUtils
					.prepareAuthHeader(getApplicationContext(), accounts[0]);
//			UserDataUtils.prepareUserData(getApplicationContext(), accounts[0]);
			Intent intent = new Intent(this, ManageListActivity.class);
			startActivity(intent);
			finish();
		}
		
		setContentView(R.layout.main_login);
		
	}

	
	@SuppressLint("ShowToast")
	public void login(View view) {

		String login = ((EditText) findViewById(R.id.loginEditText)).getText()
				.toString();
		String password = ((EditText) findViewById(R.id.passwordEditText))
				.getText().toString();
		
		if (!TextUtils.isEmpty(login) && !TextUtils.isEmpty(password)) {
			LoginThread loginThread = new LoginThread(this);
			loginThread.execute(login, password);
			progressDialog = ProgressDialog.show(LoginActivity.this, "",
					"Connexion en cours...");

		} else {
			Toast.makeText(this, getResources().getString(R.string.invalidLogin),
					Toast.LENGTH_SHORT);
			Log.i("error", "validation");
		}

	}
	
	private class LoginThread extends AsyncTask<String, Integer, Account> {

	    private final Context context;

		public LoginThread(Context context) {
			this.context = context;
		}
		@Override
		protected Account doInBackground(String... params) {

			String login = params[0];
			String password = params[1];

			Log.i(login, password);
			try {
				User userDto = new User();
				userDto.setId("");
				userDto.setUsername(login);
				userDto.setPassword(password);
				User userDataDto = NetworkUtils.authenticate(userDto);

				if (userDataDto != null) {
					Account account = new Account(login, PARAM_ACCOUNT_TYPE);
					Bundle userData = new Bundle();
					userData.putString(Constants.FIRST_NAME_KEY,
							userDataDto.getNom());
					userData.putString(Constants.LAST_NAME_KEY,
							userDataDto.getPrenom());
					userData.putString(Constants.AUTH_TOKEN_KEY,
							userDataDto.getPassword());
					userData.putString(Constants.USER_ID_KEY,
							userDataDto.getId() + "");
					userData.putString(Constants.USER_AUTHORITY,
							userDataDto.getAuthority() + "");

					Log.i("info","beforeAddAccountExplicity");
					
					if (accountManager.addAccountExplicitly(account, password,
							userData)) {
						NetworkUtils.prepareAuthHeader(getApplicationContext(),
								account);
//						UserDataUtils.prepareUserData(getApplicationContext(),
//								account);

						Log.i("add account", "success");

						return account;
					} else {
						progressDialog.dismiss();
						Log.i("add account", "fail");
						return null;
					}

				} else {
					progressDialog.dismiss();
					Log.i("error", "login");
					return null;

				}

			} catch (Exception e) {
				Log.i("error", "connexion :" + e.getMessage());
				progressDialog.dismiss();
				return null;
			}

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Account result) {
			if (result != null) {
				Intent intent = new Intent(context,
						ManageListActivity.class);
				startActivity(intent);

				progressDialog.dismiss();
				finish();
			}
			progressDialog.dismiss();
		}

	}
	
}
