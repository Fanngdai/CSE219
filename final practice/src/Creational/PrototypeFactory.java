package Creational;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory{
	
	interface Minion {
		Minion clone();
	}
	
	static class Stuart implements Minion{
		public Minion clone(){
			return new Stuart();
		}
		public String toString(){
			return "Stuart";
		}
	}
	
	static class Kevin implements Minion {
		public Minion clone(){
			return new Kevin();
		}
		public String toString(){
			return "Kevin";
		}
	}
	
	static class Bob implements Minion{
		public Minion clone(){
			return new Bob();
		}
		public String toString(){
			return "Banana!";
		}
	}
	
	static class GrusLab{
		private static Map<String, Minion> prototypes = new HashMap<>();
		static {
			prototypes.put("stuart", new Stuart());
			prototypes.put("kevin", new Kevin());
			prototypes.put("bob", new Bob());
		}
		public static Minion makeObject(String s){
			return ((Minion)prototypes.get(s).clone());
		}
	}
	
	public static void main(String[] args){
		for ( int i = 0; i < args.length; i++)
			System.out.println(GrusLab.makeObject(args[i] + " "));
	}
}