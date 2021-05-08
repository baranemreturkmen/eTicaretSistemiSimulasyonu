package eTicaretSistemiOdev5.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretSistemiOdev5.business.abstracts.ValidationService;

public class ValidationManager implements ValidationService{
	
	//Bu sınıfın altında kullancının üye olurken isim, soyisim, parola ve mailde istenilen şartları sağlayıp sağlamadığını
	//kontrol ettim.
	
	boolean value=true;
	
	//Kullanıcının isminin 2 karakterden küçük olmadığını kontrol eden metod. Kullanıcı üye olurken isim olarak
	//2 karakterden büyük veya eşit bir isim girdiğinde true , tam tersi durumda false döndürecek.
	@Override
	public boolean validateName(String name) {
		
		if(name.length()<2) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	//Kullanıcının soyisminin 2 karakterden küçük olmadığını kontrol eden metod. Kullanıcı üye olurken soyisim olarak
	//2 karakterden büyük veya eşit bir isim girdiğinde true , tam tersi durumda false döndürecek.
	@Override
	public boolean validateSurname(String surname) {
		
		if(surname.length()<2) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	
	//Bu metodun altında regex kullanarak kullanıcın üye olurken girdiği mail formatının doğru olup olmadığını değerlendiriyoruz.
	//Kullanıcının üye olurken girdiği mail formatı doğruysa true , değilse bu metod false dönecek. Bu metod çalışırken 
	//mail için gereken doğru regex formatını bulup emailRegex değişkenine atadık. Daha sonra emailPath.matcher ile kullanıcının
	//üye olurken girdiği email adresinin regex ile uyumlu olup olmadığını kıyasladık. 
	@Override
	public boolean validateMailAddress(String mailAddress) {
		// TODO Auto-generated method stub
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPath = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPath.matcher(mailAddress);
		return matcher.find();
	}
	
	//Kullancı üye olurken parola olarak 6 karakterden küçük bir parola girdiyse false, istenilen şartı
	//sağlayıp 6'dan büyük veya 6'ya eşit bir parola girdiyse true dönecek.
	@Override
	public boolean validatePassword(String password) {
		if(password.length()<6) {
			return false;
		}
		else {
			return value;
		}
		
		
	}
	
	//Kullanıcı doğrulama linkine tıkladıysa true , tıklamadıysa false döndürecek. Bu durum Main'de kurduğumuz 
	//senaryoya göre Member sınıfının isClicked özelliğine false yada true göndermemize göre değişecek.
	@Override
	public boolean validateIsClicked(boolean isClicked) {
		// TODO Auto-generated method stub
		return isClicked;
	}

}
