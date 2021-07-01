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
		
		AVL<Integer> arbol2 = new AVL<Integer>();
		arbol2.insert(80);
		arbol2.insert(95);
		arbol2.insert(66);
		arbol2.insert(70);
		arbol2.insert(98);
		arbol2.insert(67);
		arbol2.inOrden();
		
		AVL<Integer> arbol3 = new AVL<Integer>();
		arbol3.insert(80);
		arbol3.insert(40);
		arbol3.insert(60);
		arbol3.insert(120);
		arbol3.insert(100);
		arbol3.insert(30);
		arbol3.insert(130);
		arbol3.insert(140);
		arbol3.insert(125);
		arbol3.insert(150);
		arbol3.insert(20);
		arbol3.insert(15);
		arbol3.inOrden();
		
		AVL<Integer> arbol4 = new AVL<Integer>();
		arbol4.insert(14);
		arbol4.insert(1);
		arbol4.insert(6);
		arbol4.insert(17);
		arbol4.insert(8);
		arbol4.insert(9);
		arbol4.inOrden();
	}
}
