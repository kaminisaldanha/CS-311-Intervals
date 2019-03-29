/**
* Represent's an endpoint and its value
* 
* @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
* 
*/

//Returns the endpoint value. For example if the Endpoint object represents the left 
	//endpoint of the interval [1, 3], this would return -1
public class Endpoint {
	private int value;
	private int p;
	
	public Endpoint(int value, int p)
	{
		this.value = value;
		this.p = p;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public int getP()
	{
		return this.p;
	}

}
