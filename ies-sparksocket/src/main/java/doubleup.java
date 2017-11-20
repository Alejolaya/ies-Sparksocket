
public class doubleup {
	private boolean Win;
	
public doubleup() {}

public doubleup(int[]arr) {
card d = new card(arr[0]);
card p = new card(arr[1]);
	if (d.getvalue() < p.getvalue()) 
		this.Win=true;
	else this.Win=false;
}
public doubleup(card d,card p) {
	if (d.getvalue() <= p.getvalue()) 
		this.Win=true;
	else this.Win=false;
}

public boolean IsWin() {
	return this.Win;
}
}
