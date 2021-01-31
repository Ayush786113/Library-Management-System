public class ID {
	
	String id;
	
	void idgenerator()
	{
		double rndm = Math.random();
		String rndmStr = Double.toString(rndm).substring(2, 7);
		id = rndmStr;
	}
	
	public String bookid()
	{
		idgenerator();
		return id;
	}
	public String memberid()
	{
		idgenerator();
		return id;
	}
}