package Dao.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.DaoLayer;
import Entity.Gym;
import Entity.Member;
import Exception.GymNotFoundException;
import Exception.MemberNotFoundException;
import Utility.DBUtil;

public class DaoImpl implements DaoLayer {

	

	@Override
	public List<Member> getFemaleByGymName(String gymName) throws MemberNotFoundException{
		List<Member> memberList=new ArrayList<Member>();
		Member member=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="select * from gymdatabase1.gym A left join gymdatabase1.member  B on  A.gym_id=B.mid where A.gym_name=? order by B.age desc;";
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, gymName);
			rs=ps.executeQuery();
			while(rs.next())
			{
				member=new Member(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
				memberList.add(member);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		if(memberList.size()==0)
		{
			throw new MemberNotFoundException(" female is not there..");
		}
		return memberList;
	}

	@Override
	public List<Gym> sortGymByName() throws GymNotFoundException{
		List<Gym> gymlist=new ArrayList<Gym>();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select * form gym order by place,name");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Gym gym=new Gym(rs.getInt(1),rs.getString(2),rs.getString(3));
			gymlist.add(gym);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(gymlist.size()==0)
		{
			throw new GymNotFoundException();
		}
		return gymlist;
		
	}

	public boolean addDetailsIntoDb(Gym gym) {
		
		Connection con=null;
		boolean isInserted=false;
		PreparedStatement preparedstatement=null;
		String insertGyms="insert into gym values(?,?,?)";
		try {
			con=DBUtil.getConnection();
			preparedstatement=con.prepareStatement(insertGyms);
			preparedstatement.setInt(1, gym.getGym_id());
			preparedstatement.setString(2, gym.getGym_name());
			preparedstatement.setString(3, gym.getGym_place());
			preparedstatement.executeUpdate();
			
			String insertMembers="insert into member values(?,?,?,?,?,?,?)";
			preparedstatement=con.prepareStatement(insertMembers);
			List<Member> members=gym.getMembers();
			for(Member mem:members)
			{
				preparedstatement.setInt(1, mem.getMid());
				preparedstatement.setString(2, mem.getMname());
				preparedstatement.setInt(3, mem.getAge());
				preparedstatement.setDouble(4, mem.getWeight());
				preparedstatement.setDouble(5, mem.getHeight());
				preparedstatement.setString(6, mem.getGender());
				preparedstatement.setInt(7, gym.getGym_id());
				preparedstatement.execute();
				isInserted = true;
			}
		}catch(SQLException e)
		{
			System.out.println("not inserted");
		}
		return isInserted;
	}

}
