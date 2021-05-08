package eTicaretSistemiOdev5.business.abstracts;



public interface MemberService {
	
	//Kullanıcının login , şifre değiştirme mail adresi değiştirme gibi metodlarını bu interface'in altında grupladım.
	//Parametre olarak Entity tipinde Member class'ını almadığını özellikle belirtmek isterim çünkü bu işlemlerde ki parametreleri kullanıcı sisteme 
	//girerken , şifresini veya mail adresini değiştirirken kendisi input olarak girecek. Girdiği inputlara göre biz kullanıcıyı yönlendireceğiz.
	
	void login(String password,String mailAddress);
	void changePassword(String password);
	void changeMailAddress(String mailAddress);
	
	
}
