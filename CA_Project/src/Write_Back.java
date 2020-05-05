
public class Write_Back {

	Register_File reg_File;
	public Write_Back(Register_File reg_File) {
		this.reg_File = reg_File;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/*
 * This method takes in the destination register from InstDecode method, the
	result data from Execute method as an input. writes the result in the destination register
	and sets the corresponding flag for register writing
 */
	public void WriteBack() {
		if(Main.M_WB != null) {
			if(Main.M_WB.MemtoReg) {
				reg_File.write_Data = Main.M_WB.ReadData;
			}else {
				reg_File.write_Data = Main.M_WB.ALUresult;
			}
			reg_File.setWrite(Main.M_WB.RegWrite);		
		}
	}
}
