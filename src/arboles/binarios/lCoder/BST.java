package arboles.binarios.lCoder;

public class BST {
	
	Nodo raiz;
	public BST() {
		raiz=null;
	}
	
	private class Nodo{
		Nodo padre,izquierda,derecha;
		int llave;
		Object valor;
		
		Nodo(int key){
			llave=key;
			padre=null;
			izquierda=null;
			derecha=null;
			valor=null;
		}
	}
	
	public void insetar(int key,Object valor) {
		Nodo nuevo = new Nodo (key);
		nuevo.valor=valor;
		if(raiz==null) {
			raiz=nuevo;
		}else {
			Nodo temporal=raiz;
			while(temporal!=null) {
				nuevo.padre=temporal;
				if(nuevo.llave>=temporal.llave) {
					temporal=temporal.derecha;
				}else {
					temporal=temporal.izquierda;
				}
			}
			if(nuevo.llave<nuevo.padre.llave) {
				nuevo.padre.izquierda=nuevo;
			}else {
				nuevo.padre.derecha=nuevo;
			}
		}
	}
	
	public void recorrido_en_orden(Nodo x) {
		if(x!=null) {
			recorrido_en_ordenizq(x.izquierda);
			System.out.println(x.llave);
			recorrido_en_ordender(x.derecha);
		}
	}
	public void recorrido_en_ordenizq(Nodo x) {
		if(x!=null) {
			recorrido_en_ordenizq(x.izquierda);
			System.out.println("izq-- "+x.llave);
			recorrido_en_ordenizq(x.derecha);
		}
	}
	public void recorrido_en_ordender(Nodo x) {
		if(x!=null) {
			recorrido_en_ordender(x.izquierda);
			System.out.println("der-- "+x.llave);
			recorrido_en_ordender(x.derecha);
		}
	}
	
}
