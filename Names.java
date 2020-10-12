/*  Student information for assignment:
*
*  On my honor, Ziyi Zhao, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: zz5844
*  email address: ZhaoZyi@utexas.edu
*  Number of slip days I am using:
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* A collection of NameRecords. 
* Stores NameRecord objects and provides methods to select
* NameRecords based on various criteria.
*/
public class Names {
    
	// instance variables
	private ArrayList<NameRecord> names = new ArrayList<NameRecord>();
	
    /**
     * Construct a new Names object based on the data source the Scanner 
     * sc is connected to. Assume the first two lines in the 
     * data source are the base year and number of decades to use.
     * Any lines without the correct number of decades are discarded 
     * and are not part of the resulting Names object. 
     * Any names with ranks of all 0 are discarded and not
     * part of the resulting Names object.
     * @param sc Is connected to a data file with baby names 
     * and positioned at the start of the data source.
     */
    public Names(Scanner sc) {
    	int baseDecade = sc.nextInt();
    	int numRanks = sc.nextInt();
    	while (sc.hasNextLine()) { // get raw data each line
        	String rawData = sc.nextLine();
    		String[] parsedData = rawData.split("\\s+"); // parse into array of strings
    		int actualNumRanks = parsedData.length - 1;
    		boolean ranked = false;
    		int rankIndStart = 1;
    		for (int i = rankIndStart; i < parsedData.length; i++) {
    			int rank = Integer.parseInt(parsedData[i]);
    			if (rank != 0) { // check if one line of rank is not ranked(zero)
    				ranked = true;
    			}
    		}
    		if ((actualNumRanks == numRanks) && ranked) { // add the NameRecord that satisfies the condition
    			names.add(new NameRecord(baseDecade, rawData));
    		}
    	}
    	Collections.sort(names); // sort the Name object
    }

   /**
    * Returns an ArrayList of NameRecord objects that contain a 
    * given substring, ignoring case.  The names must be in sorted order based 
    * on name.
    * @param partialName != null, partialName.length() > 0
    * @return an ArrayList of NameRecords whose names contains
    * partialName. If there are no NameRecords that meet this
    * criteria returns an empty list. 
    */
   public ArrayList<NameRecord> getMatches(String partialName) {
	   // check precondition: parTialName != null, partialName.length() > 0
	   if (partialName == null || partialName.length() <= 0) {
		   throw new IllegalArgumentException();
	   }
	   // create a new ArrayList that stores satisfied NameRecord object
	   ArrayList<NameRecord> partialMatchedNames = new ArrayList<NameRecord>();
	   for (int i = 0; i < names.size(); i++) {
		   // ignore cases
		   String lowerCaseName = names.get(i).getName().toLowerCase();
		   String lowerCasePartialName = partialName.toLowerCase();
		   if (lowerCaseName.contains(lowerCasePartialName)) {
			   partialMatchedNames.add(names.get(i));
		   }
	   }
	   return partialMatchedNames;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the
    * top 1000 or better for every decade. The Strings  must be in sorted 
    * order based on name. 
    * @return A list of the names that have been ranked in the top
    * 1000 or better in every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedEveryDecade() {
	   // create a new ArrayList that stores the names for all satisfied NameRecord objects
       ArrayList<String> nameList = new ArrayList<String>();
       for (int i = 0; i < names.size(); i++) {
    	   if (names.get(i).isAlwaysTop()) { // check the condition for every NameRecord Object
    		   nameList.add(names.get(i).getName());
    	   }
       }
       return nameList;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the 
    * top 1000 or better in exactly one decade. The Strings must be in sorted 
    * order based on name. 
    * @return A list of the names that have been ranked in the top
    * 1000 or better in exactly one decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedOnlyOneDecade() {
	   // create a new ArrayList that stores the names for all satisfied NameRecord objects
       ArrayList<String> nameList = new ArrayList<String>();
       for (int i = 0; i < names.size(); i++) {
    	   if (names.get(i).isOnlyOnceTop()) { // check the condition for every NameRecord Object
    		   nameList.add(names.get(i).getName());
    	   }
       }
       return nameList;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting more
    * popular every decade. The Strings  must be in sorted order based on name.
    * @return A list of the names that have been getting more popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list. 
    */
   public ArrayList<String> alwaysMorePopular() {
	   // create a new ArrayList that stores the names for all satisfied NameRecord objects
       ArrayList<String> nameList = new ArrayList<String>();
       for (int i = 0; i < names.size(); i++) {
    	   if (names.get(i).isAlwaysMorePopular()) { // check the condition for every NameRecord Object
    		   nameList.add(names.get(i).getName());
    	   }
       }
       return nameList;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting less
    * popular every decade. The Strings  must be in sorted order based on name.
    * @return A list of the names that have been getting less popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list. 
    */
   public ArrayList<String> alwaysLessPopular() {
	   // create a new ArrayList that stores the names for all satisfied NameRecord objects
       ArrayList<String> nameList = new ArrayList<String>();
       for (int i = 0; i < names.size(); i++) {
    	   if (names.get(i).isAlwaysLessPopular()) { // check the condition for every NameRecord Object
    		   nameList.add(names.get(i).getName());
    	   }
       }
       return nameList;
   }
   
   /**
    * Return the NameRecord in this Names object that matches the given String.
    * <br>
    * <tt>pre: name != null</tt>
    * @param name The name to search for.
    * @return The name record with the given name or null if no NameRecord in this Names
    * object contains the given name.
    */
   public NameRecord getName(String name) {
       if(name == null) // check precondition
           throw new IllegalArgumentException("The parameter name cannot be null");
       for (int i = 0; i < names.size(); i++) {
    	   // ignore cases
    	   String lowerCaseName = names.get(i).getName().toLowerCase();
    	   if (lowerCaseName.equals(name.toLowerCase())) { // check if two names are the same
    		   return names.get(i);
    	   }
       }
       return null;
   }
   
   /**
    * Returns an ArrayList of Strings of names that are top 20 in a given decade.
    * @param maxDecade > decade >= baseDecade, decade % 10 == 0
    * @return a list of Strings of names that are top 20 in a given decade. The
    * list is in sorted name's ascending order. If there are no NameRecord objects that meet the condition, return
    * an empty list
    */
   public ArrayList<String> topTwenty(int decade) {
	   final int RANK_BOUND = 20;
	   final int DECADE_FACTOR = 10;
	   int baseDecade = names.get(0).getBaseDecade();
	   int numRanks = names.get(0).ranksOfNames.size();
	   int maxDecade = baseDecade + numRanks * DECADE_FACTOR; 
	   // check precondition: maxDecade > decade >= baseDecade, decade % 10 == 0
	   if (decade >= maxDecade || decade < baseDecade || decade % DECADE_FACTOR != 0) {
		   throw new IllegalArgumentException("The parameter is a multiple of " + DECADE_FACTOR + 
				   " and must be not less than " + baseDecade + " and less than " + maxDecade + ".");
	   }
	   ArrayList<String> nameList = new ArrayList<String>();
	   int indOfDecade = (decade - baseDecade) / DECADE_FACTOR;
	   // go through all the NameRecord objects and add names and the rank that matches the condition
	   for (int i = 0; i < names.size(); i++) {
		   int rank = names.get(i).getRank(indOfDecade);
		   if (rank != NameRecord.NOT_RANKED && rank <= RANK_BOUND) {
			   nameList.add(names.get(i).getName() + ": " + rank);
		   }
	   }
	   return nameList;
   }
}
