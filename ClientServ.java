import java.net.* ;
import java.rmi.* ;
import java.lang.*;

public class ClientServ
{
	public static void main(String [] args)
	{
		if (args.length != 2)
		{
			System.out.println("Usage : java Serveur <port du serveur de noms> <Nom Client>") ;
			System.exit(0) ;
		}
		try
		{
			Client objLocal = new Client (args[1]) ; 
			Thread t=new Thread(objLocal);
			t.start();
			System.out.println("rmi://localhost:" + args[0] + "/" + args[1]);
			Naming.rebind( "rmi://localhost:" + args[0] + "/" + args[1] ,objLocal);
			System.out.println("Serveur pret") ;
		}
		catch (RemoteException re)      { System.out.println(re) ; }
		catch (MalformedURLException e) { System.out.println(e) ;  }
	}
}
