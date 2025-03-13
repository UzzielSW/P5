//stringbuffermeth2.java
class stringbuffermeth2{
	public static void main(String aregs[]){
		StringBuffer s1 = new StringBuffer("I saw BALA in Ethiopia.");
		char c1 = s1.charAt(0);
		System.out.println(c1);
		s1.setCharAt(9, 'U');
		System.out.println(s1);
    }
}