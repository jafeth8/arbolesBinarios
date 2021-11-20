package arboles.binarios.lCoder;

public class Main {

	public static void main(String[] args) {
		BST arbol= new BST();
		arbol.insetar(5, null);
		arbol.insetar(2, null);
		arbol.insetar(1, null);
		arbol.insetar(3, null);
		arbol.insetar(8, null);
		arbol.insetar(6, null);
		arbol.insetar(10, null);
		
		arbol.recorrido_en_orden(arbol.raiz);

	}

}
