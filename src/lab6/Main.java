package lab6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Publication[] tablicaPublikacji= new Publication[3];//tablica [null, null, null]
        System.out.println(Arrays.toString(tablicaPublikacji));
        //musimy stworzyc publikacje i je dodac do tablicy
        Publication p1=new Publication("sasdsd","343345",67,78);
        Publication p2=new Publication("xxxxx","56563345",87,100);
        Publication p3=new Publication("eeee","7878745",12,56);
        tablicaPublikacji[0]=p1;
        tablicaPublikacji[1]=p2;
        tablicaPublikacji[2]=p3;

        ArrayOfPublicationsMethods.showPublications(tablicaPublikacji);

        System.out.println("TAB2");
        //2sposob
        Publication[] tab2={p2,p3,new Publication("ssss","9945",92,756) };
        ArrayOfPublicationsMethods.showPublications(tab2);
        System.out.println("calkowity dochod "+ArrayOfPublicationsMethods.calculateTotalIncome(tab2));
        System.out.println("ile tanszych od 50 "+ArrayOfPublicationsMethods.countNumberOfCheaper(tab2,50));
        ArrayOfPublicationsMethods.increasePricesByPercentage(tab2, 30);
        ArrayOfPublicationsMethods.showPublications(tab2);
        Publication pub=ArrayOfPublicationsMethods.getPublicationsWithId(tab2,"99945");
        if( pub == null ) System.out.println("nie ma publikacji o tym numerze");
        else {
            System.out.println("publikacja o indent \"99945\" to ");
            pub.display();
        }

    }
}
