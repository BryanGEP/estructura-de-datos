package tema4;

import java.util.Comparator;

public class CompararCuenta implements Comparator<Cuenta>
{

	@Override
	public int compare(Cuenta cue1, Cuenta cue2)
	{
		return cue1.NoCuenta() - cue2.NoCuenta();

		//return cue1.Nombre().compareTo(cue2.Nombre());
	}

}
