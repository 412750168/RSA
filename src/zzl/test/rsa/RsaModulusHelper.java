package zzl.test.rsa;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RsaModulusHelper {

	public static PublicKey getPublicKey(String modulus, String publicExponent) throws Exception {

		BigInteger bigInteger_modulus = new BigInteger(modulus);
		BigInteger bigInteger_exponent = new BigInteger(publicExponent);

		RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(bigInteger_modulus, bigInteger_exponent);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(rsaPublicKeySpec);

		return publicKey;
	}

	public static PrivateKey getPrivateKey(String modulus, String publicExponent) throws Exception {

		BigInteger bigInteger_modulus = new BigInteger(modulus);
		BigInteger bigInteger_exponent = new BigInteger(publicExponent);
		
		RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(bigInteger_modulus, bigInteger_exponent);
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(rsaPrivateKeySpec);
		return privateKey;
	}
}
