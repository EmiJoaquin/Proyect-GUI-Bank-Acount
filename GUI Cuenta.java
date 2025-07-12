import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*;

class GuiCuenta extends JFrame {
  //*Atributos de instancia, objetos gráficos y de la aplicación*/
  private CuentaBancaria saldoPesos, saldoUSD; //Estos atributos creo no se usan
  private Container contenedor;

  //Paneles
  private JPanel panelPesos;
  private JPanel panelUSD;

  //Labels y textFiled
  private JTextField montoAExtraerPesos;
  private JTextField montoADepositarPesos;
  private JTextField montoAExtraerUSD;
  private JTextField montoADepositarUSD;
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
    //panelPesos.setLayout(new GridLayout(4, 2));
    panelPesos.setPreferredSize(new Dimension(200, 200));
    panelUSD.setBackground(colorFondo);
    panelUSD.setLayout(new GridLayout(4, 2));
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
    tituloPesos = new JLabel("Cuenta pesos");
    tituloUSD = new JLabel("Cuenta USD");
    etiquetaSaldoPesos = new JLabel(saldoPesos.saldo());
    etiquetaSaldoUSD = new JLabel(saldoUSD.saldo());
    //Crea los botones
    botonExtraerPesos = new JButton("Extraer pesos");
    botonExtraerPesos.setPreferredSize(new Dimension(100, 30));;
    botonDepositarPesos = new JButton("Depositar pesos");
    botonDepositarPesos.setPreferredSize(new Dimension(100, 30));
    botonExtraerUSD = new JButton("Extraer USD");
    botonDepositarUSD = new JButton("Depositar USD");
    montoAExtraerPesos = new JTextField();
    montoAExtraerPesos.setPreferredSize(new Dimension(100, 30));
    montoADepositarPesos = new JTextField();
    montoADepositarPesos.setPreferredSize(new Dimension(100, 30));
    montoAExtraerUSD = new JTextField();
    montoAExtraerUSD.setPreferredSize(new Dimension(100, 30));
    montoADepositarUSD = new JTextField();
    montoADepositarUSD.setPreferredSize(new Dimension(100, 30));
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
    panelPesos.add(botonDepositarPesos);
    panelPesos.add(montoAExtraerPesos);
    panelPesos.add(montoADepositarPesos);


    //panelUSD
    panelUSD.add(tituloUSD);
    panelUSD.add(etiquetaSaldoUSD);
    panelUSD.add(botonExtraerUSD);
    panelUSD.add(botonDepositarUSD);
    panelUSD.add(montoAExtraerUSD);
    panelUSD.add(montoADepositarUSD);

 }
  //Implementa las oyentes
  private class OyenteBotonExtraerPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoAExtraerPesos.getText();
      saldoPesos.extraer(Integer.parseInt(monto));
      etiquetaSaldoPesos.setText(saldoPesos.saldo());
    }  
  }
  private class OyenteBotonDepositarPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoADepositarPesos.getText();
      saldoPesos.depositar(Integer.parseInt(monto));
      etiquetaSaldoPesos.setText(saldoPesos.saldo());
    }  
  }
  private class OyenteBotonExtraerUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoAExtraerUSD.getText();
      saldoUSD.extraer(Integer.parseInt(monto));
      etiquetaSaldoUSD.setText(saldoUSD.saldo());
    }  
  }
  private class OyenteBotonDepositarUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoADepositarUSD.getText();
      saldoUSD.extraer(Integer.parseInt(monto));
      etiquetaSaldoUSD.setText(saldoUSD.saldo());
    }  
  }
}