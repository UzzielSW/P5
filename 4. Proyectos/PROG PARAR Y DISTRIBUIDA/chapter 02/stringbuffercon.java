//stringbuffercon.java
class stringbuffercon{
	public static void main(String aregs[]){
	String s1 = new String("This is a string!");
	StringBuffer sb1 = new StringBuffer();
	StringBuffer sb2 = new StringBuffer(25);
	StringBuffer sb3 = new StringBuffer(s1);
		System.out.println(sb3);
    }
}