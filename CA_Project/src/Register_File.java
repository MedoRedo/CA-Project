
public class Register_File {
	boolean write;
	short[] registers;
	int read_Register_1, read_Register_2, write_Register;
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
	public void setWrite() {
		if(write)
			registers[write_Register] = write_Data;
	}
	public void decode(String instruction,char RegDst) {
		read_Register_1 = Integer.parseInt(instruction.substring(4, 8), 2);
		read_Register_2 = Integer.parseInt(instruction.substring(8, 12), 2);
		write_Register = RegDst == '0'?read_Register_2:Integer.parseInt(instruction.substring(12, 16),2);
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	}
	/*
	 * Type  opCode    funct
	 * add     0        32
	 * sub     0        34
	 * lw      35			
	 * sw      43
	 * j       2 
	 * BEQ     4
	 */
}