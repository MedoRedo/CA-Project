
public class exec_mem {

	boolean Brancheq;
	boolean Branchless;
	boolean Jump;
	boolean MemRead;
	boolean MemWrite;
	boolean MemtoReg;
	boolean RegWrite;
	String BranchVal;
	boolean ZeroLess;
	short AluResult;
	String WriteData;
	String WriteReg;

	public exec_mem(boolean brancheq,boolean branchless, boolean jump, boolean memRead, boolean memWrite, boolean memtoReg, boolean regWrite,
			String branchVal, boolean zeroLess, short aluResult, String writeData, String writeReg) {

		Brancheq = brancheq;
		Branchless = branchless;
		Jump = jump;
		MemRead = memRead;
		MemWrite = memWrite;
		MemtoReg = memtoReg;
		RegWrite = regWrite;
		BranchVal = branchVal;
		ZeroLess = zeroLess;
		AluResult = aluResult;
		WriteData = writeData;
		WriteReg = writeReg;
	}
}
