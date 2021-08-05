import java.util.Enumeration;

public abstract class Statement {
  
  public abstract String getHeader(Customer aCustomer);
  public abstract String getRentalFigures(Rental aRental);
  public abstract String getFooter(Customer aCustomer);

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = getHeader(aCustomer);
    while (rentals.hasMoreElements()) {
       Rental each = (Rental) rentals.nextElement();
       //show figures for each rental
       result += getRentalFigures(each);
    }
    //add footer lines
    result += getFooter(aCustomer);
    return result;
  }
}

