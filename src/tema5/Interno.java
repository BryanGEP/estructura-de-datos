package tema5;

import ed.Datos;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;

public class Interno
{
	private int arr[], tam, pos, x, aux;
	private Datos obd = new Datos();

	public Interno()
	{
		do
			tam = obd.Entero("Cantidad de datos: ");
		while (tam < 1);
		arr = new int[tam];
		this.Aleatorios();
		System.out.println("Arreglo Original");
		this.Mostrar(arr);
		this.Java();
		System.out.println("\n\nArreglo Ordenado");
		this.Mostrar(arr);

	}

	private void Aleatorios()
	{
		Random obr = new Random();
		for (pos = 0; pos < arr.length; pos++)
			do
			{
				arr[pos] = obr.nextInt(arr.length * 10) + 1;
				for (x = 0; x < pos && arr[x] != arr[pos]; x++)
					;
			}
			while (x < pos);
	}

	public void Mostrar(int vec[])
	{
		for (x = 0; x < vec.length; x++)
		{
			if (x % 5 == 0 && x != 0)
				System.out.println();
			System.out.print(vec[x] + "\t");
		}
	}

	public void Burbuja()
	{
		for (x = 1; x < arr.length; x++)
			for (pos = 0; pos < arr.length - 1; pos++)
				if (arr[pos] > arr[pos + 1])
				{
					aux = arr[pos];
					arr[pos] = arr[pos + 1];
					arr[pos + 1] = aux;
				}
	}

	public void BurbujaM()
	{
		for (pos = 0; pos < arr.length - 1; pos++)
			for (x = pos + 1; x < arr.length; x++)
				if (arr[pos] > arr[x])
				{
					aux = arr[pos];
					arr[pos] = arr[x];
					arr[x] = aux;
				}
	}

	public void QuickSort()
	{
		this.QuickSort(0, arr.length);
	}

	private void QuickSort(int ini, int fin)
	{
		int izq = ini, der = fin, pivote = arr[(ini + fin) / 2];
		while (izq <= der)
		{
			while (arr[izq] < pivote)
				izq++;
			while (arr[der] > pivote)
				der--;
			if (izq <= der)
			{
				aux = arr[izq];
				arr[izq] = arr[der];
				arr[der] = aux;
				izq++;
				der--;
			}
		}
		if (ini < der)
			this.QuickSort(ini, der);
		if (izq < fin)
			this.QuickSort(izq, fin);
	}

	public void ShellSort()
	{
		int sal;
		for (sal = arr.length / 2; sal > 0; sal /= 2)
			for (x = sal; x < arr.length; x++)
				for (pos = x; pos >= sal && arr[pos - sal] > arr[pos]; pos -= sal)
				{
					aux = arr[pos - sal];
					arr[pos - sal] = arr[pos];
					arr[pos] = aux;
				}
	}

	public void Radix()
	{
		int may = arr[0], nd, dig, factor;
		@SuppressWarnings("unchecked")
		LinkedList<Integer> cola[] = new LinkedList[10];
		for (x = 0; x < cola.length; x++)
			cola[x] = new LinkedList<Integer>();
		for (pos = 1; pos < arr.length; pos++)
			if (arr[pos] > may)
				may = arr[pos];
		nd = (may + "").length();
		for (dig = 1, factor = 1; dig <= nd; dig++, factor *= 10)
		{
			for (pos = 0; pos < arr.length; pos++)
				cola[arr[pos] / factor % 10].add(arr[pos]);
			for (x = 0, pos = -1; x < cola.length; x++)
				while (!cola[x].isEmpty())
					arr[++pos] = cola[x].removeFirst();
		}
	}

	public void Java()
	{
		Arrays.sort(arr);
	}
}
