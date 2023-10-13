public class Movie extends LibraryItem 
{
    private String firstName; 
    private String lastName; 
    private String rating;    // G, PG, PG-13, R, NC-17

    public Movie(String title, int year, String firstName, String lastName, String rating)
    {
        super(title, year);
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
    }

    public String getProducerFirstName()
    {
        return this.firstName;
    }

    public String getProducerLastName()
    {
        return this.lastName;
    }

    public String getRating()
    {
        return this.rating;
    }

    @Override
    public String toString()
    {
        return new String(this.title +", "+ this.year + " " + this.firstName + ", " + this.lastName + ", " + this.rating);
    }

    @Override
    public boolean matches(String keyword)
    {
        if (
            keyword.equals(this.title) ||
            keyword.equals(this.firstName) ||
            keyword.equals(this.lastName) ||
            keyword.equals(this.rating)
         ) {
            return true;
         } else {
            return false;
         }
    }
}
