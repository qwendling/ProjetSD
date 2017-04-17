import java.net.* ;
import java.rmi.* ;
import java.lang.*;

public class ProducteurServ
{
	public static void main(String [] args)
	{
		if (args.length != 6)
		{
			System.out.println("Usage : java JoueurServ <port du serveur de noms> <Nom Producteur> <Nom ressources> <nbr de ressource initiale> <ratio de prod> <Nb de ressources pouvant etre donnee>") ;
			System.exit(0) ;
		}
		try
		{
  			Producteur objLocal = new Producteur(args[1],args[2],Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5])) ;
			//Thread t=new Thread(objLocal);
			//t.start();
			Naming.rebind( "rmi://localhost:" + args[0] + "/" + args[1] ,objLocal);
			System.out.println("Serveur pret");
		}
		catch (RemoteException re)      { System.out.println(re) ; }
		catch (MalformedURLException e) { System.out.println(e) ;  }
	}
}
