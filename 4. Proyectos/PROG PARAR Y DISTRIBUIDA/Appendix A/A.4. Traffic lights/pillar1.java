import java.awt.*;


class pillar1 extends Frame implements Runnable{ 
Thread t;
Color c;
String s;
 public pillar1(String s1){
 	s=s1;
   t=new Thread(this,s);
   t.start();
    setTitle(s);
   setSize(400,400);
   setVisible(true);
  }

public void run(){
boolean tt=true;

while(tt){ 

 try{
   setBackground(Color.yellow);
   t.sleep(1500);
   
   setBackground(Color.green);
   t.sleep(1500);
   
   setBackground(Color.yellow);
   t.sleep(1500);
   
   setBackground(Color.red);
   t.sleep(1500);
   }catch(Exception e){ }

  }
 }
 
}
