/**
 * 
 */
package com.thesaka.eg.serialization;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 10, 2012
 */
public class PersistentTime implements Serializable
{
	private Date time;

	public PersistentTime()
	{
		time = Calendar.getInstance().getTime();
	}

	public Date getTime()
	{
		return time;
	}
}

