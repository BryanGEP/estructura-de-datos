package tema3;

import ed.Datos;

public class ListaCDMat
{
	private NodoCDM ini, fin, nvo, act;
	private int pos, con, bus,clv;
	private Datos obd = new Datos();

	public ListaCDMat()
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
		nvo = new NodoCDM(new MateriaOp(clv));
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
			pos = obd.Entero("Posicion para insertar la materia");
		while (pos < 1);
		if (pos == 1)
			this.InsertarIni();
		else
			if (pos > this.Cantidad())
				this.InsertarFin();
			else
			{
				nvo = new NodoCDM(new MateriaOp(clv));
				for (act = ini, con = 1; con < pos; act = act.getSiguiente(), con++)
					;
				nvo.setSiguiente(act);
				nvo.setAnterior(act.getAnterior());
				act.getAnterior().setSiguiente(nvo);
				act.setAnterior(nvo);
			}
	}

	public void InsertarFin()
	{
		nvo = new NodoCDM(new MateriaOp(clv));
		if (!this.Vacia())
		{
			fin.setAnterior(nvo);
			nvo.setSiguiente(fin);
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
			System.out.println("Datos de materia eliminado...");
			ini.getMateria().Mostrar();
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
			System.out.println("No hay materia en la lista...");
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
					System.out.println("Materia eliminado");
					act.getMateria().Mostrar();
					act.getAnterior().setSiguiente(act.getSiguiente());
					act.getSiguiente().setAnterior(act.getAnterior());
				}
		}
		else
			System.out.println("No hay materia en la lista...");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Materia eliminado ");
			fin.getMateria().Mostrar();
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
			System.out.println("No hay materia en la lista...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Lista de materia...");
			for (nvo = ini, con = 1; con < pos; nvo = nvo.getSiguiente(), con++)
				;
			nvo.getMateria().Mostrar();
			System.out.println("Fin de la lista...");
		}
		else
			System.out.println("No hay materia en la lista...");
	}

	public void BuscarMat()
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			bus = obd.Entero("Clave de materia a buscar ");
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				if (nvo.getMateria().Clave() == bus)
				{
					System.out.println("Materia encontrado...");
					nvo.getMateria().Mostrar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El materia no esta en la lista...");
		}
		else
			System.out.println("No hay materia en la lista...");
	}

	public void BuscarPlan()
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			bus = obd.Entero("Plan a buscar ");
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				if (nvo.getMateria().Plan() == bus)
				{
					if (ban)
						System.out.println("Lista de plan encontrados...");
					nvo.getMateria().Mostrar();
					ban = false;
				}
			if (ban)
				System.out.println("El materia no esta en la lista...");
			else
				System.out.println("Fin de la lista...");
		}
		else
			System.out.println("No hay materia en la lista...");
	}

	public void Modificar()
	{
		MateriaOp mat;
		boolean ban = true;
		if (!this.Vacia())
		{
			bus = obd.Entero("No. de control del alumno a modificar ");
			for (nvo = ini; nvo != null; nvo = nvo.getSiguiente())
				if (nvo.getMateria().Clave() == bus)
				{
					System.out.println("Materia encontrada");
					nvo.getMateria().Mostrar();
					mat = nvo.getMateria();
					mat.Modificar();
					nvo.setMateria(mat);
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El materia no esta en la lista...");
		}
		else
			System.out.println("No hay materia en la lista...");
	}

	public void Borrar()
	{
		ini = fin = null;
		System.out.println("Lista de materia borrada...");
	}
}
