public class Fish extends Animal implements Pet{
 private String name;
public void walk(){
System.out.println("Por supuesto, los peces no pueden camina; ellos nadan");
} 
public Fish(String nombre){
  super(0);
  this.setName(nombre);
 }	

public void setName(String name){
  this.name=name;
 }
 public String getName(){
	 return(this.name);
 }
public void Play(){
 System.out.println(this.name+" nada en su estanque todo el dia");	
}
public void eat(){
 System.out.println("Los peces comen basura del tanque");
}
}
