import java.util.Vector;
import javax.swing.*;
public class GuessingGame {
	public int target;
	public Vector guessed;
  public GuessingGame(int target){
	  this.target=target;
	  this.guessed=new Vector(100,25);
  }
  public void startGuessing(){
   int j=0,k=0;
   while(true){
   j =(int)((Math.random()*100)+1);
   if(j==this.target)
	  break;
   else{
	this.guessed.add(k,Integer.valueOf(j));
	  k++;  
   } 
   }
  }
  public void printGuessed(){
	for(int i=0;i<guessed.size();i++){
	System.out.println("Elemento guessed["+(i+1)+"] :"+guessed.get(i));	
	}
	System.out.println("Tamaño del arreglo: "+guessed.capacity());	  
  }
  public static void main(String arg[]){
	 String a= JOptionPane.showInputDialog("Ingrese un numero:");
	 GuessingGame test=new GuessingGame(Integer.parseInt(a));
	 System.out.println("ENECUNTRA: " +a);
	 test.startGuessing();
	 test.printGuessed();
  }
}
