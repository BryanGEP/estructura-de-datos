package tema4;

import java.util.TreeSet;
import ed.Datos;
import java.util.Iterator;

public class ArbolTS
{
	private String cad;
	private TreeSet<String> arbol = new TreeSet<String>();
	private Datos obd = new Datos();

	public void Insertar()
	{
		if (arbol.add(obd.Cadena("Cadena a insertar:").toUpperCase()))
			System.out.println("Cade insertada con exito...");
		else
			System.out.println("la cadena ya existe...");
	}

	public void Recorrido()
	{
		Iterator<String> it = arbol.iterator();
		if (!arbol.isEmpty())
		{
			System.out.println("Contenido del arbol....");
			while (it.hasNext())
				System.out.println(it.next());
			System.out.println("Fin del arbol...");
		}
		else
			System.out.println("Arbol vacio");
	}

	public void Eliminar()
	{
		if (!arbol.isEmpty())
		{
			cad = obd.Cadena("Cadena a eliminar: ").toUpperCase();
			if (arbol.remove(cad))
				System.out.println("Cadena eliminada");
			else
				System.out.println("La cadena no existe");
		}
		else
			System.out.println("Arbol vacio..");
	}

	public void Buscar()
	{
		if (!arbol.isEmpty())
		{
			cad = obd.Cadena("Cadena a buscar: ").toUpperCase();
			if (arbol.contains(cad))
				System.out.println("Si esta en el arbol...");
			else
				System.out.println("No esta en el arbol...");
		}
		else
			System.out.println("Arbol vacio..");
	}

	public void Borrar()
	{
		arbol.clear();
		System.out.println("Arbol borrado...");
	}
}
