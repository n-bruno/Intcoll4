
import java.util.Scanner;

//*********************************************************************
// FILE NAME    : Intcoll4.java
// DESCRIPTION  : This file contains the class Intcoll4.
//*********************************************************************
public class Intcoll4 {
////////////////////////////////////////////
//  Variables
////////////////////////////////////////////

    private ListNode firstNode;
    private int how_many = 0;

    //private boolean nodeInReverseOrder = true;
    /*
    One interesting feature I added to this class is that you can toggle
    whether the list stores the contents entered in reverse order or not.
    Unfortunately this had to be remove for this assignment by being commented
    out. Check out the code if you must. You have the choice to add the
    commented code from the insert or print method but not both.

    So if you entered 1, 2, 3, it will be printed when 
        Reverse order = true: 3, 2, 1
        Reverse order = false: 1, 2, 3
     */

////////////////////////////////////////////
//  Stuff
////////////////////////////////////////////

    /*
    Constructor for Intcoll4 class
     */
    public void Intcoll4() {
        how_many = 0;
        firstNode = new ListNode();
    }

    /*
    Returns how many ojects are in the list
     */
    public int get_howmany() {
        return how_many;
    }

    /*
    A private method for incrementing our counter.
    This is private so the user in IntColl4Client doesn't
    modify our counter and mess up the program!
     */
    private void incr_how_many() {
        how_many++;
    }

    /*
    Same for here too!
     */
    private void decr_how_many() {
        if (how_many != 0) {
            how_many--;
        } else {
            System.out.println("Error: Trying to decrease how_many"
                    + "when zero.");
        }
    }

    //debug
    public int number() {
        if (firstNode != null) {
            return firstNode.number;
        } else {
            return 0;
        }
    }

    //debug
    public void incrim() {
        if (firstNode != null) {
            firstNode = firstNode.next;
        } else {
            System.out.println("Incrim error");
            System.exit(0);
        }
    }

////////////////////////////////////////////
//  Belongs
////////////////////////////////////////////
    /*
    Checks if the integer in the parameter is in our list.
     */
    public boolean belongs(int integer) {
        return (cycle(integer) != null);
        /*
        Actually, most of the code you actually want to read is in the cycle
        method!
        
        The cycle method itself returns the node that has the integer
        or the end of the list. However since the same exact code is used
        in insert, a method was created to eliminate code rendancy. We can use
        belongs in the insert method but we need to get what node the number is
        in. The belongs method can't do this with a boolean return value.
         */
    }
////////////////////////////////////////////
//  Insert
////////////////////////////////////////////

    /*
    Inserts a number into the collection
     */
    public void insert(int integer) {
        if (integer > 0) {
            /*
        Cycle can store the node where the number was. 
        If it wasn't there, cycle will have a value of null.
        
        If it's null the value is not in the list so we can insert it, if
        cycle stores a pointer, this means a node already has the number.
        We can't store the same number twice for this assignment,
        so we skip the insertion process in this case.
             */
            ListNode cycle = cycle(integer);
            if (cycle == null) {

                /*
            Now we'll insert the integer, with lists, it's hard to generate a
            new pointer by seeing 
                 */
            /*if (nodeInReverseOrder == false){
                cycle = new ListNode(integer, null);
                ListNode lastNode = firstNode;
                ListNode prev = null;
                int i = 0;
            
                while (lastNode != null) {
                    prev = lastNode;
                    lastNode = lastNode.next;
                    i++;
                }
               
                if (prev != null)
                    prev.next = cycle;
                else firstNode = cycle;
                incr_how_many();
            } else {*/
                
                //This line of code establishes a new pointer that contains the
                //value we want
                cycle = new ListNode(integer, firstNode);
                cycle.next = firstNode;
                firstNode = cycle;
                //}
                incr_how_many();
            }
        } else {
            System.out.println("Error: You can't insert negative"
                    + "numbers or zero.");
        }
    }

////////////////////////////////////////////
//  Omit
////////////////////////////////////////////
    /*
    Deletes a member from the linked list
     */
    public void omit(int integer) {

        //check if there's actually anything in the list to check.
        if (firstNode != null) {
            ListNode cycle = firstNode;
            ListNode prev = null;

            /*
            Here we cycle through the list until we find the integer
            we want to omit or if we reach the end of the list (don't find
            the integer).
            
            We can't use the cycle method here as we need to kep track of
            two variables. This would require the cycle method to
            return two variables without is not possible to my knowledge.
             */
            while ((cycle != null) && (cycle.number != integer)) {
                prev = cycle;
                cycle = cycle.next;
            }

            //check if you actually went through the loop
            //and found the number. if not, then the checks inside are
            //pointless
            if (cycle != null) {
                if (prev == null) {
                    firstNode = cycle.next;
                } else {
                    prev.next = cycle.next;
                }
                decr_how_many();
            }

        }
    }

////////////////////////////////////////////
//  Cycle
////////////////////////////////////////////
    /*
    This method is here to avoid redundancy in this class's code.
    It makes it shorter and is better than copying and pasting.
     */
    private ListNode cycle(int integer) {
        /*
        Basically the cycle method with take in an integer and cycles
        through the list until it finds the number
        or reaches the end. Then it returns the value
        of the pointer of the node it stopped at.
        
        If the number was not found, the ListNode it reutrns will
        have a value of null (same applies to it's "next" value)
        
        This is used in the belongs and insert method.
         */

        ListNode cycle = firstNode;
        while ((cycle != null) && (cycle.number != integer)) {
            cycle = cycle.next;
        }
        return cycle;
    }

////////////////////////////////////////////
//  Copy
////////////////////////////////////////////
    /*
    Here we copy the contents from the parameter
    into the obj that executed it.
     */
    public void copy(Intcoll4 obj) {
        ListNode toOverWrite = firstNode;
        firstNode = null;
        ListNode temp = firstNode;
        ListNode copyPasta = obj.firstNode;

        while (copyPasta != null) {
            
            //create the data and pointer for the node to copy over
            temp = new ListNode(copyPasta.number, copyPasta.next); 
            
            //change firstNode's pointer to read the first node if it was empty
            if (firstNode == null) 
                firstNode = temp;
            //insert the node into the node we want to overwrite
            toOverWrite = temp; 
            toOverWrite = toOverWrite.next; //tranverse the list for next loop
            copyPasta = copyPasta.next;     //traverse the list for next loop
        }
        //update how_many soit matches the size of the array we copied
        how_many = obj.how_many; 
    }

