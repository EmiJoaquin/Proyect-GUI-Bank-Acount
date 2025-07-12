import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*;

class GuiCuenta extends JFrame {
  //*Atributos de instancia, objetos gráficos y de la aplicación*/
  private CuentaBancaria saldoPesos;
  private CuentaEspecial saldoUSD;
  private Container contenedor;

  //Paneles
  private JPanel panelPesos;
  private JPanel panelUSD;

  //Labels y textFileds
  private JTextField montoAExtraer;
  private JTextField montoADepositar;
  private JTextField montoUSDAExtraer;
  private JTextField montoUSDADepositar;
  private JLabel tituloPesos;
  private JLabel tituloUSD;
  private JLabel etiquetaSaldoPesos;
  private JLabel etiquetaSaldoUSD;

  //Botones
  private JButton botonExtraerPesos;
  private JButton botonDepositarPesos;
  private JButton botonExtraerUSD;
  private JButton botonDepositarUSD;

  
  public GuiCuenta(){
    super ("Cuenta");
    //Inicializa variables
    saldoPesos = new CuentaBancaria();
    saldoUSD = new CuentaEspecial();
    //Establece los valores de los atributos del frame
    contenedor = getContentPane();
    contenedor.setLayout(new GridLayout(1,2));
    setSize(500, 600);
    panelPesos = new JPanel();
    panelUSD = new JPanel();
    Color colorFondo = new Color(204, 229, 255);
    panelPesos.setBackground(colorFondo);  
    panelPesos.setPreferredSize(new Dimension(200, 200));
    panelUSD.setBackground(colorFondo);
    panelUSD.setPreferredSize(new Dimension(200, 200));
    contenedor.add(panelPesos);
    contenedor.add(panelUSD);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Invoca a un método interno que completa la GUI
	  hacerGUI();
    setVisible(true);
  }
  //Implementa las clases oyente
  private void hacerGUI(){
    //Crea las etiquetas para mostrar los dos fondos
    tituloPesos = new JLabel("Cuenta ARS: ");
    tituloUSD = new JLabel("Cuenta USD: ");
    etiquetaSaldoPesos = new JLabel(saldoPesos.saldo());
    etiquetaSaldoPesos.setPreferredSize(new Dimension(100, 30));
    etiquetaSaldoUSD = new JLabel(saldoUSD.saldoUSD());
    etiquetaSaldoUSD.setPreferredSize(new Dimension(100, 30));
    //Crea los botones
    botonExtraerPesos = new JButton("Extraer ARS");
    botonExtraerPesos.setPreferredSize(new Dimension(200, 35));;
    botonDepositarPesos = new JButton("Depositar ARS");
    botonDepositarPesos.setPreferredSize(new Dimension(200, 35));
    botonExtraerUSD = new JButton("Extraer USD");
    botonExtraerUSD.setPreferredSize(new Dimension(200, 35));
    botonDepositarUSD = new JButton("Depositar USD");
    botonDepositarUSD.setPreferredSize(new Dimension(200, 35));
    //Crea etiquetas
    montoAExtraer = new JTextField();
    montoAExtraer.setPreferredSize(new Dimension(100, 30));
    montoADepositar = new JTextField();
    montoADepositar.setPreferredSize(new Dimension(100, 30));
    montoUSDAExtraer = new JTextField();
    montoUSDAExtraer.setPreferredSize(new Dimension(100, 30));
    montoUSDADepositar = new JTextField();
    montoUSDADepositar.setPreferredSize(new Dimension(100, 30));
    //Registra los botones en sus respectivos oyentes
    OyenteBotonExtraerPesos EP = new OyenteBotonExtraerPesos();
    botonExtraerPesos.addActionListener(EP);
    OyenteBotonDepositarPesos DP = new OyenteBotonDepositarPesos();
    botonDepositarPesos.addActionListener(DP);
    OyenteBotonExtraerUSD EU = new OyenteBotonExtraerUSD();
    botonExtraerUSD.addActionListener(EU);
    OyenteBotonDepositarUSD DU = new OyenteBotonDepositarUSD();
    botonDepositarUSD.addActionListener(DU);

    //Inserta las componentes en los paneles	
    //panelPesos
    panelPesos.add(tituloPesos);
    panelPesos.add(etiquetaSaldoPesos);
    panelPesos.add(botonExtraerPesos);
    panelPesos.add(montoAExtraer);
    panelPesos.add(botonDepositarPesos);
    panelPesos.add(montoADepositar);

    //panelUSD
    panelUSD.add(tituloUSD);
    panelUSD.add(etiquetaSaldoUSD);
    panelUSD.add(botonExtraerUSD);
    panelUSD.add(montoUSDAExtraer);
    panelUSD.add(botonDepositarUSD);
    panelUSD.add(montoUSDADepositar);

 }
  //Implementa las oyentes
  private class OyenteBotonExtraerPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {

    }  
  }
  private class OyenteBotonDepositarPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {

    }  
  }
  private class OyenteBotonConsultarPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {

    }  
  }
  private class OyenteBotonExtraerUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {

    }  
  }
  private class OyenteBotonDepositarUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {

    }  
  }
  private class OyenteBotonConsultarUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {

    }  
  }
}