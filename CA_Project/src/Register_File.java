
public class Register_File {
	boolean write;
	short[] registers;
	short read_Register_1, read_Register_2, write_Register, read_Register_3;
	short write_Data;

	public Register_File() {
		write = false;
		registers = new short[16];
	}

	public short read_Data_1() {
		return registers[read_Register_1];
	}

	public short read_Data_2() {
		return registers[read_Register_2];
	}

	public short read_Data_3() {
		return registers[read_Register_3];
	}

	public void setWrite() {
		if (write)
			registers[write_Register] = write_Data;
	}

	public void decode(String instruction, boolean RegDst) {
		read_Register_1 = Short.parseShort(instruction.substring(4, 8), 2);
		read_Register_2 = Short.parseShort(instruction.substring(8, 12), 2);
		read_Register_3 = Short.parseShort(instruction.substring(12, 16), 2);
		write_Register = !RegDst ? read_Register_2 : Short.parseShort(instruction.substring(12, 16), 2);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}
}
