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


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.ListIterator;

import org.ccnx.ccn.protocol.ContentName;



public class RuleManager {
	
	private List<Rule> proposedRules;
	
	
	public RuleManager()
	{
		proposedRules = new ArrayList<Rule>();			
	}
	
	public synchronized void considerRules(String clientId, Rule tRule[])
	{
		//remove all previously know entries for this client.
		ListIterator<Rule> itr = proposedRules.listIterator();
		while(itr.hasNext())
		{
			Rule rule = itr.next();
			if(rule.source != null && rule.source.equals(clientId))
			{
				itr.remove();
			}
		}
		
		//add the new ones
		for(Rule rule : tRule)
		{
			proposedRules.add(rule);
		}
	}
	
	private HashMap<ContentName, Rule> aggrTable;
	public synchronized HashMap<ContentName, Rule> calculateRules()
	{
		 aggrTable = new HashMap<ContentName, Rule>();
		
		for(Rule rule : proposedRules)
		{
			Rule tRule = aggrTable.get(rule.entrypoint);
			if(tRule == null || rule.cost < tRule.cost)
			{
				aggrTable.put(rule.entrypoint, rule);
			}
		}
		
		return aggrTable;
	}
}

