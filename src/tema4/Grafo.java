package tema4;

import ed.Datos;

public class Grafo
{
	private int[][] A, B;
	private int dato;
	Datos obd = new Datos();

	public Grafo()
	{
		this.A = new int[6][6];
		this.B = new int[6][6];
	}

	public void Añadir()
	{
		int tam = 0;

		for (int ren = 1; ren <= 5; ren++)
		{
			System.out.println("\nDa el numero de vertices adyasentes al vertice " + ren + " :");
			do
				tam = obd.Entero("\nCual el tamaño:");
			while (tam < 1 || tam > 5);

			if (tam != 0 && tam <= 5)
			{
				System.out.println("\nDa los vertices adyasentes: ");
				for (int col = 1; col <= tam; col++)
				{
					do
						dato = obd.Entero("Cual es el dato");
					while (dato >= A.length);
					A[ren][dato] = 1;
				}
			}
		}
	}

	public void Mostrar()
	{
		System.out.println("\nEsta es la matriz de adyacencia");
		for (int ren = 1; ren <= 5; ren++)
		{
			for (int col = 1; col <= 5; col++)
			{
				System.out.print(" " + A[ren][col]);
			}
			System.out.print("\n");
		}
	}

	public void Conexo()
	{
		// El grafo será conexo si existe un camino desde cualquier nodo del grafo hasta
		// cualquier otro.
		boolean ban;
		int cont = 0;
		for (int ren = 1; ren <= 5; ren++)
		{
			ban = false;
			for (int col = 1; col <= 5; col++)
			{
				if (A[ren][col] == 1)
					ban = true;
			}

			if (ban == true)
				cont = cont + 1;
		}

		if (cont == 5)
			System.out.println("\nEl grafo SI es Conexo");
		else
			System.out.println("\nEL grafo NO es Conexo");
	}

	public void Grado()
	{
		int c[] = new int[6];
		int cont = 0;

		for (int ren = 1; ren <= 5; ren++)
		{
			cont = 0;
			for (int col = 1; col <= 5; col++)
			{
				if (A[ren][col] == 1 || A[col][ren] == 1)
					cont = cont + 1;
			}
			c[ren] = cont;
		}

		for (int ren = 1; ren <= 5; ren++)
		{
			System.out.println("Grado total del vertice " + ren + " es: " + c[ren]);
		}
	}

	private void Multiplica(int x)
	{
		int c[][] = new int[6][6];
		int col, ren, k;
		if (x <= 2)
			for (ren = 1; ren <= 5; ren++)
				for (col = 1; col <= 5; col++)
					for (k = 1; k <= 5; k++)
						B[ren][col] = B[ren][col] + (A[ren][k] * A[k][col]);

		else
		{
			for (ren = 1; ren <= 5; ren++)
				for (col = 1; col <= 5; col++)
					for (k = 1; k <= 5; k++)
						c[ren][col] = c[ren][col] + (A[ren][k] * B[k][col]);
			this.B = c;
		}
	}

	public void Camino(int ren, int col)
	{
		boolean ban = false;
		int cont = 0;

		while (ban == false && cont < 5)
		{
			cont = cont + 1;
			if (cont == 1)
			{
				if (A[ren][col] == 1)
				{
					System.out.println("El camino de " + ren + " a " + col + " es de longitud: " + cont);
					ban = true;
				}
			}
			else
			{
				this.Multiplica(cont);
				if (B[ren][col] != 0)
				{
					System.out.println("El camino de " + ren + " a " + col + " es de longitud: " + cont);
					ban = true;
				}
			}
		}
		if (ban == false)
			System.out.println("NO existe camino de " + ren + " a " + col);
	}

}