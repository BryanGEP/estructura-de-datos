package tema4;

import java.util.LinkedList;

public class ArbolActi
{
	private NodoActi raiz, nvo, ant, act, may;
	private int nivel;
	private LinkedList<NodoActi> lista = new LinkedList<NodoActi>();

	public ArbolActi()
	{
		raiz = null;
	}

	private boolean Vacia()
	{
		return raiz == null;
	}

	private boolean Existe()
	{
		for (ant = null, act = raiz, nivel = 1; act != null && act.getCue().NoClave() != nvo.getCue()
				.NoClave(); ant = act, act = nvo.getCue().NoClave() > act.getCue().NoClave() ? act.getDer()
						: act.getIzq(), nivel++)
			;
		return act != null;
	}

	private int NoClave()
	{
		int nc = 0;
		if (!this.Vacia())
			for (act = raiz; act != null; nc = act.getCue().NoClave(), act = act.getDer())
				;
		return nc + 1;
	}

	public void Insertar()
	{
		nvo = new NodoActi(new Articulo(this.NoClave()));
		if (!this.Vacia())
		{
			if (!this.Existe())
			{
				if (nvo.getCue().NoClave() < ant.getCue().NoClave())
					ant.setIzq(nvo);
				else
					ant.setDer(nvo);
				nvo.setPad(ant);
			}
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
			nvo = new NodoActi(new Articulo());
			this.Existe();
			if (act != null)
			{
				act.getCue().Mostrar();
				System.out.println("Articulo eliminado");
				if (act.getIzq() != null && act.getDer() != null)
				{
					for (may = act.getIzq(), nvo = may; may.getDer() != null; may = may.getDer())
						;
					may.setDer(act.getDer());
					act.getDer().setPad(may);

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
					nvo.setPad(ant);
				}
				else
				{
					raiz = nvo;
					raiz.setPad(null);
				}
			}
			else
				System.out.println("EL ARTICULO NO EXISTE");
		}
		else
			System.out.println("Árbol vacio");
	}

	public void RecorridoAmplitud()
	{
		if (!this.Vacia())
		{
			lista.addLast(raiz);
			System.out.println("\nContenido del arbol....");
			while (!lista.isEmpty())
			{
				act = lista.removeFirst();
				act.getCue().Mostrar();
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

	public void Búsqueda()
	{
		if (!this.Vacia())
		{
			nvo = new NodoActi(new Articulo());
			if (this.Existe())
			{
				System.out.println("Nivel: " + nivel);
				act.getCue().Mostrar();
			}
			else
				System.out.println("La cuenta no esta en el atbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Borrar()
	{
		raiz = null;
		System.out.println("arbol borrado");
	}
}
