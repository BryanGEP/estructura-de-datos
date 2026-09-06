package tema3;

import ed.Datos;

public class ListaSimpleTra
{
	private NodoST ini, fin, nvo, ant, act;
	private int pos, con, nt;
	private Datos obd = new Datos();

	public ListaSimpleTra()
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
			for (nvo = ini, con = 1; nvo != null; nvo = nvo.getSiguiente(), con++)
				;
			return con;
		}
		return con;
	}

	private int NoTarjeta()
	{
		if (this.Vacia())
		{
			for (act = ini, nt = act.getDato().NoTarejta(); act != null; act = act
					.getSiguiente(), nt = act.getDato().NoTarejta() > nt ? act.getDato().NoTarejta() : nt)
				;
			return nt + 1;
		}
		else
			return 1;
	}

	public void InsertarIni()
	{
		nvo = new NodoST(new Trabajador(this.NoTarjeta()));
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
		nvo = new NodoST(new Trabajador(this.NoTarjeta()));
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
				nvo = new NodoST(new Trabajador(this.NoTarjeta()));
				for (ant = ini, con = 1; con < pos - 1; ant = ant.getSiguiente(), con++)
					;
				nvo.setSiguiente(ant.getSiguiente());
				ant.setSiguiente(nvo);
			}
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Trabajadores de la lista");
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				nvo.getDato().Mostrar();
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("Lista vacia");
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Trabajador eliminadodel inicio: ");
			ini.getDato().Mostrar();
			ini = ini.getSiguiente();
		}
		else
			System.out.println("Lista vacia");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Trabajador extraido del final: ");
			fin.getDato().Mostrar();
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
					System.out.println("Trabajador extraido de la posicion: " + pos);
					ant.getSiguiente().getDato().Mostrar();
					ant.setSiguiente(ant.getSiguiente().getSiguiente());
				}
		}
		else
			System.out.println("Lista vacia");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			do
				nt = obd.Entero("NO de tarjeta a buscar: ");
			while (nt < 1);
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				if (act.getDato().NoTarejta() == nt)
				{
					nvo.getDato().Mostrar();
					break;
				}
			if (nvo == null)
				System.out.println("El trabajador no existe...");
		}
		else
			System.out.println("Lista vacia");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			do
				nt = obd.Entero("NO de tarjeta a modificar: ");
			while (nt < 1);
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				if (act.getDato().NoTarejta() == nt)
				{
					nvo.getDato().Modificar();
					break;
				}
			if (act == null)
				System.out.println("El trabajador no existe...");
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
