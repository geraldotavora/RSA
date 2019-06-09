import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
				
		KeyGen k = new KeyGen();
		Encrypt e = new Encrypt();
		Decrypt dec = new Decrypt();
		
		BigInteger[] kpub = k.geraChave();
		String a = "geraldo tavora";
		System.out.println("Texto digitado: " + a + "\n");
		long[] encrypt = e.encripta(a, k);
		dec.decripta(encrypt, k);
		
//		long qm = k.quadMult(encrypt[0], k.e, k.n);
//		System.out.println(qm);
	}
	
	//GERALDO TAVORA M FILHO 383865
}
