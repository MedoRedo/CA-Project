
public class exec_mem {

	boolean Brancheq;
	boolean Branchless;
	boolean Jump;
	boolean MemRead;
	boolean MemWrite;
	boolean MemtoReg;
	boolean RegWrite;
	short BranchVal;
	boolean Zflag;
	boolean LessThanFlag;
	short AluResult;
	short WriteData;
	short WriteReg;

	public exec_mem(boolean brancheq,boolean branchless, boolean jump, boolean memRead, boolean memWrite, boolean memtoReg, boolean regWrite,
			short branchVal, boolean zflag , boolean lessThanFlag, short aluResult, short writeData, short writeReg) {

		Brancheq = brancheq;
		Branchless = branchless;
		Jump = jump;
		MemRead = memRead;
		MemWrite = memWrite;
		MemtoReg = memtoReg;
		RegWrite = regWrite;
		BranchVal = branchVal;
		Zflag = zflag;
		LessThanFlag = lessThanFlag;
		AluResult = aluResult;
		WriteData = writeData;
		WriteReg = writeReg;
	}
}
