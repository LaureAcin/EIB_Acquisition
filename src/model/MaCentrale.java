package model;

import java.util.ArrayList;
import java.util.Date;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.PacketListener;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.wpan.IoSample;
import com.rapplogic.xbee.api.wpan.RxResponseIoSample;

public class MaCentrale {
	
	private ArrayList<EIBSample> realTimeBuffer;
	private float analogResponse;
	private String portUSB;
	private EibListener listener;
	
	public MaCentrale(String portUsb) {
		float responseValue = 0;
		analogResponse = responseValue;
		portUSB = portUsb;
		realTimeBuffer = new ArrayList<EIBSample>();
		initializeZigbeeNetwork();
		
	}
	
	private void initializeZigbeeNetwork() {
		
		XBee xBee = new XBee();
		//System.out.println("Hello Xbee");
		try {
			xBee.open(portUSB, 9600);
		} catch (XBeeException e) {
			System.out.println("Erreur de connexion au port");
			e.printStackTrace();
		}
		
		
		xBee.addPacketListener(new PacketListener() {

			@Override
			public void processResponse(XBeeResponse response) {
				//System.out.println(response.getApiId());

				if (response.getApiId() == ApiId.RX_16_IO_RESPONSE) {	
					RxResponseIoSample rxResponseIoSample = (RxResponseIoSample) response;
					
					for (IoSample sample: rxResponseIoSample.getSamples()) {
						analogResponse = sample.getAnalog0();
						System.out.println(analogResponse);
						EIBSample eibSample = new EIBSample(analogResponse, new Date());
						listener.onSampleReceived(eibSample);
						realTimeBuffer.add(eibSample);
						
						/*
						System.out.println("Analog D0 (pin 20) 10-bit reading is " + sample.getAnalog0());
						System.out.println("Digital D4 (pin 11) is " + (sample.isD4On() ? "on" : "off"));
						*/
					}
				}
			}
		});
	}
	
	public ArrayList<EIBSample> getBuffer() {
		return realTimeBuffer;
	}
	
	public void clearBuffer() {
		realTimeBuffer.clear();
	}

	public void addEibListener(EibListener listener) {
		this.listener = listener;
		
	}
}
