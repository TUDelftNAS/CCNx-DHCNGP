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
import java.net.InetAddress;

import org.ccnx.ccn.impl.CCNNetworkManager.NetworkProtocol;


public class Face implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6178484011215814079L;
	/**
	 * 
	 */
	
	public NetworkProtocol protocol;
	public InetAddress host;
	public int port;
	
		public Face(NetworkProtocol tProtocol, InetAddress tHost, int tPort) {
		protocol = tProtocol;
		host = tHost;
		port = tPort;
	}
}
