/**
 *Programa del Temperature Converter
 *Creado por...
 *Nombre : Manuel Tejada
 *Cedula : 8-818-1801
 */

public class ConvertTemp {

    public ConvertTemp() {
    	
    }
    
    public double celsiusToFarenheit(double celsius){
    	return celsius*(9/5)+32;
    }
    
    public double farenheitToCelsius(double farenheit){
    	double resp =farenheit;
    	resp-=32;
    	resp*=5;
    	resp/=9;
    	return resp;
    }
}