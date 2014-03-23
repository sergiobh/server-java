/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqs.biblioteca;

/**
 *
 * @author Edgard Davidson
 */
public class Book {

    private int numberAvailable;
    private int waitList[];
    private int checkoutList[];
    private String Title;
    private String Author;
    private int maxSizeOfWaitList;
    private int sizeOfWaitList;
    private int sizeOfCheckoutList;

    Book(String title, String author) {
        Title = title;
        Author = author;
        numberAvailable = 1;
        maxSizeOfWaitList = 5;
        checkoutList = new int[maxSizeOfWaitList];
        waitList = new int[maxSizeOfWaitList];
        sizeOfWaitList = 0;
        sizeOfCheckoutList = 0;
    }

    public void addToWaitList(int pid) throws Exception {
        /* for now, the assumption is that pid
         * isn't already in the wait list
         */
        if (sizeOfWaitList >= maxSizeOfWaitList) {
            throw new Exception("Wait List out of space...change the code");
        } else {
            waitList[sizeOfWaitList] = pid;
            sizeOfWaitList++;
        }
    }

    public void removeFromWaitList(int pid) throws Exception {
        int i;
        boolean inWaitList = false;

        for (i = 0; i < sizeOfWaitList; i++) {
            if (waitList[i] == pid) {
                inWaitList = true;
                break;
            }
        }
        if (inWaitList) {
            for (int j = i; j < sizeOfWaitList - 1; j++) {
                waitList[j] = waitList[j + 1];
            }
            sizeOfWaitList--;
        } else {
            throw new Exception("Not in Wait List, cannot be removed");
        }
    }

    public void checkout(int pid) throws Exception {
        /* if any available, add pid to check out list */
        if (getNumberAvailable() > 0) {
            checkoutList[sizeOfCheckoutList] = pid;
            sizeOfCheckoutList++;
            /* remove pid from wait list */
            if (isInWaitList(pid)) {
                removeFromWaitList(pid);
            }
        } else {
            throw new Exception("No copies of this Book available for checkout");
        }
    }

    public void checkin(int pid) throws Exception {
        /* pid must be in the check out list, else error */
        boolean inCheckoutList = false;
        int index;
        for (index = 0; index < sizeOfCheckoutList; index++) {
            if (checkoutList[index] == pid) {
                inCheckoutList = true;
            }
        }
        if (inCheckoutList) {
            /* remove from the check out list */
            for (int j = index; j < sizeOfCheckoutList - 1; j++) {
                checkoutList[j] = checkoutList[j + 1];
            }
            sizeOfCheckoutList--;
        } else {
            throw new Exception(pid + " not in Checkout List");
        }

    }

    public int getNumberAvailable() {
        return (numberAvailable - sizeOfCheckoutList);
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public boolean isInCheckoutList(int pid) {
        for (int i = 0; i < sizeOfCheckoutList; i++) {
            if (checkoutList[i] == pid) {
                return true;
            }
        }
        return false;
    }

    public boolean isInWaitList(int pid) {
        for (int i = 0; i < sizeOfWaitList; i++) {
            if (waitList[i] == pid) {
                return true;
            }
        }
        return false;
    }

    public void addACopy() {
        numberAvailable++;
    }

    public void removeACopy() {
        if (numberAvailable > 0) {
            numberAvailable--;
        }
    }

    public int getPidWaitList(int index) {
        if (sizeOfWaitList < (index + 1)) {
            return -1;
        } else {
            return waitList[index];
        }
    }

    public boolean equals(Book b) {
        if ((b.getNumberAvailable() == getNumberAvailable()) && (b.getSizeOfWaitList() == sizeOfWaitList) && (b.getSizeOfCheckoutList() == sizeOfCheckoutList)) {
            for (int i = 0; i < sizeOfWaitList; i++) {
                if (b.getPidWaitList(i) != waitList[i]) {
                    return false;
                }
            }
            for (int i = 0; i < sizeOfCheckoutList; i++) {
                if (b.isInCheckoutList(checkoutList[i]) == false) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public int getSizeOfWaitList() {
        return sizeOfWaitList;
    }

    public int getSizeOfCheckoutList() {
        return sizeOfCheckoutList;
    }
    

    public int nextWaiting() {
        if (sizeOfWaitList > 0) {
            return waitList[0];
        } else {
            return -1;
        }
    }

    public int getNumberCheckedOut() {
        return sizeOfCheckoutList;
    }
};
