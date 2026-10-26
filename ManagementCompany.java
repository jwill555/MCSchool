
/**
 * The ManagementCompany class represents a management company that manages a
 * collection of properties.
 * 
 * @author Jayden Williams
 */
public class ManagementCompany {

	private String name;
	private String taxID;
	private Property[] properties = new Property[MAX_PROPERTIES];
	private int propertyCount;
	static final int MAX_PROPERTIES = 100;

	/**
	 * Constructs a ManagementCompany with a specified name, tax ID, array of
	 * properties, and property count.
	 * 
	 * @param name          the name of the management company
	 * @param taxID         the tax ID of the management company
	 * @param properties    the array of properties managed by the company
	 * @param propertyCount the number of properties currently managed
	 */
	public ManagementCompany(String name, String taxID, Property[] properties, int propertyCount) {
		this.name = name;
		this.taxID = taxID;
		this.properties = properties;
		this.propertyCount = propertyCount;

	}

	/**
	 * Constructs a copy of the specified ManagementCompany.
	 * 
	 * @param givenMC the ManagementCompany to copy
	 */
	public ManagementCompany(ManagementCompany givenMC) {
		name = givenMC.getName();
		taxID = givenMC.getTaxId();
		propertyCount = givenMC.getPropertyCount();
		properties = new Property[givenMC.getProperties().length];

		for (int i = 0; i < propertyCount; i++) {
			properties[i] = new Property(givenMC.getProperties()[i]);
		}
	}

	/**
	 * Constructs a ManagementCompany with the specified name and tax ID.
	 * 
	 * @param name  the name of the management company
	 * @param taxID the tax ID of the management company
	 */
	public ManagementCompany(String name, String taxID) {
		this.name = name;
		this.taxID = taxID;
	}

	/**
	 * Gets the name of the management company.
	 * 
	 * @return the name of the management company
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the tax ID of the management company.
	 * 
	 * @return the tax ID of the management company
	 */
	public String getTaxId() {
		return taxID;
	}

	/**
	 * Gets the array of properties managed by the company.
	 * 
	 * @return the array of properties
	 */
	public Property[] getProperties() {
		return properties;
	}

	/**
	 * Gets the number of properties currently managed by the company.
	 * 
	 * @return the number of properties
	 */
	public int getPropertyCount() {
		return propertyCount;
	}

	/**
	 * Adds a property to the management company.
	 * 
	 * @param p the property to add
	 * @return the index where the property was added, or -1 if the property array
	 *         is full
	 */
	public int addProperty(Property p) {
		int predictedPropertyCount = propertyCount + 1;

		if (predictedPropertyCount > properties.length) {
			return -1;
		} else {
			properties[propertyCount] = p;
			return propertyCount++;
		}
	}

	/**
	 * Gets the property at the specified index.
	 * 
	 * @param index the index of the property
	 * @return the property at the specified index
	 */
	public Property getProperty(int index) {
		return properties[index];
	}

	/**
	 * Calculates the total rent of all properties managed by the company.
	 * 
	 * @return the total rent of all properties
	 */
	public double totalRent() {
		double sum = 0;

		for (int i = 0; i < propertyCount; i++) {
			sum += properties[i].getRentAmount();
		}

		return sum;
	}

	/**
	 * Returns a string containing all properties managed by the company and their
	 * index numbers.
	 * 
	 * @return a string representation of the properties
	 */
	@Override
	public String toString() {
		String props = "";

		for (int i = 0; i < propertyCount; i++) {
			props += Integer.toString(i) + ": " + properties[i] + "\n";
		}

		return props;
	}

	/**
	 * Determines whether this ManagementCompany is equal to another object.
	 * Two management companies are equal if they contain the same company
	 * information and properties.
	 * 
	 * @param obj the object to compare with this ManagementCompany
	 * @return true if the management companies are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ManagementCompany mc)
		{
			if (mc.getName().equals(name) && mc.getTaxId().equals(taxID) && mc.getPropertyCount() == propertyCount && mc.getProperties().length == properties.length && mc.getPropertyCount() == propertyCount)
			{
				for (int i = 0; i < propertyCount; i++)
				{
					if (!properties[i].equals(mc.getProperties()[i]))
					{
						return false;
					}

				}
				return true;
			}
		}

		return false;
	}

} 