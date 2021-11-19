package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.enumerations.Days;


public interface MenuService {
	List<Menu> retrieveMenu();
	Menu addMenu(Menu u);
	 void deleteMenu(Long id);
	 Menu updateMenu(Menu u);
	 Menu retrieveMenu(Long id);
	 public float CountEnergeticsPerDay(String d);
		public Long addOrUpdateMenu(Menu m) ;

		public List<Menu> FindMenuByNameKinderGarten(String Name);

		public List<Menu> MenuPerDay(String d);

}
