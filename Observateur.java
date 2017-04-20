import java.rmi.RemoteException;

public class Observateur extends Client{
  static final long serialVersionUID = 42;
  Fin typeFin;

  public Observateur(String name,Fin typeFin) throws RemoteException{
    super(name);
    this.typeFin=typeFin;
    this.monType=Type.Observateur;
  }

  public void generationLog(String nameEmetteur,Type typeEmetteur,Action event){
    generationLog(nameEmetteur,typeEmetteur,event,null,0,"",Type.Joueur);
  }

  public void generationLog(String nameEmetteur,Type typeEmetteur,Action event,Ressources r,int nombre){
    generationLog(nameEmetteur,typeEmetteur,event,r,nombre,"",Type.Joueur);
  }

  public void generationLog(String nameEmetteur,Type typeEmetteur,Action event,String nameReceveur,Type typeReceveur){
	    generationLog(nameEmetteur,typeEmetteur,event,null,0,nameReceveur,typeReceveur);
	  }

  public void generationLog(String nameEmetteur,Type typeEmetteur,Action event,Ressources r,int nombre,String nameReceveur,Type typeReceveur){

	  //On fonction de l'event le log change
	  switch(event)
	  {
	  	case Demande :
	  		System.out.println(typeEmetteur+"  "+nameEmetteur+"  Demande  "+r.getName()+"  "+nombre+"  "+typeReceveur+"  "+nameReceveur);
	  		break;

	  	case Production :
	  		System.out.println(typeEmetteur+"  "+nameEmetteur+"  Produit  "+r.getName()+"  "+nombre);
	  		break;

	  	case Vol:
	  		System.out.println(typeEmetteur+"  "+nameEmetteur+"  Vol  "+r.getName()+"  "+nombre+"  "+typeReceveur+"  "+nameReceveur);
	  		break;

	  	case Punition:
	  		System.out.println(typeEmetteur+"  "+nameEmetteur+"  Punit le  "+typeReceveur+"  "+nameReceveur);
	  		break;

	  	case Fin:
	  		System.out.println(typeEmetteur+"  "+nameEmetteur+" � fini la partie !");

	  	default:
	  		break;
	  }
  }



  public void startAgent(){
    System.out.println(name + " Debut partie");
    try{
      for(int i=0;i < ListJoueur.size();i++){
        ListJoueur.get(i).startAgent();
      }
      for(int i=0;i < ListProducteur.size();i++){
        ListProducteur.get(i).startAgent();
      }
    }catch (RemoteException re) { System.out.println(re) ; }


  }

  public void PartieFini(String name){
    generationLog(name , Type.Joueur , Action.Fin);
  }

  public void tourDeJeu(){
    
  }

}
