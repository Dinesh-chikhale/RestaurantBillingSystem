package Resto_Services;

import Resto_Model.TableModel;
import Resto_Repository.TableRepository;

public class TableService {
	
	TableRepository tRepo=new TableRepository();
	public boolean isAddTable(TableModel tmodel)
	{
		return tRepo.isAddTable(tmodel);
	}

	public boolean viewTable()
	{
		return tRepo.viewTable();
	}
}
