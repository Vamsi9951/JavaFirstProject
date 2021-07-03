package Entity;

import java.util.List;

public class Gym {

	private int gym_id;
	private String gym_name,gym_place;
	List<Member> members;
	public Gym() {
		
	}
	
	public Gym(int gym_id, String gym_name, String gym_place) {
		super();
		this.gym_id = gym_id;
		this.gym_name = gym_name;
		this.gym_place = gym_place;
	}

	public Gym(int gym_id, String gym_name, String gym_place, List<Member> members) {
		super();
		this.gym_id = gym_id;
		this.gym_name = gym_name;
		this.gym_place = gym_place;
		this.members = members;
	}
	public int getGym_id() {
		return gym_id;
	}
	public void setGym_id(int gym_id) {
		this.gym_id = gym_id;
	}
	public String getGym_name() {
		return gym_name;
	}
	public void setGym_name(String gym_name) {
		this.gym_name = gym_name;
	}
	public String getGym_place() {
		return gym_place;
	}
	public void setGym_place(String gym_place) {
		this.gym_place = gym_place;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	
	
}
