package Entity;

public class Member {

	private int mid;
	private String mname;
	private int age;
	private double weight,height;
	private String gender;
	public Member() {
		
	}
	public Member(int mid, String mname, int age, double weight, double height, String gender) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
