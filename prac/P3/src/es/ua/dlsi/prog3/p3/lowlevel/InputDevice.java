package es.ua.dlsi.prog3.p3.lowlevel;

public class InputDevice extends IODevice{
	
	public InputDevice(){
		super();
	}
	
	public	void sendToChannel(byte byte_to_send){
		super.getChannel().input(byte_to_send);
	}
	
	public	void put(byte[] byteArray_to_send) {
		for(int i=0; i<byteArray_to_send.length; i++){
			super.getChannel().input(byteArray_to_send[i]);
		}
	}
}
