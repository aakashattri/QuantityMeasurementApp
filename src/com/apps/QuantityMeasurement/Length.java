


public class Length {
	private double value;
	private LengthUnit unit;
	
	public enum LengthUnit{
		Feet(12.0),
		Inches(1.0);
		
		private double conversionFactor;
		
		LengthUnit(double conversionFactor){
			this.conversionFactor=conversionFactor;
		}
		public double getConversionFactor() {
			return this.conversionFactor;
		}
		
	}

	Length(double value,LengthUnit unit){
		this.value=value;
		this.unit=unit;
	}
	public double convertToBaseUnit() {
		return this.value*this.unit.conversionFactor;
	}
	public boolean compare(Length thatLength) {
		return this.convertToBaseUnit()==thatLength.convertToBaseUnit();
				
	}
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(o==null || getClass()!=o.getClass()) {
			return false;
		}
		Length other=(Length)o;
		return compare(other);
	}
}