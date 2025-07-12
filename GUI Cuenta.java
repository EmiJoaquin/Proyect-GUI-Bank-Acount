import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

class GuiCuenta extends JFrame {
  //*Atributos de instancia, objetos gráficos y de la aplicación*/
  private CuentaBancaria saldoPesos;
  private CuentaEspecial saldoUSD;
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
    saldoPesos = new CuentaBancaria();
    saldoUSD = new CuentaEspecial();
    setSize(450, 350);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  iniciarGUI();
    setVisible(true);
  }
  //Implementa las clases oyente
  private void iniciarGUI(){
    //Se crea el Frame y los dos paneles de las cuentas
    contenedor = getContentPane();
    contenedor.setLayout(new GridLayout(1,2));
    panelPesos = new JPanel();
    panelUSD = new JPanel();
    Color colorFondo = new Color(204, 229, 255);
    panelPesos.setBackground(colorFondo);
    panelPesos.setPreferredSize(new Dimension(200, 200));
    panelPesos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cuenta $$", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Calibri", 1, 20), Color.DARK_GRAY));
    panelUSD.setBackground(colorFondo);
    panelUSD.setPreferredSize(new Dimension(200, 200));
    panelUSD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cuenta U$D", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Calibri", 1, 20), Color.DARK_GRAY));
    contenedor.add(panelPesos);
    contenedor.add(panelUSD);

    //Crea las etiquetas para mostrar los dos fondos
    tituloPesos = new JLabel("ARS: ");
    tituloUSD = new JLabel("USD: ");
    etiquetaSaldoPesos = new JLabel(saldoPesos.saldo());
    etiquetaSaldoPesos.setPreferredSize(new Dimension(100, 30));
    etiquetaSaldoUSD = new JLabel(saldoUSD.saldo());
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

    //Crea etiquetas que van dentro de los paneles
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
    panelPesos.add(montoAExtraerPesos);
    panelPesos.add(botonDepositarPesos);
    panelPesos.add(montoADepositarPesos);

    //panelUSD
    panelUSD.add(tituloUSD);
    panelUSD.add(etiquetaSaldoUSD);
    panelUSD.add(botonExtraerUSD);
    panelUSD.add(montoAExtraerUSD);
    panelUSD.add(botonDepositarUSD);
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