import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
@SuppressWarnings("serial")
public class Pont extends JFrame {
byte adresse = 0; 
Camion[] truck;
L_Imagen l;
int flag,km,occupés=0,occupés2=0,occupés3=0;
JFrame fenêtre;
JTextArea gps;
JButton mise_à_jour;
public Pont( ){ 
 fenêtre = new JFrame();		 
Container contentPane = fenêtre.getContentPane();
		gps = new JTextArea();   	
    	JScrollPane pane = new JScrollPane(gps,
    	ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    	ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);   
	contentPane.add(pane,BorderLayout.CENTER);
	JPanel centerPanel = new JPanel();  
	 mise_à_jour = new JButton("Actualizar");
	mise_à_jour.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		gps.setText("");		
		}
	});
	centerPanel.add(mise_à_jour);
	contentPane.add(centerPanel,BorderLayout.SOUTH);
	fenêtre.setSize (370,400);
    fenêtre.setLocation (150,500);
    fenêtre.setTitle ("GPS EN CONSOLA");
    JFrame.setDefaultLookAndFeelDecorated(true);
	fenêtre.setVisible (true);	
} 	
public void setL_Imagen(L_Imagen Imagen){ 
l=Imagen; 
} 
public void setCamion( Camion[] truck ){ 
	this.truck = truck;
} 
public synchronized void demarrage1(int ad , byte id){
	km++;
	if(km>4){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
		if(ad==0){
			gps.append("Camion: "+id+" llenado el camion."+"\n");
			l.repaint();
			try{
				Thread.sleep(30);
			}catch(InterruptedException e){}
		}
	}
	else{
	try{
		Thread.sleep(1000);
	}catch(InterruptedException e){}
	if(ad==0){
		gps.append("Camion: "+id+" llenado el camion."+"\n");
		l.repaint();
		try{
			Thread.sleep(30);
		}catch(InterruptedException e){}
	}
	}
}
public void ressorts(int ressort, byte id){
    switch(ressort){
        case 0:
    while( truck[id].y >= 360){
                truck[id].x = truck[id].x +1;
                truck[id].y=truck[id].y-6;
                truck[id].kmcont();
                l.repaint();
                try{
                    Thread.sleep(50);
                    } catch(InterruptedException e){}
                 }
    while( truck[id].x+50 <= 300){
        truck[id].x = truck[id].x +10;
        truck[id].kmcont();
        l.repaint();
       
        try{
            Thread.sleep(50);
            } catch(InterruptedException e){}
    }
	
    while(occupés2==1){
    	 try{
             Thread.sleep(1000);//
             
             } catch(InterruptedException e){}
            
    }
    
    while( truck[id].y<=415){
    	if(truck[id].y>=355&&truck[id].y<=410&&truck[id].x<=260&&truck[id].x>=180){
    		
    		occupés2=2;
    	}
    	else{
    		    		occupés2=0;
    	}
     l_action3(id);
            }
    
   break;
        case 1:
            while( truck[id].y >= 470){
            	
                truck[id].x = truck[id].x +1;
                truck[id].y=truck[id].y-6;
                truck[id].kmcont();
                l.repaint();
                try{
                    Thread.sleep(50);
                    } catch(InterruptedException e){}
                 }
        break;
        case 2:
               while( truck[id].y >= 560){
                truck[id].x = truck[id].x +2;
                truck[id].y=truck[id].y-6;
                truck[id].kmcont();
                l.repaint();
                try{
                    Thread.sleep(50);
                    } catch(InterruptedException e){}
                 }
                
             break;
        case 3:
        	while( truck[id].y >= 690){
                truck[id].x = truck[id].x +20;
                truck[id].kmcont();
                l.repaint();
                try{
                    Thread.sleep(50);
                    } catch(InterruptedException e){}
                 }
                
         break;
        default:
}
}

