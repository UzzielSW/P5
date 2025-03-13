import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class otro extends JFrame
{


public otro()
{

File sf=new File("2.wav");
AudioFileFormat aff;
AudioInputStream ais;


try
{
aff=AudioSystem.getAudioFileFormat(sf);

ais=AudioSystem.getAudioInputStream(sf);


AudioFormat af=aff.getFormat();


DataLine.Info info = new DataLine.Info(
Clip.class,
ais.getFormat(),
((int) ais.getFrameLength() *
af.getFrameSize()));

Clip ol = (Clip) AudioSystem.getLine(info);

ol.open(ais);

ol.loop(Clip.LOOP_CONTINUOUSLY);

System.out.println("reprodución empezada, apretar CTRL-C para interrumpir");

}
catch(UnsupportedAudioFileException ee){}
catch(IOException ea){}
catch(LineUnavailableException LUE){};

}

public static void main(String[] ar)
{
new otro();

}

}
//------------------