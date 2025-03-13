import java.awt.*;


 class p4 extends Frame {
  
  CardLayout layout ;
  
   p4(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);

  

       layout = new CardLayout() ;

        setLayout( layout ) ;

        add("first", new Button( "First"  ) ) ;
        add("second", new Button( "Second" ) ) ;
        add("third",  new Button( "Third"  ) ) ;
        add("fourth", new Button( "Fourth" ) ) ;
        add("fifth",  new Button( "Fifth"  ) ) ; 
    }

    public boolean action( Event evt, Object arg ) {

        if ( evt.target instanceof Button ) {
            layout.next(this) ;
            return true ;
            }

        return false ;
    }

public static void main(String bpd[]){
 	new p4("Card Layout");
 }
}
