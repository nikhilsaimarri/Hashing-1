// First approach
//take hashmap and push ith values from both strings if character do not exist already, else check if corresponding value matches to continue.

//Second approach
// take one hashmap and hashset and check if current char exists and if so also check its value matches to corresponding t string, else check its corresponding t string char does not exist in set and now add schar, tchar in map and tchar in set.

//Time complexity: O(n)
//Space Complexity : O(1)   because here we can only store atmost 26 characters in map/set.



class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> hash1 = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

      // if both lengths are not same, they cannot match
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            // if schar is not added into map
            if (!hash1.containsKey(schar)) {
                //if corresponding tchar is not assigned to any other schar
                if(!set.contains(tchar)){

                    //add into map
                    hash1.put(schar, tchar);
                    set.add(tchar);
                }
                else{
                    // already some other schar has assigned to this tchar
                    return false;
                }  
            } else {
                // current schar has a tchar already assigned
                if (hash1.get(schar) != tchar) {
                    return false;
                }
            }
        }
        return true;

    }
    }

// HashMap<Character, Character> hash1 = new HashMap<>();
// HashMap<Character, Character> hash2 = new HashMap<>();
// if (s.length() != t.length()) {
//     return false;
// }
// for (int i = 0; i < s.length(); i++) {
//     char schar = s.charAt(i);
//     char tchar = t.charAt(i);
//     if (!hash1.containsKey(schar)) {
//         hash1.put(schar, tchar);
//     } else {
//         if (hash1.get(schar) != tchar) {
//             return false;
//         }
//     }
//     if (!hash1.containsKey(tchar)) {
//         hash1.put(tchar, schar);
//     } else {
//         if (hash1.get(tchar) != schar) {
//             return false;
//         }
//     }

// }
// return true;
