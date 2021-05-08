package eTicaretSistemiOdev5.entities.abstracts;

public interface Entity {
	
	//Member classlarının ortak metodlarını bu interface sayesinde grupladım.
	
	String getName();
	String getPassword();
	String getMailAddress();
	String getSurname();
	boolean isClicked();

}
