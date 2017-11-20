
	//clase para determinar si que mano es
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
	
public class handcard {
	//Atributos
	
	private int[] ids= {0,0,0,0,0};
	private int[] values= {0,0,0,0,0};
	private int[] suits= {0,0,0,0,0};
	private card cards[]= {new card(1),new card(1),new card(1),new card(1),new card(1),};
	
	//Constructor
	public handcard() {};
	
	public handcard(card c1,card c2, card c3,card c4, card c5) {
		this.cards[0]=c1;
		this.cards[1]=c2;
		this.cards[2]=c3;
		this.cards[3]=c4;
		this.cards[4]=c5;
		
		this.ids[0]=c1.getid();
		this.ids[1]=c2.getid();
		this.ids[2]=c3.getid();
		this.ids[3]=c4.getid();
		this.ids[4]=c5.getid();
		
		this.values[0]=c1.getvalue();
		this.values[1]=c2.getvalue();
		this.values[2]=c3.getvalue();
		this.values[3]=c4.getvalue();
		this.values[4]=c5.getvalue();		
		
		this.suits[0]=c1.getsuit();
		this.suits[1]=c2.getsuit();
		this.suits[2]=c3.getsuit();
		this.suits[3]=c4.getsuit();
		this.suits[4]=c5.getsuit();	
	};
	
	public handcard(int id1,int id2,int id3,int id4,int id5) {
             card c1 = new card(id1);
             card c2 = new card(id2);
             card c3 = new card(id3);
             card c4 = new card(id4);
             card c5 = new card(id5);
             
     		this.cards[0]=c1;
    		this.cards[1]=c2;
    		this.cards[2]=c3;
    		this.cards[3]=c4;
    		this.cards[4]=c5;
		
     		this.ids[0]=c1.getid();
    		this.ids[1]=c2.getid();
    		this.ids[2]=c3.getid();
    		this.ids[3]=c4.getid();
    		this.ids[4]=c5.getid();
    		
    		this.values[0]=c1.getvalue();
    		this.values[1]=c2.getvalue();
    		this.values[2]=c3.getvalue();
    		this.values[3]=c4.getvalue();
    		this.values[4]=c5.getvalue();		
    		
    		this.suits[0]=c1.getsuit();
    		this.suits[1]=c2.getsuit();
    		this.suits[2]=c3.getsuit();
    		this.suits[3]=c4.getsuit();
    		this.suits[4]=c5.getsuit();	
			
	}
	public handcard(int[] c) {
        card c1 = new card(c[0]);
        card c2 = new card(c[1]);
        card c3 = new card(c[2]);
        card c4 = new card(c[3]);
        card c5 = new card(c[4]);
        
		this.cards[0]=c1;
		this.cards[1]=c2;
		this.cards[2]=c3;
		this.cards[3]=c4;
		this.cards[4]=c5;
	
		this.ids[0]=c1.getid();
		this.ids[1]=c2.getid();
		this.ids[2]=c3.getid();
		this.ids[3]=c4.getid();
		this.ids[4]=c5.getid();
		
		this.values[0]=c1.getvalue();
		this.values[1]=c2.getvalue();
		this.values[2]=c3.getvalue();
		this.values[3]=c4.getvalue();
		this.values[4]=c5.getvalue();		
		
		this.suits[0]=c1.getsuit();
		this.suits[1]=c2.getsuit();
		this.suits[2]=c3.getsuit();
		this.suits[3]=c4.getsuit();
		this.suits[4]=c5.getsuit();	
		
}

	
	//Métodos
	public card[] getCards() {
		return this.cards;
	}
	public int[] getids() {
		return this.ids;
	}
	public int[] getvalues() {
		return this.values;
	}
	public int[] getsuits() {
		return this.suits;
	}
	//OBTENER EL ID DE LA CARTA MAYOR EN LA MANO
	public int higtherCardId() {
		int higther=0;
		int higthervalue=0;
		
		for (int i = 0; i<ids.length; i++) {
			if (this.values[i]>higthervalue) {
				higther=this.ids[i];
				higthervalue = this.values[i];
			}
		}
		
		return higther;
	}
	
	//OBTENER EL VALOR DE LA CARTA MAYOR EN LA MANO
	public int higtherCardValue() {
		return new card(this.higtherCardId()).getvalue();
	}
	//OBTENER 5*VALORMAXIMO-10
	public int valueMaxhand() {
		return 5*this.higtherCardValue()-10;
	}
	//SUMA VALOR
	
	public int sumValue() {
		int suma=0;
		for (int i=0;i < ids.length; i++) {
			suma += values[i];
		}
		return suma;
	}
	//NUMERO DE SUIT DIFERENTES EN LA MANO
	
	public int numSuits() {
		int[] aux= {1,2,3,4};
		int suma=0;
		for (int i=0;i < aux.length; i++) {
			for(int k =0;k < ids.length; k++) {
				if(aux[i]==suits[k]) {
					suma++;
					break;
				}
			}
		}
		return suma;
	}
	//NUMERO DE REPETICIONES
	public int numRep() {
		int suma=0;
		for (int i=0;i < this.values.length; i++) {
			for(int k =0;k < this.values.length; k++) {
				if(this.values[i]==this.values[k]) {
					suma++;
					
				}
			}
		}
		return suma;
	}	
	
	
	
}
