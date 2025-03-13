public class Nestedif {
public static void main(String args []) {
int a=10, b=5;
if ( a>=10)
   if(b<5)
		System.out.println(a+b);
   else 
		System.out.println(a-b);
else
    if(b>=5)
		System.out.println(a*b);
   else 
		System.out.println(a/b);

}
}
