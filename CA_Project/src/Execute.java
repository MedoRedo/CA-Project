
public class Execute {
	ALU alu;
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
	public short execute(String ALUOp, char ALUSrc, short ReadData1, short ReadData2, String SignExtend) {
		String Op = "0000";
		switch(ALUOp) {
			case "00":
				Op = "0010";
				break;
			case "01":
				Op = "0110";
				break;
			case "10":
				String funct = SignExtend.substring(26);
				switch (funct) {
					case "100000":
						Op = "0010";
						break;
					case "100010":
						Op = "0110";
						break;
					case "100100":
						Op = "0000";
						break;
					case "100101":
						Op = "0001";
						break;
					case "101010":
						Op = "0111";
						break;
				}
				break;
		}
		short Operand1 = ReadData1;
		short Operand2 = ALUSrc == '0'?ReadData2:Short.parseShort(SignExtend, 2);
		return alu.ALUEvaluator(Op, Operand1, Operand2);
	}
}
