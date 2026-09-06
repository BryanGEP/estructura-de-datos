package tema3;

import java.util.LinkedList;
import ed.Datos;

public class ListaNom
{
	private String nom;
	private int pos;
	private Datos obd = new Datos();
	private LinkedList<String> lista = new LinkedList<String>();

	public void InsertarIni()
	{
		lista.addFirst(obd.Cadena("Nuevo nombre: ").toUpperCase());
	}

	public void InsertarFin()
	{
		lista.addLast(obd.Cadena("Nuevo nombre: ").toUpperCase());
	}

	public void InsertarPos()
	{
		do
			pos = obd.Entero("Cual es la posicion: ");
		while (pos < 1 || pos > lista.size());
		lista.add(pos - 1, obd.Cadena("Nuevo nombre: ").toUpperCase());

	}

	public void ExtraerIni()
	{
		if (!lista.isEmpty())
			System.out.println("nombre eliminado " + lista.removeFirst());
		else
			System.out.println("LISTA VACIA");
	}

	public void ExtraerPos()
	{
		if (!lista.isEmpty())
		{
			do
				pos = obd.Entero("Cual es la posicion: ");
			while (pos < 1 || pos > lista.size());
			System.out.println("Nombre eliminado " + lista.remove(pos - 1));
		}
		else
			System.out.println("lista vacia");
	}

	public void ExtraerFin()
	{
		if (!lista.isEmpty())
			System.out.println("nombre eliminado " + lista.removeLast());
		else
			System.out.println("LISTA VACIA");
	}

	public void Recorrido()
	{
		if (!lista.isEmpty())
		{
			System.out.println("Lista...");
			for (String nom : lista)
				System.out.println(nom);
			System.out.println("fin de la lista");
		}
		else
			System.out.println("lista vacia");
	}

	public void Buscar()
	{
		boolean ban = true;
		if (!lista.isEmpty())
		{
			nom = obd.Cadena("nombre o apellido a buscar: ").toUpperCase();
			for (String n : lista)
				if (n.contains(nom))
				{
					if (ban)
						System.out.println("nombres encontrados");
					System.out.println(n);
					ban = false;
				}
			if (ban)
				System.out.println("no se encuetra en la lista");
		}
		else
			System.out.println("lista vacia");
	}

	public void Modificar()
	{
		if (!lista.isEmpty())
		{
			nom = obd.Cadena("nombre o apellido a modificar: ").toUpperCase();
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).equals(nom))
				{
					lista.set(pos, obd.Cadena("Nuevo nombre").toUpperCase());
					break;
				}
			if (pos > lista.size())
				System.out.println("no lo encontro");
		}
		else
			System.out.println("lista vacia");

	}

	public void BOrrar()
	{
		lista.clear();
		System.out.println("lista borrada");
	}
}
