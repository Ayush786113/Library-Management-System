
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LateFees {
	String lenddate, returndate;
	DateTimeFormatter dateFormatter;

	public LateFees() {
		dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}

	public String getLenddate() {
		return lenddate;
	}

	public void setLenddate(String lenddate) {
		this.lenddate = lenddate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	public int calculatedays()
	{
		System.out.println(getLenddate());
		System.out.println(getReturndate());
		System.out.println(dateFormatter);
		LocalDate lend = LocalDate.parse(lenddate, dateFormatter);
		LocalDate back = LocalDate.parse(returndate, dateFormatter);
		long days = Duration.between(lend, back).toDays();
		return Integer.parseInt(Long.toString(days));
	}
}
