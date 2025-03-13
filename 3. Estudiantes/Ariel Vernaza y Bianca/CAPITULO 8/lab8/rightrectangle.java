
public class RightRectangle extends Shape{
	 public int width;
	 public int height;
	 
	 public RightRectangle(int width,int height){
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
	int kuro=(int)this.height/this.width;
	System.out.println("*");
	for(int i=0;i<this.height-2;i++){
	for(int m;z)	
	 for(int j=0;j<kuro;j++)
		System.out.print("*\t");
		}
	   System.out.print("\n");
	 for(int k=0;k<this.width;k++)  	
		System.out.print("*");
	}
}
