package tema2;

import ed.Datos;

public class Potencia
{
	private Datos obd = new Datos();

	public int Numero()
	{
		return obd.Entero("Cual es el numero: ");
	}

	public int Potencias()
	{
		int pot;
		do
			pot = obd.Entero("Cual es la potencia: ");
		while (pot < 0);
		return pot;
	}

	public int Elevar(int num, int pot)
	{
		if (pot == 0)
			return 1;
		else
			return this.Elevar(num, pot - 1) * num;
	}

	public void Mostrar(int res)
	{
		System.out.println("El resultado es: " + res);
	}
}
