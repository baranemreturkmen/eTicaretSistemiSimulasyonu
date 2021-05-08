package eTicaretSistemiOdev5.business.abstracts;

public interface ValidationService {
	
	//Validate doğrulama işini yapan sınıfların ortak metodlarını içeren interface.
	//Parametre olarak Member class'ı verilmediğine özellikle dikkat edilsin. Çünkü kullanıcının 
	//üye olma işlemlerini yaparken girdiği parametrelerin şartları sağlayıp sağlamadığını kontrol 
	//edeceğiz.
	
	boolean validateName(String name);
	boolean validateSurname(String surname);
	boolean validateMailAddress(String mailAddress);
	boolean validatePassword(String password);
	boolean validateIsClicked(boolean isClicked);

}
