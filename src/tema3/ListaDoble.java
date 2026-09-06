package tema3;

import ed.Datos;

public class ListaDoble
{
	private NodoD ini, fin, nvo, act;
	private int pos, con;
	private String pro;
	private Datos obd = new Datos();

	public ListaDoble()
	{
		ini = fin = null;
	}

	private boolean Vacia()
	{
		return ini == null;
	}

	private int Cantidad()
	{
		for (act = ini, con = 0; act != null; act = act.getSiguiente(), con++)
			;
		return con;
	}

	public void InsertarIni()
	{
		nvo = new NodoD(obd.Cadena("Nombre del producto a insertar: "));
		if (!this.Vacia())
		{
			nvo.setSiguiente(ini);
			ini.setAnterior(nvo);
			ini = nvo;
		}
		else
			ini = fin = nvo;
	}

	public void InsertarPos()
	{
		do
			pos = obd.Entero("Posicion para insertar el nuevo nodo: ");
		while (pos < 1);
		if (pos == 1)
			this.InsertarIni();
		else
			if (pos > this.Cantidad())
				this.InsertarFin();
			else
			{
				nvo = new NodoD(obd.Cadena("Nombre delproducto a insertar: "));
				for (act = ini, con = 1; con < pos; act.getSiguiente(), con++)
					;
				act.getAnterior().setAnterior(nvo);
				nvo.setAnterior(act.getAnterior());
				nvo.setSiguiente(act);
				act.setAnterior(nvo);
			}
	}

	public void InsertarFin()
	{
		nvo = new NodoD(obd.Cadena("Nombre del producto a insertar: "));
		if (!this.Vacia())
		{
			nvo.setAnterior(fin);
			fin.setSiguiente(act);
			fin = nvo;
		}
		else
			ini = fin = nvo;
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Producto extraido del inicio " + ini.getProducto());
			if (ini != fin)
			{
				ini = ini.getSiguiente();
				ini.setAnterior(null);
			}
			else
				ini = fin = null;
		}
		System.out.println("lista vacia");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Producto extraido del final " + fin.getProducto());
			if (ini != fin)
			{
				fin = fin.getAnterior();
				fin.setSiguiente(null);
			}
			else
				ini = fin = null;
		}
		System.out.println("lista vacia");
	}

	public void ExtraerPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion para insertar el nuevo nodo: ");
			while (pos < 1 || pos > this.Cantidad());
			if (pos == 1)
				this.ExtraerIni();
			else
				if (pos == this.Cantidad())
					this.ExtraerFin();
				else
				{
					for (act = ini, con = 1; con < pos; act = act.getSiguiente(), con++)
						;
					System.out.println("´Producto eliminado " + act.getProducto());
					act.getAnterior().setSiguiente(act.getSiguiente());
					act.getSiguiente().setAnterior(act.getAnterior());
				}

		}
		System.out.println("lista vacia");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Lista de productos...");
			for (act = ini; act != null; act = act.getSiguiente())
				System.out.println(act.getProducto());
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("Lista vacia");
	}

	public void Buscar()
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			pro = obd.Cadena("Producto a buscar: ").toUpperCase();
			for (act = ini; act != null; act = act.getSiguiente())
				if (act.getProducto().indexOf(pro) != -1)
				{
					System.out.println(act.getProducto());
					ban = false;
				}
			if (ban)
				System.out.println("El porducto no esta en la lista");
			else
				System.out.println("Fin de la lsta");
		}
		else
			System.out.println("Lista vacia");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			pro = obd.Cadena("Producto a buscar: ").toUpperCase();
			for (act = ini; act != null; act = act.getSiguiente())
				if (act.getProducto().equals(pro))
				{
					act.setProducto(obd.Cadena("Nuevo nombre del producto: ").toUpperCase());
					break;
				}
			if (act == null)
				System.out.println("No se encuntra en la lista");
		}
		else
			System.out.println("Lista vacia");
	}

	public void Borrar()
	{
		ini = fin = null;
		System.out.println("lista borrada");
	}
}
