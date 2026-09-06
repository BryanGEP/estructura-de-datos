package tema6;

import java.util.Arrays;
import java.util.Random;

import ed.Datos;

public class Interno
{
	private int arr[], tam, pos, x;
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

	public void Java()
	{
		Arrays.sort(arr);
	}

	public void Secuencial()
	{
		int num;
		do
			num = obd.Entero("\n\nCual es el número a buscar:");
		while (num < 1);
		for (pos = 0; pos < arr.length && arr[pos] != num; pos++)
			;
		if (pos != arr.length)
			System.out.println("Encontrado en la posicion " + (pos + 1));
		else
			System.out.println("El numero no esta en el arreglo...");
	}

	public void Binaria()
	{
		int num, pos;
		do
			num = obd.Entero("\n\nCual es el número a buscar:");
		while (num < 1);
		pos = this.Binaria(0, arr.length - 1, num);
		if (arr[pos] == num)
			System.out.println("Pocision en la que se encontro: " + (pos + 1));
		else
			System.out.println("NO se encuentra en el arreglo...");
	}

	private int Binaria(int ini, int fin, int num)
	{
		int cen = (ini + fin) / 2;
		if (arr[cen] != num && ini <= fin)
			if (num > arr[cen])
				cen = this.Binaria(cen + 1, fin, num);
			else
				cen = this.Binaria(ini, cen - 1, num);
		return cen;
	}
}
