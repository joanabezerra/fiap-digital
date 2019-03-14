package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNumero1;
	private Text txtNumero2;
	private Text txtResultado;
	private Text cepOrigem;
	private Text cepDestino;
	private Text prazo;
	private Text dataMaxima;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblCalculadora = new Label(shell, SWT.NONE);
		lblCalculadora.setBounds(10, 23, 80, 15);
		lblCalculadora.setText("Calculadora");
		
		txtNumero1 = new Text(shell, SWT.BORDER);
		txtNumero1.setBounds(72, 52, 118, 26);
		
		txtNumero2 = new Text(shell, SWT.BORDER);
		txtNumero2.setBounds(72, 99, 118, 26);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Executado no clique do botão
				//Capturar os dois valores
				int n1 = Integer.parseInt(txtNumero1.getText());
				int n2 = Integer.parseInt(txtNumero2.getText());
				//somar
				int somar = n1 + n2;
				//Exibir a resposta
				txtResultado.setText(Integer.toString(somar));
				
			}
		});
		btnCalcular.setBounds(71, 151, 118, 25);
		btnCalcular.setText("Calcular");
		
		Label lblNumero = new Label(shell, SWT.NONE);
		lblNumero.setBounds(10, 55, 55, 15);
		lblNumero.setText("Numero1");
		
		Label lblNmero_1 = new Label(shell, SWT.NONE);
		lblNmero_1.setBounds(10, 102, 55, 15);
		lblNmero_1.setText("Numero2");
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setBounds(10, 212, 55, 15);
		lblResultado.setText("Resultado");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setBounds(72, 212, 118, 21);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(278, 23, -12, 204);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(211, 14, 0, 237);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBounds(211, 23, 2, 212);
		
		Label lblCepOrigem = new Label(shell, SWT.NONE);
		lblCepOrigem.setBounds(217, 23, 69, 15);
		lblCepOrigem.setText("CEP Origem");
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setBounds(223, 90, 80, 15);
		lblCepDestino.setText("CEP Destino");
		
		cepOrigem = new Text(shell, SWT.BORDER);
		cepOrigem.setBounds(220, 52, 169, 26);
		
		cepDestino = new Text(shell, SWT.BORDER);
		cepDestino.setBounds(219, 111, 170, 26);
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setBounds(217, 179, 39, 15);
		lblPrazo.setText("Prazo");
		
		prazo = new Text(shell, SWT.BORDER);
		prazo.setBounds(257, 176, 132, 26);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//Chama o objeto
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					
					//Parametros que serão enviados para o web service
					CalcPrazo valores = new CalcPrazo();
					valores.setNCdServico("40010");
					valores.setSCepDestino(cepDestino.getText());
					valores.setSCepOrigem(cepOrigem.getText());
					
					//Chamando o web service e recuperando a resposta
					CalcPrazoResponse resp = stub.calcPrazo(valores);
					
					//Exibindo a resposta na tela
					prazo.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
					dataMaxima.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(219, 143, 170, 25);
		btnNewButton.setText("Calcular");
		
		Label lblDataMxima = new Label(shell, SWT.NONE);
		lblDataMxima.setBounds(217, 212, 69, 15);
		lblDataMxima.setText("Data M\u00E1xima");
		
		dataMaxima = new Text(shell, SWT.BORDER);
		dataMaxima.setBounds(288, 212, 101, 21);

	}
}
