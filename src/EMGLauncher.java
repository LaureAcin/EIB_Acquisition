import java.awt.*;

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
import model.MaCentrale;

public class EMGLauncher extends Application {

	public static void main(String[] args) {
		Application.launch(EMGLauncher.class, args);
//		new EMGLauncher();
	}

	public EMGLauncher() {

		MaCentrale maCentrale = new MaCentrale();
		

		
//		Application.launch("EMGMainFrame");
//		emgGraph.addValue(2,3);
		/*
		 * // TODO Auto-generated method stub XBee xBee = new XBee();
		 * //System.out.println("Hello Xbee"); try { xBee.open("COM3", 9600); } catch
		 * (XBeeException e) { System.out.println("Erreur de connection au port");
		 * e.printStackTrace(); }
		 * 
		 * 
		 * xBee.addPacketListener(new PacketListener() {
		 * 
		 * @Override public void processResponse(XBeeResponse response) {
		 * System.out.println(response.getApiId());
		 * 
		 * // TODO Auto-generated method stub if (response.getApiId() ==
		 * ApiId.RX_16_IO_RESPONSE) { RxResponseIoSample rxResponseIoSample =
		 * (RxResponseIoSample) response;
		 * 
		 * for (IoSample sample: rxResponseIoSample.getSamples()) {
		 * System.out.println("Analog D0 (pin 20) 10-bit reading is " +
		 * sample.getAnalog0()); System.out.println("Digital D4 (pin 11) is " +
		 * (sample.isD4On() ? "on" : "off")); } // Integer analog0Value =
		 * rxResponseIoSample.getSamples()[0].getAnalog0(); //
		 * System.out.println("PIN 0=" + analog0Value);
		 * 
		 * }
		 * 
		 * } });
		 */

	}

	@Override
	public void start(Stage stage) {
		EMGMainFrame emgGraph = new  EMGMainFrame(stage);
		emgGraph.addValue(2, 10);
		emgGraph.addValue(20, 100);

	}

}
