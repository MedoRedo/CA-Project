
public class mem_wb {

	boolean MemtoReg;
	boolean RegWrite;
	short ALUresult;
	short ReadData;

	public mem_wb(boolean memtoReg, boolean regWrite, short aluResult, short readData) {

		MemtoReg = memtoReg;
		RegWrite = regWrite;
		ALUresult = aluResult;
		ReadData = readData;
	}

}
