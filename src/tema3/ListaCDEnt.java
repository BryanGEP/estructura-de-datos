package tema3;

import ed.Datos;

public class ListaCDEnt
{
	private NodoCDE ini, fin, nvo, ant, act;
	private int pos, con, num;
	private Datos obd = new Datos();

	public ListaCDEnt()
	{
		ini = fin = null;
	}

	private boolean Vacia()
	{
		return ini == null;
	}

	private int Cantidad()
	{
		int can = 0;
		if (!this.Vacia())
			for (nvo = ini, can = 1; nvo != fin; nvo = nvo.getSiguiente(), can++)
				;
		return can;
	}

	public void InsertarIni()
	{
		nvo = new NodoCDE(obd.Entero("Escribe el numero"));
		if (!this.Vacia())
		{
			nvo.setSiguiente(ini);
			ini.setAnterior(nvo);
			ini = nvo;
		}
		else
			ini = fin = nvo;
		ini.setAnterior(fin);
		fin.setSiguiente(ini);
	}

	public void InsertarPos()
	{
		do
			pos = obd.Entero("Cual es la posicion a insertar el entero");
		while (pos < 1);
		if (pos == 1)
			this.InsertarIni();
		else
			if (pos > this.Cantidad())
				this.InsertarFin();
			else
			{
				nvo = new NodoCDE(obd.Entero("Escribe el numero"));
				for (ant = ini, con = 1; con < pos - 1; ant = ant.getSiguiente(), con++)
					;
				nvo.setSiguiente(act);
				nvo.setAnterior(act.getAnterior());
				act.getAnterior().setSiguiente(nvo);
				act.setAnterior(nvo);
			}
	}

	public void InsertarFin()
	{
		nvo = new NodoCDE(obd.Entero("Escribe el numero"));
		if (!this.Vacia())
		{
			fin.setSiguiente(nvo);
			nvo.setAnterior(fin);
			fin = nvo;
		}
		else
			ini = fin = nvo;
		ini.setSiguiente(fin);
		fin.setSiguiente(ini);
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Numero extraido " + ini.getNumero());
			if (ini != fin)
			{
				ini = ini.getSiguiente();
				ini.setAnterior(fin);
				fin.setSiguiente(ini);
			}
			else
				ini = fin = null;
		}
		else
			System.out.println("No hay numeros en la lista...");
	}

	public void ExtraerPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion a eliminar");
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
					System.out.println("Numero eliminado" + act.getSiguiente());
					act.getAnterior().setSiguiente(act.getSiguiente());
					act.getSiguiente().setAnterior(act.getAnterior());
				}
		}
		else
			System.out.println("No hay numeros en la lista...");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Numero extraido " + fin.getNumero());
			if (ini != fin)
			{
				fin = fin.getAnterior();
				fin.setSiguiente(ini);
				ini.setAnterior(fin);
			}
			else
				ini = fin = null;
		}
		else
			System.out.println("No hay productos en la lista...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Lista de numeros...");
			for (nvo = ini, con = 1; con < pos; nvo = nvo.getSiguiente(), con++)
				;
			nvo.getNumero();
			System.out.println("Fin de la lista...");
		}
		else
			System.out.println("No hay numeros en la lista...");
	}

	public void Buscar()
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			num = obd.Entero("Numero a buscar ");
			for (nvo = ini, con = 1; con < pos; nvo = nvo.getSiguiente(), con++)
				;
			if (nvo.getNumero() == num)
			{
				System.out.println(nvo.getNumero());
				ban = false;
			}
			if (ban)
				System.out.println("El numeros no esta en la lista...");
			else
				System.out.println("Fin de la lista...");
		}
		else
			System.out.println("No hay numeros en la lista...");
	}

	public void Borrar()
	{
		ini = fin = null;
		System.out.println("Lista de numeros borrada...");
	}
}
