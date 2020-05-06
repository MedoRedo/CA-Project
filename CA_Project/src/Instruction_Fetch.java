
public class Instruction_Fetch {
	Instruction_Memory instMemo;

	public Instruction_Fetch(Instruction_Memory instMemo) {
		this.instMemo = instMemo;
	}

	public void InstFetch() {
		if (Main.PC < Main.numofins) {
			StringBuilder sb = new StringBuilder(instMemo.instructions[Main.PC]);
			Main.IF_ID=new fetch_decode(++Main.PC,sb.toString());
//			Main.IF_ID.ins = sb.toString();
//			Main.IF_ID.pc = ++Main.PC;
			print();
		} else {
			Main.IF_ID = null;
		}
	}

	public void print() {
		System.out.println("Fetch stage");
		System.out.println("Next PC: " + String.format("%16s", Main.PC).replace(" ", "0"));
		System.out.println("Instruction: " + Main.IF_ID.ins);
	}

	/*
	 * This method points to the next instruction to be executed. PC is incremented
	 * by 4 after each instruction is executed. A branch instruction alters the flow
	 * of control by modifying the PC
	 */
	// public static void ProgCount(boolean branch, boolean jump, short j, short b)
	// {
	// if (branch)
	// Main.PC = b;
	// else if (jump)
	// Main.PC = j;
	// }
}
