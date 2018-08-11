
class Solution {
    private static HashMap<Character,Integer> h = new HashMap<>();
	//将该固定的HashMap的构造放在static位置，提升后面每次的运行效率（实测提速了60%+）
	static{
		h.put('M',1000);
		h.put('D',500);
		h.put('C',100);
		h.put('L',50);
		h.put('X',10);
		h.put('V',5);
		h.put('I',1);
	}
	public int romanToInt(String s) {

		int length = s.length();
		int count = 0;
		
		int i;
		for( i = 0 ;i<length;i++){
			if(i!=length-1 && isBack(s,h,i)){
				i++;
				count+=h.get(s.charAt(i))-h.get(s.charAt(i-1));
			}
			else {
				count+=h.get(s.charAt(i));
			}
		}
		return count; 
	}

	private boolean isBack(String str,HashMap s,int i){
		return (Integer) s.get(str.charAt(i)) < (Integer) s.get(str.charAt(i + 1));
	}

}
