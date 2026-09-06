package tema4;

import java.util.TreeSet;
import ed.Datos;
import java.util.Iterator;

public class ArbolTSCue
{
	private TreeSet<Cuenta> arbol = new TreeSet<Cuenta>(new CompararCuenta());
	private Cuenta bus = null, act = null;
	private double mont;
	private Datos obd = new Datos();

	private int NoCuenta()
	{
		int nc = 0;
		if (!arbol.isEmpty())
			nc = arbol.last().NoCuenta();
		return nc + 1;
	}

	public void Insertar()
	{
		if (arbol.add(new Cuenta(this.NoCuenta())))
			System.out.println("\nCuenta insertada con exito...");
	}

	public void Recorrido()
	{
		if (!arbol.isEmpty())
		{
			System.out.println("Contenido del arbol....");
			for (Iterator<Cuenta> it = arbol.iterator(); it.hasNext();)
				it.next().MostrarT();
			System.out.println("\nFin del arbol...");
		}
		else
			System.out.println("\nArbol vacio");
	}

	public void Eliminar()
	{
		if (!arbol.isEmpty())
		{
			bus = new Cuenta();
			if (arbol.contains(bus))
			{
				for (Iterator<Cuenta> it = arbol.iterator(); it.hasNext();)
				{
					act = it.next();
					if (act.NoCuenta() == bus.NoCuenta())
						break;
				}
				if (act.Saldo() == 0)
				{
					System.out.println("\nCuenta eliminada");
					arbol.remove(act);
				}
				else
					System.out.println("\nAun cuenta con saldo");
				act.MostrarT();

			}
			else
				System.out.println("\nLa cuenta no existe");
		}
		else
			System.out.println("\nArbol vacio..");
	}

	public void Buscar()
	{
		if (!arbol.isEmpty())
		{
			bus = new Cuenta();
			if (arbol.contains(bus))
			{
				for (Iterator<Cuenta> it = arbol.iterator(); it.hasNext();)
				{
					act = it.next();
					if (act.NoCuenta() == bus.NoCuenta())
						break;
				}
				System.out.println("\nCuenta encontrada");
				act.MostrarT();
			}
			else
				System.out.println("\nLa cuenta no existe");
		}
		else
			System.out.println("\nArbol vacio..");
	}

	public void Deposito()
	{
		if (!arbol.isEmpty())
		{
			bus = new Cuenta();
			if (arbol.contains(bus))
			{
				for (Iterator<Cuenta> it = arbol.iterator(); it.hasNext();)
				{
					act = it.next();
					if (act.NoCuenta() == bus.NoCuenta())
						break;
				}
				System.out.println("\nCuenta encontrada");
				act.MostrarT();
				do
					mont = obd.Doble("\nCantidad a depositar: ");
				while (mont < 1);
				act.Movimiento(mont);
				act.MostrarT();
				arbol.remove(act);
				arbol.add(act);
			}
			else
				System.out.println("\nLa cuenta no existe");
		}
		else
			System.out.println("\nArbol vacio..");
	}

	public void Retiro()
	{
		if (!arbol.isEmpty())
		{
			bus = new Cuenta();
			if (arbol.contains(bus))
			{
				for (Iterator<Cuenta> it = arbol.iterator(); it.hasNext();)
				{
					act = it.next();
					if (act.NoCuenta() == bus.NoCuenta())
						break;
				}
				System.out.println("\nCuenta encontrada");
				act.MostrarT();
				do
					mont = obd.Doble("\nCantidad a retirar: ");
				while (mont < 1 || mont > act.Saldo());
				act.Movimiento(mont * -1);
				act.MostrarT();
				arbol.remove(act);
				arbol.add(act);
			}
			else
				System.out.println("\nLa cuenta no existe");
		}
		else
			System.out.println("\nArbol vacio..");
	}

	public void Borrar()
	{
		arbol.clear();
		System.out.println("\nArbol borrado...");
	}
}
