package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Menu;
import tn.esprit.spring.entities.enumerations.Days;
import tn.esprit.spring.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuRepository MenuRepository;
	@Override
	public List<Menu> retrieveMenu() {
		return (List<Menu>) MenuRepository.findAll();

	}

	@Override
	public Menu addMenu(Menu u) {
		return MenuRepository.save(u);
	}

	@Override
	public void deleteMenu(Long id) {
		MenuRepository.deleteById(id);		
	}

	@Override
	public Menu updateMenu(Menu u) {
		return MenuRepository.save(u);

	}

	@Override
	public Menu retrieveMenu(Long id) {
		return MenuRepository.findById(id).get();
		
	}

	@Override
	public float CountEnergeticsPerDay(String d) {
		return MenuRepository.CountEnergeticsPerDay(d);
	}

	@Override
	public Long addOrUpdateMenu(Menu m) {
		 MenuRepository.save(m);
		 return m.getIdMenu();
		

	}

	@Override
	public List<Menu> FindMenuByNameKinderGarten(String Name) {
		return MenuRepository.FindMenuByNameKinderGarten(Name);
	}

	@Override
	public List<Menu> MenuPerDay(String d) {
		return MenuRepository.MenuPerDay(d);
	}

}
