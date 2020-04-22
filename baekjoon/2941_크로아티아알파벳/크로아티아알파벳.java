import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] croa= {"c=","c-", "dz=","d-","lj","nj","s=","z="};
		for(int i = 0; i < croa.length ; i++) {
			str = str.replaceAll(croa[i], "Z");
		}
		System.out.println(str.length());
	}
}
