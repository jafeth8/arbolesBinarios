package arboles.binarios.Mak;

import javax.management.RuntimeErrorException;

public class BST implements IBST<Empleado> {

	Empleado valor;
	BST izq,der;
	BST padre;
	
	@Override
	public boolean esHoja() {
		// TODO Auto-generated method stub
		return valor!=null && izq==null && der==null;
	}

	@Override
	public boolean esVacio() {
		// TODO Auto-generated method stub
		return valor==null;
	}
	
	private void insertarImpl(Empleado empl,BST padre) {
		if(valor==null) {
			this.valor=empl;
			this.padre=padre;
		}else {
			if(empl.compareTo(valor)<0) {
				if (izq==null) {
					izq=new BST();
					//System.out.println(" izq inicializado");
				}
				izq.insertarImpl(empl,this);
			}else if(empl.compareTo(valor)>0){
				if (der==null) {
					der=new BST();
					//System.out.println("der inicalizado");
				}
				der.insertarImpl(empl,this);
			}else {
				//en caso de que la comparativa sea igual a cero, significa que  hay duplicado ---hacer algo:
				//tirar execpcion, mostrar aviso etc.
				throw new RuntimeException("valor duplicado");
			}
		}
	}
	
	@Override
	public void insertar(Empleado empl) {
		insertarImpl(empl,null);
	}

	@Override
	public boolean existe(int id) {
		if(valor!=null) {
			if(id==valor.getId()) {
				return true;
			}else if(id<valor.getId() && izq!=null) {
				return izq.existe(id);
			}else if(id>valor.getId() && der!=null){//if(id>valor.getId())
				return der.existe(id);
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}

	@Override
	public Empleado obtener(int id) {
		if(valor!=null) {
			if(id==valor.getId()) {
				return valor;
			}else if(id<valor.getId() && izq!=null) {
				return izq.obtener(id);
			}else if(id>valor.getId() && der!=null){//if(id>valor.getId())
				return der.obtener(id);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	private void preordenFormato(String profundidad) {
		if(valor!=null) {
			System.out.println(profundidad + valor);
			if(izq!=null) izq.preordenFormato(profundidad+"  ");
			if(der!=null) der.preordenFormato(profundidad+"  ");
		}
	}
	@Override
	public void preorden() {
		preordenFormato("");
	}
	private void inordenFormato(String profundidad) {
		if(valor!=null) {
			if(izq!=null) izq.inordenFormato(profundidad+"  ");
			System.out.println(profundidad + valor);
			if(der!=null) der.inordenFormato(profundidad+"  ");
		}
	}
	@Override
	public void inorden() {
		inordenFormato("");
	}

	private void postordenFormato(String profundidad) {
		if(valor!=null) {
			if(izq!=null) izq.postordenFormato(profundidad+"  ");
			if(der!=null) der.postordenFormato(profundidad+"  ");
			System.out.println(profundidad + valor);
		}
	}
	@Override
	public void postorden() {
		postordenFormato("");
	}
	
	private BST minimo() {
		if(izq!=null && !izq.esVacio()) {
			return izq.minimo();
		}else {
			return this;
		}
	}
	
	private void eliminarImpl(int id) {
		if(izq!=null && der!=null) {
			//eliminar con 2 hijos
			BST minimo=der.minimo();
			this.valor=minimo.valor;
			der.eliminar(minimo.valor.getId());
		}else if(izq!=null || der!=null) {
			//eliminar con 1 hijo
			BST sustituto=izq!=null ? izq : der;
			this.valor=sustituto.valor;
			this.izq=sustituto.izq;
			this.der=sustituto.der;
		}else {
			//eliminar con 0 hijos
			if(padre!=null) {
				if(this==padre.izq) padre.izq=null;
				if(this==padre.der) padre.der=null;
				padre=null;
			}
			valor=null;
		}
	}
	
	@Override
	public void eliminar(int id) {
		if(valor!=null) {
			if(id==valor.getId()) {
				eliminarImpl(id);
			}else if(id<valor.getId() && izq!=null) {
				izq.eliminar(id);
			}else if(id>valor.getId() && der!=null) {
				der.eliminar(id);
			}
		}
	}

}
