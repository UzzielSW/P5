public interface IntPenInterSocket {
	
	public double calcula_pendiente(Punto p1,Punto p2);
	public double calcula_pendiente(Linea lin); 
	public void validaPuntos(Punto p1, Punto p2) 
		throws PuntosIgualesException; 
    public double calculaB(Linea lin);
    public double calculaB(Punto p1,double m); 
    public Punto calIntersecEjeX(Linea lin); 
    public Punto calIntersecEje2X(Linea lin);
    public Punto calIntersecEjeY(Linea lin) ;
  //  public Punto calcula_interseccion(Linea a, Linea b)
}