/*
	 * 1 :  A  corazón 14
	 * 2 :  2  corazón 2
	 * 3 :  3  corazón 3
	 * 4 :  4  corazón 4
	 * 5 :  5  corazón 5
	 * 6 :  6  corazón 6
	 * 7 :  7  corazón 7
	 * 8 :  8  corazón 8
	 * 9 :  9  corazón 9
	 * 10:  10 corazón 10
	 * 11:  J  corazón 11
	 * 12:  Q  corazón 12
	 * 13:  K  corazón 13
	 * 
	 * 14 :  A  pica 14
	 * 15 :  2  pica 2
	 * 16 :  3  pica 3
	 * 17 :  4  pica 4
	 * 18 :  5  pica 5
	 * 19 :  6  pica 6
	 * 20 :  7  pica 7
	 * 21 :  8  pica 8
	 * 22 :  9  pica 9
	 * 23 :  10 pica 10
	 * 24 :  J  pica 11
	 * 25 :  Q  pica 12
	 * 26 :  K  pica 13
	 *  
	 * 27 :  A  diamante 14
	 * 28 :  2  diamante 2
	 * 29 :  3  diamante 3
	 * 30 :  4  diamante 4
	 * 31 :  5  diamante 5
	 * 32 :  6  diamante 6
	 * 33 :  7  diamante 7
	 * 34 :  8  diamante 8
	 * 35 :  9  diamante 9
	 * 36 :  10 diamante 10
	 * 37 :  J  diamante 11
	 * 38 :  Q  diamante 12
	 * 39 :  K  diamante 13
	 * 
	 * 40 :  A  trebol 14
	 * 41 :  2  trebol 2
	 * 42 :  3  trebol 3
	 * 43 :  4  trebol 4
	 * 44 :  5  trebol 5
	 * 45 :  6  trebol 6
	 * 46 :  7  trebol 7
	 * 47 :  8  trebol 8
	 * 48 :  9  trebol 9
	 * 49 :  10 trebol 10
	 * 50 :  J  trebol 11
	 * 51 :  Q  trebol 12
	 * 52 :  K  trebol 13
	 * 
	 * 
	 * http://fdzeta.com/data/MetaMirrorCache/_wp_content_uploads_2015_10_baraja_poker.jpg
	 */
public class card {
	//Atributos
	private int id=0;
	private int value=0;
	private int suit=0;
	private String valuestr="";
	private String suitstr="";
	private String deck[][]=  {
			{"A","corazon","1","14"},//CORAZÓN
			{"2","corazon","1","2"},//2
			{"3","corazon","1","3"},//3
			{"4","corazon","1","4"},//4
			{"5","corazon","1","5"},//5
			{"6","corazon","1","6"},//6
			{"7","corazon","1","7"},//7
			{"8","corazon","1","8"},//8
			{"9","corazon","1","9"},//9
			{"10","corazon","1","10"},//10
			{"J","corazon","1","11"},//11
			{"Q","corazon","1","12"},//12
			{"K","corazon","1","13"},//13		 
			{"A","pica","2","14"},//PICA//14
			{"2","pica","2","2"},//15
			{"3","pica","2","3"},//16
			{"4","pica","2","4"},//17
			{"5","pica","2","5"},//18
			{"6","pica","2","6"},//19
			{"7","pica","2","7"},//20
			{"8","pica","2","8"},//21
			{"9","pica","2","9"},//22
			{"10","pica","2","10"},//23
			{"J","pica","2","11"},//24
			{"Q","pica","2","12"},//25
			{"K","pica","2","13"},//26
			{"A","diamante","3","14"},//DIAMANTE//27
			{"2","diamante","3","2"},//28
			{"3","diamante","3","3"},//29
			{"4","diamante","3","4"},//30
			{"5","diamante","3","5"},//31
			{"6","diamante","3","6"},//32
			{"7","diamante","3","7"},//33
			{"8","diamante","3","8"},//34
			{"9","diamante","3","9"},//35
			{"10","diamante","3","10"},//36
			{"J","diamante","3","11"},//37
			{"Q","diamante","3","12"},//38
			{"K","diamante","3","13"},//39
			{"A","trebol","4","14"},//TREBOL//40
			{"2","trebol","4","2"},//41
			{"3","trebol","4","3"},//42
			{"4","trebol","4","4"},//43
			{"5","trebol","4","5"},//44
			{"6","trebol","4","6"},//45
			{"7","trebol","4","7"},//46
			{"8","trebol","4","8"},//47
			{"9","trebol","4","9"},//48
			{"10","trebol","4","10"},//49
			{"J","trebol","4","11"},//50
			{"Q","trebol","4","12"},//51
			{"K","trebol","4","13"},//52
			
			};
	
	
	
	//Constructor
	public card() {};
	public card(int m) {
		
		
		this.id=m;
		this.value=Integer.parseInt(deck[m-1][3]);
		this.valuestr=deck[m-1][0];
		this.suit=Integer.parseInt(deck[m-1][2]);
		this.suitstr=deck[m-1][1];
	
	
	}
	//Métodos
	public int getid() {
		return id;
	}
	public int getvalue() {
		return value;
	}
	public String getvalueString() {
		return valuestr;
	}
	public int getsuit() {
		return suit;
	}
	public String getsuitString() {
		return suitstr;
	}
	
	/*	
	public void putvalue(int v) {
		value= v;
		
	}
	public int putsuit(int s) {
		return suit=s;
	}
	*/
	public String Graph() {
		String s;
		int value = this.value;
		int suit = this.suit;
		
		s = "+-----+\n";
		switch(value){
		case 2:	s += "|2    |\n"; break;
		case 3:	s += "|3    |\n"; break;
		case 4:	s += "|4    |\n"; break;
		case 5:	s += "|5    |\n"; break;
		case 6:	s += "|6    |\n"; break;
		case 7: s += "|7    |\n"; break;
		case 8: s += "|8    |\n"; break;
		case 9: s += "|9    |\n"; break;
		case 10:s += "|10   |\n"; break;
		case 11:s += "|J    |\n"; break;
		case 12:s += "|Q    |\n"; break;
		case 13:s += "|K    |\n"; break;
		case 14:s += "|A    |\n"; break;
		}
		s+="|     |\n";
		switch(suit){
		case 1: s+="|    ♥|\n"; break; //Hearts
		case 2: s+="|    ♠|\n"; break; //Spades
		case 3: s+="|    ♦|\n"; break; //Diamonds
		case 4: s+="|    ♣|\n";	break; //Clubs			
		}
		s += "+-----+\n";

		return s;
	}
	
	
}
