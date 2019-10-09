import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XBee xBee = new XBee();
		System.out.println("Hello Xbee");
		try {
			xBee.open("usbserial-DN06AB91", 9600);
		} catch (XBeeException e) {
			System.out.println("Erreur de connection au port");
			e.printStackTrace();
		}
		
	}

}
