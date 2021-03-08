package designclasses;
/**
 * @author XiuNhon
 * Seat object includes 
 * 1/ assigned output: "." or "*"
 * 2/ seatType, using enum SeatType {AISLE, CENTER, WINDOW}
 * 3/ "available" variable to check if seat is available
 */
public class Seat
{
	private String seat;
	private SeatType seatType;
	private boolean available;
	/**
	 * default Seat is ".", and available
	 * new Seat object must pass a seatType param.
	 * @param iseatType
	 */
	public Seat(SeatType iseatType)
	{
		this.seat = ".";
		this.seatType = iseatType;
		this.available = true;
	}
	/**
	 * getter for seatType
	 * @return seatType
	 */
	public SeatType getSeatType()
	{
		return this.seatType;
	}
	/**
	 * used when seat is assigned, change seat from available to reserved
	 */
	public void setReserved()
	{
		this.seat = "*";
		this.available = false;
	}
	/**
	 * 
	 * @return true if available is true
	 * @return false if available is false
	 */
	public Boolean isAvailable() {
		return this.available;
	}
	/**
	 * Seat object's output in String
	 * "." or "*"
	 * @return seat's symbol
	 */
	public String toString()
	{
		return this.seat;
	}
}
