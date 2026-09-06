package tema2;

public class VectorP
{
	public static void main(String[] args)
	{
		Vector obv = new Vector();
		int tam = obv.Tamaño();
		obv.Aleatorios(tam);
		System.out.println("Contenido del arreglo...");
		obv.Moatrar(tam);
	}
}
