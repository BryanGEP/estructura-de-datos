package tema3;

import java.util.Vector;
import ed.Datos;

public class PilaDVector
{
	private String nom, na;
	private boolean ban;
	private Vector<String> pila = new Vector<String>(5, 2);
	private Vector<String> aux = new Vector<String>(5, 2);
	private Datos obd = new Datos();

	private boolean Vacia()
	{
		return pila.isEmpty();
	}

	public void Insertar()
	{
		nom = obd.Cadena("Nombre a insertar: ").toUpperCase();
		pila.add(nom);
		System.out.println("Nombre alamacenado...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			nom = pila.remove(pila.size() - 1);
			System.out.println("Nombre extraido " + nom);
		}
		else
			System.out.println("Pila vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Contenido de la pila...");
			while (!this.Vacia())
			{
				nom = pila.remove(pila.size() - 1);
				System.out.println(nom);
				aux.add(nom);
			}
			while (!aux.isEmpty())
				pila.add(aux.remove(aux.size() - 1));
			System.out.println("Fin de la pila...");
		}
		else
			System.out.println("Pila vacia...");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			ban = true;
			na = obd.Cadena("Nombre o apellido a buscar").toUpperCase();
			while (!this.Vacia())
			{
				nom = pila.remove(pila.size() - 1);
				if (nom.indexOf(na) != -1)
				{
					if (ban)
					{
						System.out.println("Nombres escontrados...");
						ban = false;
					}
					System.out.println(nom);
				}
				aux.add(nom);
			}
			while (!aux.isEmpty())
				pila.add(aux.remove(aux.size() - 1));
			if (ban)
				System.out.println("El nombre o apellido no esta en la pila...");
		}
		else
			System.out.println("Pila vacia...");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			ban = true;
			na = obd.Cadena("Nombre a modificar: ").toUpperCase();
			while (!this.Vacia())
			{
				nom = pila.remove(pila.size() - 1);
				if (nom.equals(na))
				{
					nom = obd.Cadena("Escribe el nuevo nombre: ").toUpperCase();
					aux.add(nom);
					ban = false;
					break;
				}
				aux.add(nom);
			}
			while (!aux.isEmpty())
				pila.add(aux.remove(aux.size() - 1));
			if (ban)
				System.out.println("El nombre o apellido no esta en la pila...");
		}
		else
			System.out.println("Pila vacia...");
	}

	public void Borrar()
	{
		pila.clear();
		System.out.println("Pila borrada...:)");
	}
}
