package ma.ensao.youmna.tabs.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ma.ensao.youmna.R;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.util.Constants;
import ma.ensao.youmna.util.NetworkUtils;

import org.springframework.web.client.ResourceAccessException;

import android.accounts.AccountManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Collaborator Fragment
 */
public class CollaboratorsFragment extends ListFragment {

	// Collaborators List
	Collaborateur[] collaborators;
	
	// ArrayList thats going to hold the search results
	ArrayList<HashMap<String, Object>> searchResults;

	// ArrayList that will hold the original Data
	ArrayList<HashMap<String, Object>> originalValues;
	LayoutInflater inflater;
	
	// Collaborators Photos
	Integer[] photos = { R.drawable.m_manager, R.drawable.f_manager};;

	
	public void fill_Collaborators(){

		// temporary HashMap for populating the
		// Items in the ListView
		HashMap<String, Object> temp;
		// now populate the ArrayList
		for (int i = 0; i < collaborators.length; i++) {
			temp = new HashMap<String, Object>();

			temp.put("name", collaborators[i].getNom()+" "+collaborators[i].getPrenom());
			temp.put("team", collaborators[i].getPosteActuel3()+", "+collaborators[i].getPosteActuel4());
			temp.put("photo", (collaborators[i].getSexe() == 'M')? photos[0]:photos[1]);

			// add the row to the ArrayList
			originalValues.add(temp);
		}
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_collaborators,
				container, false);
		final EditText searchBox = (EditText) rootView
				.findViewById(R.id.searchBox);
		
		originalValues = new ArrayList<HashMap<String,Object>>();
		collaborators = new Collaborateur[] {};
		
		String role = AccountManager.get(getActivity()).getUserData(
				NetworkUtils.account, Constants.USER_AUTHORITY);
		String name = AccountManager.get(getActivity()).getUserData(
				NetworkUtils.account, Constants.LAST_NAME_KEY);
		
		if ((Constants.ROLE_MAN).equals(role)) {
			CollabThread getCollabs = new CollabThread(getActivity(), name);
			getCollabs.execute();
			try {
				getCollabs.get(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		} else if ((Constants.ROLE_ADMIN).equals(role)) {
			CollabThread count = new CollabThread(getActivity(), "ALL");
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
		}
		
		if (collaborators!=null) fill_Collaborators();
		
		// searchResults=OriginalValues initially
		searchResults = new ArrayList<HashMap<String, Object>>(originalValues);

		// create the adapter
		// first param-the context
		// second param-the id of the layout file
		// you will be using to fill a row
		// third param-the set of values that
		// will populate the ListView
		final CustomAdapter adapter = new CustomAdapter(getActivity(),
				R.layout.list_collaborator, searchResults);

		// finally,set the adapter to the default ListView
		setListAdapter(adapter);
		searchBox.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// get the text in the EditText
				String searchString = searchBox.getText().toString();
				int textLength = searchString.length();
				searchResults.clear();

				for (int i = 0; i < originalValues.size(); i++) {
					String collabName = originalValues.get(i).get("name")
							.toString();
					if (textLength <= collabName.length()) {
						// compare the String in EditText with Names in the
						// ArrayList
						if (searchString.equalsIgnoreCase(collabName.substring(
								0, textLength)))
							searchResults.add(originalValues.get(i));
					}
				}

				adapter.notifyDataSetChanged();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void afterTextChanged(Editable s) {
			}
		});
		//originalValues = new ArrayList<HashMap<String, Object>>();

		return rootView;
	}

	// define your custom adapter
	private class CustomAdapter extends ArrayAdapter<HashMap<String, Object>> {

		public CustomAdapter(Context context, int textViewResourceId,
				ArrayList<HashMap<String, Object>> Strings) {

			// let android do the initializing :)
			super(context, textViewResourceId, Strings);
		}

		// class for caching the views in a row
		private class ViewHolder {
			ImageView photo;
			TextView name, team;

		}

		ViewHolder viewHolder;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater
						.inflate(R.layout.list_collaborator, null);
				viewHolder = new ViewHolder();

				// cache the views
				viewHolder.photo = (ImageView) convertView
						.findViewById(R.id.img);
				viewHolder.name = (TextView) convertView
						.findViewById(R.id.titre);
				viewHolder.team = (TextView) convertView
						.findViewById(R.id.description);

				// link the cached views to the convertview
				convertView.setTag(viewHolder);

			} else
				viewHolder = (ViewHolder) convertView.getTag();

			int photoId = (Integer) searchResults.get(position).get("photo");

			// set the data to be displayed
			viewHolder.photo.setImageDrawable(getResources().getDrawable(
					photoId));
			viewHolder.name.setText(searchResults.get(position).get("name")
					.toString());
			viewHolder.team.setText(searchResults.get(position).get("team")
					.toString());

			// return the view to be displayed
			return convertView;
		}

	}
	
	private class CollabThread extends AsyncTask<String, Integer, Integer> {

		private final Context context;
		private String mode;

		public CollabThread(Context context, String mode) {
			this.context = context;
			this.mode = mode;
		}

		@Override
		protected Integer doInBackground(String... params) {

			try {
				if ("ALL".equals(mode)) {
					collaborators = NetworkUtils.callWebService(Collaborateur[].class,
							"/collaborators?mode={query}", "ALL");
				} else {
					collaborators = NetworkUtils.callWebService(Collaborateur[].class,
							"/collaborators?mode={query}", mode);
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