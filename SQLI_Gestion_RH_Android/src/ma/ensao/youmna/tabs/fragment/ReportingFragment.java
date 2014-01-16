package ma.ensao.youmna.tabs.fragment;

import ma.ensao.youmna.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Reporting Fragment
 */
public class ReportingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reporting, container, false);
//        TextView v = (TextView)rootView.findViewById(R.id.text3);
        
        return rootView;
    }
}