
public class Instruction_Decode {
	String ALUop, SignExtend;
	char RegDst, ALUSrc, RegWrite, MemRead, MemWrite, Branch, MemtoReg;
	Register_File regFile;
	int ReadData1, ReadData2;
	public Instruction_Decode(Register_File regFile) {
		this.regFile = regFile;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * This method takes in the instruction from InstFetch method as an input,
		decodes and outputs the ALUOp code, the first operand, the second operand.
	 */
	public void InstDecode(String inst) {
		String OpCode = inst.substring(0, 6);
		ContUnit(OpCode);
		regFile.write = RegWrite == '1';
		regFile.decode(inst, RegDst);
		ReadData1 = regFile.read_Data_1();
		ReadData2 = regFile.read_Data_2();
		SignExtend = SignExtend(inst.substring(16));
	}
	/*
	 * This method takes from the decoded instruction first 16-bits and outputs the
		extended value in 32-bits as follows: the left most significant bit is to be duplicated e.g
		1000000000000000 -> 11111111111111111000000000000000
	 */
	public String SignExtend(String immediate) {
		return String.format("%32s", immediate).replace(" ", immediate.substring(0, 1));
	}
	/*
	 * This method takes in the OpCode code from InstDecode method as an input,
		changes the control signals according to the provided table outputs all 8 control unit signals
		to the ALU Control.
	 */
	public void ContUnit(String OpCode) {
		switch(OpCode) {
			case "000000":// R-type
				ALUop = "10";
				RegDst = '1';
				ALUSrc = '0';
				RegWrite = '1';
				MemRead = '0';
				MemWrite = '0';
				Branch = '0';
				MemtoReg = '0';
				break;
			case "000100":// BEQ
				ALUop = "01";
				ALUSrc = '0';
				RegWrite = '0';
				MemRead = '0';
				MemWrite = '0';
				Branch = '1';
				break;
			case "100011":// lw
				ALUop = "00";
				RegDst = '0';
				ALUSrc = '1';
				RegWrite = '1';
				MemRead = '1';
				MemWrite = '0';
				Branch = '0';
				MemtoReg = '1';				
				break;
			case "101011":// sw
				ALUop = "00";
				ALUSrc = '1';
				RegWrite = '0';
				MemRead = '0';
				MemWrite = '1';
				Branch = '0';
				break;
		}
	}
}
