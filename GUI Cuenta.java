import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.TitledBorder;

class GuiCuenta extends JFrame {
  //*Atributos de instancia, objetos gráficos y de la aplicación*/
  private CuentaBancaria cuentaPesos;
  private CuentaEspecial cuentaUSD;
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
  private JLabel notificacionPesos;
  private JLabel notificacionUSD;

  //Botones
  private JButton botonExtraerPesos;
  private JButton botonDepositarPesos;
  private JButton botonExtraerUSD;
  private JButton botonDepositarUSD;

public GuiCuenta(){
    super ("Cuenta");
    cuentaPesos = new CuentaBancaria();
    cuentaUSD = new CuentaEspecial();
    setSize(550, 450);
    setResizable(false);
    setLocationRelativeTo(null);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  iniciarGUI();
    setVisible(true);
  }
  //Implementa las clases oyente
  private void iniciarGUI(){
//Se crean los dos paneles de las cuentas y se agregan al Frame
    contenedor = getContentPane();
    contenedor.setLayout(new GridLayout(1,2));
    panelPesos = new JPanel();
    panelUSD = new JPanel();
    Color colorFondo = new Color(204, 229, 255);
    panelPesos.setBackground(colorFondo);
    panelPesos.setPreferredSize(new Dimension(200, 200));
    panelPesos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cuenta $$", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Calibri", 1, 25), Color.DARK_GRAY));
    panelUSD.setBackground(colorFondo);
    panelUSD.setPreferredSize(new Dimension(200, 200));
    panelUSD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cuenta U$D", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Calibri", 1, 25), Color.DARK_GRAY));
    contenedor.add(panelPesos);
    contenedor.add(panelUSD);

//Se inicializan las etiquetas para mostraren paneles
    tituloPesos = new JLabel("ARS: ");
    tituloUSD = new JLabel("USD: ");
    etiquetaSaldoPesos = new JLabel(cuentaPesos.saldo());
    etiquetaSaldoPesos.setPreferredSize(new Dimension(100, 30));
    etiquetaSaldoPesos.setFont(new Font("Calibri", 1, 22));
    etiquetaSaldoUSD = new JLabel(cuentaUSD.saldo());
    etiquetaSaldoUSD.setPreferredSize(new Dimension(100, 30));
    etiquetaSaldoUSD.setFont(new Font("Calibri", 1, 22));
    notificacionPesos = new JLabel();
    notificacionUSD = new JLabel();

//Se inicializan los botones
    botonExtraerPesos = new JButton("Extraer ARS");
    botonExtraerPesos.setPreferredSize(new Dimension(200, 35));;
    botonDepositarPesos = new JButton("Depositar ARS");
    botonDepositarPesos.setPreferredSize(new Dimension(200, 35));
    botonExtraerUSD = new JButton("Extraer USD");
    botonExtraerUSD.setPreferredSize(new Dimension(200, 35));
    botonDepositarUSD = new JButton("Depositar USD");
    botonDepositarUSD.setPreferredSize(new Dimension(200, 35));

//Se inicializan las etiquetas que van dentro de los paneles
    montoAExtraerPesos = new JTextField();
    montoAExtraerPesos.setPreferredSize(new Dimension(175, 30));
    montoADepositarPesos = new JTextField();
    montoADepositarPesos.setPreferredSize(new Dimension(175, 30));
    montoAExtraerUSD = new JTextField();
    montoAExtraerUSD.setPreferredSize(new Dimension(175, 30));
    montoADepositarUSD = new JTextField();
    montoADepositarUSD.setPreferredSize(new Dimension(175, 30));

//Se vincula los botones con sus respectivos oyentes
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
    panelPesos.add(notificacionPesos);

    //panelUSD
    panelUSD.add(tituloUSD);
    panelUSD.add(etiquetaSaldoUSD);
    panelUSD.add(botonExtraerUSD);
    panelUSD.add(montoAExtraerUSD);
    panelUSD.add(botonDepositarUSD);
    panelUSD.add(montoADepositarUSD);
    panelUSD.add(notificacionUSD);
}
public void limpiarTextFileds()
{
  montoAExtraerPesos.setText("");
  montoADepositarPesos.setText("");
  montoAExtraerUSD.setText("");
  montoADepositarUSD.setText("");
  notificacionPesos.setText("");
  notificacionUSD.setText("");
}
  //Implementa las oyentes
  private class OyenteBotonExtraerPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoAExtraerPesos.getText();
      if (Integer.parseInt(monto) > 0)
      {
        if (cuentaPesos.puedeExtraer(Integer.parseInt(monto)))
        {
          cuentaPesos.extraer(Integer.parseInt(monto));
          etiquetaSaldoPesos.setText(cuentaPesos.saldo());
          limpiarTextFileds();
          notificacionPesos.setText("Retire su Dinero.");
        }
        else
        {
          limpiarTextFileds();
          notificacionPesos.setText("Saldo Insuficiente.");
        }
      }
      else
      {
        limpiarTextFileds();
        notificacionPesos.setText("El monto a extraer debe ser mayor a 0.");
      }
    }  
  }
  private class OyenteBotonDepositarPesos implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoADepositarPesos.getText();
      if (Integer.parseInt(monto)>0)
      {
        cuentaPesos.depositar(Integer.parseInt(monto));
        etiquetaSaldoPesos.setText(cuentaPesos.saldo());
        limpiarTextFileds();
      }
      else
      {
        limpiarTextFileds();
        notificacionPesos.setText("El monto a depositar debe ser mayor a 0.");
      }
    }  
  }
  private class OyenteBotonExtraerUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoAExtraerUSD.getText();
      if (Integer.parseInt(monto) > 0)
      {
        if (cuentaUSD.puedeExtraer(Integer.parseInt(monto)))
        {
          cuentaUSD.extraerUSD(Integer.parseInt(monto));
          etiquetaSaldoUSD.setText(cuentaUSD.saldo());
          limpiarTextFileds();
          notificacionUSD.setText("Retire su Dinero.");
        }
        else
        {
          limpiarTextFileds();
          notificacionUSD.setText("Saldo Insuficiente.");
        }
      }
      else
      {
        limpiarTextFileds();
        notificacionUSD.setText("El monto a extraer debe ser mayor a 0.");
      }
    }  
  }
  private class OyenteBotonDepositarUSD implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String monto = montoADepositarUSD.getText();
      if (Integer.parseInt(monto)>0)
      {
        cuentaUSD.depositarUSD(Integer.parseInt(monto));
        etiquetaSaldoUSD.setText(cuentaUSD.saldo());
        limpiarTextFileds();
      }
      else
      {
        limpiarTextFileds();
        notificacionUSD.setText("El monto a depositar debe ser mayor a 0.");
      }
    }  
  }
}