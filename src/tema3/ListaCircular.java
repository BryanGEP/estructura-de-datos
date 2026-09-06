package tema3;

import ed.Datos;

public class ListaCircular
{
	private NodoLCDPro ini, fin, nvo, act;
	private int clv;
	private Datos obd = new Datos();

	public ListaCircular()
	{
		ini = fin = null;
	}

	private boolean Vacia()
	{
		return ini == null;
	}

	private int Clave()
	{
		return this.Vacia() ? 1 : fin.getPro().Clave() + 1;
	}

	public void Insertar()
	{
		nvo = new NodoLCDPro(new Producto(this.Clave()));
		if (!this.Vacia())
		{
			fin.setSiguiente(nvo);
			nvo.setAnterior(fin);
			fin = nvo;
			fin.setSiguiente(ini);
			ini.setAnterior(fin);
		}
		else
		{
			ini = fin = nvo;
			ini.setAnterior(fin);
			ini.setSiguiente(fin);
			fin.setSiguiente(ini);
			fin.setAnterior(ini);
		}
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("clave a extraer: ");
			while (clv < 1);
			for (act = ini; act != fin && act.getPro().Clave() != clv; act = act.getSiguiente())
				if (act.getPro().Clave() == clv)
				{
					System.out.println("Producto eliminado");
					act.getPro().Mostrar();
					if (ini != fin)
					{
						if (act == ini)
						{
							ini = ini.getSiguiente();
							ini.setAnterior(fin);
							fin.setSiguiente(ini);
						}
						else
							if (act == fin)
							{
								fin = fin.getAnterior();
								fin.setSiguiente(ini);
								ini.setAnterior(fin);
							}
							else
							{
								act.getAnterior().setSiguiente(act.getSiguiente());
								act.getSiguiente().setAnterior(act.getAnterior());
							}
					}
					else
						ini = null;
				}
				else
					System.out.println("La clave no existe");
		}
		else
			System.out.println("lista vacia");

	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Lista");
			for (act = ini; act != fin; act = act.getSiguiente())
				act.getPro().Mostrar();
			act.getPro().Mostrar();
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("lista vacia");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("clave a buscar: ");
			while (clv < 1);
			for (act = ini; act != fin && act.getPro().Clave() != clv; act = act.getSiguiente())
				;
			if (act.getPro().Clave() == clv)
			{
				System.out.println("Datos");
				act.getPro().Mostrar();
			}
			else
				System.out.println("NO existe");
		}
		else
			System.out.println("lista vacia");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("clave a modificar: ");
			while (clv < 1);
			for (act = ini; act != fin && act.getPro().Clave() != clv; act = act.getSiguiente())
				;
			if (act.getPro().Clave() == clv)
			{
				System.out.println("Datos");
				act.getPro().Modificar();
				System.out.println("Producto modificado");
			}
			else
				System.out.println("NO existe");
		}
		else
			System.out.println("lista vacia");
	}

	public void Borrar()
	{
		ini = null;
		System.out.println("lista borrada");
	}

}
