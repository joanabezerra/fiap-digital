package br.com.fiap.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;

public class Tela {

	protected Shell shell;
	private Text codigoProduto;
	private Table table;

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
		
		Label lblCdigoProduto = new Label(shell, SWT.NONE);
		lblCdigoProduto.setBounds(10, 43, 93, 21);
		lblCdigoProduto.setText("C\u00F3digo Produto");
		
		codigoProduto = new Text(shell, SWT.BORDER);
		codigoProduto.setBounds(109, 40, 290, 21);
		
		Button busca = new Button(shell, SWT.NONE);
		busca.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					EstoqueBOStub stub = new EstoqueBOStub(); 
					ConsultarProduto cp = new ConsultarProduto();
					cp.setCodigo(Integer.parseInt(codigoProduto.getText()));
					
					ConsultarProdutoResponse resp = stub.consultarProduto(cp);
					
					cp.setCodigo(Integer.parseInt(codigoProduto.getText()));
					
					TableItem item = new TableItem(table, 0);
					item.setText(new String[] { "401", "Camiseta Branca", "10", "1" } );
					
				} catch(Exception ex) {
					MessageBox dialog = MessageBox(shell);
					dialog.setMessage(ex.getMessage());
					dialog.open();
					ex.printStackTrace();
				}
				
			}
		});
		busca.setBounds(10, 70, 389, 25);
		busca.setText("Buscar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 111, 389, 140);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnDescrio = new TableColumn(table, SWT.NONE);
		tblclmnDescrio.setWidth(100);
		tblclmnDescrio.setText("Descri\u00E7\u00E3o");
		
		TableColumn tblclmnPreo = new TableColumn(table, SWT.NONE);
		tblclmnPreo.setWidth(100);
		tblclmnPreo.setText("Pre\u00E7o");
		
		TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");

	}

	protected MessageBox MessageBox(Shell shell2) {
		// TODO Auto-generated method stub
		return null;
	}
}
