package tema3;

import ed.Datos;

public class ListaSimple
{
	private NodoS ini, fin, nvo, ant, act;
	private int pos, con;
	private Datos obd = new Datos();

	public ListaSimple()
	{
		ini = fin = null;
	}

	private boolean Vacia()
	{
		return ini == null;
	}

	private int Cantidad()
	{
		int con = 0;
		if (!this.Vacia())
		{
			for (nvo = ini, con = 1; nvo != fin; nvo = nvo.getSiguiente(), con++)
				;
			return con;
		}
		return con;
	}

	public void InsertarIni()
	{
		nvo = new NodoS(obd.Cadena("Nombre a insertar al inicio: ").toUpperCase());
		if (!this.Vacia())
		{
			nvo.setSiguiente(ini);
			ini = nvo;
		}
		else
			ini = fin = nvo;
	}

	public void InsertarFin()
	{
		nvo = new NodoS(obd.Cadena("Nombre a insertar: al final: ").toUpperCase());
		if (!this.Vacia())
		{
			fin.setSiguiente(nvo);
			fin = nvo;
		}
		else
			ini = fin = nvo;
	}

	public void InsertarPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Cual es la posicicion: ");
			while (pos < 1 || pos > this.Cantidad());
			if (pos == 1)
				this.InsertarIni();
			else
				if (pos > this.Cantidad())
					this.InsertarFin();
				else
				{
					nvo = new NodoS(obd.Cadena("Nombre a insertar:").toUpperCase());
					for (act = ini, con = 1; con < pos; ant = nvo, act = act.getSiguiente(), con++)
						;
					ant.setSiguiente(nvo);
					nvo.setSiguiente(act);
				}
		}
		else
		{
			nvo = new NodoS(obd.Cadena("Nombre a insertat al inicio").toUpperCase());
			ini = fin = nvo;
		}

	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombres de la lista");
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				System.out.println(nvo.getDato());
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("Lista vacia");
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombre extraido del inicio" + ini.getDato());
			ini = ini.getSiguiente();
		}
		else
			System.out.println("Lista vacia");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombre extraido del final" + fin.getDato());
			if (ini != fin)
			{
				for (ant = ini; ant.getSiguiente() != fin; ant = ant.getSiguiente())
					fin = ant;
				fin.setSiguiente(null);
			}
			else
				ini = null;
		}
		else
			System.out.println("Lista vacia");
	}

	public void ExtraerPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Cual es la posicicion: ");
			while (pos < 1 || pos > this.Cantidad());
			if (pos == 1)
				this.ExtraerIni();
			else
				if (pos == this.Cantidad())
					this.ExtraerFin();
				else
				{
					for (ant = ini, con = 1; con < pos - 1; ant = ant.getSiguiente(), con++)
						;
					System.out.println("Nombre extraido de la pos " + pos + ": " + ant.getSiguiente().getDato());
					ant.setSiguiente(ant.getSiguiente().getSiguiente());
				}
		}
		else
			System.out.println("Lista vacia");
	}

	public void Buscar()
	{
		String nom, msj = "";
		if (!this.Vacia())
		{
			nom = obd.Cadena("Nombre a buscar: ").toUpperCase();
			for (act = ini, pos = 1, con = 0; act != null; act = act.getSiguiente(), pos++)
				if (act.getDato().equals(nom))
				{
					con++;
					msj += pos + "  ";
				}
			if (con != 0)
			{
				System.out.println("Posiciones donde se encontro: " + msj);
				System.out.println("Cantidad de veces que se encontro: " + con);
			}
			else
				System.out.println("El nombre no esta en la lista...");
		}
		else
			System.out.println("Lista vacia");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Cual es la posicicion: ");
			while (pos < 1 || pos > this.Cantidad());
			for (act = ini, con = 1; con < pos; act = act.getSiguiente(), con++)
			{
				System.out.println("Nombre a modificar " + act.getDato());
				act.setDato(obd.Cadena("Nuevo nombre: ").toUpperCase());
				System.out.println("Nombre modificado...");
			}
		}
		else
			System.out.println("Lista vacia");
	}

	public void Borrar()
	{
		ini = fin = null;
		System.out.println("Lista borrada");
	}
}
