import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class EMGMainFrame {

	private XYChart.Series series;

	public EMGMainFrame(Stage stage) {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated method stub
        stage.setTitle("Graphique EMG");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Temps");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Graphe EMG");
        series = new XYChart.Series();
        series.setName("Amplitude du signal EMG");
        //populating the series with data
        /*series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        */
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();	
	}

	public void addValue(int i, int j) {
		// TODO Auto-generated method stub
		series.getData().add(new XYChart.Data(i, j));
	}

}