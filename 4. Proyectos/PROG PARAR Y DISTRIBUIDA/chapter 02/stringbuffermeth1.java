//stringbuffermeth1.java
class stringbuffermeth1{
	public static void main(String aregs[]){
		StringBuffer s1 = new StringBuffer(14);
		System.out.println("capacity = " + s1.capacity());
		System.out.println("length = " + s1.length());
		s1.append("Bala");
		System.out.println(s1);
		System.out.println("capacity = " + s1.capacity());
		System.out.println("length = " + s1.length());
		s1.setLength(3);
		System.out.println(s1);
		System.out.println("capacity = " + s1.capacity());
		System.out.println("length = " + s1.length());

    }
}