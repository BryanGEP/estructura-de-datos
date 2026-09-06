package tema3;

public class NodoSP
{
	public static void main(String[] args)
	{
		NodoS ob1, ob2, ob3, ini, fin;
		
		ob1 = new NodoS("Maria");
		ob2 = new NodoS("Jose");
		ob3 = new NodoS("Jesus");
		
		ini = fin = ob1;
		fin = ob2;
		ini.setSiguiente(fin);
		fin.setSiguiente(ob3);
		fin = ob3;
	}
}
