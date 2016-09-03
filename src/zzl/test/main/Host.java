package zzl.test.main;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.jar.Attributes.Name;

import javax.crypto.Cipher;

import zzl.test.rsa.RsaHelper;
import zzl.test.rsa.RsaModulusUtils;

public class Host {

	private static final String NAME = "This is zzl!!";
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		String publicKeyString = RsaHelper.getKeyString(publicKey);
		String privateKeyString = RsaHelper.getKeyString(privateKey);
		
		System.out.println("public-string:"+publicKeyString);
		System.out.println("\n");
		System.out.println("private-string:"+privateKeyString);
		
		byte[] byte_data = NAME.getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		
		Key newPublicKey = RsaHelper.getPublicKey(publicKeyString);
		cipher.init(Cipher.ENCRYPT_MODE, newPublicKey);
		byte[] enByte = cipher.doFinal(byte_data);
		
		Key newPrivateKey = RsaHelper.getPrivateKey(privateKeyString);
		cipher.init(Cipher.DECRYPT_MODE, newPrivateKey);
		byte[] deByte = cipher.doFinal(enByte);
		
		String data = new String(deByte);
		System.out.println(data);
		
		System.out.println("*************************************");
		/////////////////////////////////////////////////////////////
		
		String str = "Test other rsa en/de coder!!";
		
		RsaModulusUtils rsaModulusUtils = RsaModulusUtils.getInstance();
		byte[] en_data = rsaModulusUtils.encode(str);
		String de_str = rsaModulusUtils.decode(en_data);
		System.out.println(de_str);
	}

}
