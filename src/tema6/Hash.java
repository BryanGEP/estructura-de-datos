package tema6;

public class Hash
{
	public int Modulo(int num, int tam)
	{
		return num % tam;
	}

	public int Cuadratica(int num, int tam)
	{
		int dir, nd = ((tam - 1) + "").length();
		String cua = (int) Math.pow(num, 2) + "";
		do
		{
			dir = Integer.parseInt(cua.substring(cua.length() / 2 - nd / 2, cua.length() / 2 + nd / 2));
			if (dir >= tam)
				nd--;
		}
		while (dir >= tam);
		return dir;
	}

	public int Plegamiento(int num, int tam)
	{
		int dir, suma, nd = ((tam - 1) + "").length(), ini;
		String cad = num + "";
		do
		{
			suma = 0;
			if (cad.length() > nd)
			{
				for (ini = 0; ini < cad.length() - nd; ini += nd)
					suma += Integer.parseInt(cad.substring(ini, ini + nd));
				suma += Integer.parseInt(cad.substring(ini));
				dir = Integer.parseInt((suma + "").substring((suma + "").length() - nd));
			}
			else
				dir = num;
			if (dir >= tam)
				nd--;
		}
		while (dir >= tam);
		return dir;

	}

	public int Truncamiento(int num, int tam)
	{
		int dir, nd = ((tam - 1) + "").length(), pos;
		String cad = num + "", sub = "";
		for (pos = 0; pos < cad.length(); pos += 2)
			sub += cad.charAt(pos);
		do
		{
			if (sub.length() > nd)
				dir = Integer.parseInt(sub.substring(0, nd));
			else
				dir = Integer.parseInt(sub);
			if (dir >= tam)
				nd--;
		}
		while (dir >= tam);
		return dir;
	}
}
