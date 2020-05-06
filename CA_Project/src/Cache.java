
public class Cache {
	Block[] blocks;
	int hit,miss;
	DataMemory ram;
	public Cache(DataMemory ram){
		blocks = new Block[8];
		for(int i=0;i<8;i++){
			blocks[i] = new Block();
		}
		this.ram = ram;
	}
	public void write(int address, short shortData) {
		int index = address%8;
		int tag = address/8;
		Block tmp = blocks[index];
		if(tmp.validBit){
			if(tmp.tag == tag){
				tmp.data = shortData;
			}else{
				tmp.tag = tag;
				tmp.data = shortData;
			}
		}else{
			tmp.tag = tag;
			tmp.data = shortData;
			tmp.validBit = true;			
		}
		ram.setMemWrite(address, shortData);	
	}

	public short read(int address){
		int index = address%8;
		int tag = address/8;
		Block tmp = blocks[index];
		if(tmp.validBit){
			if(tmp.tag == tag){
//				System.out.print("Hit");
//				hit++;
				return tmp.data;
			}else{
//				System.out.print("Miss");
//				miss++;
				tmp.tag = tag;
				tmp.data = ram.setMemRead(address);
				return tmp.data;
			}
		}else{
//			System.out.print("Miss");
//			miss++;
			tmp.tag = tag;
			tmp.data = ram.setMemRead(address);
			tmp.validBit = true;
			return tmp.data;			
		}
	}
	public static void main(String[] args) {
		DataMemory ram = new DataMemory();//of size 1024 words
		for (int i=0;i<5000;i++){
			int addr = (int)(Math.random()*1024);
			ram.setMemWrite(addr, (short)55);
		}
		
		Cache cache = new Cache(ram);

		System.out.println("\t"+cache.read(466));
		System.out.println("\t"+cache.read(167));
		System.out.println("\t"+cache.read(1000));
		System.out.println("\t"+cache.read(6));
		System.out.println("\t"+cache.read(466));
		System.out.println("\t"+cache.read(167));
		System.out.println("\t"+cache.read(7));
		System.out.println("\t"+cache.read(167));
		System.out.println("\t"+cache.read(7));
		System.out.println("\t"+cache.read(1000));
		System.out.println("\t"+cache.read(0));
		System.out.println("\t"+cache.read(1008));
		System.out.println("\t"+cache.read(0));
		System.out.println("\t"+cache.read(6));
		System.out.printf("#Hits = %d,\t #Misses = %d\n", cache.hit, cache.miss);
	}
	static class Block{
		int tag;
		boolean validBit;
		short data;
		public Block(){
			tag = 0;
			validBit = false;
			data = 0;
		}
	}
}