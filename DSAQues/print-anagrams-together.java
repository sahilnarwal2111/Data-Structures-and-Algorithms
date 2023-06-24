class Solution {
    public static HashMap<Character, Integer> hashMapCalc(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        return map;
    }
    
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> bmap = new HashMap<>();
        for(int i = 0 ; i < string_list.length; i++){
            String str = string_list[i];
            HashMap<Character, Integer> map = hashMapCalc(str);
            if(bmap.containsKey(map)){
                List<String> l1 = bmap.get(map);
                l1.add(str);
                // Collections.sort(l1);
            }
            else{
                List<String> l1 = new ArrayList<>();
                l1.add(str);
                bmap.put(map, l1);
            }
        }
        for(HashMap<Character, Integer> map : bmap.keySet()){
            ans.add(bmap.get(map));
        }
       Collections.sort(ans, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                String s1 = list1.get(0);
                String s2 = list2.get(0);
                return s1.compareTo(s2);
            }
        });
        return ans;
    }
}
