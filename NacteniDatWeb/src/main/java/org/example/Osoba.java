package org.example;

import java.time.LocalDate;

public class Osoba {
    //Tvorba atributu pro tridu
    private String firstname;
    private String lastname;
    private LocalDate birthday;

    //Konstruktor třídy
    public Osoba(String firstname, String lastname, LocalDate birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }
    //Gettery
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    //settery
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    //Prevod objektu na text
    @Override
    public String toString() {
        return "Osoba{" +
                "jméno='" + firstname + '\'' +
                ", příjmení='" + lastname + '\'' +
                ", narozeniny=" + birthday +
                '}';
    }
}
