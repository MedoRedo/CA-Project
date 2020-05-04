
public class decode_exec {

	boolean RegDst;
	boolean Branch;
	boolean Jump;
	boolean MemRead;
	boolean MemWrite;
	boolean MemtoReg;
	boolean RegWrite;
	String AluOp;
	boolean AluSrc;
	short Pc;
	String ReadData1;
	String ReadData2;
	String ReadData3;
	String Immediate;
	String rd;
	String rt;

	public decode_exec(boolean regDst, boolean branch, boolean jump, boolean memRead, boolean memWrite,
			boolean memtoReg, String aluOp, boolean aluSrc, boolean regWrite, short pc, String readData1,
			String readData2, String readData3, String immediate, String rd, String rt) {
		RegDst = regDst;
		Branch = branch;
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
		this.rd = rd;
		this.rt = rt;
	}
}
