public class ewliminacion{

  private NodoAVL eliminacionAVL(NodoAVL nodoActual, int key) {
    if(nodoActual == null){
      return nodoActual;
    }

    if(key < nodoActual.key){
      nodoActual.left = eliminacionAVL(nodoActual.left, key)
    }else if(key > nodoActual.key){
      nodoActual.right = eliminarAVL(nodoActual.right, key)
    }else{
      if((nodoActual.left == null) || (nodoActual.right == null)){
        NodoAVL temp = null;
        if(temp == nodoActual.left){
          temp = nodoActual.right;
        }else{
          temp = nodoActual.left;
        }

        if(temp == null){
          nodoActual = null;
        }else{
          nodoActual = temp;
        }
      }else{
        NodoAVL temp = getNodoConValorMaximo(nodoActual.left);
        nodoActual.key = temp.key;
        nodoActual.left = eliminarAVL(nodoActual.left, temp.key);
      }
    }
  }


}
