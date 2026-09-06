
package tema4;

import ed.Datos;
import ed.Formato;

public class Cuenta
{
	private int nc;
	private String nom;
	private double sal;
	private Datos obd = new Datos();
	private Formato obf = new Formato();

	public Cuenta()
	{
		do
			nc = obd.Entero("No. Cuenta a buscar: ");
		while (nc < 1);
	}

	public Cuenta(int nc)
	{
		this.nc = nc;
		System.out.println("Escribe losdatos de la cuenta");
		System.out.println("No. Cuenta " + nc);
		nom = obd.Cadena("Nombre: ").toUpperCase();
		do
			sal = obd.Doble("Saldo: ");
		while (sal < 1);
	}

	public void MostrarT()
	{
		System.out.println(obf.Izquierda(nc + "", 5) + obf.Izquierda(nom, 25) + obf.Derecho(obf.Pesos(sal), 12));
	}

	public void Mostrar()
	{
		System.out.println(obf.Izquierda(nom, 25) + obf.Derecho(obf.Pesos(sal), 12));
	}

	public void Movimiento(double mon)
	{
		sal += mon;
	}

	public double Saldo()
	{
		return sal;
	}

	public int NoCuenta()
	{
		return nc;
	}

	public String Nombre()
	{
		return nom;
	}

}
