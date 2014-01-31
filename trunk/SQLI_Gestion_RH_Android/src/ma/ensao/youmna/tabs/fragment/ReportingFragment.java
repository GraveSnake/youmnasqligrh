package ma.ensao.youmna.tabs.fragment;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ma.ensao.youmna.R;
import ma.ensao.youmna.util.Constants;
import ma.ensao.youmna.util.NetworkUtils;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.AbstractChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.springframework.web.client.ResourceAccessException;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Reporting Fragment
 */
public class ReportingFragment extends Fragment {

	private Integer masculins = 0;
	private Integer feminins = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_reporting,
				container, false);
		LinearLayout chartContainer = (LinearLayout) rootView
				.findViewById(R.id.reporting_layout);

		RatioThread getRatio = new RatioThread(getActivity());
		getRatio.execute();
		try {
			getRatio.get(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		TextView ratio = new TextView(getActivity());
		ratio.setText("Ratio Féminin/Masculins");
		ratio.setPadding(0, 100, 0, 0);
		ratio.setTextSize(20);
		ratio.setGravity(Gravity.CENTER);
		chartContainer.addView(ratio);
		GraphicalView chartView = PieChartView.getNewInstance(getActivity(),
				masculins, feminins);
		chartContainer.addView(chartView);
		return rootView;
	}

	public static class PieChartView extends GraphicalView {

		/**
		 * Constructor that only calls the super method. It is not used to
		 * instantiate the object from outside of this class.
		 * 
		 * @param context
		 * @param arg1
		 */
		private PieChartView(Context context, AbstractChart arg1) {
			super(context, arg1);
		}

		/**
		 * This method returns a new graphical view as a pie chart view. It uses
		 * the income and costs and the static color constants of the class to
		 * create the chart.
		 * 
		 * @param context
		 *            the context
		 * @param masc
		 *            total men
		 * @param fem
		 *            total women
		 * @return a GraphicalView object as a pie chart
		 */
		public static GraphicalView getNewInstance(Context context, int masc,
				int fem) {
			return ChartFactory.getPieChartView(context,
					getDataSet(context, masc, fem), getRenderer());
		}

		/**
		 * Creates the renderer for the pie chart and sets the basic color
		 * scheme and hides labels and legend.
		 * 
		 * @return a renderer for the pie chart
		 */
		private static DefaultRenderer getRenderer() {
			int[] colors = new int[] { Constants.COLOR_ORANGE,
					Constants.COLOR_BLUE };

			DefaultRenderer defaultRenderer = new DefaultRenderer();
			for (int color : colors) {
				SimpleSeriesRenderer simpleRenderer = new SimpleSeriesRenderer();
				simpleRenderer.setColor(color);
				defaultRenderer.addSeriesRenderer(simpleRenderer);
			}
			defaultRenderer.setShowLegend(false);
			defaultRenderer.setDisplayValues(true);
			defaultRenderer.setZoomEnabled(false);
			defaultRenderer.setPanEnabled(false);
			
			defaultRenderer.setLabelsTextSize(20);
			defaultRenderer.setLabelsColor(Color.BLACK);
			return defaultRenderer;
		}

		/**
		 * Creates the data set used by the PieChart by adding the string
		 * Representation and it's integer value to a CategorySeries object.
		 * Note that the string representations are hard coded.
		 */
		private static CategorySeries getDataSet(Context context, int masc,
				int fem) {
			CategorySeries series = new CategorySeries("Chart");
			series.add("Masculin",  Math.floor((Float.valueOf(masc)/Float.valueOf(masc+fem))*100 * 100) / 100);
			series.add("Féminin",  Math.floor((Float.valueOf(fem)/Float.valueOf(masc+fem))*100 * 100) / 100);
			return series;
		}
	}

	private class RatioThread extends AsyncTask<String, Integer, Integer> {

		private final Context context;

		public RatioThread(Context context) {
			this.context = context;
		}

		@Override
		protected Integer doInBackground(String... params) {

			try {
				masculins = NetworkUtils.callWebService(Integer.class,
						"/ratio?gender={query}", "M");
				feminins = NetworkUtils.callWebService(Integer.class,
						"/ratio?gender={query}", "F");

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
