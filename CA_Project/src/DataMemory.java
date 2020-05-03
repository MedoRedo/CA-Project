 
public class DataMemory {
	boolean MemRead, MemWrite;
	short[] data;
	int address;
	short writeData, readData;
	
	
	public DataMemory() {
		data = new short[1024];
		MemWrite = false;
		MemRead = false;		
	}
	
	public void setAddress(int address) {
		this.address = address;
	}

	public void setWriteData(short writeData) {
		this.writeData = writeData;
	}

	public short read(){
		readData = data[address];
		return readData;
	}
	public short setMemRead(int address){
		MemRead = true;
		short ans = -1;
		setAddress(address);
		ans = read();
		return ans;
	}
	public void write(){
		data[address]=writeData;
	}	
	public void setMemWrite(int address, short shortData){
		MemWrite = true;
		setAddress(address);
		this.writeData= shortData;
		write();
	}
	
	 public static void main(String[] args) {
		 DataMemory ram = new DataMemory();
		 short data = 72;
		 ram.setMemWrite(167, data);
		 data = 35;
		 ram.setMemWrite(1000, data);
		 data = 100;
		 ram.setMemWrite(1023, data);
		 data = 10;
		 ram.setMemWrite(6, data);
		 data = 4;
		 ram.setMemWrite(12, data);
		 
		 System.out.println(ram.setMemRead(0));		//default value because no data was written in index 0
		 System.out.println(ram.setMemRead(6));
		 System.out.println(ram.setMemRead(12));
		 System.out.println(ram.setMemRead(167));
		 System.out.println(ram.setMemRead(1000));
		 System.out.println(ram.setMemRead(1023));
		 System.out.println(ram.setMemRead(5));		//default value because no data was written in index 5
	 }
}
