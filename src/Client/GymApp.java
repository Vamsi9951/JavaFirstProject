package Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.Gym;
import Entity.Member;
import Exception.GymNotFoundException;
import Exception.MemberNotFoundException;
import Service.Service;
import ServiceImpl.ServiceImpl;

public class GymApp {
	static Scanner scanner=new Scanner(System.in);
	static Service service=new ServiceImpl();
	public static void main(String[] args) throws SQLException{
		
		boolean exit=true;
		do {
		menu();
		System.out.println("enetr your option..");
		int option=getOption();
		switch (option) {
		case 1:
			Gym gym=addGymDetails();
			boolean isInserted=service.addDetailsIntoDb(gym);
			if(isInserted)
			{
				System.out.println("Inserted successfully..");
			}
			break;
		case 2:
			System.out.println("Enetr gym name..");
			String gymName=scanner.next();
			List<Member> memberList=new ArrayList<Member>();
			try {
			memberList=service.getFemaleByGymName(gymName);
			}catch(MemberNotFoundException e)
			{
				e.printStackTrace();
			}
			displayMembersByGym(memberList);
			
			break;
		case 3:
			List<Gym> memberList1=new ArrayList<Gym>();
			try {
				memberList1 = service.sortGymByName();
			} catch (GymNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayGymMembers(memberList1);
			
			break;
		
		case 4:
			exit=false;
			break;

		default:
			System.out.println("Invalid option..");
			break;
		}
		}while(exit);

	}

	private static void displayGymMembers(List<Gym> memberList1) {
		for(Gym mem:memberList1)
		{
			System.out.println(mem.getGym_id()+" "+mem.getGym_name()+" "+mem.getGym_place());
		}
		
	}

	private static void displayMembersByGym(List<Member> memberList) {
		for(Member mem:memberList)
		{
			System.out.println(mem.getMid()+" "+mem.getAge()+" "+mem.getMname()+" "+mem.getHeight()+" "+mem.getWeight()+" "+mem.getGender());
		}
		
	}


	private static Gym addGymDetails() {
		List<Member> members=new ArrayList<Member>();
		System.out.println("Enter gym details..");
		System.out.println("Enter gym id..");
		int gymID=scanner.nextInt();
		System.out.println("entr gym name..");
		String gymName=scanner.next();
		System.out.println("Enter gym location..");
		String gymPlace=scanner.next();
		System.out.println("Enter how many memers to add into gym..");
		int noOfMembers=scanner.nextInt();
		for (int i = 0; i <noOfMembers; i++) {
			System.out.println("----- Add New Member -----");
			System.out.println();
			
			System.out.println("Enter The New Members Id : ");
			int membersId = scanner.nextInt();
			
			System.out.println("Enter The New Member Name : ");
			scanner.nextLine();
			String membersName = scanner.nextLine();
			
			System.out.println("Enter The Member Age : ");
			int memberAge = scanner.nextInt();
			
			System.out.println("Enter the Member weight : ");
			int weight = scanner.nextInt();
			
			System.out.println("Enter the Member height : ");
			int height = scanner.nextInt();
			
			System.out.println("Enter The New Member gender : ");
			scanner.nextLine();
			String gender = scanner.nextLine();
			
		    Member member=new Member(membersId, membersName, memberAge, weight, height, gender);
		    members.add(member);
		
		}
		Gym gym=new Gym(gymID, gymName, gymPlace, members);
		return gym;
	}

	private static int getOption() {
		int option=scanner.nextInt();
		return option;
	}

	private static void menu() {
		System.out.println("1.add members to gym");
		   System.out.println("2.search a gym and show all female members associated with that gym age >50 in sorted order by name");
		   System.out.println("3.sorted all gym as per location if location same then sort by name");
		   System.out.println("4.exit");
		
	}

}
