package dsp.db.setup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * The {@link DBPasswordManager} grabs an encrypted password from a
 * file and returns it. There is also an option to encrypt a password
 * in the case that the database's password is ever going to change.
 * 
 * TODO Write a password manager gui/program, and comment this class.
 * 
 * @author Ryan Conrad
 */
public class DBPasswordManager {

	public static final String PASSWORD_LOCATION = "resources/password.txt";
	public static final String ENC_METHOD = "AES";
	public static final int KEY_LENGTH = 128;
	public static final String MODE = "CBC";
	public static final String PADDING = "PKCS5Padding";
	public static final String TRANSFORMATION =
			ENC_METHOD + "/" +
			MODE + "/" +
			PADDING;
	
	private static final String KEY_LOC = "resources/key.txt";
	private static final String IV_LOC = "resources/iv.txt";
	
	private Cipher cipher;
	
	public DBPasswordManager() {
		cipher = null;
		try {
			cipher = Cipher.getInstance(TRANSFORMATION);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPassword() {
		try {
			byte[] iv = new byte[16];
			SecureRandom random = new SecureRandom();
			random.nextBytes(iv);
			cipher.init(
					Cipher.DECRYPT_MODE,
					getKey(),
					getIV());

			byte[] encrypted = Files.readAllBytes(
					new File(PASSWORD_LOCATION).toPath());
			
			byte[] decrypted = cipher.doFinal(encrypted);
			
			return new String(decrypted);
		} catch (InvalidKeyException
				| InvalidAlgorithmParameterException
				| IOException
				| IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void setPassword(String password) {
		try {
			cipher.init(
					Cipher.ENCRYPT_MODE,
					createAndSaveNewKey(),
					createAndSaveNewIV());
			
			byte[] encrypted = cipher.doFinal(
					password.getBytes());
			
			FileOutputStream fs = new FileOutputStream(
					new File(PASSWORD_LOCATION), false);
			fs.write(encrypted);
			fs.close();
			
		} catch (InvalidKeyException
				| InvalidAlgorithmParameterException
				| IllegalBlockSizeException
				| BadPaddingException
				| IOException e) {
			e.printStackTrace();
		}
	}
	
	private Key createAndSaveNewKey() {
		try {
			File f = new File(KEY_LOC);
			FileOutputStream fs = new FileOutputStream(
					f, false);
			KeyGenerator keyGen =
					KeyGenerator.getInstance("AES");
			keyGen.init(KEY_LENGTH);
			SecretKey secretKey = keyGen.generateKey();
			fs.write(secretKey.getEncoded());
			fs.close();
			return secretKey;
		} catch (IOException
				| NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	private SecretKeySpec getKey() {
		try {
	        return new SecretKeySpec(
	        		Files.readAllBytes(
	        				new File(KEY_LOC).toPath()
	        		), ENC_METHOD);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	private IvParameterSpec createAndSaveNewIV() {
		try {
			File f = new File(IV_LOC);
			FileOutputStream fs =
					new FileOutputStream(f, false);
			byte[] iv = new byte[16];
			SecureRandom random = new SecureRandom();
			random.nextBytes(iv);
			fs.write(iv);
			fs.close();
			return new IvParameterSpec(iv);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private IvParameterSpec getIV() {
		try {
	        return new IvParameterSpec(
	        		Files.readAllBytes(
	        				new File(IV_LOC).toPath()
	        		));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
