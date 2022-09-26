import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors




public class TrustpilotMD5 {
  static String anagram = "poultry outwits ants";
  static byte[] anagramChars = new byte[26];
  static int anagramLength = anagram.length();
  static ArrayList<String> wordList = new ArrayList<String>();

  public static void anagramToArray() {
      //DONE - convert anagram to anagramChars array
      // 1 - create a loop for reading each consecutive char in the anagram
      for (int i=0 ; i<anagramLength ; i++) {
      // 2 - check if the read char is a letter from a-z (or we can simply assume it is)
          char tempChar = anagram.charAt(i);
          if (tempChar >= 'a' && tempChar<='z') {
              // 3 - add +1 to the spot in the anagramChars array, which corresponds to the given char
              anagramChars[tempChar -'a']++;
          }
      }
  }
  
  //specific function for checking if a string s is an anagram of the global string 'anagram'
  public static boolean isAnagram(String s) {
      // 1 - convert s to a char array like the one used for the anagram
      if (s.length() != anagramLength) {
          return false;
      }

      byte[] tempChars = new byte[26];
      for (int i=0 ; i<anagramLength ; i++) {
          char tempChar = s.charAt(i);
          if (tempChar != ' ') {
              tempChars[tempChar -'a']++;
          } 
          
      }
      // 2 - compare the number of elements in both arrays to see if they match
      for (int i=0; i<26; i++){
        if (tempChars[i] != anagramChars[i]){
          return false;
        }
      }
      return true;
  }
  
  //general function for checking if two strings are anagrams of each other
  public static boolean isAnagram(String s1, String s2) {
    byte[] tempChars1 = new byte[27];
    byte[] tempChars2 = new byte[27];
    int length;

    length = s1.length();
    for (int i=0 ; i<anagramLength ; i++) {
      char tempChar1 = s1.charAt(i);
      if (tempChar1 != ' ') {
          tempChars1[tempChar1 -'a']++;
      }
  }
  for (int i=0 ; i<anagramLength ; i++) {
        char tempChar2 = s1.charAt(i);
        if (tempChar2 != ' ') {
            tempChars2[tempChar2 -'a']++;
        }
  }
  
  length = s2.length();
  for (int i=0 ; i<anagramLength ; i++) {
      char tempChar = s2.charAt(i);
      if (tempChar != ' ') {
          tempChars1[tempChar -'a']++;
      }
  }
  
  for(int i=0 ; i<26 ; i++) {
    if (tempChars1[i] != tempChars2[i]){
      return false; }
    }

  return true;
  
}


  
  
  //check if a given string can be written using the letters available from the anagram
  public static boolean lettersAvailable(String s) {
      byte [] tempChars = new byte[26];
      int length = s.length();
      for (int i=0 ; i<length ; i++) {
          char tempChar = s.charAt(i);
          if (tempChar != ' ') {
              tempChars[tempChar -'a']++;
          } else {
            return false;
          }
      }
      for (int i=0; i<26; i++){
        if (tempChars[i] > anagramChars[i]){
          return false;
        }
      }
      return true;
  }
  

}


