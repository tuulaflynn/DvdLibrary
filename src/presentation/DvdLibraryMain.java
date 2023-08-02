package presentation;

import dao.DvdDao;
import dao.DvdDaoImpl;
import model.DvdPojo;
import service.DvdService;
import service.DvdServiceImpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DvdLibraryMain {
    public static void main(String[] args) {

        DvdService dvdServiceObject = new DvdServiceImpl();     // only create one instance (object) of dvdServiceImpl.

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("**************************************");
            System.out.println("Welcome to DVD Library");
            System.out.println("1. Add a DVD");
            System.out.println("2. Remove a DVD by id");
            System.out.println("3. Edit a DVD by id");
            System.out.println("4. List DVDs");
            System.out.println("5. Display a DVD by id");
            System.out.println("6. Search for a DVD by title");
            System.out.println("7. Load DVD library from file");
            System.out.println("8. Save DVD library to file");
            System.out.println("9. Add multiple DVDs ");
            System.out.println("10. Edit multiple DVDs with ids");
            System.out.println("11. Delete multiple DVDs with ids");
            System.out.println("12. Exit");
            System.out.println("**************************************");
            System.out.println("Enter menu option: ");
            System.out.println("**************************************");

            userChoice = scanner.nextInt();
            scanner.nextLine();         // this will consume the left over /n from the nextInt() line,
            // allowing nextline() method to hit the correct breakpoint (/n) of the line it is trying to capture.

            switch (userChoice) {
                case 1:
                    System.out.println("Enter dvd title: ");
                    String title = scanner.nextLine();
                    // newDvd.setDvdTitle(title);       I would have had to initialise newDvd above this code
                    // I will do this all in one go when I make the dvd Pojo #object after obtaining all user input

                    System.out.println("Enter dvd release date (YYYY-MM-DD): ");
                    String release = scanner.nextLine();
                    LocalDate releaseDate = LocalDate.parse(release);
                    // newDvd.setDvdReleaseDate(releaseDate);

                    System.out.println("Enter MPAA rating: ");
                    String MPAArating = scanner.nextLine();

                    System.out.println("Enter director name(s): ");
                    String director = scanner.nextLine();

                    System.out.println("Enter studio: ");
                    String studio = scanner.nextLine();

                    System.out.println("Enter your user rating: ");
                    String userRating = scanner.nextLine();

                    DvdPojo newDvd = new DvdPojo(0, title, releaseDate, MPAArating, director, studio, userRating);

                    // need to use the object of DvdServiceImpl, to use the method addDvd on, which will then call
                    // the method addDvd in class DvdDaoImpl
                    dvdServiceObject.addDvd(newDvd);
                    System.out.println("DVD has been added successfully with id: " + newDvd.getDvdId());
                    break;
                case 2:
                    System.out.println("Enter the id of the dvd you want to remove: ");
                    int dvdId = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Enter the id of the dvd you want to edit: ");
                    break;
                case 4:
                    System.out.println("The dvds in the library are....");
                    List<DvdPojo> allDvds = dvdServiceObject.listDvds();        // allDvds stores the returned arrayList of all dvds
                    for (DvdPojo dvd: allDvds) {
                        // for each loops through each element (dvd) in the list and presents it to the user one dvd on each line
                        System.out.println(dvd);
                    }
                    break;
                case 5:
                    System.out.println("Enter the id of the dvd you want to display: ");
                    int dvdIdDisplay = scanner.nextInt();
                    DvdPojo dvdDisplay = dvdServiceObject.displayDvd(dvdIdDisplay);
                    if (dvdDisplay != null ) {
                        System.out.println("Dvd with id " + dvdIdDisplay + " is: ");
                        System.out.println(dvdDisplay);
                        break;
                    }
                    System.out.println("Sorry no dvd has id: " + dvdIdDisplay);
                    break;
                case 6:
                    System.out.println("Enter the title you would like to search for: ");
                    String dvdTitle = scanner.nextLine();
                    DvdPojo dvdTitleReturned = dvdServiceObject.searchDvd(dvdTitle);
                    if (dvdTitleReturned != null) {
                        System.out.println("Dvd with title" + "\'" + dvdTitle + "\'" + " is: ");
                        System.out.println(dvdTitleReturned);
                        break;
                    }
                    System.out.println("Sorry no dvd with " + "\'" + dvdTitle + "\'" + " is in the Library.");
                    break;
            }
        }
        while (userChoice != 12);

    }
}
