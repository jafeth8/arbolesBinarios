package arboles.binarios.Mak;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado e1=new Empleado(20,"Romeo","ing, sistemas","sala1");
		Empleado e2=new Empleado(44,"Jibril","desing","sala2");
		Empleado e3=new Empleado(18,"Mateo","administrador bd","sala3");
		Empleado e4=new Empleado(33,"Abigail","tester","sala4");
		Empleado e5=new Empleado(64,"Miguel","electronica","sala5");
		Empleado e6=new Empleado(55,"Manuel","arq de software","sala6");
		
		//Empleado e7=new Empleado(51,"Manuel","arq de software","sala6");
		//Empleado e8=new Empleado(56,"Manuel","arq de software","sala6");
		
		BST arbol = new BST();
		/*
		System.out.println("es vacio- "+arbol.esVacio()+" es hoja- "+arbol.esHoja());
		arbol.insertar(e1);
		System.out.println("es vacio- "+arbol.esVacio()+" es hoja- "+arbol.esHoja());
		arbol.insertar(e2);
		System.out.println("es vacio- "+arbol.esVacio()+" es hoja- "+arbol.esHoja());
		
		localizar(arbol, 44);
		localizar(arbol, 5);
		*/
		
		Arrays.asList(e1,e2,e3,e4,e5,e6).forEach(e->arbol.insertar(e));
		//Arrays.asList(e1,e2,e3,e4,e5,e6).forEach(arbol::insertar);
		arbol.inorden();
		arbol.eliminar(20);
		System.out.println();
		arbol.inorden();
	}
	
	public static void localizar(BST bst,int id) {
		if(bst.existe(id)) {
			System.out.println(bst.obtener(id));
		}else {
			System.out.println("no se encuentra el empledo con el id-- "+id);
		}
	}
}