    /*
    Prints all contents in the list
     */
////////////////////////////////////////////
//  Print
////////////////////////////////////////////
    public void print() {
        //if (nodeInReverseOrder == true) {
            ListNode P = firstNode;
            while (P != null) {
                System.out.println(P.number);
                P = P.next;
            }
        
        //Print in order the way it was inputted
         
 /*} else {
        ListNode P = firstNode;

        int[] someArray = new int[get_howmany() + 1];

        int i;
        for (i = 0; i < get_howmany(); i++) {
            someArray[i] = P.number;
            P = P.next;
        }

        i = get_howmany() - 1;
        while (i >= 0) {
            System.out.println(someArray[i]);
            i--;*/

        //}
    }

////////////////////////////////////////////
//  Equals
////////////////////////////////////////////
    /*
    Check if two link lists are equal. In this method, we define equality by
    the similarity in:
        a) the integers
        b) what order the integers are in
        c) the size of the link lists
     */
    public boolean equals(Intcoll4 obj) {
        /*
        Before we actually compare the list's contents we check attributes 
        like size and if both firstnode's are null. 
        
        These checks are done beforehand to make the code for
        comparing the elements in the list much more efficient and 
        less lengthy.
         */

        //check if firstNode's pointers are equal, if so they are equal
        if (firstNode != obj.firstNode) {
            //if the size's aren't equal, the lists aren't equal
            //the only time where we ever use how_many!
            if (get_howmany() == obj.get_howmany()) { 
                if (firstNode != null && obj.firstNode != null) {
                    boolean testPass = true;
                    ListNode myCycle = firstNode;
                    ListNode objCycle = obj.firstNode;

                    //end if we reach the end of the list or testPass is false
                    while ((myCycle != null && testPass)) {
                        //check is numbers are equal in node
                        //if so cycle to the next node
                        if (myCycle.number == objCycle.number) {
                            myCycle = myCycle.next;
                            objCycle = objCycle.next;
                        } else {
                            //if numbers aren't equal, the lists aren't equal  
                            testPass = false;
                        }
                    } return testPass;
                } else return true;
            } else return false;
        } else return true;
    }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
//  ListNode
///////////////////////////////////////////////////////////////////////////////

    private class ListNode {

        /*
        I guess I have to explain link lists now....yay...

        ********************************
        Variables
        ********************************
        Firstly, I modified the variable names to be much more 
        obvious what they're meaning is.
        
        Number: is the number the node stores.
        Next: the pointer that is next in the list. 
        
        ********************************
        How objects work
        ********************************
        
        In short, a link list is a lot of pointers.
        In order to understand link lists, it is important to understand that
        an object in java stores a pointer, a memory address that points
        to variable values, not variables themselves.
        
        ********************************
        How a link list works
        ********************************
        
        Each object of ListNode points to a certain node that contains the
        two aforementioned variables. Each node has it's own associated memory
        address.
        
        The "next" variable stores the memory address of the next node.
        When you do cycle = cycle.next, you are changing the pointer of the
        object to point to a different memory address. In this case,
        when you set an object equal to the pointer its pointer stores,
        you are setting the object equal to the next member in the list.
        Once this is done, you can read the variable values stored at
        the memory address that is the next member.
        
        firstNode serves as our "starting point" for our linked list so we
        modifying it to explore our listy. Instead we set a new object equal
        to its pointer.
        
        Here's an example:
        
        @ $13 //our first node, firstNode object points to this momory address
        number = 44
        next = $256
        
        @ $256
        number = 2
        next = null
         */

////////////////////////////////////////////
//  Variables
////////////////////////////////////////////
        private int number;
        private ListNode next;

////////////////////////////////////////////
//  Constructors
////////////////////////////////////////////
        public ListNode() {
            number = 0;
            next = null;
        }

        public ListNode(int i, ListNode n) {
            number = i;
            next = n;
        }
///////////////////////////////////////////////////////////////////////////////
    }
}
