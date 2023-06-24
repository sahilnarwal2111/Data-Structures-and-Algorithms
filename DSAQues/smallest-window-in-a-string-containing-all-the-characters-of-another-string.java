//https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < p.length(); i++){
            char ch = p.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);
        }
        int dmct = p.length();
        int mct = 0;
        int i =-1, j=-1;
        HashMap<Character, Integer> map1 = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i < s.length()-1 && mct<dmct){
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                    mct++;
                }
                f1 = true;
            }
            
            // collect and release step
            while(j < i && mct == dmct){
                String pans = s.substring(j+1,i+1);
                if(ans.length()==0 || pans.length()<ans.length()){
                    ans = pans;
                }
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch)==0){
                    map1.remove(ch);
                }
                else{
                    map1.put(ch,map1.get(ch)-1);
                }
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                    mct--;
                }
                f2 = true;
            }
            if(f1==false && f2 == false) break;
        }
        
        
        
        return ans;
        
    }
}
