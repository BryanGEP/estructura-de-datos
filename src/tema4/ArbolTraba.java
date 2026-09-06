package tema4;

import java.util.LinkedList;
import ed.Datos;

public class ArbolTraba
{
	private Nodo2T raiz, nvo, ant, act, may, suc, asu;
	private int nivel;
	private Datos obd = new Datos();
	private LinkedList<Nodo2T> lista = new LinkedList<Nodo2T>();
	private LinkedList<Trabajador> listao = new LinkedList<Trabajador>();

	public ArbolTraba()
	{
		raiz = null;
	}

	private boolean Vacia()
	{
		return raiz == null;
	}

	private void Existe()
	{
		for (ant = null, act = raiz, nivel = 1; act != null && !act.getTra().Nombre().equals(
				nvo.getTra().Nombre()); ant = act, act = nvo.getTra().Nombre().compareTo(act.getTra().Nombre()) > 0
						? act.getDer()
						: act.getIzq(), nivel++)
			;
	}

	private int NoTarjeta()
	{
		int nt = 0;
		if (!this.Vacia())
		{
			listao.clear();
			this.ListaOrdenada(raiz);
			for (Trabajador tra : listao)
				if (tra.NoTarejta() > nt)
					nt = tra.NoTarejta();
		}
		return nt + 1;
	}

	private void ListaOrdenada(Nodo2T act)
	{
		if (act != null)
		{
			this.ListaOrdenada(act.getIzq());
			listao.addLast(act.getTra());
			this.ListaOrdenada(act.getDer());
		}
	}

	private void Balanceo(int ini, int fin)
	{
		int cen;
		if (ini <= fin)
		{
			cen = (ini + fin) / 2;
			this.Insertar(listao.get(cen));
			this.Balanceo(ini, cen - 1);
			this.Balanceo(cen + 1, fin);
		}
	}

	public void Balanceo()
	{
		listao.clear();
		if (!this.Vacia())
		{
			this.ListaOrdenada(raiz);
			raiz = null;
			this.Balanceo(0, listao.size() - 1);
			System.out.println("Arbol de trabajadores balanceado con exito...");
		}
		else
			System.out.println("Arbol de trabajadores vacio...");
	}

	private void Insertar(Trabajador tra)
	{
		nvo = new Nodo2T(tra);
		if (!this.Vacia())
		{
			this.Existe();
			if (act == null)
			{
				if (nvo.getTra().Nombre().compareTo(ant.getTra().Nombre()) > 0)
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
				System.out.println("Trabajado almacena en el arbol...");
			}
			else
				System.out.println("El trabajado ya existe en el arbol...");
		}
		else
			raiz = nvo;
	}

	public void Insertar()
	{
		nvo = new Nodo2T(new Trabajador(this.NoTarjeta()));
		if (!this.Vacia())
		{
			this.Existe();
			if (act == null)
			{
				if (nvo.getTra().Nombre().compareTo(ant.getTra().Nombre()) > 0)
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
				System.out.println("Trabajador almacenando en el arbol...");
			}
			else
				System.out.println("El trabajador ya existe en el arbol...");
		}
		else
			raiz = nvo;
	}

	public void EliminarFuncion()
	{
		if (!this.Vacia())
		{
			nvo = new Nodo2T(new Trabajador(obd.Cadena("Cual es el nombre a eliminar")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Trabajador eliminado...");
				act.getTra().Mostrar();
				if (act.getIzq() != null && act.getDer() != null)
				{
					for (may = act.getIzq(), nvo = may; may.getDer() != null; may = may.getDer())
						;
					may.setDer(act.getDer());
				}
				else
					if (act.getIzq() != null)
						nvo = act.getIzq();
					else
						nvo = act.getDer();
				if (act != raiz)
					if (act.getIzq() == act)
						ant.setIzq(nvo);
					else
						ant.setDer(nvo);
				else
					raiz = nvo;
			}
			else
				System.out.println("El trabajador no existe en el arbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void EliminarCopiado()
	{
		if (!this.Vacia())
		{
			nvo = new Nodo2T(new Trabajador(obd.Cadena("Cual es nombre del trabajador a eliminar")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Trabajador eliminado...");
				act.getTra().Mostrar();
				if (act.getIzq() != null)
				{
					for (asu = act, suc = act.getIzq(); suc.getDer() != null; asu = suc, suc = suc.getDer())
						;
					act.setTra(suc.getTra());
					if (asu == act)
						act.setIzq(suc.getIzq());
					else
						asu.setDer(suc.getIzq());
				}
				else
					if (act.getDer() != null)
					{
						for (asu = act, suc = act.getDer(); suc.getIzq() != null; asu = suc, suc = suc.getIzq())
							;
						act.setTra(suc.getTra());
						if (asu == act)
							act.setDer(suc.getDer());
						else
							asu.setIzq(suc.getDer());
					}
					else
						if (ant != null)
							if (ant.getIzq() == act)
								ant.setIzq(null);
							else
								ant.setDer(null);
						else
							raiz = null;
			}
			else
				System.out.println("La cadena no existe del arbol...");
		}
		else
			System.out.println("El del arbol del trabajador vacio...");
	}

	public void ReccorridoAmplitud()
	{
		if (!this.Vacia())
		{
			lista.addLast(raiz);
			System.out.println("Contenido del arbol...");
			while (!lista.isEmpty())
			{
				act = lista.removeFirst();
				act.getTra().Mostrar();
				if (act.getIzq() != null)
					lista.addLast(act.getIzq());
				if (act.getDer() != null)
					lista.addLast(act.getDer());
			}
			System.out.println("Fin del arbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void RecorridoProfundidad()
	{
		if (!this.Vacia())
		{
			System.out.println("Contenido del arbol...");
			lista.addLast(raiz);
			while (!lista.isEmpty())
			{
				act = lista.removeLast();
				act.getTra().Mostrar();
				if (act.getDer() != null)
					lista.addLast(act.getDer());
				if (act.getIzq() != null)
					lista.addLast(act.getIzq());
			}
			System.out.println("Fin del arbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			nvo = new Nodo2T(new Trabajador(obd.Cadena("Cual es la cadena que busca")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Cadena encontrado en el nivel " + nivel);
				act.getTra().Mostrar();
			}
			else
				System.out.println("La cadena no esta en el arbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Borrar()
	{
		raiz = null;
		System.out.println("Arbol borrado");
	}

}