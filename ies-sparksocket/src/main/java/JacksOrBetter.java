public class JacksOrBetter {
private boolean win;
private String hand;
private int prize;

public JacksOrBetter() {};
public JacksOrBetter(handcard hc) {
	if (hc.sumValue() != hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==5 ) {//NADA
		this.win=false;
		this.hand="Nothing";
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==7 ) {//PAR
		int job[] = {11,10,12,13,14};
		int[] aux= hc.getvalues();
		int cont=0;
		//bucle1:
			for(int i = 0;i < job.length; i++) {
				for(int k = 0;k < aux.length; k++) {
					if(job[i]==aux[k]) {
						cont++;
					}
				}
				if(cont==2) {
					this.win=true;
					this.hand="JACKS OR BETTER";
					break;// bucle1;
				}else cont=0;
			}
		if (cont<2) {
		this.win=false;
		this.hand="Nothing";
		}
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==9) {
		this.win=true;
		this.hand="2 PAIR";
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==11) {
		this.win=true;
		this.hand="3 OF A KIND";
	}else if(hc.sumValue() == hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==5) {
		this.win=true;
		this.hand="STRAIGHT";
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()==1 && hc.numRep()==5) {
		this.win=true;
		this.hand="FLUSH";
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==13) {
		this.win=true;
		this.hand="FULL HOUSE";
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()>1 && hc.numRep()==13) {
		this.win=true;
		this.hand="FULL HOUSE";
	}else if(hc.sumValue() != hc.valueMaxhand() && hc.numSuits()==4 && hc.numRep()==17) {
		this.win=true;
		this.hand="POKER";
	}else if(hc.sumValue() == hc.valueMaxhand() && hc.valueMaxhand()!= 60 && hc.numSuits()==1 && hc.numRep()==5) {
		this.win=true;
		this.hand="STR. FLUSH";
	}else if(hc.sumValue() == hc.valueMaxhand() && hc.valueMaxhand()== 60 && hc.numSuits()==1 && hc.numRep()==5) {
		this.win=true;
		this.hand="ROYAL FLUSH";
	}else this.hand="Error hand not considered";
}

public boolean IsWin() {
	return this.win;
}
public String getHand() {
	return this.hand;
}
}
