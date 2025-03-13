class stringcons{
	public static void main(String aregs[]){
		String s1 = new String();
		String s2 = new String("Hello");
		char cArray[] = {'B', 'a', 'l', 'a', 'n'};
		String s3 = new String(cArray);
		String s4 = new String(cArray, 1, 3);
        System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
    }
}