package com.company;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Serveur {
	public static void main(String[] args) {
		try {
			java.util.Properties props = new java.util.Properties();
			props.put("org.omg.CORBA.ORBClass", "org.openorb.CORBA.ORB");
			props.put("org.omg.CORBA.ORBSingletonClass", "org.openorb.CORBA.ORBSingleton");
			props.put("org.omg.CORBA.ORBInitialHost","localhost");
			props.put("org.omg.CORBA.ORBInitialPort","4321");
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			NoteImpl note = new NoteImpl();
			byte[] monEuroId = rootPOA.activate_object(note);
			rootPOA.the_POAManager().activate();
			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(note));
			System.out.println("l'objet possede la reference suivante :");
			System.out.println(IORServant);
			orb.run();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
