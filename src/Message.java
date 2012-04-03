//Dynamic Host Configuration and Name Generation Protocol (DHCNGP)
//
//Copyright (C) 2012, Niels van Adrichem
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

public  class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 864353840212848267L;
	public MessageType msgType;
	public String clientID;
	public String serverID;
	public String clientHostname;
	
	public Face faces[];
	public Rule rules[];
	
	public enum MessageType {
		Discover,
		Offer,
		Request,
		Acknowledgement;
	}
	
	public Message (MessageType tMsgType)
	{
		msgType = tMsgType;
		
	}
}
