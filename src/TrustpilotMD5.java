import java.util.ArrayList;
import java.io.File; // Import the File class
import java.io.FileReader;
import java.io.BufferedReader;

public class TrustpilotMD5 {
  static String anagram = "poultry outwits ants";
  static byte[] anagramChars = new byte[26];
  static int anagramLength = anagram.length();
  static ArrayList<String> wordList = new ArrayList<String>();
  static long startTime;

  TrustpilotMD5() {
    startTime = System.nanoTime();
    anagramToArray();
    reedWordList();
    generateAnagrams();

  }

  public static void anagramToArray() {
    // DONE - convert anagram to anagramChars array
    // 1 - create a loop for reading each consecutive char in the anagram
    for (int i = 0; i < anagramLength; i++) {
      // 2 - check if the read char is a letter from a-z (or we can simply assume it
      // is)
      char tempChar = anagram.charAt(i);
      if (tempChar >= 'a' && tempChar <= 'z') {
        // 3 - add +1 to the spot in the anagramChars array, which corresponds to the
        // given char
        anagramChars[tempChar - 'a']++;
      }
    }
  }

  // specific function for checking if a string s is an anagram of the global
  // string 'anagram'
  public static boolean isAnagram(String s) {
    // 1 - convert s to a char array like the one used for the anagram
    if (s.length() != anagramLength) {
      return false;
    }

    byte[] tempChars = new byte[26];
    for (int i = 0; i < anagramLength; i++) {
      char tempChar = s.charAt(i);
      if (tempChar != ' ') {
        tempChars[tempChar - 'a']++;
      }

    }
    // 2 - compare the number of elements in both arrays to see if they match
    for (int i = 0; i < 26; i++) {
      if (tempChars[i] != anagramChars[i]) {
        return false;
      }
    }
    return true;
  }

  // general function for checking if two strings are anagrams of each other
  public static boolean isAnagram(String s1, String s2) {
    byte[] tempChars1 = new byte[27];
    byte[] tempChars2 = new byte[27];
    int length;

    length = s1.length();
    for (int i = 0; i < anagramLength; i++) {
      char tempChar1 = s1.charAt(i);
      if (tempChar1 != ' ') {
        tempChars1[tempChar1 - 'a']++;
      }
    }
    for (int i = 0; i < anagramLength; i++) {
      char tempChar2 = s1.charAt(i);
      if (tempChar2 != ' ') {
        tempChars2[tempChar2 - 'a']++;
      }
    }

    length = s2.length();
    for (int i = 0; i < anagramLength; i++) {
      char tempChar = s2.charAt(i);
      if (tempChar != ' ') {
        tempChars1[tempChar - 'a']++;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (tempChars1[i] != tempChars2[i]) {
        return false;
      }
    }

    return true;

  }

  // check if a given string can be written using the letters available from the
  // anagram
  public static boolean lettersAvailable(String s) {
    byte[] tempChars = new byte[26];
    // convert s to tempChars array
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char tempChar = s.charAt(i);
      if (tempChar >= 'a' && tempChar <= 'z') {
        tempChars[tempChar - 'a']++;
      } else {
        // if we make it here, the char wasn't a letter from a-z
        return false;
      }
    }
    // compare the number of elements in both arrays to see if we can write the
    // string
    for (int i = 0; i < 26; i++) {
      if (tempChars[i] > anagramChars[i])
        return false;
    }
    return true;
  }

  public static void reedWordList() {
    try {
      File myFile = new File("wordlist.txt");
      FileReader myFileReader = new FileReader(myFile);
      BufferedReader myReader = new BufferedReader(myFileReader);

      String word;
      String lastWord = "";

      while ((word = myReader.readLine()) != null) {
        if (lettersAvailable(word)) {
          System.out.println(word);
          if (!word.equals(lastWord)) {
            if (word.length() > 1) {
              wordList.add(word);
              lastWord = word;
            }
          }
        }
      }
      // add single characters
      wordList.add("a");
      wordList.add("i");
      // we do not need to add o since the word is "o'" and there isnt an apostrophe
      // in the anagram
      // since we get one less word, our total wordlist count gets shortened to 1649,
      // which is a tribute to King Charles' beheading :-)

      System.out.println("Words Added: " + wordList.size());
      myReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  // function for generating and checking anagrams
  public void generateAnagrams() {
    // generate 3 word sentences from the word we get
    // isAnagram(string1, anagram);
    for (int i = 0; i < wordList.size(); i++) {
      String string1 = wordList.get(i);
      for (int j = 0; j < wordList.size(); j++) {
        String string2 = wordList.get(j);
        for (int k = 0; k < wordList.size(); k++) {
          String string3 = wordList.get(k);
          if (isAnagram(string1 + " " + string2 + " " + string3)) {
            if (TPHashing.MD5Hash(string1 + " " + string2 + " " + string3).equals("e4820b45d2277f3844eac66c903e84be")) {
              System.out.println(string1 + " " + string2 + " " + string3);
              System.out.println("Time: " + (System.nanoTime() - startTime) / 1000000000 + "ms");
              System.exit(0);
            }
          }
        }
      }
    }
    // check if the sentences are anagrams

    // check if any anagrams has the right MD5

    // e4820b45d2277f3844eac66c903e84be
    // 23170acc097c24edb98fc5488ab033fe
  }

}
