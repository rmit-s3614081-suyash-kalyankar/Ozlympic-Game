import java.util.Random;

public class Cyclist extends Athlete{
	
	//constructor
		public Cyclist(String ID,
				String name,
				int age,
				String state){
			super(ID,name,age,state);
		}
		
		//randomly generate 500 to 800 seconds for a cyclist
		public int compete(){
			int max=800;
			int min=500;
			Random Rand=new Random();
			int ranNum=Rand.nextInt(max-min)+min;
			return ranNum;
		}
}
