package arquivos;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author Gleison
 *
 */
public class ManipulaExcel {
	private int numeroDeLinhas;
	private int numeroDeColunas;
	private double d[];
	private double dados[][];
	private String caminho;
	private int linhasExcluidas;
	private int numeroDaFolha;
	
	
	
	public ManipulaExcel(String caminho, int linhasExcluidas, int numeroDaFolha) {
		this.caminho = caminho;
		this.linhasExcluidas = linhasExcluidas;
		this.numeroDaFolha = numeroDaFolha;
	}

	public int getLinhas() {
		return numeroDeLinhas;
	}

	public void setLinhas(int linhas) {
		this.numeroDeLinhas = linhas;
	}

	public int getColunas() {
		return numeroDeColunas;
	}

	public void setColunas(int colunas) {
		this.numeroDeColunas = colunas;
	}

	/**
	 * @return uma matriz com os dados da folha do arquivo para teste
	 * 
	 */
	public double[][] getPlanilha() throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File(caminho));
		Sheet folha = workbook.getSheet(numeroDaFolha - 1);
		numeroDeLinhas = folha.getRows();
		numeroDeColunas = folha.getColumns();
		Cell celula;

		dados = new double[numeroDeLinhas][numeroDeColunas];

		for (int l = linhasExcluidas; l < numeroDeLinhas; l++) {
			for (int c = 0; c < numeroDeColunas; c++) {
				celula = folha.getCell(c, l);
				dados[l - linhasExcluidas][c] = Double.parseDouble(celula
						.getContents().replace(',', '.'));
			}
		}

		return dados;
	}

	/**
	 * @return uma matriz com os dados da folha do arquivo para treinamento
	 * 
	 */
	public double[][] getPlanilhaTreinamento() throws BiffException,
			IOException {
		Workbook workbook = Workbook.getWorkbook(new File(caminho));
		Sheet folha = workbook.getSheet(numeroDaFolha - 1);
		numeroDeLinhas = folha.getRows();
		numeroDeColunas = folha.getColumns() - 1;
		Cell celula;

		dados = new double[numeroDeLinhas][numeroDeColunas];
		d = new double[numeroDeLinhas - linhasExcluidas];

		for (int l = linhasExcluidas; l < numeroDeLinhas; l++) {
			for (int c = 0; c < numeroDeColunas; c++) {
				celula = folha.getCell(c, l);
				dados[l - linhasExcluidas][c] = Double.parseDouble(celula
						.getContents().replace(',', '.'));
			}
			celula = folha.getCell(numeroDeColunas, l);
			d[l - linhasExcluidas] = Double.parseDouble(celula.getContents()
					.replace(',', '.'));
		}

		return dados;
	}

	public double[] getD() {
		return d;
	}

	public void setD(double[] d) {
		this.d = d;
	}

	public double[][] getDados() {
		return dados;
	}

	public void setDados(double[][] dados) {
		this.dados = dados;
	}

}
