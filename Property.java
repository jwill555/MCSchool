
/**
 * The Property class represents a property with a property name, city, rent
 * amount, and owner.
 * 
 * @author Jayden Williams
 */
public class Property {

	private String propertyName, city, owner;
	private double rentAmount;

	/**
	 * Constructs a Property with default values.
	 */
	public Property() {

	}

	/**
	 * Constructs a Property with a specified property name, city, rent amount, and
	 * owner.
	 * 
	 * @param propName   the name of the property
	 * @param city       the city where the property is located
	 * @param rentAmount the rent amount of the property
	 * @param owner      the owner of the property
	 */
	public Property(String propName, String city, double rentAmount, String owner) {
		propertyName = propName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	/**
	 * Constructs a copy of the specified Property.
	 * 
	 * @param prop the Property to copy
	 */
	public Property(Property prop) {
		propertyName = prop.getPropertyName();
		rentAmount = prop.getRentAmount();
		city = prop.getCity();
		owner = prop.getOwner();
	}

	/**
	 * Gets the name of the property.
	 * 
	 * @return the name of the property
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Gets the city where the property is located.
	 * 
	 * @return the city of the property
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the rent amount of the property.
	 * 
	 * @return the rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Gets the owner of the property.
	 * 
	 * @return the owner of the property
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the name of the property.
	 * 
	 * @param propertyName the new name of the property
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;

	}

	/**
	 * Sets the city where the property is located.
	 * 
	 * @param city the new city of the property
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Sets the rent amount of the property.
	 * 
	 * @param rentAmount the new rent amount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Sets the owner of the property.
	 * 
	 * @param owner the new owner of the property
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns a string containing the property name, city, rent amount, and owner.
	 * 
	 * @return a string representation of the property
	 */
	@Override
	public String toString() {
		return propertyName + ", " + city + ", Rent: $" + String.format("%.2f", rentAmount) + ", Owner: " + owner;
	}

	/**
	 * Determines whether this Property is equal to another object.
	 * Two properties are equal if they have the same city, owner,
	 * property name, and rent amount.
	 * 
	 * @param obj the object to compare with this Property
	 * @return true if the properties are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Property p)
		{
			if (p.getCity().equals(city) && p.getOwner().equals(owner) 
					&& p.getPropertyName().equals(propertyName) 
					&& p.getRentAmount() == rentAmount)
			{
				return true;
			}
		}

		return false;
	}
}