package tema3;

import ed.Datos;
import ed.Formato;

public class TDATarea2
{
	private Datos obd = new Datos();
	private Formato obf = new Formato();
	private String mov, fecha, msj;
	private int clv;
	private int monto;

	public TDATarea2(String mov, int clv, int saldo)
	{
		this.clv = clv;
		this.mov = mov;
		if (saldo != 0 || mov.equals("Deposito"))
		{
			System.out.println("Movimiento: " + this.mov);
			fecha = obd.Cadena("fecha del " + mov + " :").toUpperCase();
			do
				monto = obd.Entero("Monto: ");
			while (monto < 1);
			if (mov.equals("Retiro"))
			{
				do
				{
					if (monto > saldo)
					{
						System.out.println("NO HAY SUFICIENTE SALDO");
						do
							monto = obd.Entero("Monto: ");
						while (monto < 1);
					}
				}
				while (monto > saldo);
			}
			msj="";
		}
		else
		{
			System.out.println("NO CUENTAS CON SALDO");
			msj = "Nulo";
		}
	}

	public void Mostrar2()
	{
		System.out.println(
				obf.Derecho(mov, 10) + " | " + obf.Izquierda(fecha, 10) + " | " + obf.Izquierda(obf.Pesos(monto), 50));
	}

	public String Nulo()
	{
		return msj;
	}

	public int Clave()
	{
		return clv;
	}

	public String Movimiento()
	{
		return mov;
	}

	public int Monto()
	{
		return monto;
	}

}
