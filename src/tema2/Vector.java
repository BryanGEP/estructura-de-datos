package tema2;

import ed.Datos;

public class Vector
{
	private int vec[];
	private java.util.Random obr = new java.util.Random();

	public int Tamaño()
	{
		int ind;
		do
			ind = new Datos().Entero("Cual es el tamaño del vector: ");
		while (ind < 0);
		vec = new int[ind];
		return ind;
	}

	public void Aleatorios(int ind)
	{
		if (ind != 1)
			this.Aleatorios(ind - 1);
		vec[ind - 1] = obr.nextInt(100);
	}

	public void Moatrar(int ind)
	{
		if (ind != 1)
			this.Moatrar(ind-1);
		System.out.print("["+vec[ind - 1]+"]");
	}
}
