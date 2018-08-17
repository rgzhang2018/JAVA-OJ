
// 利用sort的快排，使得每组元素快速的得到一个固定的顺序，便于后续比较
// 将特征值放在MAP里，利用containsKey快速查得所需，可以节省大量的时间

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s : strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String t = String.valueOf(tmp);
            if(map.containsKey(t)){
                map.get(t).add(s);
            } else{
                map.put(t, new ArrayList<String>());
                map.get(t).add(s);
            }
        }
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}