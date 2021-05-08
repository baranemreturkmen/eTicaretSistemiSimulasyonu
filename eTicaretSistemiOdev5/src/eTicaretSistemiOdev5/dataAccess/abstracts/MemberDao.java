package eTicaretSistemiOdev5.dataAccess.abstracts;

import eTicaretSistemiOdev5.entities.abstracts.Entity;

public interface MemberDao {
	
	//Veri tabanı işlerini yapan class'ımın ortak metodlarını bu interface sayesinde gruplamış oldum.
	//Ortak metodlarım parametre olarak Entity tipinde bir Member class'ı alıyor.
	
	boolean add(Entity member);
	void update(Entity member);
	void delete(Entity member);

}
