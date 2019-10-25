package model;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.PacketListener;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.wpan.IoSample;
import com.rapplogic.xbee.api.wpan.RxResponseIoSample;

public class MaCentrale {
	
	private String analogResponse;
	
	public MaCentrale() {
		int i = 0;
		analogResponse = Integer.toString(i);
	}
	
	public void setResponse(int i) {
		
		// TODO Auto-generated method stub
		XBee xBee = new XBee();
		//System.out.println("Hello Xbee");
		try {
			xBee.open("COM3", 9600);
		} catch (XBeeException e) {
			System.out.println("Erreur de connection au port");
			e.printStackTrace();
		}
		
		
		xBee.addPacketListener(new PacketListener() {

			@Override
			public void processResponse(XBeeResponse response) {
				System.out.println(response.getApiId());

				// TODO Auto-generated method stub
				if (response.getApiId() == ApiId.RX_16_IO_RESPONSE) {	
					RxResponseIoSample rxResponseIoSample = (RxResponseIoSample) response;
					
					for (IoSample sample: rxResponseIoSample.getSamples()) {
						analogResponse = Integer.toString(sample.getAnalog0());
						System.out.println("Analog D0 (pin 20) 10-bit reading is " + sample.getAnalog0());
						System.out.println("Digital D4 (pin 11) is " + (sample.isD4On() ? "on" : "off"));
					}
				}
			}
		});
	}
	
	public String getResponse() {
		return analogResponse;
	}
}
