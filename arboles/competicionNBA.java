package arboles;

import treesDS_ESI_UCLM_v2.BinTree;
import treesDS_ESI_UCLM_v2.BinTreeInterface;
import treesDS_ESI_UCLM_v2.NodeBinTree;

public class competicionNBA{
  public static void main(String args[]) {
    BinTreeInterface<Integer> t=new BinTree<>();
    NodeBinTree<Integer> nLak4 = new NodeBinTree<>(6);
    NodeBinTree<Integer> nLak2 = new NodeBinTree<>(7);
    NodeBinTree<Integer> nMia4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nBos4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nBos1 = new NodeBinTree<>(1);
    NodeBinTree<Integer> nKni4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nNug4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nCav4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nCav2 = new NodeBinTree<>(3);
    NodeBinTree<Integer> nMem1 = new NodeBinTree<>(3);
    NodeBinTree<Integer> nMemW= new NodeBinTree<>(7);
    NodeBinTree<Integer> nPhi4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nBos2= new NodeBinTree<>(3);
    NodeBinTree<Integer> nMem2=new NodeBinTree<>(9);
    NodeBinTree<Integer> nMem4=new NodeBinTree<>(5);
    
    t.addRoot(nMemW);
    t.addLeft(nMemW,nBos1);
    t.addRight(nMemW, nMem1);
    t.addLeft(nBos1, nLak2);
    t.addRight(nBos1, nBos2);
    t.addLeft(nMem1, nCav2);
    t.addRight(nMem1, nMem2);
    t.addRight(nLak2, nMia4);
    t.addLeft(nBos2, nBos4);
    t.addRight(nBos2, nKni4);
    t.addLeft(nCav2, nNug4);
    t.addRight(nCav2, nCav4);
    t.addLeft(nMem2, nMem4);
    t.addRight(nMem2, nPhi4);
    t.addLeft(nLak2, nLak4);
    //

    System.out.println("Mejor conferencia: "+mejorConferencia(t));
    System.out.println("El número de nodos es: "+t.size());
  }
  
  private static String mejorConferencia(BinTreeInterface<Integer> t)
  {
  	int vOeste=sumarVictorias(t,t.getRoot().getLeft()),
  			vEste=sumarVictorias(t,t.getRoot().getRight());

  	if(vOeste>vEste) 
  	  return "West";
  	else 
  		return "East";
  }

  private static int sumarVictorias(BinTreeInterface<Integer> t, NodeBinTree<Integer> nodo)
  {
  	int sv=0;
    if(t.isExternal(nodo))
    	sv=nodo.getElement();
    else if(t.isInternal(nodo))
    	sv=nodo.getElement()+nodo.getLeft().getElement();
    return sv;
  }
}
