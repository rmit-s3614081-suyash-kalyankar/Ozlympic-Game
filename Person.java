package ass1;


public abstract class Person {
	private String Refreeid;
	private String Refreename;
	private int Refreeage;
	private int Refreestate;
	private String Athleteid;
	private String Athletename;
	private int Athleteage;
	private int Atheletestate;
	
	public Person(String id,String name,int age,int state){
		this.Refreeid=id;
		this.Refreename=name;
		this.Refreeage=age;
		this.Refreestate=state;
	}

	public String getRefreeid(){
		return Refreeid;
	}
	
}
