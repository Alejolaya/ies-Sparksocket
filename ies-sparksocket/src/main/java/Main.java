import static spark.Spark.*;
import static spark.Spark.post;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import static spark.Spark.port;

import org.json.JSONArray;
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import static spark.Spark.get;
//import org.json.JSONObject;


import spark.Request;


public class Main {
	
	

	
	

	public static void main(String[]args) {
		
	
		
		webSocket("/WSocket/echo",EchoWebSocket.class);
		init();
		
		post("/echoJson", (req, res) -> {
			try {
			JSONParser json_parse= new JSONParser();
			JSONObject json_data = (JSONObject) json_parse.parse(req.body());
			return json_data.toString(); 
			}catch (Exception e) {
				// TODO: handle exception
				
				return e.toString();
			}
			
		});
		//informacion necesaria para comenzar a jugar
		/*
		 * FALTA LEER REQUEST
		 * FALTA CONSULTAR BD
		 * FALTA ENVIAR RESPUESTA
		 */
		get("/JotasOMejor/Config", (req, res) -> {
			/*
			 * FALTA LEER REQUEST
			 * FALTA CONSULTAR BD
			 */
			JSONObject json_data= new JSONObject();
			JSONObject json_tabla_premios= new JSONObject();
			String idgame= "asdf1234";
			int min_bet = 1;
			int max_bet = 20;
			String[] prize_name= {"ROYAL FLUSH","STR. FLUSH","POKER","FULL HOUSE","FLUSH","STRAIGHT","3 OF A KIND","2 PAIR","JACKS OR BETTER"};
			int[] prize_value= {300,50,20,7,5,4,3,2,1};
			int[] deno_values= {10,20,50,100};
			
			
			res.type("aplication/json");
			
			json_data.put("idgame", "asdf1234");
			json_tabla_premios.put("ROYAL FLUSH","300");
			json_tabla_premios.put("STR. FLUSH","50");
			json_tabla_premios.put("POKER","20");
			json_tabla_premios.put("FULL HOUSE","7");
			json_tabla_premios.put("FLUSH","5");
			json_tabla_premios.put("STRAIGHT","4");
			json_tabla_premios.put("3 OF A KIND","3");
			json_tabla_premios.put("2 PAIR","2");
			json_tabla_premios.put("JACKS OR BETTER","1");
			
			json_data.put("min_bet", "1");
			json_data.put("max_bet", "20");
			json_data.put("denominacion", "[10,20,50,100]");
			json_data.put("denominacion2",deno_values);
			json_data.put("tabla_premiacion",json_tabla_premios);
			json_data.put("RF_mul", "1.2");
						
			return json_data.toString();
		});
		post("/JotasOMejor/Config", (req, res) -> {
			/*
			 * FALTA LEER REQUEST
			 * FALTA CONSULTAR BD
			 */
			JSONObject json_data= new JSONObject();
			JSONObject json_tabla_premios= new JSONObject();
			int min_bet = 1;
			int max_bet = 20;
			
			res.type("aplication/json");
			
			json_data.put("idgame", "asdf1234");
			json_tabla_premios.put("ROYAL FLUSH","300");
			json_tabla_premios.put("STR. FLUSH","50");
			json_tabla_premios.put("POKER","20");
			json_tabla_premios.put("FULL HOUSE","7");
			json_tabla_premios.put("FLUSH","5");
			json_tabla_premios.put("STRAIGHT","4");
			json_tabla_premios.put("3 OF A KIND","3");
			json_tabla_premios.put("2 PAIR","2");
			json_tabla_premios.put("JACKS OR BETTER","1");
			json_tabla_premios.put("Nothing","1");
			
			json_data.put("min_bet", "1");
			json_data.put("max_bet", "20");
			json_data.put("denominacion", "[10,20,50,100]");
			json_data.put("tabla_premiacion",json_tabla_premios);
			json_data.put("RF_mul", "1.2");
						
			return json_data.toString();
		});
		//Hacer apuesta, se responde con las cartas que se van a jugar
		
		post("/JotasOMejor/MakeBet", (req, res) -> {
			/*
			 * FALTA LEER REQUEST DE FRONTEND 
			 * FALTA CONSULTAR CARTAS A R
			 * 
			 */
			try {
			
			JSONObject json_data= new JSONObject();
			res.type("aplication/json");
			
			json_data.put("idgame", "asdf1234");
			//rng.intRNG();
			//json_data.put("payingCards", Arrays.toString(rng.getGameHandRNG()));
			json_data.put("payingCards", "[1,13,12,11,10,51,52,45,44,43]");
			
			return json_data.toString();
			}catch (Exception e) {
				// TODO: handle exception
				return e.toString();
			}
		});
		//Validar mano
		post("/JotasOMejor/validatehand", (req, res) -> {
			
			//jsson con los premios, 
			//esto se debe camabiar a consulta en la base de datos
			JSONObject json_prize= new JSONObject();
			json_prize.put("ROYAL FLUSH","300");
			json_prize.put("STR. FLUSH","50");
			json_prize.put("POKER","20");
			json_prize.put("FULL HOUSE","7");
			json_prize.put("FLUSH","5");
			json_prize.put("STRAIGHT","4");
			json_prize.put("3 OF A KIND","3");
			json_prize.put("2 PAIR","2");
			json_prize.put("JACKS OR BETTER","1");
			json_prize.put("Nothing","0");
			try {
				res.type("aplication/json");
				JSONParser json_parse= new JSONParser();
				JSONObject json_rx= (JSONObject) json_parse.parse(req.body());
		
				int credits = Integer.parseInt(json_rx.get("credits").toString());
				int bet = Integer.parseInt(json_rx.get("bet").toString());
				int deno = Integer.parseInt(json_rx.get("deno").toString());
				String str = json_rx.get("handCards").toString();
				int[] arr = Arrays.stream(str.substring(1, str.length()-1).split(","))
					    .map(String::trim).mapToInt(Integer::parseInt).toArray();
				handcard handcard = new handcard(arr); 
				JacksOrBetter job = new JacksOrBetter(handcard);
				
				
				/*
				 * FALTA CONSULTAR LA BASE DE DATOS
				 * FALTA ACTUALIZAR LA BASE DE DATOS
				 */
				
				JSONObject json_data= new JSONObject();
					
				json_data.put("idgame", "asdf1234");
				json_data.put("winned", job.IsWin());
				json_data.put("hand",job.getHand());
		
				if (job.IsWin()) {																																																																																																												
					credits+=(Integer.parseInt(json_prize.get(job.getHand()).toString()))*bet;
				}
				json_data.put("credits", credits);
				json_data.put("currentWinnedValue",(Integer.parseInt(json_prize.get(job.getHand()).toString()))*bet);
				json_data.put("canDouble", job.IsWin());
				
				return json_data.toString();
			}catch (ParseException ex) {
				return ex.toString()+" Error en el JSON";
			}
		});
		post("/JotasOMejor/getdouble", (req, res) -> {
			/*
			 * FALTA LEER REQUEST 
			 * FALTA CONSULTAR BASE DE DATOS
			 * FALTA VALIDAR SI PUEDE DOBLAR
			 * FALTA ACTUALIZAR BASE DE DATOS
			 * FALTA ENVIAR RESPUESTA
			 */
			
			JSONObject json_data= new JSONObject();
			res.type("aplication/json");
			
			json_data.put("Idgame", "asdf1234");
			//consultar creditos 
			json_data.put("credits", "123");
			//INSERTAR R
			//rng.intRNG();
			//json_data.put("doubleCards", Arrays.toString(rng.getHandRNG()));
			json_data.put("payingCards","[1,2,3,4,14]");		
			return json_data.toString();
		});
		
		

		
		
		
		
		post("JotasOMejor/validatedouble", (req, res) -> {
			double maxMoney = 1000000;
			try {
			res.type("aplication/json");
			JSONParser json_parse= new JSONParser();
			JSONObject json_rx= (JSONObject) json_parse.parse(req.body());
			String str = json_rx.get("cards").toString();
			int credits = Integer.parseInt(json_rx.get("credits").toString());
			int deno = Integer.parseInt(json_rx.get("deno").toString());
			int bet =  Integer.parseInt(json_rx.get("bet").toString());
			int cwv =  Integer.parseInt(json_rx.get("currentWinnedValue").toString());
			int doubleCount =  Integer.parseInt(json_rx.get("doubleCount").toString());
			JSONObject json_data= new JSONObject();
			//JSONArray array = json_rx.get
			int[] arr = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			System.out.println(arr.toString());
			doubleup du = new doubleup(arr);
			json_data.put("idgame", "asdf1234");
			json_data.put("winned", du.IsWin());//SI GANO Y EL DINERO QUE HA 
			if ((double)cwv*4<maxMoney && du.IsWin())
				json_data.put("canDouble", true);
			else json_data.put("canDouble", false);
			json_data.put("credits", credits );
			if (du.IsWin())
			json_data.put("currentWinnedValue", cwv*2 );
			else json_data.put("currentWinnedValue", 0 );
			return json_data.toString();
			}catch (ParseException e) {
				return e.toString();
				// TODO: handle exception
			}catch (Exception e2) {
				// TODO: handle exception
				return e2.toString();
			}
		});
		/*
		 * FALTA LEER REQUEST
		 * FALTA FUNCION PARA VALIDAR DOBLON
		 * ACTUALIZAR BASE DE DATOS
		 * FALTA ENVIAR RESPUESTA
		 */

		post("/jotasomayor/fin", (req,res)-> {
			/*
			 * FALTA LEER REQUEST
			 * FALTA ENVIAR LA BD LOS RESULTADOS
			 * 
			 */
			
			System.out.println("asdfasdf\n");
			//System.out.println(req.attribute("asdf").toString());
			System.out.println(req.body());
			return "fin";
		/*
		 * WEBSOCKET
		 */
		
		
		
		
		});
		

			
			

		
	

	}
	
}
