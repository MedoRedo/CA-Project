 
public class DataMemory {
	boolean MemRead, MemWrite;
	int[] data;
	int address;
	int writeData, readData;
	
	
	public DataMemory() {
		data = new int[1024];
		MemWrite = false;
		MemRead = false;		
	}
	
	public void setAddress(int address) {
		this.address = address;
	}

	public void setWriteData(int writeData) {
		this.writeData = writeData;
	}

	public int read(){
		readData = data[address];
		return readData;
	}
	public int setMemRead(int address){
		MemRead = true;
		int ans = -1;
		setAddress(address);
		ans = read();
		return ans;
	}
	public void write(){
		data[address]=writeData;
	}	
	public void setMemWrite(int address, int intData){
		MemWrite = true;
		setAddress(address);
		this.writeData= intData;
		write();
	}
	
	// public static void main(String[] args) {
		// DataMemory ram = new DataMemory();
		// ram.write(167, 72);
		// ram.write(1000, 35);
		// ram.write(1023, 100);
		// ram.write(6, 10);
		// ram.write(12, 4);
		
		// ram.read(0);		//default value because no data was written in index 0
		// ram.read(6);
		// ram.read(12);
		// ram.read(167);
		// ram.read(1000);
		// ram.read(1023);
		// ram.read(5);		//default value because no data was written in index 5
	// }
}
