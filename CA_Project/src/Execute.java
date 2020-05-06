
public class Execute {
	ALU alu;
	short branchAddress;
	boolean Zflag;
	boolean LessThanflag;
	short ALUResult;
	short ReadData2;

	public Execute(ALU alu) {
		this.alu = alu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * This method takes in the ALUOp from ContUnit method, the first operand and
	 * the second operand from InstDecode method as an input. computes and outputs
	 * the result.
	 */
	public void execute() {
		if (Main.ID_EXE != null) {
			short Operand1 = Main.ID_EXE.ReadData1;
			short Operand2 = Main.ID_EXE.AluSrc == false ? Main.ID_EXE.ReadData2 : Main.ID_EXE.Immediate;
			ALUResult = alu.ALUEvaluator(Main.ID_EXE.AluOp, Operand1, Operand2);
			Zflag = alu.Zflag;
			LessThanflag = alu.LessThanflag;
			Add();
			Main.EXE_M = new exec_mem(Main.ID_EXE, ALUResult, branchAddress, LessThanflag, Zflag);
			print();
		} else {
			Main.EXE_M = null;
		}
	}

	// zero flag: 1
	// branch address: 0000 0000 0000 0000 0000 0000 0000 1000
	// ALU result/address: 0000 0000 0000 0000 0000 0000 0000 0000
	// register value to write to memory: 0000 0000 0000 0000 0000 0000 0000 0000
	// rt/rd register: 01001
	// WB controls: MemToReg: 0, RegWrite: 1
	// MEM controls: MemRead: 1, MemWrite: 0, Branch: 0

	public void print() {
		System.out.println("Execute stage");
		System.out.printf("zero flag : %d , less than flag : %d ", (Zflag ? 1 : 0), (LessThanflag ? 1 : 0));
		System.out.println("branch address: " + Instruction_Decode.SignExtend(Integer.toBinaryString(branchAddress)));
		System.out.println("ALU result/address: " + Instruction_Decode.SignExtend(Integer.toBinaryString(ALUResult)));
		System.out.println("rt/rd register: " + Integer.toBinaryString(Main.ID_EXE.writereg));
		System.out.printf("WB controls: MemToReg: %d, RegWrite: %d\n", (Main.ID_EXE.MemtoReg ? 1 : 0),
				(Main.ID_EXE.RegWrite ? 1 : 0));
		System.out.printf("MEM controls: MemRead: %d, MemWrite: %d, BranchEq: %d, BranchLessThan: %d, jump: %d\n",
				(Main.ID_EXE.MemRead ? 1 : 0), (Main.ID_EXE.MemWrite ? 1 : 0), (Main.ID_EXE.Brancheq ? 1 : 0),
				(Main.ID_EXE.Branchless ? 1 : 0), (Main.ID_EXE.Jump ? 1 : 0));
	}

	public void Add() {
		branchAddress = (short) (Main.ID_EXE.Immediate + Main.ID_EXE.Pc);
	}

}