public void  est_sorti_de_la_cale(byte id, int ad) { 
if( ad == 0 ){ 
gps.append("Camion: "+id+" Salio del muelle ."+"\n");
while( truck[id].x+50 <= 300){ 
l_action1(id);
} 
} 
}
public void approché_de_la_route(byte id, int ad) { 
if( ad == 0 ){ 
gps.append("Camion: "+id+" llego al camino."+"\n");
while(occupés2==2){
	try{
		
		Thread.sleep(1000);
		} catch(InterruptedException e){} 
}
while( truck[id].y >= 420){
	if(truck[id].y>=425&&truck[id].y<=4800&&truck[id].x<=260&&truck[id].x>=220){
	
		occupés2=1;
	}
	else{
		
		occupés2=0;
	}
l_action4(id);
}
} 
}
public void la_route1(byte id,int ad){
if(ad==0){
	gps.append("Camion: "+id+" llego al camino."+"\n");
	while( truck[id].x-50 <= 560){
		truck[id].x = truck[id].x+10;
                truck[id].kmcont();
        l.repaint();
        try{
       Thread.sleep(50);
} catch(InterruptedException e){} 
}	
}
}

public void sur_le_pont2(byte id, int ad){
if(ad==0){
	gps.append("Camion: "+id+" camion llego al puente."+"\n");	
while( truck[id].y-240 >= 90){
		l_action4(id);
}	
}	
}
public synchronized void est_sur_le_pont( byte id, int ad ) { 
	 while(occupés==2){
		 try{
			 Thread.sleep(50);
			 } catch(InterruptedException e){} 	 
	 }
gps.append("Camion: "+id+" Esta pasando el puente."+"\n");
if( ad == 0){ 
while( truck[id].x-50 <= 800&&truck[id].x-50 >= 320){ 
occupés=1;
truck[id].x = truck[id].x+15;
truck[id].kmcont();
l.repaint();
try{
Thread.sleep(50);
} catch(InterruptedException e){} 
} 
}
notifyAll();
} 
public void bas_de_la_route2(byte id, int ad) {
	occupés=0;
gps.append("Camion: "+id+" Esta bajando hacia al camino2."+"\n");
if( ad == 0 ){ 
while( truck[id].y-120 <= 390){ 
l_action3(id); 
} 
} 
}
public void la_route2(byte id,int ad){
if(ad==0){
	gps.append("Camion: "+id+" pasando al camino2."+"\n");
	while( truck[id].x-50 <= 900){
		l_action1(id);
}	
}
}
public void atteindre_l_intersection(byte id, int ad) { 
if( ad == 0 ){ 
gps.append("Camion: "+id+" interseccion a la ciudad."+"\n");

while( truck[id].y-310 >= 90){ 
truck[id].y = truck[id].y-2;
truck[id].x = truck[id].x+2;
truck[id].kmcont();
l.repaint();
try{
Thread.sleep(50);
} catch(InterruptedException e){} 
}
} 
}
public void arrivés_dans_la_ville(byte id, int ad) { 
if( ad == 0 ){ 
gps.append("Camion: "+id+" llego a la ciudad."+"\n");
while( truck[id].x <=1100){ 
	l_action1(id);
	} 
while( truck[id].x <=1600){ 
l_action6(id);
} 
while( truck[id].y-245>=90){ 
	truck[id].y= truck[id].y - 25;
	truck[id].kmcont();
	l.repaint();
	try{
	Thread.sleep(50);
	} catch(InterruptedException e){} 
	}
} 
}
 public byte laissant_la_ville(byte id, int ad) { 
 	byte idt=id;
 	try{
Thread.sleep( (int)(Math.random()*3000)+3000 );
} catch(InterruptedException e){} 
if( ad == 0 ){ 
gps.append("Camion: "+id+" saliendo de la ciudad."+"\n");
while( truck[id].x-30>1100){ 
truck[id].xa=1;
truck[id].x = truck[id].x -300; 
l.repaint();
try{
Thread.sleep(30);
} catch(InterruptedException e){} 
}
while( truck[id].x-30>1050){ 
	l_action2(id);
}
} 
return idt;
}
public void au_restaurant(byte id, int ad)  {
	gps.append("Camion: "+id+" camiones hacia el restaurante."+"\n");
                 while( truck[id].y>=110){
                 l_action4(id);
                     }
}
public void parc(int estasionamiento, byte id){
    switch(estasionamiento){
        case 0:
    while( truck[id].x >= 850){
               l_action2(id);
                 } 
    while( truck[id].y>=10){
      l_action4(id); 	
         }
    le_sommeil1();
    break;
        case 1:
            while( truck[id].x >= 950){
                l_action2(id);
                 }
            
            while( truck[id].y>=10){
            l_action4(id);
           
            }
            le_sommeil1();
                 while( truck[id].y<=60){
                     l_action3(id);
                      }break;    
        case 2:
               while( truck[id].x >= 1050){
          l_action2(id);
                 }
                
               while( truck[id].y>=10){
                  l_action4(id);

                    }
            le_sommeil1();
                    while( truck[id].y<=70){
                       l_action3(id);
                         }break;
        default:flag=1;
}    
}

