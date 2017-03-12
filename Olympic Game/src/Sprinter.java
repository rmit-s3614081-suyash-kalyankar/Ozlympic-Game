import java.util.Random;

public class Sprinter extends Athlete{
	
	//constructor
			public Sprinter(String ID,
					String name,
					int age,
					String state){
				super(ID,name,age,state);
			}
			
			//randomly generate 10 to 20 seconds for a sprinter
			public int compete(){
				int max=20;
				int min=10;
				Random Rand=new Random();
				int ranNum=Rand.nextInt(max-min)+min;
				return ranNum;
			}
}
