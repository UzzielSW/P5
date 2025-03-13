package media;

import java.applet.*;

/**
 * Clase que retorna objetos AudioClip.
 */
public class SoundEffects {

  
   private String prefix = "";

   
   public SoundEffects() { }

  /**Retorna el AudioClip asociado con el soundFile.
   @param soundFile Nombre del archivo de sonido.
   @return AudioClip.*/ 
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

   /**Método que coloca  el nombre de la carpeta donde se encuentran los archivos de audio.
    @param string Nombre de la carpeta donde se encuentran los archivos de sonido.*/
   public void setPathPrefix( String string )
   {
      prefix = string;
   }
}