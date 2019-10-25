import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class EMGMainFrame {

	private XYChart.Series series;
	private LineChart<Number, Number> lineChart;
	private Stage stage;
	private Scene scene;
	private NumberAxis xAxis;
	private NumberAxis yAxis;

	public EMGMainFrame(Stage stage) {
		this.stage = stage;
		this.stage.setTitle("Graphique EMG");
		xAxis = new NumberAxis();
		yAxis = new NumberAxis();
		xAxis.setLabel("Temps");
		lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("Graphe EMG");
		series = new XYChart.Series();
		series.setName("Amplitude du signal EMG");
		// populating the series with data
		/*
		 * series.getData().add(new XYChart.Data(1, 23)); series.getData().add(new
		 * XYChart.Data(2, 14));
		 */

		scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);

		stage.setScene(scene);
		stage.show();

		refreshGraph();

	}

	public void addValue(long i, float j) {
		// TODO Auto-generated method stub
		series.getData().add(new XYChart.Data(i, j));
	}

	public void refreshGraph() {
		//Blocage ici, sur set scene
	}

}