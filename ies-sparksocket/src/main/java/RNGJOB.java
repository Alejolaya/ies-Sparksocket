
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;


public class RNGJOB {

	private int[] oneHand= {1,2,3,4,5};
	private int[] twoHand = {1,2,3,4,5,6,7,8,9,10};
			
	private RConnection RConn;
	
	public void intRNG() throws RserveException{
		setRConn ( new RConnection()); //Crear coneccion con el script de R
		
		getRConn().eval("source('/home/alejo/eclipse-workspace/ies-sparksocket/gamedice.R')");
		
		getRConn().eval("initSeed()");
	}
	
	public int getDataRNG() throws RserveException, REXPMismatchException{
		return getRConn().eval("getData()").asInteger();
	}
	
	public int[] getHandRNG() throws RserveException, REXPMismatchException{
		return getRConn().eval("getHand()").asIntegers();
	}
	
	public int[] getGameHandRNG() throws RserveException, REXPMismatchException{
		return getRConn().eval("getGameHand()").asIntegers();
	}
	
	public int[] getDeckRNG() throws RserveException, REXPMismatchException{
		return getRConn().eval("getDeck()").asIntegers();
	}
	
	public RConnection getRConn() {
		return RConn;
	}

	public void setRConn(RConnection rConn) {
		RConn = rConn;
	}
	
	public int[] getOneHand() {
		return this.oneHand;
	}
	public int[] getTwoHand() {
		return this.twoHand;
	}

}
