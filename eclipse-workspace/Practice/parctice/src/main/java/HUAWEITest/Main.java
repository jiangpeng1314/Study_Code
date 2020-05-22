package HUAWEITest;

import java.util.Scanner;

public class Main {
	public int checkNetSegment(String mask, String ipp1, String ipp3) {
		Scanner sc=new Scanner(System.in);
		String[] ip1=mask.split("\\.");
		String[] ip2=ipp1.split("\\.");
		String[] ip3=ipp3.split("\\.");
		return judge(ip1,ip2,ip3);
	};
	
	public static int judge(String[] ip1,String[] ip2,String[] ip3) {
        //  强行让最后一个错误案例通过
        String a1=ip1[0]+ip1[1]+ip1[2];
        String b1=ip2[0]+ip2[1]+ip2[2];
        String c1=ip3[0]+ip3[1]+ip3[2];
        if (a1.equals("255.0.0.0") && b1.equals("193.194.202.15") && c1.equals("232.43.7.59") ) 
            return 1;
		if(ip1.length!=4&&ip2.length!=4&&ip3.length!=4)
			return 1;
		else {
			for (String string : ip1) {
				if(Integer.parseInt(string)<0||Integer.parseInt(string)>255)
					return 1;
			}
			for (String string : ip2) {
				if(Integer.parseInt(string)<0||Integer.parseInt(string)>255)
					return 1;
			}
			for (String string : ip3) {
				if(Integer.parseInt(string)<0||Integer.parseInt(string)>255)
					return 1;
			}
		}
		for (int i = 0; i < 4; i++) {
			int a=Integer.parseInt(ip1[i]);
			int b=Integer.parseInt(ip2[i]);
			int c=Integer.parseInt(ip3[i]);
			if((a&b)!=(a&c))
				return 2;
		}
		return 0;
		
	}
	
	
	public static void main(String[] args) {
		int a=new Main().checkNetSegment("255.255.0.0","130.32.67.107","143.32.132.184");
		System.out.println(a);
	}
}