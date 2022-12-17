package wargame;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class Hand extends LinkedList<Card>{
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("HAND:").append(System.lineSeparator());
		
		for(int pos = 0; pos < size(); pos++) {
			sb.append("    ").append(get(pos)).append(System.lineSeparator());
		}
		return sb.toString();
	}

}
