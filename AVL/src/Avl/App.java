package Avl;

public class App {
	public static void main(String [] args) throws ItemDuplicated {
		AVL<Integer> arbol = new AVL<Integer>();
		
		arbol.insert(44);
		arbol.insert(70);
		arbol.insert(30);
		arbol.insert(2);
		arbol.insert(72);
		arbol.insert(26);
		arbol.insert(81);
		arbol.insert(55);	
		arbol.inOrden();
	}
}
