
public class Procedure 
{
	private String procedureName, date, practitionerName;
	private double chargeForProcedure;
	public Procedure()
	{
		
	}
	public Procedure(String procName , String date)
	{
		procedureName = procName;
		this.date = date;
	}
	public Procedure(String givProcedureName, String givDate , String givPractitionerName , double givChargeForProcedure )
	{
		procedureName = givProcedureName;
		date = givDate;
		practitionerName = givPractitionerName;
		chargeForProcedure = givChargeForProcedure;
		
	}

	public String getProcedureName()
	{
		return procedureName;
	}
	public void setProcedureName( String givProcedureName ) 
	{
		procedureName = givProcedureName;
	}

	public String getDate()
	{
		return date;
	}
	public void setDate(String givDate) 
	{
		date = givDate;
	}

	public String getPractitionerName() 
	{
		return practitionerName;
	}
	public void setPractitionerName(String givPractitionerName ) 
	{
		practitionerName = givPractitionerName;
	}

	public double getCharge()
	{
		return chargeForProcedure;
	}
	public void setChargeForProcedure(double givCharge)
	{
		chargeForProcedure = givCharge;
	}

	public boolean isExpensiveProcedure()
	{
		if (chargeForProcedure >= 1000)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void applyDiscount(double percent)
	{
		chargeForProcedure = chargeForProcedure * percent;
	}
	public String getChargeCategory()
	{
		if (chargeForProcedure <= 500)
		{
			return "Low";
		}
		else if (chargeForProcedure > 500 && chargeForProcedure < 1000)
		{
			return "Medium";
		}
		else
		{
			return "High";
		}
	}
	public boolean isPerformedBy(String givPractitionerName ) 
	{
		if (practitionerName.equals(givPractitionerName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	 public String getFormattedCharge()
	 {
		 String formattedCharge = String.format("$%,.2f", chargeForProcedure);
		 
		 return formattedCharge;
	 }
	@Override
	public String toString()
	{
		return getProcedureName() + "    " + getDate() + "   " + getPractitionerName() + "    " + "  " + getCharge()
		+ "   " + getChargeCategory();
	}

}
