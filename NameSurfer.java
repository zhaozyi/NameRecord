/*
 * Student information for assignment: Replace <NAME> in the following with your
 * name. You are stating, on your honor you did not copy any other code on this
 * assignment and have not provided your code to anyone. 
 * 
 * On my honor, Ziyi Zhao, this programming assignment is my own work 
 * and I have not provided this code
 * to any other student. 
 * UTEID: 
 * email address: 
 * Number of slip days I am using:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSurfer {

    // CS314 students, explain your menu option 7 here:
	// return top 20 names and their ranks at a given decade
	// precondition: maxDecade > decade >= baseDecade, decade % 10 == 0
	public static void topTwentyNames(Names namesDatabase, Scanner keyboard) {
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        System.out.print("Enter a decade: ");
        // get user input and parse it into int
        int decade = Integer.parseInt(keyboard.nextLine());
        ArrayList<String> nameList = namesDatabase.topTwenty(decade);
        System.out.println("\nTop 20 names of that decade are: ");
        for (int i = 0; i < nameList.size(); i++) {
        	System.out.println(nameList.get(i));
        }
	}

    // CS314 students, Explain your interesting search / trend here:
	/* One of the interesting trend is the name franklin, rosevelt and roosevelt. It seems that during the decade
	 * 1930 these three names have a distinct rise in rank. Franklin reaches top 100, while other times it is 
	 * around 150. For rosevelt, this name rises to top 1000 around 1930s and 1940s, while other decades 
	 * it never reaches top 1000. As for roosevelt, the most popular decade is also 1930.
	 * The cause of this might be the influence of the name of the president Franklin Roosevelt at that time.
	 */

    // CS314 students, add test code for NameRecord class here:
	public static void methodTest() {
		int baseDecade = 1900;
		String alanRawData = "Alan 408 366 213 120 56 45 59 112 109 145 162";
		String annRawData = "Ann 63 45 50 34 38 45 60 102 180 325 495";
		String alanaRawData = "0 0 0 0 841 831 822 517 358 304 247";
		NameRecord alanRecord = new NameRecord(baseDecade, alanRawData);
		NameRecord alanaRecord = new NameRecord(baseDecade, alanaRawData);
		NameRecord annRecord = new NameRecord(baseDecade, annRawData);
		
		// getName() test 1
		String expectedName = "Alan";
		String actualName = alanRecord.getName();
		if (expectedName.equals(actualName)) {
			System.out.println("getName() test 1 PASSED");
		} else {
			System.out.println("getName() test 1 FAILED");
		}
		
		// getName() test 2
		expectedName = "Ann";
		actualName = annRecord.getName();
		if (expectedName.equals(actualName)) {
			System.out.println("getName() test 2 PASSED");
		} else {
			System.out.println("getName() test 2 FAILED");
		}
		
		// getBaseDecade() test 3
		int expect = 1900;
		int actual = alanRecord.getBaseDecade();
		if (expect == actual) {
			System.out.println("getBaseDecade() test 3 PASSED");
		} else {
			System.out.println("getBaseDecade() test 3 FAILED");
		}
		
		// getBaseDecade() test 4
		actual = annRecord.getBaseDecade();
		if (expect == actual) {
			System.out.println("getBaseDecade() test 4 PASSED");
		} else {
			System.out.println("getBaseDecade() test 4 FAILED");
		}
		
		// getRank() test 5
		int expectedRank = 213;
		int actualRank = alanRecord.getRank(2);
		if (expectedRank == actualRank) {
			System.out.println("getRank() test 5 PASSED");
		} else {
			System.out.println("getRank() test 5 FAILED");
		}
		
		// getRank() test 6
		expectedRank = 45;
		actualRank = annRecord.getRank(1);
		if (expectedRank == actualRank) {
			System.out.println("getRank() test 6 PASSED");
		} else {
			System.out.println("getRank() test 6 FAILED");
		}
		
		// getBestDecade() test 7
		int expectedDecade = 1950;
		int actualDecade = alanRecord.getBestDecade();
		if (expectedDecade == actualDecade) {
			System.out.println("getBestDecade() test 7 PASSED");
		} else {
			System.out.println("getBestDecade() test 7 FAILED");
		}
		
		// getBestDecade() test 8
		expectedDecade = 1930;
		actualDecade = annRecord.getBestDecade();
		if (expectedDecade == actualDecade) {
			System.out.println("getBestDecade() test 8 PASSED");
		} else {
			System.out.println("getBestDecade() test 8 FAILED");
		}
		
		// isAlwaysTop() test 9
		boolean expectResult = true;
		boolean actualResult = alanRecord.isAlwaysTop();
		if (expectResult == actualResult) {
			System.out.println("isAlwaysTop() test 9 PASSED");
		} else {
			System.out.println("isAlwaysTop() test 9 FAILED");
		}
		
		// isAlwaysTop() test 10
		expectResult = true;
		actualResult = annRecord.isAlwaysTop();
		if (expectResult == actualResult) {
			System.out.println("isAlwaysTop() test 10 PASSED");
		} else {
			System.out.println("isAlwaysTop() test 10 FAILED");
		}
		
		// isOnlyOnceTop() test 11
		expectResult = false;
		actualResult = alanRecord.isOnlyOnceTop();
		if (expectResult == actualResult) {
			System.out.println("isOnlyOnceTop() test 11 PASSED");
		} else {
			System.out.println("isOnlyOnceTop() test 11 FAILED");
		}
		
		// isOnlyOnceTop() test 12
		expectResult = false;
		actualResult = annRecord.isOnlyOnceTop();
		if (expectResult == actualResult) {
			System.out.println("isOnlyOnceTop() test 12 PASSED");
		} else {
			System.out.println("isOnlyOnceTop() test 12 FAILED");
		}
		
		// isAlwaysMorePopular() test 13
		expectResult = false;
		actualResult = alanRecord.isAlwaysMorePopular();
		if (expectResult == actualResult) {
			System.out.println("isAlwaysMorePopular() test 13 PASSED");
		} else {
			System.out.println("isAlwaysMorePopular() test 13 FAILED");
		}
		
		// isAlwaysMorePopular() test 14
		expectResult = false;
		actualResult = annRecord.isAlwaysMorePopular();
		if (expectResult == actualResult) {
			System.out.println("isAlwaysMorePopular() test 14 PASSED");
		} else {
			System.out.println("isAlwaysMorePopular() test 14 FAILED");
		}
		
		// isAlwaysLessPopular() test 15
		expectResult = false;
		actualResult = alanRecord.isAlwaysLessPopular();
		if (expectResult == actualResult) {
			System.out.println("isAlwaysLessPopular() test 15 PASSED");
		} else {
			System.out.println("isAlwaysLessPopular() test 15 FAILED");
		}
		
		// isAlwaysLessPopular() test 16
		expectResult = false;
		actualResult = annRecord.isAlwaysLessPopular();
		if (expectResult == actualResult) {
			System.out.println("isAlwaysLessPopular() test 16 PASSED");
		} else {
			System.out.println("isAlwaysLessPopular() test 16 FAILED");
		}
		
		// toString() test 17
		String expectedStr = "Alan\n1900: 408\n1910: 366\n1920: 213\n1930: 120\n1940: 56\n1950: "
				+ "45\n1960: 59\n1970: 112\n1980: 109\n1990: 145\n2000: 162\n";
		String actualStr = alanRecord.toString();
		if (expectedStr.equals(actualStr)) {
			System.out.println("toString() test 17 PASSED");
		} else {
			System.out.println("toString() test 17 FAILED");
		}
		
		// toString() test 18
		expectedStr = "Ann\n1900: 63\n1910: 45\n1920: 50\n1930: 34\n1940: 38\n1950: 45\n1960: 60\n1970: "
				+ "102\n1980: 180\n1990: 325\n2000: 495\n";
		actualStr = annRecord.toString();
		if (expectedStr.equals(actualStr)) {
			System.out.println("toString() test 18 PASSED");
		} else {
			System.out.println("toString() test 18 FAILED");
		}
		
		// compareTo() test 19
		int expectDiff = -2;
		int actualDiff = alanRecord.compareTo(annRecord);
		if (expectDiff == actualDiff) {
			System.out.println("compareTo() test 19 PASSED");
		} else {
			System.out.println("compareTo() test 19 FAILED");
		}
		
		// compareTo() test 20
		expectDiff = 17;
		actualDiff = alanRecord.compareTo(alanaRecord);
		if (expectDiff == actualDiff) {
			System.out.println("compareTo() test 20 PASSED");
		} else {
			System.out.println("compareTo() test 20 FAILED");
		}
	}

    // A few simple tests for the Names and NameRecord class.
    public static void simpleTest() {
        // raw data for Jake. Alter as necessary for your NameRecord
        String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
        int baseDecade = 1900;
        NameRecord jakeRecord = new NameRecord(baseDecade, jakeRawData); // complete with your constructor
        String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: "
                        + "484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: 117\n2000: 97\n";
        String actual = jakeRecord.toString();
        System.out.println("expected string:\n" + expected);
        System.out.println("actual string:\n" + actual);
        if (expected.equals(actual)) {
            System.out.println("passed Jake toString test.");
        } else {
            System.out.println("FAILED Jake toString test."); 
        }

        // Some getName Tests

        Names names = new Names(getFileScannerForNames("names.txt"));
        String[] testNames = {"Isabelle", "isabelle", "sel", "X1178", "ZZ", "via", "kelly"};
        boolean[] expectNull = {false, false, true, true, true, true, false};
        for (int i = 0; i < testNames.length; i++) {
            performGetNameTest(names, testNames[i], expectNull[i]);
        }
    }

    private static void performGetNameTest(Names names, String name, boolean expectNull) {
        System.out.println("Performing test for this name: " + name);
        if (expectNull) {
            System.out.println("Expected return value is null");
        } else {
            System.out.println("Expected return value is not null");
        }
        NameRecord result = names.getName(name);
        if ((expectNull && result == null) || (!expectNull && result != null)) {
            System.out.println("PASSED TEST.");
        } else {
            System.out.println("Failed test");
        }
    }

    // main method. Driver for the whole program
    public static void main(String[] args) {
        final String NAME_FILE = "names.txt";
        Scanner fileScanner = getFileScannerForNames(NAME_FILE);
        Names namesDatabase = new Names(fileScanner);
        fileScanner.close();
        runOptions(namesDatabase);
    }

    // pre: namesDatabase != null
    // ask user for options to perform on the given Names object.
    // Creates a Scanner connected to System.in.
    private static void runOptions(Names namesDatabase) {
        Scanner keyboard = new Scanner(System.in);
        MenuChoices[] menuChoices = MenuChoices.values();
        MenuChoices menuChoice;
        do {
            showMenu();
            int userChoice = getChoice(keyboard) - 1;
            menuChoice = menuChoices[userChoice];
            if(menuChoice == MenuChoices.SEARCH) {
                search(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.ONE_NAME) {
                oneName(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.APPEAR_ONCE) {
                appearOnce(namesDatabase);
            } else if (menuChoice == MenuChoices.APPEAR_ALWAYS) {
                appearAlways(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_MORE) {
                alwaysMore(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_LESS) {
                alwaysLess(namesDatabase);
            } else if (menuChoice == MenuChoices.STUDENT_SEARCH) {
                topTwentyNames(namesDatabase, keyboard);// CS314 students, call your search method here
            }
        } while(menuChoice != MenuChoices.QUIT);
        keyboard.close();
    }

    // pre: fileName != null
    // create a Scanner and return connected to a File with the given name.
    private static Scanner getFileScannerForNames(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Problem reading the data file. Returning null for Scanner"
                    + "object. Problems likely to occur." + e);
        }
        return sc;
    }

    // method that shows names that have appeared in ever decade
    // pre: n != null
    // post: print out names that have appeared in ever decade
    private static void appearAlways(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
        }
        ArrayList<String> nameList = namesDatabase.rankedEveryDecade();
        System.out.println(nameList.size() + " names appear in every decade. The names are: ");
        for (int i = 0; i < nameList.size(); i++) {
        	System.out.println(nameList.get(i));
        }
    }

    // method that shows names that have appeared in only one decade
    // pre: n != null
    // post: print out names that have appeared in only one decade
    private static void appearOnce(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
        }
        ArrayList<String> nameList = namesDatabase.rankedOnlyOneDecade();
        System.out.println(nameList.size() + " names appear in exactly one decade. The names are: ");
        for (int i = 0; i < nameList.size(); i++) {
        	System.out.println(nameList.get(i));
        }
        
    }
    
    // method that shows names that have gotten more popular 
    // in each successive decade
    // pre: n != null
    // post: print out names that have gotten more popular in each decade
    private static void alwaysMore(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
        }
        ArrayList<String> nameList = namesDatabase.alwaysMorePopular();
        System.out.println(nameList.size() + " names are more popular in every decade. ");
        for (int i = 0; i < nameList.size(); i++) {
        	System.out.println(nameList.get(i));
        }
    }
    
    // method that shows names that have gotten less popular 
    // in each successive decade
    // pre: n != null
    // post: print out names that have gotten less popular in each decade
    private static void alwaysLess(Names namesDatabase) {
        if (namesDatabase == null) { // check precondition
            throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
        }
        ArrayList<String> nameList = namesDatabase.alwaysLessPopular();
        System.out.println(nameList.size() + " names are less popular in every decade. ");
        for (int i = 0; i < nameList.size(); i++) {
        	System.out.println(nameList.get(i));
        }
    }

    // method that shows data for one name, or states that name has never been
    // ranked
    // pre: n != null, keyboard != null and is connected to System.in
    // post: print out the data for n or a message that n has never been in the
    // top 1000 for any decade
    private static void oneName(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        System.out.print("Enter a name: ");
        String name = keyboard.nextLine(); // get the user input
        System.out.println();
        if (namesDatabase.getName(name) == null) {
        	System.out.println(name + " does not appear in any decade.");
        } else {
        	System.out.println(namesDatabase.getName(name).toString());
        }
    }

    // method that shows all names that contain a substring from the user
    // and the decade they were most popular in
    // pre: n != null, keyboard != null and is connected to System.in
    // post: show the correct data
    private static void search(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        System.out.print("Enter a partial name: ");
        String partialName = keyboard.nextLine(); // get the user input
        ArrayList<NameRecord> names = namesDatabase.getMatches(partialName);
        System.out.println("\nThere are " + names.size() + " matches for " + partialName + ".");
        if (names.size() > 0) {
        	System.out.println("\nThe matches with their highest ranking decade are:");
        }
        for (int i = 0; i < names.size(); i++) {
        	int bestDecade = names.get(i).getBestDecade();
        	String name = names.get(i).getName();
        	System.out.println(name + " " + bestDecade);
        }
    }

    // get choice from the user
    // keyboard != null and is connected to System.in
    // return an int that is >= SEARCH and <= QUIT
    private static int getChoice(Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (keyboard == null) {
            throw new IllegalArgumentException("The parameter keyboard cannot be null");
        }
        int choice = getInt(keyboard, "Enter choice: ");
        keyboard.nextLine();
        // add one due to zero based indexing of enums, but 1 based indexing of menu
        final int MAX_CHOICE = MenuChoices.QUIT.ordinal() + 1;
        while (choice < 1  || choice > MAX_CHOICE) {
            System.out.println();
            System.out.println(choice + " is not a valid choice");
            choice = getInt(keyboard, "Enter choice: ");
            keyboard.nextLine();
        }
        return choice;
    }

    // ensure an int is entered from the keyboard
    // pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (s == null) {
            throw new IllegalArgumentException("The parameter s cannot be null");
        }
        System.out.print(prompt);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
    private static void showMenu() {
        System.out.println();
        System.out.println("Options:");
        System.out.println("Enter 1 to search for names.");
        System.out.println("Enter 2 to display data for one name.");
        System.out.println("Enter 3 to display all names that appear in only "
                + "one decade.");
        System.out.println("Enter 4 to display all names that appear in all "
                + "decades.");
        System.out.println("Enter 5 to display all names that are more popular "
                + "in every decade.");
        System.out.println("Enter 6 to display all names that are less popular "
                + "in every decade.");
        System.out.println("Enter 7 to display top 20 names at a given decade.");
        System.out.println("Enter 8 to quit.");
        System.out.println();
    }

}
