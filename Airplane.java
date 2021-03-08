package designclasses;
/**
 * @author Tien N., Victoria T., Nik K.
 * using Map to maintain seats
 * key = row number, value = array of Seat objects
 */
import java.util.Map;
import java.util.HashMap;

public class Airplane {
	private boolean foundMatched;
	public Map<Integer, Seat[]> allSeats = new HashMap<Integer, Seat[]>();
	
	/**
	 * default empty seat as "." with assigned seat types
	 * First Class: 5 rows, 4 seats each row, window-aisle-aisle-window
	 * Economy Class: 15 rows, 6 seats each row, window-center-aisle-aisle-center-window
	 */
	public Airplane() {
		// construct default First Class seats
		for (int i = 1; i <= 5; i++) {
			allSeats.put(i, new Seat[] { new Seat(SeatType.WINDOW), new Seat(SeatType.AISLE), new Seat(SeatType.AISLE),
					new Seat(SeatType.WINDOW) });
		}
		// // construct default Economy seats
		for (int i = 6; i <= 20; i++) {
			allSeats.put(i, new Seat[] { new Seat(SeatType.WINDOW), new Seat(SeatType.CENTER), new Seat(SeatType.AISLE),
					new Seat(SeatType.AISLE), new Seat(SeatType.CENTER), new Seat(SeatType.WINDOW) });
		}
	}
	/**
	 * method is called to add new passenger(s)
	 * added seat is changed from "." to "*"
	 * @param numberOfPassenger, travelClass (First or Economy), seat type (aisle/center/window)
	 */
	public void addSeat(int numberOfPassengers, TravelClass travelClass, SeatType type) {
		foundMatched = false;
		// add First Class seat
		if (travelClass == TravelClass.FIRST_CLASS) {
			for (int i = 1; i <= 5; i++) {
				if (foundMatched) {
					break;
				}
				Seat[] seatArray = allSeats.get(i);
				if (numberOfPassengers == 2) {
					if (seatArray[0].isAvailable() && seatArray[1].isAvailable()) {
						seatArray[0].setReserved();
						seatArray[1].setReserved();
						foundMatched = true;
					} else if (seatArray[2].isAvailable() && seatArray[3].isAvailable()) {
						seatArray[2].setReserved();
						seatArray[3].setReserved();
						foundMatched = true;
					}
				} else {
					for (int j=0; j<seatArray.length;j++) {
						if (seatArray[j].isAvailable() && seatArray[j].getSeatType() == type) {
							seatArray[j].setReserved();
							foundMatched = true;
							break;
						}
					}
				}
			}
		}
		//add Economy Class seat
		else if (travelClass == TravelClass.ECONOMY_CLASS) {
			for (int i = 6; i <= 20; i++) {
				if (foundMatched) {
					break;
				}
				Seat[] seatArray = allSeats.get(i);
				if (numberOfPassengers == 3) {
					if (seatArray[0].isAvailable() && seatArray[1].isAvailable() && seatArray[2].isAvailable()) {
						seatArray[0].setReserved();
				          seatArray[1].setReserved();
				          seatArray[2].setReserved();
				          foundMatched = true;
				        }
				        else if (seatArray[3].isAvailable() && seatArray[4].isAvailable() && seatArray[5].isAvailable()){
				          seatArray[3].setReserved();
				          seatArray[4].setReserved();
				          seatArray[5].setReserved();
				          foundMatched = true;
					}
				}
				else if (numberOfPassengers == 2) {
					//AISLE - only add if (aisle and center) OR (aisle and aisle) is available
					if (type == SeatType.AISLE) {
						if (seatArray[1].isAvailable() && seatArray[2].isAvailable()) { //(aisle and center)
							seatArray[1].setReserved();
							seatArray[2].setReserved();
							foundMatched = true;
						} else if (seatArray[2].isAvailable() && seatArray[3].isAvailable()) { //(aisle and aisle)
							seatArray[2].setReserved();
							seatArray[3].setReserved();
							foundMatched = true;
						} else if (seatArray[3].isAvailable() && seatArray[4].isAvailable()) { //(aisle and center)
							seatArray[3].setReserved();
							seatArray[4].setReserved();
							foundMatched = true;
						}
					} 
					//WINDOW - only add if (window and center) is available
					else if (type == SeatType.WINDOW) { 
						if (seatArray[0].isAvailable() && seatArray[1].isAvailable()) {
							seatArray[0].setReserved();
							seatArray[1].setReserved();
							foundMatched = true;
						} else if (seatArray[4].isAvailable() && seatArray[5].isAvailable()) {
							seatArray[4].setReserved();
							seatArray[5].setReserved();
							foundMatched = true;
						}
					} 
					//CENTER - only add if (window and center) or (center and aisle) is available
					else {
						if (seatArray[0].isAvailable() && seatArray[1].isAvailable()){ //(window and center)
				            seatArray[0].setReserved();
				            seatArray[1].setReserved();
				            foundMatched = true;
				          }
				          else if (seatArray[1].isAvailable() && seatArray[2].isAvailable()){ //(center and aisle)
				            seatArray[1].setReserved();
				            seatArray[2].setReserved();
				            foundMatched = true;
				          }
				          else if (seatArray[3].isAvailable() && seatArray[4].isAvailable()){ //(center and aisle)
				            seatArray[3].setReserved();
				            seatArray[4].setReserved();
				            foundMatched = true;
				          }
				          else if (seatArray[4].isAvailable() && seatArray[5].isAvailable()){ //(window and center)
				            seatArray[4].setReserved();
				            seatArray[5].setReserved();
				            foundMatched = true;
				          }
					}
				} else {
					for (int j=0; j<seatArray.length;j++) {
						if (seatArray[j].isAvailable() && seatArray[j].getSeatType() == type) {
							seatArray[j].setReserved();
							foundMatched = true;
							break;
						}
					}
				}
			}
		}
	}
	/**
	 * used to print out warning message if there's no availability
	 * @return true if foundMatched is true
	 * @return false if foundMatched is false
	 */
	public boolean isMatched() {
		return this.foundMatched;
	}
	/**
	 * @override toString in java.lang.Object
	 * @return the whole seating map
	 * ie:
	 	 1:. . . .
		 2:. . . .
		 3:. . . .
		 4:. . . .
		 5:. . . .
		 6:... ...
		 7:... ...
		 8:... ...
		 9:... ...
		10:... ...
	 */
	public String toString() {
		String str = "";
		for (Map.Entry<Integer, Seat[]> entry : allSeats.entrySet()) {
			Seat[] seatArray = entry.getValue();
			String finalSeats = "";
			if (seatArray.length == 4) {
				for (Seat s : seatArray) {
					finalSeats += s.toString() + " ";
				}
				finalSeats = finalSeats.substring(0, finalSeats.length()-1);
			}
			else if (seatArray.length == 6) {
				finalSeats = seatArray[0].toString() + seatArray[1].toString() + seatArray[2].toString() + " "
							+ seatArray[3].toString() + seatArray[4].toString() + seatArray[5].toString();
			}
			str += String.format("%2s", entry.getKey()) + ": " + finalSeats + "\n";
		}
		return str;
	}
}
