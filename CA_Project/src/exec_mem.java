
public class exec_mem {

	boolean Brancheq;
	boolean Branchless;
	boolean Jump;
	boolean MemRead;
	boolean MemWrite;
	boolean MemtoReg;
	boolean RegWrite;
	short BranchAddress;
	boolean Zflag;
	boolean LessThanFlag;
	short AluResult;
	short WriteData;
	short WriteReg;

	public exec_mem(decode_exec ID_EXE, Short ALUResult, Short branchAddress, boolean lessThanFlag, boolean Zflag) {
		this.Brancheq = ID_EXE.Brancheq;
		this.Branchless = ID_EXE.Branchless;
		this.Jump = ID_EXE.Jump;
		this.MemRead = ID_EXE.MemRead;
		this.MemWrite = ID_EXE.MemWrite;
		this.MemtoReg = ID_EXE.MemtoReg;
		this.RegWrite = ID_EXE.RegWrite;
		this.WriteData = ID_EXE.ReadData2;
		this.AluResult = ALUResult;
		this.BranchAddress = branchAddress;
		this.LessThanFlag = lessThanFlag;
		this.Zflag = Zflag;
	}
}
