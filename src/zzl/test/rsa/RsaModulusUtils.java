package zzl.test.rsa;

import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;

import javax.crypto.Cipher;

public class RsaModulusUtils {

	private static final String modulus = "10103166745709600780215616551837697832816413714471062522342538060943596036859967333870827790358555455232243383580565187280643159050869924436081447583051139";   	  
    private static final String publicExponent = "65537";   
    private static final String privateExponet = "367979294475011322800474185715497882523349856362702385535371444397399388741997039894583483410120364529325888461124714276674612930833020362278754665756193";   
	
    private static RsaModulusUtils rsaModulusUtils;
    private PublicKey publicKey ;
    private PrivateKey privateKey;
    private Cipher cipher;
	
	private RsaModulusUtils() throws Exception{
		publicKey = RsaModulusHelper.getPublicKey(modulus, publicExponent);
		privateKey = RsaModulusHelper.getPrivateKey(modulus, privateExponet);
		cipher = Cipher.getInstance("RSA");
	}

	public static RsaModulusUtils getInstance() {
		if (rsaModulusUtils == null) {
			try {
				rsaModulusUtils = new RsaModulusUtils();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rsaModulusUtils;
		}
		return rsaModulusUtils;
	}
	
	public byte[] encode(String data) throws Exception{
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] en_data = cipher.doFinal(data.getBytes());
		return en_data;
	}
	
	public String decode(byte[] data) throws Exception{
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] de_data = cipher.doFinal(data);
		String str = new String(de_data);
		return str;
	}
}
