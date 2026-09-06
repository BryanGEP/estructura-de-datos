package tema3;

import java.util.Vector;

import ed.Datos;

public class BicolaProducto
{
	private Datos obd = new Datos();
	private Vector<Producto> bicola = new Vector<Producto>(5, 2);
	private int clv;
	private boolean ban;

	private int Clave()
	{
		return bicola.isEmpty() ? 1
				: bicola.get(0).Clave() > bicola.get(bicola.size() - 1).Clave() ? bicola.get(0).Clave() + 1
						: bicola.get(bicola.size() - 1).Clave() + 1;
	}

	public void InsertarIni()
	{
		bicola.add(0, new Producto(this.Clave()));
		System.out.println("Producto almacenado con exito");
	}

	public void InsertarFin()
	{
		bicola.add(new Producto(this.Clave()));
		System.out.println("Producto almacenado con exito");
	}

	public void ExtraerIni()
	{
		if (!bicola.isEmpty())
		{
			System.out.println("Producto extraido del inicio: ");
			bicola.remove(0).Mostrar();
		}
		else
			System.out.println("Bicola vacia...");
	}

	public void ExtraerFin()
	{
		if (!bicola.isEmpty())
		{
			System.out.println("Producto extraido del final: ");
			bicola.remove(bicola.size() - 1).Mostrar();
		}
		else
			System.out.println("Bicola vacia...");
	}

	public void Recorrido()
	{
		if (!bicola.isEmpty())
		{
			System.out.println("<<Lista>>");
			for (Producto c : bicola)
				c.Mostrar();
			System.out.println("Fin de la lista...");
		}
		else
			System.out.println("Bicola vacia...");

	}

	public void Buscar()
	{
		ban = true;
		if (!bicola.isEmpty())
		{
			do
				clv = obd.Entero("CLave del producto a buscar");
			while (clv < 1);
			for (Producto c : bicola)
			{
				if (c.Clave() == clv)
				{
					System.out.println("Producto encontrado...");
					c.Mostrar();
					ban = false;
					break;
				}
			}
			if (ban)
				System.out.println("El producto no esta en la bicola");
		}
		else
			System.out.println("Bicola vacia...");
	}

	public void Modificar()
	{
		ban = true;
		if (!bicola.isEmpty())
		{
			do
				clv = obd.Entero("CLave del producto a modificar");
			while (clv < 1);
			for (Producto c : bicola)
			{
				if (c.Clave() == clv)
				{
					c.Modificar();
					ban = false;
					break;
				}
			}
			if (ban)
				System.out.println("El producto no esta en la bicola");
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
