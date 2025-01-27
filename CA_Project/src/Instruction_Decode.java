import javax.xml.crypto.dsig.SignedInfo;

public class Instruction_Decode {
	String ALUop, SignExtendimm;
	boolean RegDst, ALUSrc, RegWrite, MemRead, MemWrite, Brancheq, Branchless, MemtoReg, jump;
	Register_File regFile;
	short ReadData1, ReadData2, WriteReg, JumpDest;

	public Instruction_Decode(Register_File regFile) {
		this.regFile = regFile;
	}

	/*
	 * This method takes in the instruction from InstFetch method as an input,
	 * decodes and outputs the ALUOp code, the first operand, the second operand.
	 */

	public void InstDecode() {
		if (Main.IF_ID != null) {
			String inst = Main.IF_ID.ins;
			String OpCode = inst.substring(0, 4);
			ContUnit(OpCode);
			regFile.write = RegWrite;
			regFile.decode(inst, RegDst);
			ReadData1 = regFile.read_Data_1();
			ReadData2 = regFile.read_Data_2();
			WriteReg = regFile.write_Register;
			SignExtendimm = SignExtend(inst.substring(12));
			JumpDest = ReadData1;
			Main.ID_EXE = new decode_exec(RegDst, Brancheq, Branchless, jump, MemRead, MemWrite, MemtoReg, ALUop,
					ALUSrc, RegWrite, Main.IF_ID.pc, ReadData1, ReadData2, SignExtendimm, WriteReg, JumpDest);
			print();
		} else
			Main.ID_EXE = null;
	}

	/*
	 * This method takes from the decoded instruction first 4-bits and outputs the
	 * extended value in 16-bits as follows: the left most significant bit
	 * dublicates
	 */
	public static String SignExtend(String immediate) {
		return String.format("%16s", immediate).replace(" ", immediate.substring(0, 1));
	}

	/*
	 * This method takes in the OpCode code from InstDecode method as an input,
	 * changes the control signals according to the provided table outputs all 8
	 * control unit signals to the ALU Control.
	 */

	public void ContUnit(String OpCode) {
		switch (OpCode) {
		case "0000":// sub
			ALUop = "001";
			RegDst = false;
			ALUSrc = false;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0001":// and
			ALUop = "000";
			RegDst = false;
			ALUSrc = false;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0010":// addi
			ALUop = "000";
			RegDst = true;
			ALUSrc = true;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0011":// mul
			ALUop = "010";
			RegDst = false;
			ALUSrc = false;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0100":// or
			ALUop = "100";
			RegDst = false;
			ALUSrc = false;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0101":// andi
			ALUop = "011";
			RegDst = true;
			ALUSrc = true;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0110":// srl
			ALUop = "110";
			RegDst = true;
			ALUSrc = true;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "0111":// sll
			ALUop = "101";
			RegDst = true;
			ALUSrc = true;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "1000":// lw
			ALUop = "000";
			RegDst = true;
			ALUSrc = true;
			RegWrite = true;
			MemRead = true;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = true;
			break;
		case "1001":// sw
			ALUop = "000";
			RegDst = false;
			ALUSrc = true;
			RegWrite = false;
			MemRead = false;
			MemWrite = true;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "1010":// beq
			ALUop = "001";
			RegDst = false;
			ALUSrc = false;
			RegWrite = false;
			MemRead = false;
			MemWrite = false;
			Brancheq = true;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "1011":// blt
			ALUop = "001";
			RegDst = false;
			ALUSrc = false;
			RegWrite = false;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = true;
			jump = false;
			MemtoReg = false;
			break;
		case "1100":// set on less than immemdiate
			ALUop = "001";
			RegDst = true;
			ALUSrc = true;
			RegWrite = true;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = false;
			MemtoReg = false;
			break;
		case "1101":// jump
			ALUop = "111";
			RegDst = false;
			ALUSrc = false;
			RegWrite = false;
			MemRead = false;
			MemWrite = false;
			Brancheq = false;
			Branchless = false;
			jump = true;
			MemtoReg = false;
			break;

		}
	}

	public static String exshort(short x) {
		return ((x >= 0 ? String.format("%16s", Integer.toBinaryString(x)).replace(" ", "0")
				: Integer.toBinaryString(x).substring(16)));
	}

	public void print() {
		System.out.println("Decode stage");
		System.out.println("read data 1: " + exshort(ReadData1));
		System.out.println("read data 2: " + (jump ? "don't care" : exshort(ReadData2)));
		System.out.println("sign-extend: " + SignExtendimm);
		System.out.println("rt: " + (jump ? "don't care" : Main.IF_ID.ins.substring(8, 12)));
		System.out.println("rd: " + (ALUSrc ? "don't care" : Main.IF_ID.ins.substring(12)));
		System.out
				.println("Next PC: " + String.format("%16s", Integer.toBinaryString(Main.IF_ID.pc)).replace(" ", "0"));
		System.out.printf("WB controls: MemToReg: %d, RegWrite: %d\n", (MemtoReg ? 1 : 0), (RegWrite ? 1 : 0));
		System.out.printf("MEM controls: MemRead: %d, MemWrite: %d, BranchEq: %d, BranchLessThan: %d, jump: %d\n",
				(MemRead ? 1 : 0), (MemWrite ? 1 : 0), (Brancheq ? 1 : 0), (Branchless ? 1 : 0), (jump ? 1 : 0));
		System.out.printf("EX controls: RegDest: %d, ALUOp: %s, ALUSrc: %d\n\n", (RegDst ? 1 : 0), ALUop,
				(ALUSrc ? 1 : 0));

	}
}
