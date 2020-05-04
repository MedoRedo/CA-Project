
public class Execute {
	ALU alu;
	short AddResult;
	boolean Zflag ;
	boolean LessThanflag;
	short ALUResult;
	short ReadData2;
	short MUX;
	short M1;
	short M2;
	
	
	
	public Execute(ALU alu) {
		this.alu = alu;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * This method takes in the ALUOp from ContUnit method, the first operand and
		the second operand from InstDecode method as an input. computes and outputs the result.
	 */
	public void execute() {
		if (Main.ID_EXE != null) {
			
			short Operand1 = Main.ID_EXE.ReadData1;
			short Operand2 = Main.ID_EXE.AluSrc == false ? Main.ID_EXE.ReadData2
					: Main.ID_EXE.Immediate;
			ALUResult = alu.ALUEvaluator(Main.ID_EXE.AluOp, Operand1, Operand2);
			Zflag = alu.Zflag;
			LessThanflag = alu.LessThanflag;
			Add();
			Main.EXE_M = new exec_mem(Main.ID_EXE.Brancheq, Main.ID_EXE.Branchless, Main.ID_EXE.Jump, Main.ID_EXE.MemRead, Main.ID_EXE.MemWrite, 
					Main.ID_EXE.MemtoReg, Main.ID_EXE.RegWrite, AddResult, Zflag,LessThanflag,ALUResult, Main.ID_EXE.ReadData2, Main.ID_EXE.RegWrite)	;
					}
		else{
			Main.EXE_M = null;
		}
	}

	public void Add() {
		AddResult = (short)(Main.ID_EXE.Immediate + Main.ID_EXE.Pc);
	}
	
	
}
