import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.PacketListener;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.wpan.IoSample;
import com.rapplogic.xbee.api.wpan.RxResponseIoSample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.EIBSample;
import model.EibListener;
import model.MaCentrale;

public class EMGLauncher extends Application implements EibListener {

	private static final String PORT_COM = "COM3";
	private EMGMainFrame emgGraph;
	private MaCentrale maCentrale;

	public static void main(String[] args) {

		Application.launch(EMGLauncher.class, args);
		// new EMGLauncher("COM3");
	}

	public EMGLauncher() {

		
//		Application.launch("EMGMainFrame");
//		emgGraph.addValue(2,3);

	}

	@Override
	public void start(Stage stage) {
		emgGraph = new EMGMainFrame(stage);

		maCentrale = new MaCentrale(PORT_COM);
		maCentrale.addEibListener(this);
		maCentrale.getBuffer();

		/*
		 * //Pre-determined test values emgGraph.addValue(2, 10); emgGraph.addValue(20,
		 * 100);
		 */

	}

	@Override
	public void onSampleReceived(EIBSample eibSample) {
		emgGraph.addValue(eibSample.getDate().getSeconds(), eibSample.getSampleValue());
		emgGraph.refreshGraph();
	}

}
