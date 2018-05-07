package dto;

public class Top10Row {
    private String naam;
    private int totaal_aantal;

    public Top10Row(String naam, int totaal_aantal) {
        this.naam = naam;
        this.totaal_aantal = totaal_aantal;
    }

    public String getNaam() {
        return naam;
    }

    public int getTotaal_aantal() {
        return totaal_aantal;
    }

    @Override
    public String toString() {
        return "Top10Row{" +
                "naam='" + naam + '\'' +
                ", totaal_aantal=" + totaal_aantal +
                '}';
    }
}
