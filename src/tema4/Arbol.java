package tema4;

import ed.Datos;
import java.util.LinkedList;

public class Arbol
{
	private Nodo2 raiz, nvo, ant, act, may, suc, asu;
	private int nivel;
	private Datos obd = new Datos();
	private LinkedList<Nodo2> lista = new LinkedList<Nodo2>();
	private LinkedList<Integer> listao = null;// listao = new LinkedList<Integer>()

	public Arbol()
	{
		raiz = null;
	}

	private boolean Vacia()
	{
		return raiz == null;
	}

	private void Existe()
	{
		for (ant = null, act = raiz, nivel = 1; act != null
				&& act.getNum() != nvo.getNum(); ant = act, act = nvo.getNum() > act.getNum() ? act.getDer()
						: act.getIzq(), nivel++)
			;
	}

	public void Insertar()
	{
		nvo = new Nodo2(obd.Entero("Ingresa el numero: "));
		if (!this.Vacia())
		{
			this.Existe();
			if (act == null)
				if (nvo.getNum() > ant.getNum())
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			else
				System.out.println("El nodo ya existe");
		}
		else
			raiz = nvo;
	}

	public void EliminarFusion()
	{
		if (!this.Vacia())
		{
			nvo = new Nodo2(obd.Entero("Ingresa el numero a eliminar: "));
			this.Existe();
			if (act != null)
			{
				if (act.getIzq() != null && act.getDer() != null)
				{
					for (may = act.getIzq(), nvo = may; may.getDer() != null; may = may.getDer())
						may.setDer(act.getDer());
				}
				else
					if (act.getIzq() != null)
						nvo = act.getIzq();
					else
						nvo = act.getDer();
				if (act != raiz)
				{
					if (ant.getIzq() == act)
						ant.setIzq(nvo);
					else
						ant.setDer(nvo);
				}
				else
					raiz = nvo;

			}
			else
				System.out.println("EL NUMERO NO EXISTE");
		}
		else
			System.out.println("arbol vacio");
	}

	public void EliminarCopiado()
	{
		if (!this.Vacia())
		{
			nvo = new Nodo2(obd.Entero("Ingresa el numero a eliminar: "));
			this.Existe();
			if (act != null)
			{
				if (act.getIzq() != null)
				{
					for (asu = act, suc = act.getIzq(); suc.getDer() != null; asu = suc, suc = suc.getDer())
						act.setNum(suc.getNum());
					if (asu == act)
						act.setIzq(suc.getIzq());
					else
						asu.setDer(suc.getIzq());
				}
				else
					if (act.getDer() != null)
					{
						for (asu = act, suc = act.getDer(); suc.getIzq() != null; asu = suc, suc = suc.getIzq())
							act.setNum(suc.getNum());
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
				System.out.println("EL NUMERO NO EXISTE");
		}
		else
			System.out.println("arbol vacio");
	}

	public void RecorridoAmplitud()
	{
		if (!this.Vacia())
		{
			lista.addLast(raiz);
			System.out.println("Contenido del arbol....");
			while (!lista.isEmpty())
			{
				act = lista.removeFirst();
				System.out.println(act.getNum());
				if (act.getIzq() != null)
					lista.addLast(act.getIzq());
				if (act.getDer() != null)
					lista.addLast(act.getDer());
			}
			System.out.println("Fin del arbol....");
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
				System.out.println(act.getNum());
				if (act.getDer() != null)
					lista.addLast(act.getDer());
				if (act.getIzq() != null)
					lista.addLast(act.getIzq());
			}
			System.out.println("Fin del arbol....");
		}
		else
			System.out.println("Arbol vacio...");

	}

	public void Búsqueda()
	{
		if (!this.Vacia())
		{
			nvo = new Nodo2(obd.Entero("Cual es el numero a buscar: "));
			this.Existe();
			if (act != null)
				System.out.println("Número encontrado en el nivel :" + nivel);
			else
				System.out.println("El número no esta en el atbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Balanceo()
	{
		// listao = new LinkedList<Integer>();
		listao.clear();
		if (!this.Vacia())
		{
			this.ListaOrdenada(raiz);
			raiz = null;
			this.Balanceo(0, listao.size() - 1);
		}
		else
			System.out.println("Arbol vacio...");

	}

	private void ListaOrdenada(Nodo2 raiz)
	{
		if (act != null)
		{
			this.ListaOrdenada(act.getIzq());
			listao.addLast(act.getNum());
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

	private void Insertar(int num)
	{
		nvo = new Nodo2(num);
		if (!this.Vacia())
		{
			if (act == null)
			{
				this.Existe();
				if (nvo.getNum() > ant.getNum())
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			}
			System.out.println("Hola mundo");
		}
		else
			raiz = nvo;
	}

	public void Borrar()
	{
		raiz = null;
		System.out.println("arbol borrado");
	}

}
