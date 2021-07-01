package Avl;

public class AVL<E extends Comparable<E>> {
	class Node {
		protected E data;
		protected Node left, right;
		protected int bf;	
		public Node(E data) {
			this (data,null,null);
		}
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.bf = 0;
		}
	}
	
	private Node root;
	private boolean height;
	
	public boolean isEmpty() { return this.root == null; }
	
	public void insert(E x)  throws ItemDuplicated {
		this.height = false;
		this.root = insert(x, this.root);
	}
	
	protected Node insert(E x, Node node) throws ItemDuplicated{
		Node res = node;
		if (node == null) {
			this.height = true;
			res = new Node (x);
		}
		else {
			int resC = node.data.compareTo(x);
			if(resC == 0)throw new ItemDuplicated(x+" ya se encuentra en el arbol...");
			if(resC < 0) {
				res.right = insert(x, node.right);
				if(this.height)
					switch(res.bf) {
					case -1: res.bf = 0;
						this.height = false;
						break;
					case 0: res.bf = 1;
						this.height = true;
						break;
					case 1: res = balanceToLeft(res);
						this.height = false;
						break;
					}
			}
			else { 
				res.left = insert(x, node.left);
				if(this.height)
					switch(res.bf) {
					case 1: res.bf = 0;
						this.height = false;
						break;
					case 0: res.bf = 1;
						this.height = true;
						break;
					case -1: res = balanceToRight(res);
						this.height = false;
						break;
					}
			}
		}
		return res;
	}
	
	private Node balanceToRight(Node node){
		Node hijo = node.left;
		switch(hijo.bf) {
		case -1: 
			node.bf = 0;
			hijo.bf = 0;
			node = rotateSL(node);
			break;
		case 1:
			Node nieto = hijo.right;
			switch(nieto.bf) {
				case 1: node.bf = 0;hijo.bf = 1; break;
				case 0: node.bf = 0; hijo.bf = 0; break;
				case -1: node.bf = -1; hijo.bf = 0; break;	
			}
			nieto.bf =0;
			
			node.left = rotateSR(hijo);
			node = rotateSL(node);
		}
		
		return node;
	}
	
	
	private Node balanceToLeft(Node node){
		Node hijo = node.right;
		switch(hijo.bf) {
		case 1: 
			node.bf = 0;
			hijo.bf = 0;
			node = rotateSL(node);
			break;
		case -1:
			Node nieto = hijo.left;
			switch(nieto.bf) {
			case -1: node.bf = 0;hijo.bf = -1; break;
			case 0: node.bf = 0; hijo.bf = 0; break;
			case 1: node.bf = 1; hijo.bf = 0; break;
			
			}
			nieto.bf =0;
			
			node.right = rotateSR(hijo);
			node = rotateSL(node);
		}
		return node;
	}
	
	
	private Node rotateSL(Node node){
		Node p = node.right;
		node.right = p.left;
		p.left = node;
		node = p;
		return node;
	}
	
	private Node rotateSR(Node node){
		Node p = node.left;
		node.left = p.right;
		p.right = node;
		node = p;
		
		return node;
	}
	
	
	public void inOrden(){
		if (this.isEmpty())
			System.out.println("Arbol esta vacio....");
		else
			inOrden(this.root);
		System.out.println();
	}

	protected void inOrden(Node actual){
		if (actual.left != null) inOrden(actual.left);
		System.out.print(actual.data.toString()+"/"+actual.bf+", ");
		if (actual.right != null) inOrden(actual.right);
	}
	
	
	public void delete(E elem) {
		
	}
}







