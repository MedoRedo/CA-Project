public class ALU {
	short result = 0;
	String OpName = null;

	// Input Type : Decimal
	public short ALUEvaluator(String Op, short Operand1, short Operand2) {
		switch (Op) {
		// And
		case "011":
			result = AndOp(Operand1, Operand2);
			OpName = "And";
			break;
		// Or
		case "100":
			result = OrOp(Operand1, Operand2);
			OpName = "Or";
			break;
		// Add
		case "000":
			result = AddOp(Operand1, Operand2);
			OpName = "Add";
			break;
		// Sub
		case "001":
			result = SubOp(Operand1, Operand2);
			OpName = "Sub";
			break;

		case "010":
			result = MultOp(Operand1, Operand2);
			OpName = "Multiply";
			break;

		case "101":
			result = SllOp(Operand1, Operand2);
			OpName = "Shift Left Logic";
			break;

		case "110":
			result = SrlOp(Operand1, Operand2);
			OpName = "Shift Right Logic";
			break;

		}
		return result;
	}

	// And Operation
	public static short AndOp(short Operand1, short Operand2) {
		short result = (short) (Operand1 & Operand2);
		return result;
	}

	// Or Operation
	public static short OrOp(short Operand1, short Operand2) {
		short result = (short) (Operand1 | Operand2);
		return result;
	}

	// Add Operation
	public static short AddOp(short Operand1, short Operand2) {
		short result = (short) (Operand1 + Operand2);
		return result;
	}

	// Subtract Operation
	public static short SubOp(short Operand1, short Operand2) {
		short result = (short) (Operand1 - Operand2);
		return result;
	}

	// Multiply Operation
	public static short MultOp(short Operand1, short Operand2) {
		short result = (short) (Operand1 * Operand2);
		return result;
	}

	// Shift Left Logic Operation
	public static short SllOp(short Operand1, short ShiftAmount) {
		short result = (short) (Operand1 << ShiftAmount);
		return result;
	}

	// Shift Right Logic Operation
	public static short SrlOp(short Operand1, short ShiftAmount) {
		short result = (short) (Operand1 >> ShiftAmount);
		return result;
	}

}

