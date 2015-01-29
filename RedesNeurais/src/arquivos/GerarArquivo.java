package arquivos;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;


public class GerarArquivo {
	
	public void gerarCsv(String name, ArrayList<Double> x1, ArrayList<Double> x2, ArrayList<Double> y){
		try {
			FileWriter myWriter = new FileWriter(name);
			myWriter.append(";");
			for(int i = 0; i < x1.size()+1; i++){
				for(int j = 0; j < x2.size()+1; j++){
					if (i == 0 && j < x2.size()) myWriter.append(x2.get(j)+";");
					else if (j == 0 && i > 0) myWriter.append(x1.get(i-1)+";");
					else if (i == j && i > 0) myWriter.append(y.get(i-1)+";");
					else myWriter.append(";");					
				}
				myWriter.append("\n");
			} 
			myWriter.flush(); 
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarCsv2(String name, ArrayList<Double> x1, ArrayList<Double> x2, ArrayList<Double> y){
		int x = 0;
		String temp = "";
		try {
			FileWriter myWriter = new FileWriter(name);
			for(int i = 0; i <= x1.size(); i++){
				for(int j = 0; j <= x2.size(); j++){
					if (i == j && j == 0){
						myWriter.append(";");
					}
					else if (i == 0 && j <= x2.size()) {
						//System.out.println(x2.get(j-1));
						//temp = String.format(new Locale("pt", "BR"), "%f", x2.get(j-1));
						temp = ""+x2.get(j-1);
						//System.out.println(temp);
						temp = replace(temp, '.', ',');
						//System.out.println(temp);
						myWriter.append(temp+";");
					}
					else if (j == 0 && i != 0) {
						//temp = String.format(new Locale("pt", "BR"), "%f", x1.get(i-1));
						temp = ""+x1.get(i-1);
						temp = replace(temp, '.', ',');
						myWriter.append(temp+";");
					}
					else if(x < (x2.size() * x1.size())){
						//temp = String.format(new Locale("pt", "BR"), "%f", y.get(x++));
						temp = ""+y.get(x++);
						temp = replace(temp, '.', ',');
						myWriter.append(temp+";");
					}
					
				}
				myWriter.append("\n");
			}
			//temp = transform(temp,);
//			myWriter.write(temp);
			myWriter.flush(); 
			myWriter.close();
//			System.out.println(temp);
			System.out.println(x1.size());
			System.out.println(x2.size());
			System.out.println(y.size());
			System.out.println(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String replace(String entrada, char antes, char depois) {
		String saida = "";
		for (int i = 0; i < entrada.length(); i++) {
			if (entrada.charAt(i) == antes)
				saida = saida + depois;
			else
				saida = saida + entrada.charAt(i);
		}
		return saida;
	}
	
//	public void gerarCsv3(String name, ArrayList<Double> B, ArrayList<Double> u){
//		int x = 0;
//		try {
//			FileWriter myWriter = new FileWriter(name);
//			for(int i = 0; i < 3; i++){
//				for(int j = 0; j < u.size(); j++){
//					if (i == 0 && j == 0) myWriter.append(";");
//					else if (i == 0 && j != 0)
//						
//						myWriter.append(B.get(i)+";");
//					else myWriter.append(u.get(i)+";");					
//				}
//				myWriter.append("\n");
//			} 
//			myWriter.flush(); 
//			myWriter.close();
////			System.out.println(x1.size());
////			System.out.println(x2.size());
////			System.out.println(y.size());
//			System.out.println(x);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public String transform(String temp, int tam){
//		for(int i = 0; i <= tam; i++){
//			for(int j = 0; j <= tam; j++){
//				
//			}
//		}
//		return temp;
//	}
	
	public void gerarCsvTeste(String name, ArrayList<Double> x1, ArrayList<Double> x2, ArrayList<Double> y){
		int x = 0;
		String temp = "";
		try {
			FileWriter myWriter = new FileWriter(name);
			for(int i = 0; i <= x1.size(); i++){
				for(int j = 0; j <= x2.size(); j++){
					if (i == j && j == 0){
						myWriter.append(";");
					}
					else if (i == 0 && j <= x2.size()) {
						temp = String.format(new Locale("pt", "BR"), "%f", x2.get(j-1));
						myWriter.append(temp+";");
					}
					else if (j == 0 && i != 0) {
						temp = String.format(new Locale("pt", "BR"), "%f", x1.get(i-1));
						myWriter.append(temp+";");
					}
					else if(x < (x2.size() * x1.size()) && j <= i ){
						temp = String.format(new Locale("pt", "BR"), "%f", y.get(x++));
						myWriter.append(temp+";");
					}else{
						x++;
						myWriter.append(";");
					}
						
					
				}
				myWriter.append("\n");
			}
			//temp = transform(temp,);
//			myWriter.write(temp);
			myWriter.flush(); 
			myWriter.close();
//			System.out.println(temp);
			System.out.println(x1.size());
			System.out.println(x2.size());
			System.out.println(y.size());
			System.out.println(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarCsvErro(String name, ArrayList<Double> epoca, ArrayList<Double> erro){
		try {
			FileWriter myWriter = new FileWriter(name);
			for(int i = 0; i < epoca.size(); i++){
				myWriter.append(String.format(new Locale("pt", "BR"), "%f", epoca.get(i))+";"+String.format(new Locale("pt", "BR"), "%f", erro.get(i))+";"+"\n");
			}
			myWriter.flush(); 
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
