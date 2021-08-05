import java.util.Enumeration;

public class TextStatement extends Statement {
 public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getHeader(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += getRentalFigures(each);
      }
      //add footer lines
      result += getFooterCharge(aCustomer);
      result += getFooterPoints(aCustomer);
      return result;
 }

 private String getHeader(Customer aCustomer) {
   return "Rental Record for " + aCustomer.getName() + "\n";
 }

 private String getRentalFigures(Rental aRental) {
   return "\t" + aRental.getMovie().getTitle()+ "\t" +
    String.valueOf(aRental.getCharge()) + "\n";
 }

 private String getFooterCharge(Customer aCustomer) {
   return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
 }

 private String getFooterPoints(Customer aCustomer) {
   return "You earned " +
   String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
   " frequent renter points";
 }

}
