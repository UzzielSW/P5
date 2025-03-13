package messages;
/**
 * Esta interfaz que contiene los mensajes de error más común que se puedan 
 * dar durante la simulación.
 */
public interface Messages{
	
   /**Campo de entrada de datos vacio.*/
   public static final String EMPTY_TEXTFIELD = "Deve llenar todos los campos de texto";
   /**Nombre ingresado incorrecto.*/
   public static final String INCORRECT_NAME = "El nombre no esta correcto";
   /**Dirección ingresada incorrecta.*/
   public static final String INCORRECT_DIRECTION = "La direccion no es correcta";
   /**Identificación Personal ingresada incorrecta.*/
   public static final String INCORRECT_ID = "La Cédula no esta correcta";
   /**Deposito ingresado incorrecto.*/
   public static final String INCORRECT_DEPOSIT = "El deposito esta incorrecto";
   /**Retiro ingresdado incorrecto.*/
   public static final String INCORRECT_RETIRO = "El retiro incorrecto";
   /**Número de cuenta ingresado incorrecto.*/
   public static final String INCORRECT_ACCOUNT = "Numero de cuenta incorrecto";
   /**Cliente no registrado.*/
   public static final String NOT_REGISTERED = "No se encuentra registrado";
   /**Fondos insuficientes para hacer transacción.*/
   public static final String INSSUFFICIENT_FOUNDS = "Fondos insuficientes";
   /**Retiro ingresado incorrecto.*/
   public static final String INCORRECT_WITHDRAW = "Retiro incorrecto";
   
   
}