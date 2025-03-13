package media;

import java.applet.*;

public class SoundEffects {

   // localizacion de los archivos de sonido
   private String prefix = "";

   public SoundEffects() { }

   
   public AudioClip getAudioClip( String soundFile )
   {
      try {
         return Applet.newAudioClip( getClass().getResource( 
            prefix + soundFile ) );
      }

      
      catch ( NullPointerException nullPointerException ) {
         return null;
      }
   }

   
   public void setPathPrefix( String string )
   {
      prefix = string;
   }
}