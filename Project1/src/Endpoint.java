/**
* Represent's an endpoint and its value
* 
* @author Smruthi Sandhanam, Meghna Vaidya, and Kamini Saldanha
* 
*/

public class Endpoint {
	/**
	 * Value of endpoint
	 */
	private int value;
	/**
	 * P value of endpoint
	 */
	private int p;
	
	/**
	 * Endpoint constructor, sets values for p and value
	 * @param value
	 * @param p
	 */
	public Endpoint(int value, int p)
	{
		this.value = value;
		this.p = p;
	}
	
	/**
	 * Returns endpoint value
	 * @return
	 */
	public int getValue()
	{
		return this.value;
	}
	
	/**
	 * Return p value
	 * @return
	 */
	public int getP()
	{
		return this.p;
	}

}
