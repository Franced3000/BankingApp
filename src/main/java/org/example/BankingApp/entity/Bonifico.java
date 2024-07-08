package org.example.BankingApp.entity;

public class Bonifico extends Operation {
    private ContoBancario contoDestinatario;
    private double amount;

    public Bonifico(ContoBancario conto, ContoBancario contoDestinatario, double amount) {
        super(conto);
        this.contoDestinatario = contoDestinatario;
        this.amount = amount;
    }

    @Override
    public void esegui() {
        if (conto.getSaldo() >= amount) {
            conto.preleva(amount);
            contoDestinatario.versa(amount);
            conto.addOperazione("Bonifico di " + amount + " euro a " + contoDestinatario.getIban());
        } else {
            System.out.println("Saldo insufficiente per il bonifico");
        }
    }
}

