import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;

public class Decrypt {

	KeyGen k;
	long INI, END;
	
	public long[] decripta(long[] enc, KeyGen k) throws UnsupportedEncodingException {
		long[] textoClaro = new long[enc.length];
		BigInteger[] tc = new BigInteger[enc.length];
		BigInteger[] aux = new BigInteger[enc.length];		

			
//			//IMPLEMENTAÇÃO RSA CFME AULA
//			for(int i = 0; i < enc.length; i++) {
//				aux[i] = BigInteger.valueOf(enc[i]);
//			}
//			
//			INI = System.currentTimeMillis();
//			for(int i = 0; i < enc.length; i++) {
//				tc[i] = aux[i].modPow(k.d, k.n);
//				System.out.println("Encriptado: " + enc[i] + "\tDecriptado: " + tc[i] );
//			}
//			END = System.currentTimeMillis();
//			System.out.printf("Tempo total DECRIPTAÇÃO: " + "%.3f ms%n", (END - INI) / 1000d);
//			//FIM DA IMPLEM RSA AULA
			
		
//			//USO DO METODO SQUARE AND MULTIPLY
//			INI = System.currentTimeMillis();
//			for(int i = 0; i < enc.length; i++) {
//				tc[i] = BigInteger.valueOf(k.quadMult(enc[i], k.d.longValue(), k.n.longValue()));
////				System.out.println("D: "+ k.d.longValue() + " N: "+ k.n.longValue());
//				System.out.println("Encriptado: " + enc[i] + "\tDecriptado: " + tc[i] );
//			}	
//			END = System.currentTimeMillis();
//			System.out.printf("Tempo total DECRIPTAÇÃO: " + "%.3f ms%n", (END - INI) / 1000d);
//			// FIM IMPLEMENTAÇAO SM
		
		
		
//		for(int i = 0; i < enc.length; i++) {
//			textoClaro[i] = (long) Math.pow(enc[i], k.d.longValue()) % k.n.longValue();
//			System.out.println("D: "+ k.d + " N: "+ k.n);
//			System.out.println("Encriptado: " + enc[i] + "\tDecriptado: " + textoClaro[i] );
//		}	
		
			//USO DO METODO CRT DEC
			INI = System.currentTimeMillis();
			for(int i = 0; i < enc.length; i++) {
				tc[i] = BigInteger.valueOf(k.CRT(enc[i]));
//				System.out.println("D: "+ k.d.longValue() + " N: "+ k.n.longValue());
				System.out.println("Encriptado: " + enc[i] + "\tDecriptado: " + tc[i] );
			}	
			END = System.currentTimeMillis();
			System.out.printf("Tempo total DECRIPTAÇÃO: " + "%.3f ms%n", (END - INI) / 1000d);
			// FIM IMPLEMENTAÇAO CRT DEC
			
			
		System.out.println("\nFim da DECRIPTAÇÃO\n");
		return textoClaro;
	}

	@Override
	public String toString() {
		return "Decrypt [k=" + k + ", toString()=" + super.toString() + "]";
	}
	
	
	//GERALDO TAVORA M FILHO 383865
}
