import java.util.Enumeration;

public class HtmlStatement extends Statement {
   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getHeader(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for each rental
         result += getRentalFigures(each);
      }
      //add footer lines
      result += getFooterCharge(aCustomer);
      result += getFooterPoints(aCustomer);
      return result;
   }

   private String getHeader(Customer aCustomer) {
     return "<H1>Rentals for <EM>" + aCustomer.getName() +
     "</EM></H1><P>\n";
   }

   private String getRentalFigures(Rental aRental) {
     return aRental.getMovie().getTitle()+ ": " +
      String.valueOf(aRental.getCharge()) + "<BR>\n";
   }

   private String getFooterCharge(Customer aCustomer) {
     return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) +
       "</EM><P>\n";
   }

   private String getFooterPoints(Customer aCustomer) {
     return "On this rental you earned <EM>" +
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      "</EM> frequent renter points<P>";
   }
}
