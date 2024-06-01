import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private int waitingListPosition;


    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWaitingListPosition() {
        return waitingListPosition;
    }

    public void setWaitingListPosition(int waitingListPosition) {
        this.waitingListPosition = waitingListPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, email, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Guest guest = (Guest) obj;
        return Objects.equals(lastName, guest.lastName) &&
                Objects.equals(firstName, guest.firstName) &&
                Objects.equals(email, guest.email) &&
                Objects.equals(phoneNumber, guest.phoneNumber);
    }

    @Override
    public String toString() {
        return "Nume: " + getFirstName() + " " + getLastName() + ", Email: " + getEmail() + ", Telefon: " + getPhoneNumber();
        //Nume: Popescu Ion, Email: ipopescu@devmind.com, Telefon: 0777111222
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}

class GuestsList {

    int availableRemaining;
    ArrayList<Guest> guestList = new ArrayList<>();
    ArrayList<Guest> waitingList = new ArrayList<>();
    private int waitingListPosition;


    public GuestsList(int guestsCapacity) {
        this.availableRemaining = guestsCapacity;
    }

    /**
     * Add a new, unique guest to the list.
     *
     * @param g the guest to be added
     * @return '-1' if the guest is already present, '0' if is a guest, or the
     *         number on the waiting list
     */
    public int add(Guest g) {
        if (guestList.contains(g)) {
            return -1;
        } else if (availableRemaining > 0) {
            guestList.add(g);
            availableRemaining--;
            return 0;
        } else {
            waitingList.add(g);
            g.setWaitingListPosition(waitingList.size());
            waitingListPosition++;
            return waitingList.size();
        }
    }

    /**
     * Check if someone is already registered ( as a guest, or on the waiting
     * list).
     *
     * @param g the guest we are searching for
     * @return true if present, false if not
     */
    private boolean isOnTheListAlready(Guest g) {

        return guestList.contains(g) || waitingList.contains(g);
    }

    /**d last na
     * Search for a guest based on first name. Return the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return the guest if found, null if not
     */
    public Guest search(String firstName, String lastName) {
        firstName = firstName.trim();
        lastName = lastName.trim();
        for (Guest guest : guestList) {
            if (guest.getFirstName().equalsIgnoreCase(lastName) && guest.getLastName().equalsIgnoreCase(firstName)) {
                return guest;
            }
        }

        for (Guest guest : waitingList) {
            if (guest.getFirstName().equalsIgnoreCase(lastName) && guest.getLastName().equalsIgnoreCase(firstName)) {
                return guest;
            }
        }
        return null;
    }

    /**
     * Search for a guest based on email or Telefon. Return the first result.
     *
     * @param opt option to use for searching: 2 for email, 3 for Telefon
     * @param match what is searched for
     * @return the guest if found, null if not
     */
    public Guest search(int opt, String match) {
        switch (opt) {
            case 2:
                for (Guest guest : guestList) {
                    if (guest.getEmail().equalsIgnoreCase(match)) {
                        return guest;
                    }
                }
                for (Guest guest : waitingList) {
                    if (guest.getEmail().equalsIgnoreCase(match)) {
                        return guest;
                    }
                }
                break;
            case 3:
                for (Guest guest : guestList) {
                    if (guest.getPhoneNumber().equalsIgnoreCase(match)) {
                        return guest;
                    }
                }
                for (Guest guest : waitingList) {
                    if (guest.getPhoneNumber().equalsIgnoreCase(match)) {
                        return guest;
                    }
                }
                break;
        }
        return null;
    }

    /**
     * Remove a guest based on first and last name. Remove the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return true if removed, false if not
     */
    public boolean remove(String firstName, String lastName) {
        for (Guest guest : guestList) {
            if (guest.getFirstName().equalsIgnoreCase(firstName) && guest.getLastName().equalsIgnoreCase(lastName)) {
                guestList.remove(guest);
                availableRemaining++;
                return true;
            }
        }

        for (Guest guest : waitingList) {
            if (guest.getFirstName().equalsIgnoreCase(firstName) && guest.getLastName().equalsIgnoreCase(lastName)) {
                waitingList.remove(guest);
                waitingListPosition--;
                return true;
            }
        }
        return false;
    }

