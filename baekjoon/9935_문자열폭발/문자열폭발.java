package pro;

import java.io.*;

public class 문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine();
		String bomb = br.readLine();

		StringBuilder sb = new StringBuilder();
		
		sb.append(target);
		
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == bomb.charAt(0)) {
				if(bomb.length()+i > sb.length())continue;
					String temp = sb.substring(i, i + bomb.length());
					
				if(temp.equals(bomb)) {
					sb.delete(i, i+bomb.length());
						i-=bomb.length();
					if(i<=-2) i=-1;
				}
			}
		}

		if (sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb.toString());
		}
}
