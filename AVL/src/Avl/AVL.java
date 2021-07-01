package Avl;

public class AVL<E extends Comparable<E>> {
	class Node {
		public E data;
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
		
		public void setLeft(Node nodeL) {
			this.left = nodeL;
		}
		public void setRight(Node nodeR) {
			this.right = nodeR;
		}
		public void setData(E dat) {
			this.data = dat;
		}
		public E getData() {
			return this.data;
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
	
	

	
	public Node delete(Node node, E data) {
		
		if(node == null) {
			return node;
		}
		int da1 = (int)data;
		int da2 = (int)node.getData();
		
		if(da1 < da2) {
			node.setLeft(delete(node.left, data));
		}else if(da1 > da2) {
			node.setRight(delete(node.right, data));
		}else {
			if(node.left == null && node.right == null) {
				System.out.println("removing a leaf node ... ");
				return null;
			}
			
			if(node.left == null) {
				System.out.println("msm 2");
				Node tempNode = node.right;
				node = null;
				return tempNode;
			} else if(node.right == null) {
				System.out.println("msm 3");
				Node tempNode = node.left;
				node = null;
				return tempNode;
			}
			
			System.out.println(" removing ...");
			Node tempNode = getPredecessor(node.left);
			
			node.setData(tempNode.getData());
			node.setLeft(delete(node.left, tempNode.getData()));
		}
		
		//node.setHeight(Math.max(height(node.left), height(node.right) +1 ));
		return settleDeletion(node);
	}
	
	private Node settleDeletion(Node node) {
		int balance = getBalance(node);
		if(balance > 1) {
			if(getBalance(node.left) < 0) {
				node.setLeft(rotateSL(node.left));
			}
			return rotateSR(node);
		}
		
		if(balance < -1) {
			if(getBalance(node.right) > 0) {
				node.setRight(rotateSR(node.right));
			}
			return rotateSL(node);
		}
		return node;
	}
	
	private int height(Node node) {
		if(node== null) {
			return -1;
		}
		return 0;
		//return node.getHeight();
	}
	
	private int getBalance(Node node) {
		if(node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}
	
	private Node getPredecessor(Node node) {
		Node predecessor = node;
		while(predecessor.right != null) {
			predecessor = predecessor.right;
		}
		return predecessor;
	}
	
	
	
}
//https://www.youtube.com/watch?v=sezWC_pplHc -- apoyo del delete






