
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
	public int MemoAccess(short ALUresult, short ReadData2, char MemWrite, char MemRead, char BranchEq, char BranchLess,
			char Zero_Flag, char lessThan_Flag, int SignExtend, short branchAddress) {
		if (MemWrite == '1') {
			ram.setMemWrite(ALUresult, ReadData2);
		}
		
		if (BranchEq == '1' && Zero_Flag == '1') {
			Main.PC = branchAddress;
		}
		if (BranchLess == '1' && lessThan_Flag == '1') {
			Main.PC = branchAddress;
		}
		
		if (MemRead == '1') {
			return ram.setMemRead(ALUresult);
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
