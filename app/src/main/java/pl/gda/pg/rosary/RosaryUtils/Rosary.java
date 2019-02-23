package pl.gda.pg.rosary.RosaryUtils;

/**
 * Created by jkijo on 17.02.2019.
 */

public class Rosary {

    private int counter;
    private int rozaniec;

    public Rosary(int counter) {
        this.counter = counter;
    }

    public String getStatusText(int delta, String czesc) {
        counter = counter + delta;
//        System.out.println("standardowo: "+ ((counter - 5) % 10));
        System.out.println(counter);



        if (counter == 0)
            return "Krzyżyk - wierzę w Boga";
        if (counter == 1)
            return "Pierwszy paciorek - Ojcze nasz";
        if (counter > 1 && counter < 5)
            return "Wiara, nadzieja i miłość. Zdrowaśka " + (counter - 1);
        if (counter == 5)
            return "Ojcze Nasz, Tajemnica 1";
        if (counter > 5 && counter < 61) {
            if (counter == 16 || counter == 27 || counter == 38 || counter == 49)
                return "Chwała ojcu po tajemnicy nr: " + ((counter - 5) % 10) + ". Ojcze nasz";
            else if (counter == 60)
                return "Chwała ojcu po " + ((counter - 5) % 10) + " dziesiątce. Koniec. Znak krzyża.";
            else
                return "Zdrowaśka numer: " + ((counter - 5) % 11);
        }

        else {
            setCounter(0);
            return "Koniec różańca. Kliknij aby zacząć od nowa";

        }

    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }
    public String getTajemnica() {
        if(counter>5 && counter<16)
            return "Tajemnica pierwsza";
        if(counter>16 && counter<27)
            return "Tajemnica druga";
        if(counter>27 && counter<38)
            return "Tajemnica trzecia";
        if(counter>38 && counter<49)
            return "Tajemnica czwarta";
        if(counter>49 && counter<60)
            return "Tajemnica piąta";
        else
            return "";
    }

    public String checkForChwala()
    {
        if (counter == 5 || counter == 16 || counter == 27 || counter == 38 || counter == 49 )
            return "TEN";
        else if (counter == 11 || counter == 22 || counter == 33 || counter == 44 || counter == 55 )
            return "MIDDLE";
        else if ( counter == 60)
            return "END";
        else
            return "";
    }

    public void goForward(int counter) {
        this.counter = counter++;
    }

    public void goBack(int counter) {
        if (counter > 0)
            this.counter = counter--;
    }


}
