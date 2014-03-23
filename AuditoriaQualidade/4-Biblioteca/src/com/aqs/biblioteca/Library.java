/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqs.biblioteca;

/**
 *
 * @author Edgard Davidson
 */
public class Library {

    private Book[] listOfBooks;
    private int numberOfBooks;
    private int maxNumberOfBooks;

    public Library() {
        numberOfBooks = 0;
        maxNumberOfBooks = 100000;	/* a very modest Library!! */
        listOfBooks = new Book[maxNumberOfBooks];
    }

    public Book getBook(String title, String author) {
        for (int index = 0; index < numberOfBooks; index++) {
            if (listOfBooks[index].getTitle().equals(title)) {
                if (listOfBooks[index].getAuthor().equals(author)) {
                    return listOfBooks[index];
                }
            }
        }
        return null;
    }

    public void addBook(String title, String author) {
        //if Book is already in the Library then add one to
        //Book.numberAvailable
        int index;
        boolean alreadyInLibrary = false;

        for (index = 0; index < numberOfBooks; index++) {
            if (listOfBooks[index].getTitle().equals(title)) {
                if (listOfBooks[index].getAuthor().equals(author)) {
                    alreadyInLibrary = true;
                    break;
                }
            }
        }
        if (alreadyInLibrary) {
            listOfBooks[index].addACopy();
        } else {
            listOfBooks[numberOfBooks] = new Book(title, author);
            numberOfBooks++;
        }
    }

    public void removeBook(String title, String author) throws Exception {
        for (int i = 0; i < numberOfBooks; i++) {
            if (listOfBooks[i].getTitle().equals(title)) {
                if (listOfBooks[i].getAuthor().equals(author)) {
                    if (listOfBooks[i].getNumberAvailable() > 0) {
                        listOfBooks[i].removeACopy();
                    } else {
                        throw new Exception("All copies checked out, cannot remove");
                    }
                }
            }
        }
    }

    public void checkoutBook(String title, String author, int pid) throws Exception {
        for (int i = 0; i < numberOfBooks; i++) {
            if (listOfBooks[i].getTitle().equals(title)) {
                if (listOfBooks[i].getAuthor().equals(author)) {
                    listOfBooks[i].checkout(pid);
                    return;
                }
            }
        }
        throw new Exception("No such Book available in Library");
    }

    public void checkinBook(String title, String author, int pid) throws Exception {
        for (int i = 0; i < numberOfBooks; i++) {
            if (listOfBooks[i].getTitle().equals(title)) {
                if (listOfBooks[i].getAuthor().equals(author)) {
                    listOfBooks[i].checkin(pid);
                    return;
                }
            }
        }
        throw new Exception("No such Book belongs to Library");
    }

    public boolean equals(Library l) {
        if (l.getNumberOfBooks() == numberOfBooks) {
            for (int i = 0; i < numberOfBooks; i++) {
                Book temp = l.getBook(listOfBooks[i].getTitle(), listOfBooks[i].getAuthor());
                if (listOfBooks[i].equals(temp) == false) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isAbleToBeRemoved(String title, String author) {
        /* To be able to be removed, a copy of Book must exist in the Library */
        for (int i = 0; i < numberOfBooks; i++) {
            if (listOfBooks[i].getTitle().equals(title)) {
                if (listOfBooks[i].getAuthor().equals(author)) {
                    if (listOfBooks[i].getNumberAvailable() > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean isAbleToBeCheckedOut(String title, String author) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (listOfBooks[i].getTitle().equals(title)) {
                if (listOfBooks[i].getAuthor().equals(author)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAbleToBeCheckedIn(String title, String author, int pid) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (listOfBooks[i].getTitle().equals(title)) {
                if (listOfBooks[i].getAuthor().equals(author)) {
                    if (listOfBooks[i].isInCheckoutList(pid)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void addToBookWaitList(String title, String author, int pid) throws Exception {
        Book temp = getBook(title, author);
        if (temp != null) {
            temp.addToWaitList(pid);
        }
    }

    public void removeFromBookWaitList(String title, String author, int pid) throws Exception {
        Book temp = getBook(title, author);
        if (temp != null) {
            temp.removeFromWaitList(pid);
        }
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean isInLibrary(String title, String author) {
        int index;
        for (index = 0; index < numberOfBooks; index++) {
            if (listOfBooks[index].getTitle().equals(title)) {
                if (listOfBooks[index].getAuthor().equals(author)) {
                    return true;
                //break;
                }
            }
        }
        return false;
    }
};

