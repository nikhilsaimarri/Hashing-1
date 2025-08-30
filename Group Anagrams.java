// First take a string and sort it, now check if it is in map and if available add to corresponding list of key value pair.
// else add a new sorted word and new list with word.

// TIme Complexity O(n * k)
// space complexity O(n*k)


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();

        // for(String str:strs){
        //     char[] word = str.toCharArray();
        //     Arrays.sort(word);
        //     String sortedStr = String.valueOf(word);
        //     if(!map.containsKey(sortedStr)){
        //         map.put(sortedStr, new ArrayList<>());
        //     }
        //         map.get(sortedStr).add(str);
        // }
        // return new ArrayList<>(map.values());

        for (String str : strs) {
            double e = hash(str);
            if (!map.containsKey(e)) {
                map.put(e, new ArrayList<>());
            }
            map.get(e).add(str);
        }
        return new ArrayList<>(map.values());
    }

    double hash(String str) {
        int[] values = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73,79, 83, 89, 97, 101};
        double value = 1;
        for (char c : str.toCharArray()) {
            value *= values[c - 'a'];
        }
        return value;
    }

}
