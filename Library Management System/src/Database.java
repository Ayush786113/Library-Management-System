import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

class Database {
	static Connection connection;
	public static Connection connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:library.db");
		return connection;
	}
	public void create(String forwhat) throws SQLException, ClassNotFoundException
	{
		connect();
		if(forwhat.equals("Books"))
		{
			String url = "CREATE TABLE IF NOT EXISTS\"Books\" (\r\n"
					+ "	\"Name\"	TEXT,\r\n"
					+ "	\"Author\"	TEXT,\r\n"
					+ "	\"ISBN\"	TEXT,\r\n"
					+ "	\"Category\"	TEXT\r\n"
					+ ", \"ID\"	TEXT, \"Availability\"	TEXT)";
			PreparedStatement pst = connection.prepareStatement(url);
			pst.execute();
		}
		else if(forwhat.equals("Members"))
		{
			String url = "CREATE TABLE IF NOT EXISTS\"Members\" (\r\n"
					+ "	\"Name\"	TEXT,\r\n"
					+ "	\"Age\"	TEXT,\r\n"
					+ "	\"School\"	TEXT,\r\n"
					+ "	\"Phone\"	TEXT,\r\n"
					+ "	\"ID\"	TEXT\r\n"
					+ ")";
			PreparedStatement pst = connection.prepareStatement(url);
			pst.execute();
		}
		else if(forwhat.equals("lending"))
		{
			String url = "CREATE TABLE IF NOT EXISTS \"LendTable\" (\r\n"
					+ "	\"Book\"	TEXT,\r\n"
					+ "	\"Member\"	TEXT,\r\n"
					+ "	\"Borrow Date\"	TEXT,\r\n"
					+ "	\"Return Date\"	TEXT\r\n"
					+ ")";
			PreparedStatement pst = connection.prepareStatement(url);
			pst.execute();
		}
	}
	public String insertBooks(String title, String author, String isbn, String category) throws SQLException, ClassNotFoundException
	{
		create("Books");
		String id = new ID().bookid();
		String sql = "INSERT INTO Books VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, title);
		pst.setString(2, author);
		pst.setString(3, isbn);
		pst.setString(4, category);
		pst.setString(5, id);
		pst.setString(6, "Available");
		pst.executeUpdate();
		return "Book Successfully Added to Database!";
	}
	public String addMember(String name, String age, String school, String phone) throws SQLException, ClassNotFoundException
	{
		create("Members");
		String id = new ID().memberid();
		String url = "INSERT INTO Members VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pst = connection.prepareStatement(url);
		pst.setString(1, name);
		pst.setString(2, age);
		pst.setString(3, school);
		pst.setString(4, phone);
		pst.setString(5, id);
		pst.executeUpdate();
		String message = "Member Added Successfully \n Unique ID - "+id;
		return message;
	}
	public static void readData(JTable table, String detailsubject) throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "SELECT * FROM "+detailsubject;
		PreparedStatement pst = connection.prepareStatement(url);
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	public LinkedList<String> booklist() throws ClassNotFoundException, SQLException
	{
		connect();
		LinkedList<String> books = new LinkedList<>();
		books.add("Select Book");
		String url = "SELECT * FROM Books";
		PreparedStatement pst = connection.prepareStatement(url);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			books.add(rs.getString("Name"));
		}
		return books;
	}
	public LinkedList<String> memberlist() throws SQLException, ClassNotFoundException
	{
		connect();
		LinkedList<String> members = new LinkedList<>();
		members.add("Select Member");
		String url = "SELECT * FROM Members";
		PreparedStatement pst = connection.prepareStatement(url);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			members.add(rs.getString("Name")+" - "+rs.getString("ID"));
		}
		return members;
	}
	public LinkedList<String> updateMemberlist() throws SQLException, ClassNotFoundException
	{
		connect();
		LinkedList<String> members = new LinkedList<>();
		members.add("Select Member");
		String url = "SELECT * FROM Members";
		PreparedStatement pst = connection.prepareStatement(url);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			members.add(rs.getString("Name"));
		}
		return members;
	}
	public void lendbook(String bookname) throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "UPDATE Books set Availability = ? WHERE Name = ?";
		PreparedStatement pst = connection.prepareStatement(url);
		pst.setString(1, "Unavailable");
		pst.setString(2, bookname);
		pst.executeUpdate();
	}
	public void returnbook(String bookname) throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "UPDATE Books set Availability = ? WHERE Name = ?";
		PreparedStatement pst = connection.prepareStatement(url);
		pst.setString(1, "Available");
		pst.setString(2, bookname);
		pst.executeUpdate();
	}
	public void updateMember(String name, String feild, String data) throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "";
		switch(feild)
		{
		case "Age":
		{
			url = "UPDATE Members set Age = ? WHERE Name = ?";
			break;
		}
		case "School":
		{
			url = "UPDATE Members set School = ? WHERE Name = ?";
			break;
		}
		case "Phone":
		{
			url = "UPDATE Members set Phone = ? WHERE Name = ?";
			break;
		}
		}
		PreparedStatement pst = connection.prepareStatement(url);
		pst.setString(1, data);
		pst.setString(2, name);
		pst.executeUpdate();
	}
	public void lenddatabase(String bookname, String borrower, String lenddate, String returndate) throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "INSERT INTO LendTable VALUES(?, ?, ?, ?)";
		PreparedStatement pst = connection.prepareStatement(url);
		pst.setString(1, bookname);
		pst.setString(2, borrower);
		pst.setString(3, lenddate);
		pst.setString(4, returndate);
		pst.execute();
	}
	public void getlenddate() throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "SELECT * FROM LendTable";
		PreparedStatement pst = connection.prepareStatement(url);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			new LateFees().setLenddate(rs.getString("Borrow Date"));
		}
	}
	public void deleteData(String book, String member) throws ClassNotFoundException, SQLException
	{
		connect();
		String url = "DELETE FROM LendTable WHERE Book = ? AND Member = ?";
		PreparedStatement pst = connection.prepareStatement(url);
		pst.setString(1, book);
		pst.setString(2, member);
		pst.execute();
	}
}
