import java.awt.*;
public class Camion implements Runnable {
 int adresse=0; 
 byte direcc;
 byte ad;
 byte idt;
 Pont pont;
 private int contre=0;
 public int flag;
 private boolean stationnement[],ressorts[],stationnementf[];
 private int stationnement_correspondiente,ressorts_correspondiente,stationnementlf_correspondiente;
 Point location;	
int x=10,y;
int xa, ya,x1,y1,xa1,ya1;
 public Image i  =Toolkit.getDefaultToolkit().getImage( System.getProperty("user.dir")+System.getProperty("file.separator")+ "bluecar1.gif");
 public Image j = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+System.getProperty("file.separator")+"redcar1.3.gif");
public void kmcont(){
    this.contre++;
}
    public int getContador() {
        return contre;
    }
public Camion( byte dir, Pont p, byte n,boolean esta[],boolean muelles[],boolean estancionamientof[]) {
     this.stationnement=esta;
     this.stationnementf=estancionamientof;
     this.ressorts=muelles;
     adresse=dir; 
     pont = p;ad = n; 	
       if( (int)dir==0 ){ 
     	x=-1500;
     	y=650;
     }
     if( (int)dir==0 ){
     xa=0;
     ya=20;	
     }
     if( (int)dir==0 ){  
      	xa1=-1500;
      	ya1=650;
      }
     } 
public void run() { 
try{
Thread.sleep( (int)(Math.random()*1000) );
}catch(InterruptedException e){} 
while(true){
pont.demarrage1( adresse, ad );
this.ressorts_correspondiente=Sélectionnezressorts();
pont.ressorts(this.ressorts_correspondiente,ad);
pont.est_sorti_de_la_cale( ad,(int)adresse);
pont.approché_de_la_route( ad,(int)adresse );
pont.la_route1( ad,(int)adresse );
pont.sur_le_pont2( ad,(int)adresse );
pont.est_sur_le_pont(ad,(int)adresse);
pont.bas_de_la_route2(ad,(int)adresse);
pont.la_route2( ad,(int)adresse );
pont.atteindre_l_intersection(ad,(int)adresse);
pont.arrivés_dans_la_ville( ad,(int)adresse);
pont.laissant_la_ville(ad,(int)adresse);
this.stationnement_correspondiente=Sélectionnezstationnement();
pont.au_restaurant(ad,(int)adresse);
pont.parc(this.stationnement_correspondiente,ad);
pont.Le_Restaurant(ad,(int)adresse);
pont.a_quitté_le_restaurant(ad,(int)adresse);
pont.Retour_vers_le_pont(ad,(int)adresse);
pont.la_route5(ad,(int)adresse);
pont.la_station(ad,(int)adresse);
this.stationnementlf_correspondiente=Sélectionnezstationnementf();
pont.parking_finales(this.stationnementlf_correspondiente,ad);

}
} 
public void paint(Graphics g) 
{ 
 if(xa==0){
g.drawImage(i, x, y, null);
g.drawString("Camion: "+ad,x,y );

}  
if(xa== 1){
g.drawImage(j, x, y, null);

g.drawString("Camion: "+ad,x,y );	
}
if(xa==2){
	g.drawImage(i, x, y, null);
	g.drawString("Camion: "+ad,x,y );
	
}
}
    public int getstationnement_correspondiente() {
        return stationnement_correspondiente;
    }
    public int getressorts_correspondiente() {
        return ressorts_correspondiente;
    }
    public int getstationnementf_correspondiente() {
        return stationnementlf_correspondiente;
    }
    public byte getId() {
        return ad;
    }
    public void setId(byte id) {
        this.ad = id;
    }
    public int Sélectionnezstationnement() {
        for(int i=0;i<3;i++)
        {
          if(this.stationnement[i])
          {
            this.stationnement[i]=false;
         
            return i;
          }
        }
       
        return -1;
    }
   public void publié()
   {
       if(this.stationnement_correspondiente!=-1)
       this.stationnement[this.stationnement_correspondiente]=true;
   }
   public int Sélectionnezressorts() {
    	   for(int j=0;j<4;j++){
         if(this.ressorts[j]){
           this.ressorts[j]=false;
           return j;
         }
       } 
       return (int) (Math.random()*4);
   }
   public void publiéressorts()
   {
       if(this.ressorts_correspondiente!=-1)
       this.ressorts[this.ressorts_correspondiente]=true;
   }
   public int Sélectionnezstationnementf() {
	for(int j=0;j<10;j++){
     if(this.stationnementf[j]){
       this.stationnementf[j]=false;
       
       return j;
     } 
   } 
   return (int) (Math.random()*4);
}
public void publiéstationnementf(){
   if(this.stationnementlf_correspondiente!=-1)
   this.stationnementf[this.stationnementlf_correspondiente]=true;
}
} 
