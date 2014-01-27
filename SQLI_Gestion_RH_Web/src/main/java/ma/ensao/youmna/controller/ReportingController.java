package ma.ensao.youmna.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.TechnologieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.BarChart;
import com.googlecode.charts4j.BarChartPlot;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Slice;

@Controller
public class ReportingController {

	@Autowired
	private CollaborateurService collaborateurService;

	@Autowired
	private TechnologieService technologieService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("reporting")
	public ModelAndView reporting() {
		// Ratio F/M
		int male = collaborateurService.getAllCollaborateurs('M');
		int female = collaborateurService.getAllCollaborateurs('F');
		float malePercent = (male * 100) / (male + female);
		float femalePercent = (female * 100) / (male + female);
		Slice s1 = Slice.newSlice((int) malePercent, Color.newColor("CACACA"),
				String.valueOf(malePercent + "% "), "Male");
		Slice s2 = Slice.newSlice((int) femalePercent,
				Color.newColor("DF7417"), String.valueOf(femalePercent + "% "),
				"Female");
		PieChart chartpi = GCharts.newPieChart(s1, s2);
		chartpi.setTitle("Ratio Female Male", Color.BLACK, 16);
		chartpi.setSize(500, 200);
		chartpi.setThreeD(true);

		// Ratio recrus/année
		List<String> date = new ArrayList<String>();
		List<Long> numberRecrus = new ArrayList<Long>();
		Map<String, Long> recrusByYear = new TreeMap<String, Long>(
				collaborateurService.getRecrByYear());

		for (Map.Entry entry : recrusByYear.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
			date.add(((String) entry.getKey()));
			numberRecrus.add((Long) entry.getValue());
		}
		BarChartPlot team1 = Plots.newBarChartPlot(Data.newData(numberRecrus),
				Color.BLUEVIOLET);
		AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 13,
				AxisTextAlignment.CENTER);
		AxisLabels number = AxisLabelsFactory.newAxisLabels("Number", 50.0);
		number.setAxisStyle(axisStyle);
		AxisLabels year = AxisLabelsFactory.newAxisLabels("Year", 50.0);
		year.setAxisStyle(axisStyle);

		BarChart chartComp = GCharts.newBarChart(team1);

		chartComp.addXAxisLabels(AxisLabelsFactory.newAxisLabels(date));
		chartComp.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0,
				500));
		chartComp.addYAxisLabels(number);
		chartComp.addXAxisLabels(year);
		chartComp.setSize(550, 350);
		chartComp.setBarWidth(BarChart.AUTO_RESIZE);
		chartComp.setSpaceWithinGroupsOfBars(20);
		chartComp.setDataStacked(true);
		chartComp.setTitle("Ratio", Color.BLACK, 16);
		// chartComp.setGrid(10, 600,3, 2);
		chartComp.setGrid(100, 10, 3, 2);
		chartComp.setBackgroundFill(Fills.newSolidFill(Color.ALICEBLUE));
		LinearGradientFill fillComp = Fills.newLinearGradientFill(0,
				Color.LAVENDER, 100);
		fillComp.addColorAndOffset(Color.WHITE, 0);
		chartComp.setAreaFill(fillComp);

		ModelAndView mav = new ModelAndView("reporting");
		mav.addObject("mapRec", recrusByYear);
		mav.addObject("chartRatioRecrusUrl", chartComp.toURLString());
		mav.addObject("chartRatioUrl", chartpi.toURLString());
		return mav;

	}
}
