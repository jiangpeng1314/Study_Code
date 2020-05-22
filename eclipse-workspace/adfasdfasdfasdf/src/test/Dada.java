package test;

public class Dada {
	
		public int FirstNotRepeatingChar(String str) {
	        int[] count=new int[256];
	        for(int i=0;i<str.length();i++){
	            count[str.charAt(i)]++;
	        }
	        for(int i=0;i<str.long;i++){
	            if(count[str.charAt(i)]==1)
	                return i;
	        }
	        return -1;
	    }
	

	public static void main(String[] args) {
		Dada da = new Dada();
		String google="google";
		int a=da.FirstNotRepeatingChar(google);
		System.out.println();
		System.out.println("a value:"+a);

	}

}
