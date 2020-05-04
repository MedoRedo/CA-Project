
public class mem_wb {

	boolean MemtoReg;
	boolean RegWrite;
	short AluResult;

	public mem_wb(boolean memtoReg, boolean regWrite, short aluResult, String readData) {

		MemtoReg = memtoReg;
		RegWrite = regWrite;
		AluResult = aluResult;
		ReadData = readData;
	}

	String ReadData;
}
