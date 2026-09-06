package tema3;

import ed.Datos;

public class ListaDobleAlu
{
	private NodoDAlu ini, fin, nvo, act;
	private int pos, con;
	private String bus;
	private Datos obd = new Datos();

	public ListaDobleAlu()
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
		nvo = new NodoDAlu(new Alumno());
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
				nvo = new NodoDAlu(new Alumno());
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
		nvo = new NodoDAlu(new Alumno());
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
			System.out.println("Producto extraido del inicio: ");
			ini.getAlumno().Mostrar();
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
			System.out.println("Producto extraido del final ");
			fin.getAlumno().Mostrar();
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
					System.out.println("alumno eliminado ");
					act.getAlumno().Mostrar();
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
			System.out.println("Lista de alumnos...");
			for (act = ini; act != null; act = act.getSiguiente())
				act.getAlumno().Mostrar();
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("Lista vacia");
	}

	public void BuscarNc()
	{
		if (!this.Vacia())
		{
			bus = obd.Cadena("Nc a buscar: ").toUpperCase();
			for (act = ini; act != null; act = act.getSiguiente())
				if (act.getAlumno().NoControl().equals(bus))
				{
					System.out.println("Alumno encontrado");
					act.getAlumno().Mostrar();
					break;
				}
			if (act == null)
				System.out.println("El alumno no esta en la lista");
		}
		else
			System.out.println("Lista vacia");
	}

	public void BuscarNom()
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			bus = obd.Cadena("Nombre o aplelido a buscar: ").toUpperCase();
			for (act = ini; act != null; act = act.getSiguiente())
				if (act.getAlumno().Nombre().contains(bus))
				{
					if (ban)
						System.out.println("lista de alumnos encontrados");
					act.getAlumno().Mostrar();
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
			bus = obd.Cadena("nc de control a modificar: ").toUpperCase();
			for (act = ini; act != null; act = act.getSiguiente())
				if (act.getAlumno().NoControl().equals(bus))
				{
					act.getAlumno().Modificar();
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
