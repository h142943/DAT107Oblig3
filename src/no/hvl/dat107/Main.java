package no.hvl.dat107;

import java.time.LocalDate;

public class Main {
 public static void main(String[]args) {
	 AvdelingDAO x = new AvdelingDAO();
	 System.out.println(x.listAlleAnsatte(0));
	 System.out.println(x.finnAvdelingMedId(1).toString());
	 x.opprettAvdeling(1);
	 
	 System.out.println(x.listAlleAnsatte(1).toString());
	 System.out.println(x.listAlleAvdelinger());
	 AnsattDAO en = new AnsattDAO();
	 
	 System.out.println(en.finnAnsattMedId(1).toString());
	 en.oppdaterAvdeling(en.finnAnsattMedId(1),1);
	 System.out.println(en.finnAnsattMedId(1).toString());
	 Ansatt to = en.finnAnsattMedId(1);
	 System.out.println(to.toString());
	 System.out.println(en.finnAnsattMedBrukernavn("12").toString());
	 
	 System.out.println(en.listAlleAnsatte().toString());
	 en.oppdaterStillingOgLonn(1,"vaktmester" , 12000);
	 System.out.println(en.finnAnsattMedId(1).toString());
	 en.leggTilAnsatt(new Ansatt("p123","donald","duck",LocalDate.parse("2010-10-07"),"vekter",20000,2),1);
	 System.out.println(en.finnAnsattMedBrukernavn("p123").toString());
	 System.out.println(en.listAlleAnsatte().toString());
	 
 }
}
