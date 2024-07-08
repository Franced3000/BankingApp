package org.example.BankingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ContoBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    private double saldo;
    private List<String> operazioni;

    public ContoBancario() {
        operazioni = new ArrayList<>();
    }

    public ContoBancario(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
        operazioni = new ArrayList<>();
    }

    // Getter e Setter
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addOperazione(String operazione) {
        operazioni.add(operazione);
    }

    public void stampaListaOperazioni() {
        for (String operazione : operazioni) {
            System.out.println(operazione);
        }
    }

    public void preleva(double importo) {
        if (importo <= saldo) {
            saldo -= importo;
            addOperazione("Prelievo di " + importo + " euro");
        } else {
            System.out.println("Saldo insufficiente");
        }
    }

    public void versa(double importo) {
        saldo += importo;
        addOperazione("Versamento di " + importo + " euro");
    }

    public void svuotaConto() {
        saldo = 0;
        addOperazione("Conto svuotato");
    }

    public void stampaSaldo() {
        System.out.println("Saldo attuale: " + saldo);
    }
}
