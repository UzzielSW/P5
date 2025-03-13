
public class TestAnimal {
	public static void main(String arg[]){
	 Fish f=new Fish("Pecesito");
	 Cat c=new Cat("SIlvestre");
	 Animal a1 =new Fish("Pex");
	 Animal a2=new Spider();
	 Pet p= new Cat();
	 f.Play();
	 c.Play();
	 a1.eat();
	 a1.walk();
	 a2.eat();
	 a2.walk();	 
	 p.Play();
	 p.getName();
	}
}
