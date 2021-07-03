package Dao;

import java.util.List;

import Entity.Gym;
import Entity.Member;
import Exception.GymNotFoundException;
import Exception.MemberNotFoundException;

public interface DaoLayer {

	boolean addDetailsIntoDb(Gym gym);
	List<Member> getFemaleByGymName(String gymName) throws MemberNotFoundException;
	List<Gym> sortGymByName() throws GymNotFoundException;
}
