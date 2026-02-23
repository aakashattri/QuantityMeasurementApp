

public class QuantityMeasurmentApp {
	public static class Feet{
		private final double value;
		
		Feet(double value){
			this.value=value;
		}
		public double getValue() {
			return value;
		}
		
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			if(obj==null || getClass()!=obj.getClass()) {
				return false;
			}
			Feet other=(Feet)obj;
			
			return Double.compare(this.value, other.value)==0;
		}
		
	}
	public static class Inches{
		private final double value;
		
		Inches(double value){
			this.value=value;
		}
		public double getValue() {
			return this.value;
		}
		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			if(obj==null||getClass()!=obj.getClass()) {
				return false;
			}
			Inches other=(Inches)obj;
			return Double.compare(this.value, other.value)==0;
		}
	}
	public static void demonstrateFeetEquality() {
		Feet f1=new Feet(1.2);
		Feet f2=new Feet(1.2);
		System.out.println("Equals("+f1.equals(f2)+")");
	}
	public static void demonstrateInchesEquality() {
		Inches f1=new Inches(1.2);
		Inches f2=new Inches(4.5);
		System.out.println("Equals("+f1.equals(f2)+")");
	}
	public static void demonstrateFeetAndInchesEquality() {
		Length l1=new Length(1, Length.LengthUnit.Feet);
		Length l2=new Length(12, Length.LengthUnit.Inches);
		System.out.println("Equals("+l1.compare(l2)+")");
		
	}
	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
		demonstrateFeetAndInchesEquality();
		
	}
}