    /**
     * Remove a guest based on email or Telefon. Remove the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for Telefon
     * @param match the match we are searching for
     * @return true if removed, false if not
     */
    public boolean remove(int opt, String match) {

        switch (opt) {
            case 2:
                for (Guest guest : guestList) {
                    if (guest.getEmail().equalsIgnoreCase(match)) {
                        guestList.remove(guest);
                        availableRemaining++;
                        return true;
                    }
                }

                for (Guest guest : waitingList) {
                    if (guest.getEmail().equalsIgnoreCase(match)) {
                        waitingList.remove(guest);
                        waitingListPosition--;
                        return true;
                    }
                }
                break;
            case 3:
                for (Guest guest : guestList) {
                    if (guest.getPhoneNumber().equalsIgnoreCase(match)) {
                        guestList.remove(guest);
                        availableRemaining++;
                        return true;
                    }
                }

                for (Guest guest : waitingList) {
                    if (guest.getPhoneNumber().equalsIgnoreCase(match)) {
                        guestList.remove(guest);
                        waitingListPosition--;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    // Show the list of guests.
    public void showGuestsList() {

        for (int i = 0; i < guestList.size(); i++) {
            Guest guest = guestList.get(i);
            System.out.println((i + 1) + ". Nume: " + guest.getFirstName() + " " + guest.getLastName() +
                    ", Email: " + guest.getEmail() + ", Telefon: " + guest.getPhoneNumber());
        }
    }

    // Show the people on the waiting list.
    public void showWaitingList() {
        for (int i = 0; i < waitingList.size(); i++) {
            Guest guest = waitingList.get(i);
            System.out.println((i + 1) + ". " + "Nume: " + guest.getFirstName() + " " + guest.getLastName() +
                    ", Email: " + guest.getEmail() + ", Telefon: " + guest.getPhoneNumber());
        }
        if (waitingList.size() == 0) {
            System.out.println("Lista de asteptare este goala...");
        }

        //Nume: Popescu Ion, Email: ipopescu@devmind.com, Telefon: 0777111222
    }

    public void moveFromWaitingListToGuestList() {
        if (!waitingList.isEmpty() && availableRemaining > 0) {
            Guest guest = waitingList.remove(0);
            guest.setWaitingListPosition(0);
            guestList.add(guest);
            availableRemaining--;
            waitingListPosition--;

            System.out.println("[" + guest.getFirstName() + " " + guest.getLastName() + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
        }
    }

    /**
     * Show how many free spots are left.
     *
     * @return the number of spots left for guests
     */
    public int numberOfAvailableSpots() {
        return availableRemaining;
    }

    /**
     * Show how many guests there are.
     *
     * @return the number of guests
     */
    public int numberOfGuests() {
        return guestList.size();
    }

    /**
     * Show how many people are on the waiting list.
     *
     * @return number of people on the waiting list
     */
    public int numberOfPeopleWaiting() {
        return waitingList.size();
    }

    /**
     * Show how many people there are in total, including guests.
     *
     * @return how many people there are in total
     */
    public int numberOfPeopleTotal() {
        return numberOfGuests() + numberOfPeopleWaiting();
    }

    /**
     * Find all people based on a partial value search.
     *
     * @param match the match we are looking for
     * @return a list of people matching the criteria
     */
    public List<Guest> partialSearch(String match) {
        List<Guest> matchedGuests = new ArrayList<>();
        for (Guest guest : guestList) {
            if (guest.getFirstName().toLowerCase().contains(match.toLowerCase()) ||
                    guest.getLastName().toLowerCase().contains(match.toLowerCase()) ||
                    guest.getEmail().toLowerCase().contains(match.toLowerCase()) ||
                    guest.getPhoneNumber().toLowerCase().contains(match.toLowerCase())) {
                matchedGuests.add(guest);
            }
        }

        for (Guest guest : waitingList) {
            if (guest.getFirstName().toLowerCase().contains(match.toLowerCase()) ||
                    guest.getLastName().toLowerCase().contains(match.toLowerCase()) ||
                    guest.getEmail().toLowerCase().contains(match.toLowerCase()) ||
                    guest.getPhoneNumber().contains(match)) {
                matchedGuests.add(guest);
            }
        }
        return matchedGuests;
    }

    @Override
    public String toString() {
        return "GuestsList{" +
                "availableRemaining=" + availableRemaining +
                ", guestList=" + guestList +
                ", waitingList=" + waitingList +
                '}';
    }

}


public class Main {
    private static void showCommands() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua persoana (inscriere)");
        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("remove       - Sterge o persoana existenta din lista");
        System.out.println("update       - Actualizeaza detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de asteptare");
        System.out.println("available    - Numarul de locuri libere");
        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("subscribe_no - Numarul total de persoane inscrise");
        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("save         - Salveaza lista cu invitati");
        System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
        System.out.println("reset        - Sterge informatiile salvate despre invitati");
        System.out.println("quit         - Inchide aplicatia");
    }

    private static void addNewGuest(Scanner sc, GuestsList list) {
        Guest newGuest = instantiateAGuest(sc);
        int result = list.add(newGuest);
        if (result == -1) {
            System.out.println("Deja este inregistrat");
        } else if (result == 0) {
            System.out.println("[" + newGuest.getFirstName() + " " + newGuest.getLastName() + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");

        } else {
            System.out.println("[" + newGuest.getFirstName() + " " + newGuest.getLastName() + "] Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + newGuest.getWaitingListPosition() + ". Te vom notifica daca un loc devine disponibil.");
        }
    }

    private static void checkGuest(Scanner sc, GuestsList list) {

        String option = sc.nextLine();


        switch (option) {
            case "1":
                String lastName = sc.nextLine().toLowerCase();
                String firstName = sc.nextLine().toLowerCase();
                Guest guestByName = list.search(firstName.toLowerCase(), lastName.toLowerCase());
                if (guestByName != null) {
                    System.out.println(guestByName.toString());

                } else {
                    System.out.println("not found");
                }
                break;
            case "2":
                String email = sc.nextLine();
                Guest guestByEmail = list.search(2, email);
                if (guestByEmail != null) {
                    System.out.println(guestByEmail.toString());
                }
                break;
            case "3":
                String phoneNumber = sc.nextLine();
                Guest guestByPhone = list.search(3, phoneNumber);
                if (guestByPhone != null) {
                    System.out.println(guestByPhone.toString());
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static Guest checkGuestAndRetrieve(Scanner sc, GuestsList list) {

        String option = sc.nextLine();


        switch (option) {
            case "1":
                String lastName = sc.nextLine().toLowerCase();
                String firstName = sc.nextLine().toLowerCase();
                Guest guestByName = list.search(firstName.toLowerCase(), lastName.toLowerCase());
                if (guestByName != null) {
                    return guestByName;
                } else {
                    System.out.println("not found");
                }
                break;
            case "2":
                String email = sc.nextLine();
                Guest guestByEmail = list.search(2, email);
                if (guestByEmail != null) {
                    return guestByEmail;
                }
                break;
            case "3":
                String phoneNumber = sc.nextLine();
                Guest guestByPhone = list.search(3, phoneNumber);
                if (guestByPhone != null) {
                    return guestByPhone;
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
        return null;
    }

    private static void removeGuest(Scanner sc, GuestsList list) {


        Guest guestToRemove = checkGuestAndRetrieve(sc, list);

        try {
            if (guestToRemove != null) {
                list.remove(guestToRemove.getFirstName(), guestToRemove.getLastName());
                list.moveFromWaitingListToGuestList();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


    }

    private static void updateGuest(Scanner sc, GuestsList list) {

        String option = sc.nextLine();

        switch (option) {
            case "1":
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                Guest searchedGuestByName = list.search(firstName, lastName);
                if (searchedGuestByName != null) {
                    updateSelectedGuest(sc, searchedGuestByName);
                }
                break;
            case "2":
                String email = sc.nextLine();
                Guest searchedGuestByEmail = list.search(2, email);
                if (searchedGuestByEmail != null) {
                    updateSelectedGuest(sc, searchedGuestByEmail);
                }
                break;
            case "3":
                String phoneNumber = sc.nextLine();
                Guest searchedGuestByPhone = list.search(3, phoneNumber);
                if (searchedGuestByPhone != null) {
                    updateSelectedGuest(sc, searchedGuestByPhone);
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void updateSelectedGuest(Scanner sc, Guest guest) {

        String fieldOption = sc.nextLine();

        switch (fieldOption) {
            case "1":
                String newFirstName = sc.nextLine();
                guest.setFirstName(newFirstName);
                break;
            case "2":
                String newLastName = sc.nextLine();
                guest.setLastName(newLastName);
                ;
                break;
            case "3":
                String newEmail = sc.nextLine();
                guest.setEmail(newEmail);
                break;
            case "4":
                String newPhoneNumber = sc.nextLine();
                guest.setPhoneNumber(newPhoneNumber);
                break;
            default:
                ;
                break;
        }
    }


    private static void searchList(Scanner sc, GuestsList list) {
        String keyword = sc.nextLine();

        List<Guest> foundGuests = list.partialSearch(keyword);

        if (foundGuests.isEmpty()) {
            System.out.println("Nothing found");
        } else {
            for (Guest guest : foundGuests) {
                System.out.println(guest.toString());
            }
        }
    }

    private static Guest instantiateAGuest(Scanner sc) {
        String firstname = sc.nextLine();
        String lastname = sc.nextLine();
        String email = sc.nextLine();
        String phoneNumber = sc.nextLine();

        return new Guest(lastname, firstname, email, phoneNumber);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        GuestsList list = new GuestsList(size);

        boolean running = true;
        while (running) {
            String command = scanner.nextLine();


            switch (command) {
                case "help":
                    showCommands();
                    break;
                case "add":
                    addNewGuest(scanner, list);
                    break;
                case "check":
                    checkGuest(scanner, list);
                    break;
                case "remove":
                    removeGuest(scanner, list);
                    break;
                case "update":
                    updateGuest(scanner, list);
                    break;
                case "guests":
                    list.showGuestsList();
                    break;
                case "waitlist":
                    list.showWaitingList();
                    break;
                case "available":
                    System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
                    break;
                case "guests_no":
                    System.out.println("Numarul de participanti: " + list.numberOfGuests());
                    break;
                case "waitlist_no":
                    System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
                    break;
                case "subscribe_no":
                    System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
                    break;
                case "search":
                    searchList(scanner, list);
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    scanner.close();
                    running = false;
                    break;
                default:
                    System.out.println("Comanda introdusa nu este valida.");
                    System.out.println("Incercati inca o data.");

            }
        }
    }
}