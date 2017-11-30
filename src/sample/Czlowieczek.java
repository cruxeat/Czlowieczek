package sample;

public class Czlowieczek {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String wiek;
    private String wzrost;

    public Czlowieczek() {
        this.imie = "";
        this.nazwisko = "";
        this.pesel = "";
        this.wiek = "";
        this.wzrost = "";
    }


    public Czlowieczek(String imie, String nazwisko, String pesel, String wiek, String wzrost) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.wzrost = wzrost;
    }


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getWiek() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public String getWzrost() {
        return wzrost;
    }

    public void setWzrost(String wzrost) {
        this.wzrost = wzrost;
    }
}

