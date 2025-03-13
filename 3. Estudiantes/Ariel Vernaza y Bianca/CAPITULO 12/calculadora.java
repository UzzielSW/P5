import java.awt.*;

public class Calculadora{
 private Label resultado;
 private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,punto,igual,mas,menos,por,entre;
 
 public Calculadora(){
resultado=new Label("0.0",Label.RIGHT);
resultado.setBackground(Color.WHITE);
cero=new Button("0");
uno=new Button("1");
dos=new Button("2");
tres=new Button("3");
cuatro=new Button("4");
cinco=new Button("5");
seis=new Button("6");
siete=new Button("7");
ocho=new Button("8");
nueve=new Button("9");
igual=new Button("=");
igual.setBackground(Color.pink);
mas=new Button("+");
menos=new Button("-");
por=new Button("X");
entre=new Button("/");
punto=new Button(".");
 }
 
 public void launchframe(){
 Frame f=new Frame("Calculadora");
 f.setLayout(new BorderLayout());
 f.add(resultado,BorderLayout.NORTH);
 Panel p1= new Panel();
 p1.add(siete);
 p1.add(ocho);
 p1.add(nueve);
 p1.add(mas);
 p1.add(cuatro);
 p1.add(cinco);
 p1.add(seis);
 p1.add(menos);
 p1.add(uno);
 p1.add(dos);
 p1.add(tres);
 p1.add(por);
 p1.add(cero);
 p1.add(punto);
 p1.add(igual);
 p1.add(entre);
 f.add(p1,BorderLayout.CENTER);
 f.setSize(130,170);
 f.setVisible(true);
 }
	public static void main(String args[]){
	Calculadora test=new Calculadora();
	test.launchframe();
	}
}
