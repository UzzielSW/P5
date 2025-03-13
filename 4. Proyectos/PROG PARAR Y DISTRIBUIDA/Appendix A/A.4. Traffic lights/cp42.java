import java.awt.*;


public class cp42 extends Frame implements Runnable{ 
Thread t;

String s;
 public cp42(String s1){
 	s=s1;
   t=new Thread(this,s);
   t.start();
   setTitle(s);
   setSize(800,400);
   setVisible(true);
  }

public void run(){

while(true){ 

 try{
   setBackground(Color.red);
   t.sleep(1500);
   
   setBackground(Color.yellow);
   t.sleep(1500);
   
   setBackground(Color.green);
   t.sleep(1500);
     
   setBackground(Color.yellow);
   t.sleep(1500);
   
   }catch(Exception e){ }

  }

 }


 public static void main(String s[]) throws Exception{
  new cp42("one");
  new pillar1("two");
  new pillar2("three");
  
  
  }
}


