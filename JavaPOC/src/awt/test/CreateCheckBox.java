package awt.test;

import java.applet.Applet;
import java.awt.Checkbox;
 
 
/*
<applet code="CreateCheckBox" width=200 height=200>
</applet>
*/
 
public class CreateCheckBox extends Applet{
	
	Checkbox checkBox1;
	Checkbox checkBox2;
 
	public void init(){
 
		/*
		 * To create a checkbox use
		 * Checkbox() constructor.
		 */
 
		checkBox1 = new Checkbox("Akhash", true);
 
		/*
		 * Set Checkbox caption or label using
		 * void setLabel(String text)
		 * method of AWT Checkbox class.
		 */
 
		checkBox1.setLabel("My Checkbox 1");
 
		/*
		 * To create checkbox with the caption use
		 * CheckBox(String text) constructor of
		 * AWT Checkbox class.
		 */
 
		checkBox2 = new Checkbox("Suresh", true);
 
		//add checkboxes using add method
		add(checkBox1);
		add(checkBox2);
	}	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("My Checkbox 1 state === " + checkBox1.getState() );
		System.out.println("My Checkbox 2 state === " + checkBox2.getState() );
	}
}
