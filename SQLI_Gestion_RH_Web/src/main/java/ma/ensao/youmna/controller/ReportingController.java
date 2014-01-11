package ma.ensao.youmna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Slice;

@Controller
public class ReportingController {
	
	
	@RequestMapping("reporting")
	public ModelAndView reporting() {
		//Salaire
        Plot plot = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart = GCharts.newLineChart(plot);
        chart.addYAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart.addXAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart.setSize(400, 200);
        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score = AxisLabelsFactory.newAxisLabels("Salaire", 50.0);
        score.setAxisStyle(axisStyle);
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year.setAxisStyle(axisStyle);
        chart.addYAxisLabels(score);
        chart.addXAxisLabels(year);
        
        //Poste
        Plot plot2 = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart2 = GCharts.newLineChart(plot2);
        chart2.addYAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart2.addXAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart2.setSize(400, 200);
        AxisStyle axisStyle2 = AxisStyle.newAxisStyle(Color.BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score2 = AxisLabelsFactory.newAxisLabels("Poste", 50.0);
        score2.setAxisStyle(axisStyle2);
        AxisLabels year2 = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year2.setAxisStyle(axisStyle);
        chart2.addYAxisLabels(score);
        chart2.addXAxisLabels(year);
        
        //Ratio
        Slice s1 = Slice.newSlice(70, Color.newColor("CACACA"), "Masculin", "Masculin");
        Slice s2 = Slice.newSlice(30, Color.newColor("DF7417"), "Feminin", "Feminin");

        PieChart chartpi = GCharts.newPieChart(s1, s2);
        chartpi.setTitle("Ratio Feminin Masculin", Color.BLACK, 16);
        chartpi.setSize(500, 200);
        chartpi.setThreeD(true);
        
        ModelAndView mav=new ModelAndView("reporting");
        mav.addObject("chartSalaireUrl", chart.toURLString());
        mav.addObject("chartPosteUrl", chart2.toURLString());
        mav.addObject("chartRatioUrl", chartpi.toURLString());
		return mav;
	}

	

}
