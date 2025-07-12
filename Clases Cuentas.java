class CuentaBancaria
{
    //Atributos
    private int saldoPesos;
    //Constructor
    public CuentaBancaria()
    {
        this.saldoPesos = 0;
    }
    //Comandos
    public void extraer(int monto)
    {
        this.saldoPesos -= monto;
    }
    public void depositar(int monto)
    {
        this.saldoPesos += monto;
    }
    //Consultas
    public int consultarSaldo()
    {
        return this.saldoPesos;
    }
    public String saldo()
    {
        return "$"+ consultarSaldo();
    }
}
class CuentaEspecial extends CuentaBancaria
{
    //Atributos
    private int saldoUSD;
    //Constructor
    public CuentaEspecial()
    {
        this.saldoUSD = 0;
    }
    //Comandos
    public void extraerUSD(int monto)
    {
        this.saldoUSD -= monto;
    }
    public void depositarUSD(int monto)
    {
        this.saldoUSD += monto;
    }
    //Consultas
    public int consultarSaldo()
    {
        return this.saldoUSD;
    }
    public String saldo()
    {
        return "$"+ consultarSaldo();
    }
}