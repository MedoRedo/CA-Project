
public class Memory_Access {
	Cache cache;

	public Memory_Access(Cache cache) {
		this.cache = cache;
	}

	/*
	 * This method takes in the Address which is the ALU result (offset is added to
	 * the value in the rs in the ALU). Plus the readdata2 value (this will be our
	 * write data in the memory). from InstDecode method, the result data from
	 * Execute method as an input. writes the result in the memory address and sets
	 * the corresponding flag for memory accessing
	 */
	public void MemoAccess() {
		if (Main.EXE_M != null) {
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
				cache.write(ALUresult, writeData);
			}

			if (BranchEq && Zero_Flag) {
				Main.PC = branchAddress;
			}
			if (BranchLess && lessThan_Flag) {
				Main.PC = branchAddress;
			}
			if (Main.EXE_M.Jump) {
				Main.PC = Main.EXE_M.JumpDest;
			}
			short readData = 0;
			if (MemRead) {
				readData = cache.read(ALUresult);
			}
			Main.M_WB = new mem_wb(Main.EXE_M.MemtoReg, Main.EXE_M.RegWrite, ALUresult, readData);
			print();
		} else {
			Main.M_WB = null;
		}
	}

	// ALU result: 0000 0000 0000 0000 0000 0000 0000 0000
	// memory word read: 1111 1111 1111 1111 0000 0000 0000 0000
	// rt/rd field: 01001
	// WB controls: MemToReg: 0, RegWrite: 1

	public void print() {
		System.out.println("Memory stage");
		System.out.println("ALU result/address: " + (Main.EXE_M.AluResult >= 0
				? String.format("%16s", Integer.toBinaryString(Main.EXE_M.AluResult)).replace(" ", "0")
				: Integer.toBinaryString(Main.EXE_M.AluResult).substring(16)));
		System.out.println("memory word read: " + Instruction_Decode.exshort(Main.M_WB.ReadData));
		System.out.println("rt/rd register: " + Integer.toBinaryString(Main.EXE_M.WriteReg));
		System.out.printf("WB controls: MemToReg: %d, RegWrite: %d\n\n", (Main.EXE_M.MemtoReg ? 1 : 0),
				(Main.EXE_M.RegWrite ? 1 : 0));
	}

}
