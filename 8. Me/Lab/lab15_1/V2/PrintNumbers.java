
public class PrintNumbers implements Runnable{

    public boolean keepGoing;
    public Print gui;

    public PrintNumbers(Print g)
    {
        keepGoing = true;
        gui = g;
    }

    public void stopPrinting()
    {
        keepGoing = false;
    }

    @Override
    public void run()
    {
        int counter = 1;
        
        while(keepGoing)
        {
            gui.getArea().append((counter++) + "\n");
            
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
        
        //habilitar botones
        gui.getInicio().setEnabled(true);
        gui.getLimpiar().setEnabled(true);
    }
}