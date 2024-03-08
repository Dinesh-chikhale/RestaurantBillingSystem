package Resto_Services;

import Resto_Model.MenuModel;
import Resto_Repository.MenuRepository;

public class MenuService {
	MenuRepository mRepo=new MenuRepository();
	public boolean isAddMenu(MenuModel mmodel)
	{
		return mRepo.isAddMenu(mmodel);
	}
	public boolean ViewFood()
	{
		return mRepo.ViewFood();
	}
	public boolean searchByName(String name)
	{
		return mRepo.searchByName(name);
	}
	public boolean deleteByName(String name)
	{
		return mRepo.deleteByName(name);
	}
	public boolean updateByName(MenuModel model,String name)
	{
		return mRepo.updateByName(model,name);
	}
}
