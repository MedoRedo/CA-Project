
public class Main {
	static fetch_decode IF_ID;
	static decode_exec ID_EXE;
	static exec_mem EXE_M;
	static mem_wb M_WB;
	static short PC;
	static Register_File regFile;
	static DataMemory ram;
	static Instruction_Memory instMemo;
	static ALU alu;
	static int numofins;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regFile = new Register_File();
		ram = new DataMemory();
		instMemo = new Instruction_Memory();
		alu = new ALU();

	}

	public void run() {
		for (int i = 0; i < numofins + 4; i++) {
			nextCycle();
		}
	}

	public void nextCycle() {
		Write_Back wb = new Write_Back(regFile);
		wb.WriteBack();
		Memory_Access ma = new Memory_Access(ram);
		ma.MemoAccess();
		Execute ex = new Execute(alu);
		ex.execute();
		Instruction_Decode id = new Instruction_Decode(regFile);
		id.InstDecode();
		Instruction_Fetch iFetch = new Instruction_Fetch(instMemo);
		iFetch.InstFetch();
	}

}
