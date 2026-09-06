package tema4;

import ed.Datos;
import ed.Formato;

public class Articulo
{
	private int nc, exi;
	private String nom;
	private double pre;
	private Datos obd = new Datos();
	private Formato obf = new Formato();

	public Articulo()
	{
		do
			nc = obd.Entero("\nNo. Clave a buscar: ");
		while (nc < 1);
	}

	public Articulo(int nc)
	{
		this.nc = nc;
		System.out.println("\nEscribe los datos del articulo");
		System.out.println("No. Clave " + nc);
		nom = obd.Cadena("Nombre: ").toUpperCase();
		do
			pre = obd.Doble("Precio: ");
		while (pre < 1);
		do
			exi = obd.Entero("Existencia: ");
		while (exi < 0);
	}

	public void Mostrar()
	{
		System.out.println(obf.Izquierda(nc + "", 5) + obf.Izquierda(nom, 25) + obf.Derecho(obf.Pesos(pre), 12)
				+ obf.Derecho(exi + "", 12));
	}
	public int NoClave()
	{
		return nc;
	}
}
