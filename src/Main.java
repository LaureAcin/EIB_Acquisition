import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.PacketListener;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.wpan.IoSample;
import com.rapplogic.xbee.api.wpan.RxResponseIoSample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XBee xBee = new XBee();
		System.out.println("Hello Xbee");
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
						System.out.println("Analog D0 (pin 20) 10-bit reading is " + sample.getAnalog0());
						System.out.println("Digital D4 (pin 11) is " + (sample.isD4On() ? "on" : "off"));
					}
//					Integer analog0Value = rxResponseIoSample.getSamples()[0].getAnalog0();
//					System.out.println("PIN 0=" + analog0Value);

				}
			}
		});

	}

}
