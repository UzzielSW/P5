//stringmeth1.java
class stringmeth1{
	public static void main(String aregs[]){
		String s1 = new String("This is a test string!");
		int len = s1.length();
		char c = s1.charAt(8);
		boolean b1 = s1.startsWith("This");
		boolean b2 = s1.startsWith("test", 10);
		boolean b3 = s1.endsWith("string.");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
    }
}