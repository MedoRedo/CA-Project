
public class Memory_Access {
	DataMemory ram;

	public Memory_Access(DataMemory ram) {
		this.ram = ram;
	}

	/*
	 * This method takes in the Address which is the ALU result (offset is added to
	 * the value in the rs in the ALU). Plus the readdata2 value (this will be our
	 * write data in the memory). from InstDecode method, the result data from
	 * Execute method as an input. writes the result in the memory address and sets
	 * the corresponding flag for memory accessing
	 */
	public void MemoAccess() {
		if(Main.EXE_M != null) {
			short ALUresult = Main.EXE_M.AluResult;
			boolean MemWrite = Main.EXE_M.MemWrite;
			boolean MemRead = Main.EXE_M.MemRead;
			boolean BranchEq, Zero_Flag, BranchLess, lessThan_Flag;
			BranchEq = Main.EXE_M.Brancheq;
			Zero_Flag = Main.EXE_M.Zflag;
			BranchLess = Main.EXE_M.Branchless;
			lessThan_Flag = Main.EXE_M.LessThanFlag;
			short writeData = Main.EXE_M.WriteData;
			short branchAddress = Main.EXE_M.BranchAddress;
			if (MemWrite) {
				ram.setMemWrite(ALUresult, writeData);
			}
			
			if (BranchEq && Zero_Flag) {
				Main.PC = branchAddress;
			}
			if (BranchLess && lessThan_Flag){
				Main.PC = branchAddress;
			}
			short readData = 0;
			if (MemRead) {
				readData =  ram.setMemRead(ALUresult);
			}
			Main.M_WB = new mem_wb(Main.EXE_M.MemtoReg, Main.EXE_M.RegWrite, Main.EXE_M.AluResult, readData);			
		}else {
			Main.M_WB = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
