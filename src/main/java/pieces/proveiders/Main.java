package pieces.proveiders;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		DAO d = new DAO();
		Provides pr = new Provides();
		ArrayList<Provides> listProvides;
		
		
		pr= d.getProvides (100);
		System.out.println("Estas dentro");
		System.out.println("Pieza: "+pr.getPiece());
		System.out.println("Provider: "+pr.getProvider());
		System.out.println("Precio: "+pr.getPrice());
		System.out.println("**********************");
		
		d.deleteProvides(100);
		System.out.println(" Borrado correctamente");
		System.out.println("**********************");
		
		d.updateProvides(pr);
		
		pr.setPiece(1);
		pr.setProvider("HAL");
		pr.setPrice(100);
		
		listProvides = d.getAllProvides();
		for (int i=0;i<8;i++){
			
			System.out.println("Piece: " + listProvides.get(i).getPiece());
			System.out.println("Provider: " + listProvides.get(i).getProvider());
			System.out.println("Precio: " + listProvides.get(i).getPrice());
		}
		//d.deleteProvides(7);
		//pr.setPiece(1);
		//pr.setProvider("HAL");
		//pr.setPrice(100);
		//d.updateProvides(pr);

		/*ArrayList<Provides> AllProvides = d.getAllProvides();
		if (AllProvides.size() > 0) {
			int numeroPersona = 0;

			for (int i = 0; i < AllProvides.size(); i++) {
				numeroPersona++;
				pr = AllProvides.get(i);
				System.out.println("Provedor " + numeroPersona);
				System.out.println("Pieza: " + pr.getPiece());
				System.out.println("Provedor: " + pr.getProvider());
				System.out.println("Precio: " + pr.getPrice());
				// System.out.println("*************************************************\n");
			}
		} else {
			System.out.println("Actualmente no existen registros");
		}*/

	}
	
	
}
