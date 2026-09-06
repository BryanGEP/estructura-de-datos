package tema5;

import java.util.Random;

import ed.Datos;

public class Actividad
{
	private int tam, pos, x;
	private String arr[], aux;
	private Datos obd = new Datos();

	public Actividad()
	{
		do
			tam = obd.Entero("Cantidad de datos: ");
		while (tam < 1);
		arr = new String[tam];
		this.NoControl();
		System.out.println("\n\nArreglo original");
		this.Mostrar();
		System.out.println("\n\nArreglo ordenado de forma descendente(ShellSort)");
		this.ShellSort();
		this.Mostrar();
		System.out.println("\n\nArreglo ordenado de forma ascendente(BurbujaM)");
		this.BurbujaM();
		this.Mostrar();
	}

	private void NoControl()
	{
		Random obr = new Random();
		int a;
		String nc;
		for (pos = 0; pos < arr.length; pos++)
			do
			{
				a = obr.nextInt(24);
				nc = a + "";
				arr[pos] = (a < 10 ? "0" + nc : nc) + (420000 + (obr.nextInt(9999) + 1));
				for (x = 0; x < pos && arr[x] != arr[pos]; x++)
					;
			}
			while (x < pos);
	}

	private void Mostrar()
	{
		for (x = 0; x < arr.length; x++)
		{
			if (x % 5 == 0 && x != 0)
				System.out.println();
			System.out.print(arr[x] + "\t");
		}
	}

	private void ShellSort()
	{
		int sal;
		for (sal = arr.length / 2; sal > 0; sal /= 2)
			for (x = sal; x < arr.length; x++)
				for (pos = x; pos >= sal && arr[pos - sal].compareTo(arr[pos]) < 0; pos -= sal)
				{
					aux = arr[pos - sal];
					arr[pos - sal] = arr[pos];
					arr[pos] = aux;
				}
	}

	private void BurbujaM()
	{
		for (pos = 0; pos < arr.length - 1; pos++)
			for (x = pos + 1; x < arr.length; x++)
				if (arr[pos].compareTo(arr[x]) > 0)
				{
					aux = arr[pos];
					arr[pos] = arr[x];
					arr[x] = aux;
				}
	}
}
