import java.util.ArrayList;

public class NameRecord implements Comparable<NameRecord>{
	
	// class variable
	public static final int DECADE_FACTOR = 10;
	public static final int LOWEST_RANK_BOUND = 1000;
	public static final int NOT_RANKED = 0;
	
	// instance variables
	private String name;
	private int baseDecade;
	public ArrayList<Integer> ranksOfNames = new ArrayList<Integer>();
	
	// create a NameRecord Object
	public NameRecord(int baseDecade, String rawData) {
		String[] parsedData = rawData.split("\\s+");
		int start = 1;
		this.name = parsedData[0];
		this.baseDecade = baseDecade;
		for (int i = start; i < parsedData.length; i++) {
			ranksOfNames.add(Integer.parseInt(parsedData[i]));
		}
	}
	
	// get the name for this NameRecord Object
	public String getName() {
		return name;
	}
	
	// get the base decade for this NameRecord Object
	public int getBaseDecade() {
		return baseDecade;
	}
	
	// get the NameRecord's rank for a given decade
	// precondition: 0 <= decade < ranksOfNames.size()
	public int getRank(int decade) {
		if (decade < 0 || decade >= ranksOfNames.size()) {
			throw new IllegalArgumentException("The parameter must be between 0 and " + ranksOfNames.size());
		}
		return ranksOfNames.get(decade);
	}
	
	// get the NameRecord's best decade(the decade which its name is the most popular)
	public int getBestDecade() {
		int minInd = 0;
		for (int i = 0; i < ranksOfNames.size(); i++) {
			int rank = ranksOfNames.get(i);
			int minRank = ranksOfNames.get(minInd);
			// convert NOT_RANKED to LOWEST_RANK_BOUND, easier to compare
			if (rank == NOT_RANKED) {
				rank += LOWEST_RANK_BOUND;
			}
			if (minRank == NOT_RANKED) {
				minRank += LOWEST_RANK_BOUND;
			}
			// update the index of the most popular year of a name
			if (minRank > rank) {
				minInd = i;
			}
		}
		int bestDecade = baseDecade + minInd * DECADE_FACTOR;
		return bestDecade;
	}
	
	// check if the name has been ranked in top 1000 in every decades
	public boolean isAlwaysTop() {
		for (int i = 0; i < ranksOfNames.size(); i++) {
			int rank = ranksOfNames.get(i);
			if (rank == NOT_RANKED) {
				return false;
			}
		}
		return true;
	}
	
	// check if the name appears in top 1000 in only one decade
	public boolean isOnlyOnceTop() {
		final int once = 1;
		int count = 0;
		for (int i = 0; i < ranksOfNames.size(); i++) {
			int rank = ranksOfNames.get(i);
			if (rank != NOT_RANKED) {
				count++;
			}
			if (count > once) {
				return false;
			}
		}
		return count == once;
	}
	
	// check if the name is used more often every decade
	public boolean isAlwaysMorePopular() {
		for (int i = 0; i < ranksOfNames.size() - 1; i++) {
			int rank1 = ranksOfNames.get(i);
			int rank2 = ranksOfNames.get(i + 1);
			// get rid of 0: complicated when comparing, 
			// so add 1000 but not changing the value stored in the ArrayList
			if (rank1 == NOT_RANKED) {
				rank1 += LOWEST_RANK_BOUND;
			}
			if (rank2 == NOT_RANKED) {
				rank2 += LOWEST_RANK_BOUND;
			}
			// return result once found
			if (rank1 <= rank2) {
				return false;
			}
		}
		return true;
	}
	
	// check if the name is used less often every decade
	public boolean isAlwaysLessPopular() {
		for (int i = 0; i < ranksOfNames.size() - 1; i++) {
			int rank1 = ranksOfNames.get(i);
			int rank2 = ranksOfNames.get(i + 1);
			// get rid of 0: complicated when comparing, 
			// so add 1000 but not changing the value stored in the ArrayList
			if (rank1 == NOT_RANKED) {
				rank1 += LOWEST_RANK_BOUND;
			}
			if (rank2 == NOT_RANKED) {
				rank2 += LOWEST_RANK_BOUND;
			}
			// return result once found
			if (rank1 >= rank2) {
				return false;
			}
		}
		return true;
	}
	
	// returns a string that stores the data
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String newLineChar = "\n";
		sb.append(name + newLineChar);
		for (int i = 0; i < ranksOfNames.size(); i++) {
			String format = (baseDecade + i * DECADE_FACTOR) + ": " + ranksOfNames.get(i) + newLineChar;
			sb.append(format);
		}
		return sb.toString();
	}
	
	// return a a value that is the result of comparing names of two NameRecord object
	public int compareTo(NameRecord other) {
		return (this.name).compareTo(other.name);
	}

}
