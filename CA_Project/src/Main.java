import java.io.BufferedReader;
import java.io.FileReader;

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
	static Cache cache;
	static int numofins;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		// loadProgram();
		run();
	}

	public static void init() {
		PC = 0;
		regFile = new Register_File();
		ram = new DataMemory();
		instMemo = new Instruction_Memory();
		alu = new ALU();
		cache = new Cache(ram);
	}

	public static void loadProgram() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Program"));
			for (int i = 0; i < 6; i++) {
				instMemo.instructions[i] = reader.readLine();
				numofins++;
			}
			reader.close();
			ram.setMemWrite(0, (short) 15);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void run() {
		for (int i = 0; i < numofins + 4 && numofins > 0; i++) {
			System.out.printf("After clock-cycle: %d\n", (i + 1));
			nextCycle();
			System.out.println();
		}
	}

	public static void nextCycle() {
		Write_Back wb = new Write_Back(regFile);
		wb.WriteBack();
		Memory_Access ma = new Memory_Access(cache);
		ma.MemoAccess();
		Execute ex = new Execute(alu);
		ex.execute();
		Instruction_Decode id = new Instruction_Decode(regFile);
		id.InstDecode();
		Instruction_Fetch iFetch = new Instruction_Fetch(instMemo);
		iFetch.InstFetch();
		
	}

}
