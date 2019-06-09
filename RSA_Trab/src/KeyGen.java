import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class KeyGen {
	BigInteger e = BigInteger.valueOf(3);
	BigInteger[] res = new BigInteger[2];
	public BigInteger d;
	public BigInteger n;
	public BigInteger a = gerarAleatorio();
	public BigInteger b = gerarAleatorio();
	public BigInteger on;
	
	
	boolean primo(long num) {
		int i, resultado = 0;
		
	    for (int j = 2; j < num; j++) {
	        if (num % j == 0)
	            return false;   
	    }
	    return true;
//		for (i = 2; i <= num / 2; i++) {
//		    if (num % i == 0) {
//		       resultado++;
//		       break;
//		    }
//		 }
//		 
//		if (resultado != 0) {
//		   return true;
//		}else {
//		   return false;
//		}
		
	}
	
	BigInteger gerarAleatorio() {
		BigInteger bi;
		Random rand = new Random();
		int bitLength = 11;
		
		bi = (BigInteger.probablePrime(bitLength, rand).abs());
		
//		long r = min + (long)(Math.random() * ((max - min) + 1));
//			while(!primo(r)) {
//				r = gerarAleatorio();
//			}
		return bi;
	}
	
	public BigInteger inversoD () throws ArithmeticException{
		BigInteger aux = e.modInverse(on);
		return aux;
	}
	
	public BigInteger[] geraChave() {
		BigInteger p = a;
		BigInteger q = b;
		BigInteger sub = BigInteger.ONE;
		n = p.multiply(q);
		System.out.println("N: "+ n + "\tP: "+ p + "\t\tQ: "+ q + "\t\tE: "+ e);
		on = p.subtract(sub).multiply(q.subtract(sub));
		System.out.println("Função O(n): \t" + on);
		d = inversoD();
		System.out.println("Valor de Kprv (chave privada): " + d);
		res[0] = n;
		res[1] = e;
		System.out.println("Valor de Kpub (chave publica): " + "[" + res[0] + ", " + res[1] + "]\n");
		return res;
	}
	
	public long quadMult( long base,  long exp,  long modn){
		long res;
		BigInteger r, s;
		int[] bin = new int[32];
		int i;
		r = BigInteger.valueOf(base);
		s = BigInteger.valueOf(base);
		i = 0;
		
//		int aux = Integer.parseInt(Long.toString(exp));
//		String a = Integer.toBinaryString(aux);
//		char[] bins = a.toCharArray();
		
		while( exp > 0 ){
			if (exp % 2 == 0){
				bin[i] = 0;
			}else{
				bin[i] = 1;
			}
			exp = exp/2;
			i++;

		}
//		System.out.println("expoente binario:\n");
//		
//		for(int a : bin) {
//			System.out.print(a);
//			
//		}
//		System.out.println();
		i--; //t-1
		while(i>0){
			BigInteger m = BigInteger.valueOf(modn);
			r = r.multiply(r).mod(m);
			if( bin[--i] == 1 ){
				r = r.multiply(s).mod(m);
			}
		}
		
		return r.longValue();
	}
	
	public long CRT(long y) {
		BigInteger yp, yq, dp, dq, xp, xq, cp, cq, x;
		BigInteger sub = BigInteger.ONE;
		yp = BigInteger.valueOf(y).mod(a);
		yq = BigInteger.valueOf(y).mod(b);
		dp = d.mod(a.subtract(sub));
		dq = d.mod(b.subtract(sub));
		xp = yp.modPow(dp, a);
		xq = yq.modPow(dq, b);
		cp = b.modInverse(a);
		cq = a.modInverse(b);
		
		x = b.multiply(cp).multiply(xp).add(a.multiply(cq).multiply(xq)).mod(n);
		
		
		return x.longValue();
	}
	

	@Override
	public String toString() {
		return "KeyGen [e=" + e + ", geraChave()=" + Arrays.toString(geraChave()) + "]";
	}
	
	
	//GERALDO TAVORA M FILHO 383865
}
