package arquivos;

import java.io.IOException;

import jxl.read.biff.BiffException;

public class TestePlanilha {

	public TestePlanilha() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		ManipulaExcel excel = new ManipulaExcel("C:/Users/Gleison/Desktop/UFPI/Redes Neurais/Lista_Exercícios_06/Teste_Adaline_PPA.xls", 1, 1);
		double rec[][] = excel.getPlanilha();
		
		for (int l = 0; l < excel.getLinhas()-1; l++){
			for (int c = 0; c < excel.getColunas(); c++){
				System.out.print(rec[l][c]+" ");
			}
			System.out.println();
		}
		System.out.println();		
		
	}

}
