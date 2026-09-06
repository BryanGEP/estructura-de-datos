package tema3;

import ed.Datos;
import java.util.LinkedList;

public class ListaPro
{

	private Datos obd = new Datos();
	private LinkedList<Producto> lista = new LinkedList<Producto>();
	private int pos, clv;

	private int Clave()
	{
		return lista.isEmpty() ? 1 : lista.getLast().Clave() + 1;
	}

	public void Insertar()
	{
		lista.add(new Producto(this.Clave()));
	}

	public void Extraer()
	{
		if (!lista.isEmpty())
		{
			do
				clv = obd.Entero("Clave a extraer: ");
			while (clv < 1 || clv > lista.getLast().Clave());
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).Clave() == clv)
				{
					System.out.println("Producto extraido...");
					lista.remove(pos).Mostrar();
					break;
				}
			if (pos > lista.size())
				System.out.println("el producto no existe..");
		}
		else
			System.out.println("lista vacia");
	}

	public void Recorrido()
	{
		if (!lista.isEmpty())
		{
			System.out.println("Lista");
			for (Producto pro : lista)
				pro.Mostrar();
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("lista vacia");
	}

	public void Buscar()
	{
		if (!lista.isEmpty())
		{
			do
				clv = obd.Entero("Clave a buscar: ");
			while (clv < 1 || clv > lista.getLast().Clave());
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).Clave() == clv)
				{
					System.out.println("Producto encontrado...");
					lista.get(pos).Mostrar();
					break;
				}
			if (pos > lista.size())
				System.out.println("el producto no existe..");
		}
		else
			System.out.println("lista vacia");
	}

	public void Modificar()
	{
		if (!lista.isEmpty())
		{
			do
				clv = obd.Entero("Clave a modificar: ");
			while (clv < 1 || clv > lista.getLast().Clave());
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).Clave() == clv)
				{
					System.out.println("Producto encontrado...");
					lista.get(pos).Modificar();
					break;
				}
			if (pos > lista.size())
				System.out.println("el producto no existe..");
		}
		else
			System.out.println("lista vacia");
	}

	public void Borrar()
	{
		lista.clear();
		System.out.println("Lista borrada");
	}
}
