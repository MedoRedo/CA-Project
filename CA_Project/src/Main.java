
public class Main {
	static fetch_decode IF_ID;
	static decode_exec ID_EXE;
	static exec_mem EXE_M;
	static mem_wb M_WB;
	static int PC;
	static Register_File regFile;
	static DataMemory ram;
	static Instruction_Memory instMemo;
	static ALU alu;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regFile = new Register_File();
		ram = new DataMemory();
		instMemo = new Instruction_Memory();
		alu = new ALU();

	}

}
