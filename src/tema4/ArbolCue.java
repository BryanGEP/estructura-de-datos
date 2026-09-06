package tema4;

import java.util.LinkedList;
import ed.Datos;

public class ArbolCue
{
	private NodoCue raiz, nvo, ant, act, may;
	private int nivel;
	private double mont;
	private Datos obd = new Datos();
	private LinkedList<NodoCue> lista = new LinkedList<NodoCue>();
	private LinkedList<Cuenta> listao = new LinkedList<Cuenta>();

	public ArbolCue()
	{
		raiz = null;
	}

	private boolean Vacia()
	{
		return raiz == null;
	}

	private boolean Existe()
	{
		for (ant = null, act = raiz, nivel = 1; act != null && act.getCue().NoCuenta() != nvo.getCue()
				.NoCuenta(); ant = act, act = nvo.getCue().NoCuenta() > act.getCue().NoCuenta() ? act.getDer()
						: act.getIzq(), nivel++)
			;
		return act != null;
	}

	private int NoCuenta()
	{
		int nc = 0;
		if (!this.Vacia())
			for (act = raiz; act != null; nc = act.getCue().NoCuenta(), act = act.getDer())
				;
		return nc + 1;
	}

	public void Insertar()
	{
		nvo = new NodoCue(new Cuenta(this.NoCuenta()));
		if (!this.Vacia())
		{
			if (!this.Existe())
			{
				if (nvo.getCue().NoCuenta() < ant.getCue().NoCuenta())
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
			nvo = new NodoCue(new Cuenta());
			this.Existe();
			if (act != null)
			{
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
				nvo.setPad(ant);
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
				System.out.println("LA CUENTA NO EXISTE");
		}
		else
			System.out.println("Árbol vacio");
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
				act.getCue().MostrarT();
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
			nvo = new NodoCue(new Cuenta());
			if (this.Existe())
			{
				System.out.println(nivel);
				act.getCue().Mostrar();
			}
			else
				System.out.println("La cuenta no esta en el atbol...");
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Deposito()
	{
		if (!this.Vacia())
		{
			nvo = new NodoCue(new Cuenta());
			if (this.Existe())
				act.getCue().Mostrar();
			do
				mont = obd.Doble("Cantidad a depositar: ");
			while (mont < 1);
			act.getCue().Movimiento(mont);
			act.getCue().Mostrar();
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Retiro()
	{
		if (!this.Vacia())
		{
			nvo = new NodoCue(new Cuenta());
			if (this.Existe())
				act.getCue().Mostrar();
			do
				mont = obd.Doble("Cantidad a retirar: ");
			while (mont < 1 || mont > act.getCue().Saldo());
			act.getCue().Movimiento(mont * -1);
			act.getCue().Mostrar();
		}
		else
			System.out.println("Arbol vacio...");
	}

	public void Balanceo()
	{

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

	private void ListaOrdenada(NodoCue act)
	{
		if (act != null)
		{
			this.ListaOrdenada(act.getIzq());
			listao.addLast(act.getCue());
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

	private void Insertar(Cuenta cue)
	{
		nvo = new NodoCue(cue);
		if (!this.Vacia())
		{

			this.Existe();
			if (nvo.getCue().NoCuenta() < ant.getCue().NoCuenta())
				ant.setDer(nvo);
			else
				ant.setIzq(nvo);
			nvo.setPad(ant);
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
