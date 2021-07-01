package Avl;

public class App {
	public static void main(String [] args) throws ItemDuplicated {
		AVL<Integer> arbol = new AVL<Integer>();	
		int [] a = {44, 70, 30, 2 , 72, 26, 81,55}; 
		insertar(arbol, a);
		
		AVL<Integer> arbol2 = new AVL<Integer>();
		int [] b = {80, 95, 66, 70, 98, 67};
		insertar(arbol2, b);
		
		AVL<Integer> arbol3 = new AVL<Integer>();
		int [] c = {80,40,60,120,100,30,130,140,125,150,20,15};
		insertar(arbol3, c);
		
		arbol3.delete(100);
		arbol3.inOrden();
		
		
		AVL<Integer> arbol4 = new AVL<Integer>();
		int [] d = {14, 1, 6, 17, 8, 9};
		insertar(arbol4, d);		
	}
	
	public static void insertar(AVL<Integer> tree, int [] arr) throws ItemDuplicated {
		for(int i=0; i<arr.length; i++) {
			tree.insert(arr[i]);
		}
		tree.inOrden();
	}
}
