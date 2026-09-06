package tema3;

import ed.Datos;

public class BicolaNombres
{
	private int tam, pos;
	private String bicola[], nom;
	private Datos obd = new Datos();

	public BicolaNombres()
	{
		do
			tam = obd.Entero("Tamaño de la bicola");
		while (tam < 1);
		bicola = new String[tam];
		tam = -1;
	}

	private boolean Vacia()
	{
		return tam == -1;
	}

	private boolean Llena()
	{
		return tam == bicola.length - 1;
	}

	public void InsertarIni()
	{
		if (!this.Vacia())
		{
			for (pos = tam + 1; pos > 0; pos--)
				bicola[pos] = bicola[pos - 1];
			bicola[0] = obd.Cadena("Introduzca un nombre").toUpperCase();
			System.out.println("Nombre insertado con éxito");
		}
		else
			System.out.println("La bicola está llena...");
	}

	public void InsertarFin()
	{
		if (!this.Llena())
		{
			bicola[++tam] = obd.Cadena("Inserte un nombre").toUpperCase();
			System.out.println("Nombre insertado con éxito...");
		}
		else
			System.out.println("La bicola está llena...");
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombre extraído " + bicola[0]);
			// if(tam!=0) //quiere decir que hay más de un elemento
			// {
			for (pos = 0; pos < tam; pos++)
				bicola[pos] = bicola[pos + 1];
			tam--;
			// }
			// else
			// tam=-1;
		}
		else
			System.out.println("La bicola está vacía...");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombre extraído " + bicola[tam]);
		}
		else
			System.out.println("La bicola está vacía...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombres de la lista...");
			for (pos = 0; pos <= tam; pos++)
				System.out.println(bicola[pos]);
			System.out.println("Fin de la bicola");
		}
		else
			System.out.println("La bicola vacía...");
	}

	public void Buscar() // que cuente cuantas veces se encontró el nombre
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			nom = obd.Cadena("Nombre a buscar").toUpperCase();
			for (pos = 0; pos <= tam; pos++)
				if (bicola[pos].contains(nom))
				{
					System.out.println(bicola[pos]);
					ban = false;
				}
			if (ban)
				System.out.println("El nombre o apellido no está en la cola...");
		}
		else
			System.out.println("La bicola está vacía...");
	}

	public void Borrar()
	{
		tam = -1;
		System.out.println("Bicola borrada...");
	}
}
