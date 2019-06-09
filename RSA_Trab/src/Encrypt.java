import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Scanner;

public class Encrypt {
	
	KeyGen k;
	long INI;
	long END;
	int OPT;
	
	public long[] encripta(String a, KeyGen k) throws UnsupportedEncodingException {
		long[] encriptado = new long[a.length()];
		BigInteger[] tc = new BigInteger[a.length()];
		byte[] textoClaro = a.getBytes("ISO-8859-1");
//		int opt;
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o algoritmo de aceleração desejado\n"
				+ "#1 - RSA\n"
				+ "#2 - quare and Multiply\n"
				+ "#0 - Sair");
		OPT = scan.nextInt();
		scan.close();
		switch(OPT) {
		case 1:
			INI = System.currentTimeMillis();
			//IMPLEMENTAÇÃO NORMAL CFME APRESENTAÇÃO
			for(int i = 0; i < textoClaro.length; i++) {
				encriptado[i] = (long)Math.pow(textoClaro[i], k.res[1].longValue()) % k.res[0].longValue();
				System.out.println("Decriptado: "+ textoClaro[i] + "\tEncriptado: " + encriptado[i]);
			}
			//FIM DA IMPLEMENTAÇÃO CFME APRESENTACAO
			END = System.currentTimeMillis();
			System.out.printf("Tempo total ENCRIPTAÇAO: " + "\n%.3f ms%n", (END - INI) / 1000d);
			break;
			
		case 2:
			INI = System.currentTimeMillis();
			//USO DO METODO SQUARE AND MULTIPLY
			for(int i = 0; i < textoClaro.length; i++) {
			tc[i] = BigInteger.valueOf(k.quadMult(textoClaro[i], k.res[1].longValue(), k.res[0].longValue()));
			System.out.println("Encriptado: " + textoClaro[i] + "\tDecriptado: " + tc[i] );
			}
			
			for(int i = 0; i < textoClaro.length; i++) {
				encriptado[i] = tc[i].longValue();
			}
			//FIM DO SQUARE MULTIPLY
			END = System.currentTimeMillis();
			System.out.printf("Tempo total ENCRIPTAÇAO: " + "%.3f ms%n", (END - INI) / 1000d);
			
			break;
		case 0:
			System.exit(1);
		}
		
		
//		System.out.println(new String (textoClaro, "ISO-8859-1"));
//		for(byte b  : textoClaro) {
//			long y = (long) Math.pow(b, k.res[1]) % k.res[0];
//			System.out.println("letra: "+ b + " encriptado: " + y);
//		}
		System.out.println("\nFim da ENCRIPTAÇÃO\n");
		return encriptado;
	}

	public int getOPT() {
		return OPT;
	}

	public void setOPT(int oPT) {
		OPT = oPT;
	}
	
	//GERALDO TAVORA M FILHO 383865
	
}
