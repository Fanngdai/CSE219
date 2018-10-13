import java.io.PrintStream;

public class Testing {
	public static void main(String[] args){
		String a = "CSE";
		String b = new String("CSE");
		String c = "CSE 219";
		String d = c.substring(0,2);
		String e = c.substring(0,3);
		
		PrintStream out = System.out;
		
		out.println(a);
		out.println(b);
		out.println(c);
		out.println(d);
		out.println(e);
		
		if(a == b) out.println("A");
		else if (a == c) out.println("B");
		else if (a == d) out.println("C");
		else if (a == e) out.println("D");
		else out.println("E");
	}
}
