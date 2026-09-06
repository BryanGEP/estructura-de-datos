package tema6;

import java.util.Random;

import ed.Datos;

public class InternaHash
{
	private int arr[], tam, con, num, hash, dir = 0;
	private Datos obd = new Datos();
	private Hash obh = new Hash();

	public InternaHash()
	{
		do
			tam = obd.Entero("Cantidad de datos: ");
		while (tam < 1);
		arr = new int[tam];
		do
			hash = obd.Entero(
					"\nCual es la funcion hash a utilizar \n1)MODULO \n2)CUADRATICA \n3)PLEGAMIENTO \n4)TRUNCAMIENTO ");
		while (hash < 1 || hash > 4);
		this.Aleatorios();
		this.Mostrar();
	}

	private void Aleatorios()
	{
		Random obr = new Random();
		boolean ban;
		for (con = 1; con <= arr.length; con++)
		{
			do
			{
				num = obr.nextInt(arr.length * 100) + 1;
				this.Direccion();
				ban = this.Existe(num);
			}
			while (ban);
			for (; arr[dir] != 0; dir = dir == arr.length - 1 ? 0 : dir + 1);
			arr[dir] = num;
		}
	}

	private void Direccion()
	{
		switch (hash)
		{
			case 1:
				dir = obh.Modulo(num, arr.length);
				break;
			case 2:
				dir = obh.Cuadratica(num, arr.length);
				break;
			case 3:
				dir = obh.Plegamiento(num, arr.length);
				break;
			case 4:
				dir = obh.Truncamiento(num, arr.length);
		}
	}

	private boolean Existe(int num)
	{
		int pos;
		for (pos = 0; pos < arr.length && arr[pos] != num; pos++);
		return pos < arr.length;
	}

	public void Mostrar()
	{
		System.out.println("Contenido del arreglo...");
		for (con = 0; con < arr.length; con++)
		{
			System.out.print(arr[con] + "\t");
			if ((con + 1) % 5 == 0)
				System.out.println();
		}
	}

	public void Buscar()
	{
		int pos;
		do
			num = obd.Entero("\nNumero a buscar: ");
		while (num < 1);
		this.Direccion();
		if (arr[dir] != num)
			for (pos = dir, dir++; arr[dir] != num && pos != dir; dir = dir == arr.length - 1 ? 0 : dir + 1);
		if (arr[dir] == num)
			System.out.println("Encontrado en la posicion " + (dir + 1));
		else
			System.out.println("El número no esta en el arreglo...");
	}

}
