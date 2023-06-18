package Project2;


public class SuccessorNode implements Comparable<SuccessorNode>{
	private int[] sequence;
	private Integer h;
	
	public SuccessorNode(int[] sequence, Integer h)
	{
		this.sequence = sequence;
		this.h = h;
	}
	
	public int[] getSequence()
	{
		return sequence;
	}
	public Integer get_h()
	{
		return h;
	}
	public String toString() {
		return sequence + ": " + h;
	}
	
	@Override
	public int compareTo(SuccessorNode other) {
		return this.h.compareTo(other.get_h());
	}

}