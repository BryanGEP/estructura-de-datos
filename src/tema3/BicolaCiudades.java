package tema3;

import ed.Datos;
import java.util.Vector;

public class BicolaCiudades
{
	private Datos obd = new Datos();
	private Vector<String> bicola = new Vector<String>(3, 2);

	public void InsertarIni()
	{
		bicola.add(0, obd.Cadena("Nombre de la ciudad").toUpperCase());
		System.out.println("Ciudad almacenada con exito");
	}

	public void InsertarFin()
	{
		bicola.add(obd.Cadena("Nombre de la ciudad: ").toUpperCase());
		System.out.println("Ciudad almacenada con exito");
	}

	public void ExtraerIni()
	{
		if (!bicola.isEmpty())
		{
			System.out.println("Ciudad extraida del inicio: " + bicola.remove(0));
		}
		else
			System.out.println("Bicola vacia...");
	}

	public void ExtraerFin()
	{
		if (!bicola.isEmpty())
		{
			System.out.println("Ciudad extraida del inicio: " + bicola.remove(bicola.size() - 1));
		}
		else
			System.out.println("Bicola vacia...");
	}

	public void Recorrido()
	{
		if (!bicola.isEmpty())
		{
			System.out.println("<<Lista>>");
			for (String c : bicola)
				System.out.println(c);
			System.out.println("Fin de la lista...");
		}
		else
			System.out.println("Bicola vacia...");

	}

	public void Buscar()
	{
		int pos = 1;
		String cd;
		boolean ban = true;
		if (!bicola.isEmpty())
		{
			cd = obd.Cadena("Ciudad a buscar").toUpperCase();
			for (String c : bicola)
			{
				if (c.equals(cd))
				{
					if (ban)
						System.out.println("La ciudad esta en las posiciones...");
					System.out.println(pos);
					ban=false;
				}
				pos++;
			}
			if (ban)
				System.out.println("La ciudad no esta en la bicola");
		}
		else
			System.out.println("Bicola vacia...");
	}

	public void Borrar()
	{
		bicola.clear();
		System.out.println("Bicola borrada");
	}
}