public void Le_Restaurant(byte id, int d) { 
	truck[id].publié();
if( d == 0 ){
gps.append("Camion: "+id+" Esta en restaurante."+"\n");
while( truck[id].x >= 850){ 
l_action2(id);
} 
} 
}

public void a_quitté_le_restaurant(byte id, int d) { 
while( truck[id].y <= 300){ 
l_action3(id);
} 
}
public synchronized void Retour_vers_le_pont(byte id, int d) { 
	while(occupés==1){
		try{
			Thread.sleep(50);
			} catch(InterruptedException e){} 	 
	}
if( d == 0 ){
	occupés=2;
gps.append("Camion: "+id+" Esta en el puente."+"\n");
while( truck[id].x-300 >= 320&&truck[id].x-300 <= 800){ 
truck[id].xa=1;
truck[id].x = truck[id].x -10;
truck[id].kmcont();
l.repaint();
try{
Thread.sleep(50);
} catch(InterruptedException e){} 
} 
} 
}
public void la_route5(byte id, int d ){
	occupés=0;
	if(d==0){
		while(truck[id].y>=200){
			l_action4(id);
		}
	}
}
public void la_station(byte id, int d) { 
if( d == 0 ){ 
while( truck[id].x>= 360){ 
l_action2(id); 
} 
} 
}

