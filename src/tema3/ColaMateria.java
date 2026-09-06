package tema3;

import ed.Datos;
import ed.Formato;

public class ColaMateria
{
	private int ini, fin, tam, clv = 1;
	private Materia cola[];
	private Datos obd = new Datos();

	public ColaMateria()
	{
		do
			tam = obd.Entero("Ingresa el tamaño de la cola circular: ");
		while (tam < 1);
		cola = new Materia[tam];
		ini = -1;
		fin = -1;
	}

	private boolean Vacia()
	{
		return ini == -1;
	}

	private boolean Llena()
	{
		return ini == 0 && fin == cola.length - 1 || ini - 1 == fin;
	}

	private int Clave()
	{
		if (!this.Vacia())
			return clv++;
		else
			return 1;
	}

	private void Titulo()
	{
		Formato obf = new Formato();
		System.out.println(obf.Izquierda("CLAVE", 5) + " | " + obf.Izquierda("NOMBRE", 25) + " | "
				+ obf.Derecho("CREDITOS", 12) + " | " + obf.Derecho("PLAN", 12));
	}

	public void Insertar()
	{
		if (!this.Llena())
		{
			if (this.Vacia())
				ini = fin = 0;
			else
				if (fin + 1 == cola.length)
					fin = 0;
				else
					fin++;
			cola[fin] = new Materia(this.Clave());
			System.out.println("Materia insertada con exito...");
		}
		else
			System.out.println("cola llena...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			System.out.println("MATERIA EXTRAÍDA...");
			cola[ini].Mostrar();
			if (ini == fin)
				ini = fin = -1;
			else
				if (ini == cola.length - 1)
					ini = 0;
				else
					ini++;
		}
		else
			System.out.println("cola vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Contenido de la cola circular...");
			this.Titulo();
			for (tam = ini; tam != fin; tam = tam == cola.length - 1 ? 0 : tam + 1)
				cola[tam].Mostrar();
			cola[tam].Mostrar();

		}
		else
			System.out.println("cola vacia...");
	}

	public void Buscar()
	{
		int num;
		if (!this.Vacia())
		{
			do
				num = obd.Entero("busqueda de clave o plan: ");
			while (num < 1);
			for (tam = ini; tam != fin; tam = tam == cola.length - 1 ? 0 : tam + 1)
				if (cola[tam].Clave() == num || cola[tam].Plan() == num)
				{
					this.Titulo();
					cola[tam].Mostrar();
					break;
				}
			if (cola[tam].Clave() == num)
				cola[tam].Mostrar();

		}
		else
			System.out.println("cola vacia...");
	}

	public void Modificar()
	{
		int num;
		if (!this.Vacia())
		{
			num = obd.Entero("Clave a buscar: ");
			for (tam = ini; tam != fin; tam = tam == cola.length - 1 ? 0 : tam + 1)
				if (cola[tam].Clave() == num)
				{
					cola[tam].Modificar();
					break;
				}
			if (cola[tam].Clave() == num)
				cola[tam].Modificar();
		}
		else
			System.out.println("cola vacia...");
	}

	public void Borrar()
	{
		ini = fin = -1;
		System.out.println("Cola borrada");
	}
}
