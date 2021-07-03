package ServiceImpl;

import java.util.List;

import Dao.DaoImpl.DaoImpl;
import Entity.Gym;
import Entity.Member;
import Exception.GymNotFoundException;
import Exception.MemberNotFoundException;
import Service.Service;

public class ServiceImpl implements Service {
	static DaoImpl daoImpl=new DaoImpl();
	@Override
	public boolean addDetailsIntoDb(Gym gym) {
		
		return daoImpl.addDetailsIntoDb(gym);
	}

	@Override
	public List<Member> getFemaleByGymName(String gymName) throws MemberNotFoundException{
		
		return daoImpl.getFemaleByGymName(gymName);
	}

	@Override
	public List<Gym> sortGymByName() throws GymNotFoundException{
		
		return daoImpl.sortGymByName();
	}
	
		
		
	}

