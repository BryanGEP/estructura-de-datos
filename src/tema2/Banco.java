package tema2;

import ed.Datos;
import ed.Formato;

public class Banco
{
	private Datos obd = new Datos();

	public double Deposito()
	{
		double dep;
		dep = obd.Doble("Deposito inicial: ");
		if (dep < 1)
			dep = this.Deposito();
		return dep;
	}

	public int Meses()
	{
		int mes;
		mes = obd.Entero("Cantidad de meses: ");
		if (mes < 0)
			mes = this.Meses();
		return mes;
	}

	public double Porcentaje()
	{
		double por;
		por = obd.Doble("Porcentaje: ");
		if (por < 1 || por > 100)
			por = this.Porcentaje();
		por = 1 + por / 100.0;
		return por;
	}

	public double Calcular(double dep, double por, int mes)
	{
		if (mes == 0)
			return dep;
		else
			return por * this.Calcular(dep, por, mes - 1);
	}

	public void Mostrar(double tot)
	{
		System.out.println("El saldo de la ceunta es: " + new Formato().Pesos(tot));
	}
}
