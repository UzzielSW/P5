
public class Rectangle extends Shape{
 public int width;
 public int height;
 
 public Rectangle(int width,int height){
 if(width<1||width>15)
	this.width=15;
 else
   this.width=width;	 
 if(height<1||height>15)
	 this.height=15;
 else
	this.height=height;   
 }
  
 void draw(){
	for(int i=0;i<(this.width);i++){
	  System.out.print("*\t");}
	  System.out.print("\n");
	for(int j=0;j<(this.height-2);j++){
	 System.out.print("*");
	 for(int k=0;k<(this.width-1);k++){
		 System.out.print("\t");}
	 System.out.print("*\n");
	}
   for(int m=0;m<(this.width);m++){
		  System.out.print("*\t");}
 } 
}
