package tema3;

import ed.Datos;
import ed.Formato;

public class TDATarea
{
	private int nt;
	private String nom, fecha;
	private int saldo;
	private Datos obd = new Datos();
	private Formato obf = new Formato();

	public TDATarea(int nt)
	{
		this.nt = nt;
		System.out.println("\nEscribe los datos de la cuenta...");
		System.out.println("No. de Cuenta " + this.nt);
		nom = obd.Cadena("Nombre: ").toUpperCase();
		fecha = obd.Cadena("Fecha de apertura: ").toUpperCase();
		do
			saldo = obd.Entero("Saldo inicial: ");
		while (saldo < 1);
	}

	public void Mostrar(int val)
	{
		System.out.println(obf.Izquierda(nt + "", 10) + " | " + obf.Izquierda(nom, 25) + " | "
				+ obf.Izquierda(fecha, 12) + " | " + obf.Izquierda(obf.Pesos(val), 20) );
	}

	public int NoTarejta()
	{
		return nt;
	}

	public String Fecha()
	{
		return fecha;
	}

	public int Saldo()
	{
		return saldo;
	}
}