public void parking_finales(int estafin, byte id){
    switch(estafin){
    case 0:
    l_action5(id);
    break;
    case 1:
    	l_action5(id);
    	break;    
    case 2:
    	l_action5(id);
    	break;                 
    case 3:
   l_action5(id);
   break;    
   case 4:
   while( truck[id].x >= 235){
    l_action2(id);
         }
   while( truck[id].y>=118){
	   l_action4(id);
   }
   while( truck[id].x>=0){
  	l_action2(id);
  	       }
   try{
       Thread.sleep(5000);
   while( truck[id].x<=40){
 	   l_action1(id);
                }
   while( truck[id].y<=230){
	  l_action3(id);
   }cycle(id);
   }catch(InterruptedException e){}break;    
   case 5:
   while( truck[id].x >= 235){
      l_action2(id);
         }
   while( truck[id].y>=40){
	  l_action4(id);
   }
   while( truck[id].x>=0){
  	   l_action2(id);
    }
   try{
       Thread.sleep(5000);
   while( truck[id].x<=40){
 	   l_action1(id);
                }
   while( truck[id].y<=230){
	  l_action3(id);
   }cycle(id);
   }catch(InterruptedException e){}break;         
    case 6:
   while( truck[id].x >= 235){
      l_action2(id);
         }     	 
   while( truck[id].y>=40){
	   l_action4(id);
   }
   while( truck[id].x>=105){
	    	  l_action2(id);
	       }
   while( truck[id].y>=20){
	    	  l_action4(id);
	       }
   try{
       Thread.sleep(5000);
       while( truck[id].y<=230){
    		  l_action3(id);
    	   }
   while( truck[id].x>=40){
 	   l_action2(id);
                }
  cycle(id);
   }catch(InterruptedException e){}break;            
    case 7:
    while( truck[id].x >= 235){
    	l_action2(id);
         }
    while( truck[id].y>=40){
       l_action4(id);
     }
  	while( truck[id].x >= 185){
       l_action2(id);
         }
    while( truck[id].y>=20){
      l_action4(id);
       } try{
           Thread.sleep(5000);
           while( truck[id].y<=230){
        		  l_action3(id);
        	   }
       while( truck[id].x>=40){
     	   l_action2(id);
                    }
      cycle(id);
       }catch(InterruptedException e){}break;             
    case 8: 
    while( truck[id].x >= 235){
     l_action2(id);
         }
    while( truck[id].y>=40){
      l_action4(id);
         }
    while( truck[id].x <= 265){
       l_action1(id);
    }
    while( truck[id].y >= 20){
              l_action4(id);
           } 
    try{
               Thread.sleep(5000);
               while( truck[id].y >= 20){
                   l_action3(id);
                } 
               while( truck[id].x >= 200){
                   l_action2(id);
                }
               while( truck[id].y<=230){
            		  l_action3(id);
            	   }
           while( truck[id].x>=40){
         	   l_action2(id);
                        }
          cycle(id);
           }catch(InterruptedException e){}break;             
    case 9:
    while( truck[id].x >= 235){
    l_action2(id);
         }
    
    while( truck[id].y>=118){
       l_action4(id);
    }
    while( truck[id].x <=265){
     l_action1(id); 
       }
    try{
        Thread.sleep(5000);
        while( truck[id].x >= 200){
            l_action2(id);
         }
        while( truck[id].y<=230){
     		  l_action3(id);
     	   }
    while( truck[id].x>=40){
  	   l_action2(id);
                 }
   cycle(id);
    }catch(InterruptedException e){}
    break;              
    default:flag=1;
}}
public void cycle(byte id){
	 while( truck[id].x >= -1000){
	        truck[id].x = truck[id].x -500;
	        truck[id].kmcont();
	        truck[id].xa=2;
	        try{
	        	Thread.sleep(50);
	            } catch(InterruptedException e){}
	         }
	    while( truck[id].y <= 650){
	    	
	        truck[id].y = truck[id].y +50;
	        truck[id].kmcont();
	        try{
	            Thread.sleep(50);
	            } catch(InterruptedException e){}
	         }truck[id].y = truck[id].y -2;
	         truck[id].y=650;                    
}
public void l_action1(byte id){
	truck[id].x = truck[id].x + 5; 
	l.repaint();
	try{
	Thread.sleep(30);
	} catch(InterruptedException e){} 
}
public void l_action2(byte id){
	truck[id].x = truck[id].x - 5; 
	l.repaint();
	try{
	Thread.sleep(30);
	} catch(InterruptedException e){} 
}
public void l_action3(byte id){
	truck[id].y = truck[id].y + 5; 
	l.repaint();
	try{
	Thread.sleep(30);
	} catch(InterruptedException e){} 
}
public void l_action4(byte id){
	truck[id].y = truck[id].y - 5; 
	l.repaint();
	try{
	Thread.sleep(30);
	} catch(InterruptedException e){} 	
}
public void l_action5(byte id){
	while( truck[id].x >= 40){
        l_action2(id);
          } 
cycle(id);
}
public void l_action6(byte id){
	truck[id].publiéstationnementf();
	truck[id].x = truck[id].x +300; 
	l.repaint();
	try{
	Thread.sleep(30);
	} catch(InterruptedException e){} 		
}
public void le_sommeil1(){
	try{
		Thread.sleep( (int)(Math.random()*3000)+3000 );
	}catch(InterruptedException e){}
}


}



    



