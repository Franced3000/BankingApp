package org.example.BankingApp.entity;

public abstract class Operation {
    protected ContoBancario conto;

    public Operation(ContoBancario conto) {
        this.conto = conto;
    }

    public abstract void esegui();
}
