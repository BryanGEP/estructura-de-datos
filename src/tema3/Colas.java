package tema3;

import ed.Datos;

public class Colas
{
	private String cola[];
	private int tam, pos;
	private ed.Datos obd = new Datos();

	public Colas()
	{
		do
			tam = obd.Entero("Cual es el tamaño de la cola: ");
		while (tam < 1);
		cola = new String[tam];
		tam=-1;
	}

	private boolean Vacia()
	{
		return tam == -1;
	}

	private boolean Llena()
	{
		return tam == cola.length - 1;
	}

	public void Insertar()
	{
		if (!this.Llena())
		{
			cola[++tam] = obd.Cadena("Nombre del alumno: ").toUpperCase();
			System.out.println("Nombre insertado con exito...");
		}
		else
			System.out.println("Cola llena...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombre extraido " + cola[0]);
			if (tam != 0)
			{
				for (pos = 0; pos < tam; pos++)
					cola[pos] = cola[pos + 1];
				tam--;
			}
			else
				tam = -1;
		}
		else
			System.out.println("Cola llena...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombres de la lista...");
			for (pos = 0; pos <= tam; pos++)
				System.out.println(cola[pos]);
			System.out.println("Fin de la cola...");
		}
		else
			System.out.println("Cola llena...");
	}

	public void Buscar()
	{
		boolean ban = true;
		String nom;
		if (!this.Vacia())
		{
			nom = obd.Cadena("Nombre o apellido a buscar: ").toUpperCase();
			for (pos = 0; pos <= tam; pos++)
				if (cola[pos].contains(nom))
				{
					System.out.println(cola[pos]);
					ban = false;
				}
			if (ban)
				System.out.println("El nombre o apellido no se encuentra en la cola...");
		}
		else
			System.out.println("Cola llena...");
	}

	public void Borrar()
	{
		tam = -1;
		System.out.println("Cola borrada...");
	}
}
