package core.basesyntax.model;

public class Bet {
    private int value;
    private double risk;

    public Bet(int value, double risk) {
        this.value = value;
        this.risk = risk;
    }

    public int getValue() {
        return value;
    }

    public Bet setValue(int value) {
        this.value = value;
        return this;
    }

    public double getRisk() {
        return risk;
    }

    public Bet setRisk(double risk) {
        this.risk = risk;
        return this;
    }
}
