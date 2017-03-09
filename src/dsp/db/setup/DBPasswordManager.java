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
 * The main point of this is so that the plain-text password isn't
 * kept in the Java class files or any other text file.
 * 
 * TODO Write a password manager gui/program, and comment this class.
 * 
 * TODO Eliminate null returns by throwing exceptions instead of handling
 * 
 * @author Ryan Conrad
 */
public class DBPasswordManager {

	private static final String PASSWORD_LOCATION = "resources/password.txt";
	private static final String KEY_LOC = "resources/key.txt";
	private static final String IV_LOC = "resources/iv.txt";
	private static final String ENC_METHOD = "AES";
	private static final int KEY_LENGTH = 128;
	private static final String MODE = "CBC";
	private static final String PADDING = "PKCS5Padding";
	private static final String TRANSFORMATION =
			ENC_METHOD + "/" +
			MODE + "/" +
			PADDING;
	
	/**
	 * The cipher.
	 */
	private Cipher cipher;
	
	/**
	 * Constructs a new {@link DBPasswordManager}.
	 */
	public DBPasswordManager() {
		
		// Try to create a new cipher
		cipher = null;
		try {
			cipher = Cipher.getInstance(TRANSFORMATION);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		try {
			
			// Create a random initialization vector
			byte[] iv = new byte[16];
			SecureRandom random = new SecureRandom();
			random.nextBytes(iv);
			cipher.init(
					Cipher.DECRYPT_MODE,
					getKey(),
					getIV());

			// Read the encrypted final
			byte[] encrypted = Files.readAllBytes(
					new File(PASSWORD_LOCATION).toPath());
			
			// Decrypt the file
			byte[] decrypted = cipher.doFinal(encrypted);
			
			// Return the decrypted string
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

	/**
	 * 
	 * @param password
	 */
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
	
	/**
	 * 
	 * @return
	 */
	private Key createAndSaveNewKey() {
		try {
			File f = new File(KEY_LOC);
			FileOutputStream fs = new FileOutputStream(
					f, false);
			KeyGenerator keyGenerator =
					KeyGenerator.getInstance(ENC_METHOD);
			keyGenerator.init(KEY_LENGTH);
			SecretKey secretKey = keyGenerator.generateKey();
			fs.write(secretKey.getEncoded());
			fs.close();
			return secretKey;
		} catch (IOException
				| NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	private SecretKeySpec getKey() {
		try {
	        return new SecretKeySpec(Files.readAllBytes(
	        				new File(KEY_LOC).toPath()), ENC_METHOD);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 
	 * @return
	 */
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

	/**
	 * 
	 * @return
	 */
	private IvParameterSpec getIV() {
		try {
			
			// Return an IV parameter spec based on the IV text file
	        return new IvParameterSpec(Files.readAllBytes(
	        		new File(IV_LOC).toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
