
public class decode_exec {

	boolean RegDst;
	boolean Branchless;
	boolean Brancheq;
	boolean Jump;
	boolean MemRead;
	boolean MemWrite;
	boolean MemtoReg;
	boolean RegWrite;
	String AluOp;
	boolean AluSrc;
	short Pc;
	short ReadData1;
	short ReadData2;
	short ReadData3;
	short Immediate;
	short writereg;
	short jumpDest;

	public decode_exec(boolean regDst, boolean brancheq,boolean branchless, boolean jump, boolean memRead, boolean memWrite,
			boolean memtoReg, String aluOp, boolean aluSrc, boolean regWrite, short pc, short readData1,
			short readData2, short readData3, short immediate, short writereg, short j) {
		RegDst = regDst;
		Brancheq = brancheq;
		Branchless = branchless;
		Jump = jump;
		MemRead = memRead;
		MemWrite = memWrite;
		MemtoReg = memtoReg;
		AluOp = aluOp;
		AluSrc = aluSrc;
		RegWrite = regWrite;
		Pc = pc;
		ReadData1 = readData1;
		ReadData2 = readData2;
		ReadData3 = readData3;
		Immediate = immediate;
		this.writereg = writereg;
		jumpDest = j;
	}
}
