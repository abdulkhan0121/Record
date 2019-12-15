//Abdul Khan
//C Block
//2/5/19
package Record;

public class Record implements Comparable<Record> {

	private char letter;
	private int frequency;
	private char uncoded;
	
	public  Record() {
		
		this.frequency = 0;
		
	}
	
	 public int compareTo(Record other)
	   {
	       if(frequency > other.frequency)
	    	   return 1;
	       else if(frequency < other.frequency)
	    	   return -1;
	       else 
	       		return 0;
	       
	   }

	
	public Record(char let, int freq) {
	
		this.letter = let;
		this.frequency = freq;
		
	}

	
	public void setFreq(int freq) {
		
		this.frequency = freq;
		
	}
	
	public void setLet(char let) {
		
		this.letter = let;
		
	}
	
	public int getFreq() {
		
		return this.frequency;
		
	}
	
	public char getLet() {
		
		return this.letter;
		
	}

	public void setUncoded(char uncoded) {
		
		this.uncoded = uncoded;
		
	}
	
	public char getUncoded() {
		
		return this.uncoded;
		
	}
}
