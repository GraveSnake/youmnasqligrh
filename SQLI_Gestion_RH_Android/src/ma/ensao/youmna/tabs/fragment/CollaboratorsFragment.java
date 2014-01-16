package ma.ensao.youmna.tabs.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import ma.ensao.youmna.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Collaborator Fragment
 */
public class CollaboratorsFragment extends ListFragment {

	// ArrayList thats going to hold the search results
	ArrayList<HashMap<String, Object>> searchResults;

	// ArrayList that will hold the original Data
	ArrayList<HashMap<String, Object>> originalValues;
	LayoutInflater inflater;
	Integer[] photos = { R.drawable.m_manager, R.drawable.f_manager};;

	
	public void fill_Collaborators(){

		// temporary HashMap for populating the
		// Items in the ListView
//		HashMap<String, Object> temp;
		// now populate the ArrayList players
//		for (int i = 0; i < noOfPlayers; i++) {
//			temp = new HashMap<String, Object>();
//
//			temp.put("name", names[i]);
//			temp.put("team", teams[i]);
//			temp.put("photo", photos[i]);

			// add the row to the ArrayList
//			originalValues.add(temp);
		}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_collaborators,
				container, false);
		final EditText searchBox = (EditText) rootView
				.findViewById(R.id.searchBox);
		originalValues = new ArrayList<HashMap<String,Object>>();
		
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
					String playerName = originalValues.get(i).get("name")
							.toString();
					if (textLength <= playerName.length()) {
						// compare the String in EditText with Names in the
						// ArrayList
						if (searchString.equalsIgnoreCase(playerName.substring(
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
		originalValues = new ArrayList<HashMap<String, Object>>();

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
}