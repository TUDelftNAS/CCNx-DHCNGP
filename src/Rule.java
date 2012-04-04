//Dynamic Host Configuration and Name Generation Protocol (DHCNGP)
//
//Copyright (C) 2012, Delft University of Technology, Faculty of Electrical Engineering, Mathematics and Computer Science, Network Architectures and Services, Niels van Adrichem
//
//    This file is part of DHCNGP.
//
//    DHCNGP is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License version 3 as published by
//    the Free Software Foundation.
//
//    DHCNGP is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with DHCNGP.  If not, see <http://www.gnu.org/licenses/>.


import java.io.Serializable;

import org.ccnx.ccn.protocol.ContentName;

public class Rule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7146323208805401527L;
	public ContentName entrypoint;
	public int cost = 0;
	public boolean aggregate = false;
	public ContentName aggregatedName;
	public String[] pathVector;
	public String source;
	public boolean active = false;
	
	public Rule(ContentName tEntrypoint) {
		// TODO Auto-generated constructor stub
		entrypoint = tEntrypoint;
		pathVector = new String[0];
		
	}
	
	public Rule(Rule tRule, String tHostID, String tHostName, String tSource)
	{
		entrypoint = tRule.entrypoint;
		cost = tRule.cost + 10;
		aggregate = tRule.aggregate;
		source = tSource;
		if(aggregate)
			aggregatedName = ContentName.fromNative(tRule.aggregatedName, tHostName);
		
		pathVector = new String[tRule.pathVector.length + 1];
		int i;
		for(i = 0; i < tRule.pathVector.length; i++)
		{
			pathVector[i] = tRule.pathVector[i];
		}
		pathVector[i] = tHostID;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String tmp = "Entrypoint: "+entrypoint+"\tCost: "+cost + "\tpathVector: ";
		for(String tmp2 : pathVector)
			tmp += "/"+tmp2;
		tmp += "\taggregate: "+aggregate+"\tName: "+aggregatedName;
		return tmp;
	}

}
