package ass1;

public class SuperAthletes implements Athletes {

	public int compete(){
		
		int swimTime = 0;
		swimTime = 100 + (int)(Math.random() * 100); 
		return swimTime;
		
	}

}
