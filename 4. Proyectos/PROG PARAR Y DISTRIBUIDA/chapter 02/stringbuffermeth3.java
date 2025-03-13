//stringbuffermeth3.java
class stringbuffermeth3{
	public static void main(String aregs[]){
		StringBuffer sb1 = new StringBuffer("2 + 2 = ");
		StringBuffer sb2 = new StringBuffer("The tires make contact ");
		sb1.append(2 + 2);
		sb2.append("with the road.");
		sb2.insert(10, "are the things on the car that ");
		System.out.println(sb1);
		System.out.println(sb2);
    }
}