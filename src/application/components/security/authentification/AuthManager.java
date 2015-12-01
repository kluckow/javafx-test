package application.components.security.authentification;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * The Class AuthManager.
 */
public class AuthManager {

	/** The sha. */
	private String sha;
	
	/** The salt. */
	private String salt;
	
	/** The hash info. */
	private String hashInfo;
	
	/** The existing user. */
	String existingUser;
	
	/** The Constant SALT_LENGTH. */
	private static final int SALT_LENGTH = 32;
	
	/**
	 * Creates the user.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void createUser(String username, String password) {
		
		existingUser = username;
		
		salt = generateSalt();
		byte[] sha256 = DigestUtils.sha256(password + salt);
		sha = Base64.encodeBase64String(sha256);
		hashInfo = salt + ":" + sha;
		System.out.println(hashInfo);
		login(username, password);
	}
	
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean login(String username, String password) {
		
		if (userExists(username)) {
			System.out.println("Validating credentials.");
			return validatePassword(username, password);
		} else {
			System.out.println("User not existing.");
			return false;
		}
		
//		String salt = generateSalt();
//		System.out.println(username + ": " + password);
//		byte[] sha1 = DigestUtils.sha256(password);
//
//		String encodedSalt = generateSalt();
//		System.out.println("Encoded-Salt: " + encodedSalt.toString());
//		decodeSalt(encodedSalt);
//		String decodedSalt = decodeSalt(encodedSalt);
//		System.out.println(decodedSalt);
	}

//	private String byteArrayToHexString(byte[] sha1) {
//		String result = "";
//		for (int i = 0; i < sha1.length; i++) {
//			result += Integer.toString((sha1[i] & 0xff) + 0x100, 16).substring(1);
//		}
//		return result.toString();
//	}

	/**
 * Validate password.
 *
 * @param username the username
 * @param password the password
 * @return true, if successful
 */
private boolean validatePassword(String username, String password) {
		
		String hashInfo = getHashInfo(username);
		String[] hashInfoSplitted = hashInfo.split(":");
		String salt = hashInfoSplitted[0];
		String hash = hashInfoSplitted[1];
		
		System.out.println("salt: "+hashInfoSplitted[0]);
		System.out.println("hash: "+hashInfoSplitted[1]);
		
		byte[] sha256 = DigestUtils.sha256(password + salt);
		String sha = Base64.encodeBase64String(sha256);
		
		if (hash.equals(sha)) {
			System.out.println("Password correct!");
		} else {
			System.out.println("hash: "+hash);
			System.out.println("sha: " + sha);
		}
		
		return false;
	}

	/**
	 * Gets the hash info.
	 *
	 * @param username the username
	 * @return the hash info
	 */
	private String getHashInfo(String username) {
		
		// TODO: SELECT hash_info FROM user WHERE username = username;
		
		return hashInfo;
	}

	/**
	 * User exists.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	private boolean userExists(String username) {
		
		// TODO: SELECT * FROM user WHERE username = username;
		
		return true;
	}

	/**
	 * Generate salt.
	 *
	 * @return the string
	 */
	private String generateSalt() {
		
		final Random r = new SecureRandom();
		byte[] salt = new byte[SALT_LENGTH];
		r.nextBytes(salt);
		
		return Base64.encodeBase64String(salt);
	}

//	private String decodeSalt(String base64Salt) {
//		byte[] decodedSaltByte = Base64.decodeBase64(base64Salt);
//		System.out.println("Decode-Salt-Byte: " + decodedSaltByte.toString());
//		System.out.println("Encoded-Salt-String: " + Base64.encodeBase64(decodedSaltByte));
//		String decodedSaltString = decodedSaltByte.toString();
//		System.out.println("Decoded-Salt-String: " + decodedSaltString);
//		String encodedSaltString = Base64.encodeBase64String(decodedSaltByte.clone());
//		System.out.println("Base64-Encoded-Salt: " + encodedSaltString);
//		byte[] decodedSaltByte2 = Base64.decodeBase64(base64Salt);
//		String decodedSaltString2 = decodedSaltByte2.toString();
//		System.out.println("Decoded-Salt-String: " + decodedSaltString2.toString());
		
//		return decodedSaltString;
//	}
}
