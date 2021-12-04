# !/usr/bin/python3

# Singly Linked List implementation in Python

# Node class
class Node:
    # constructor to initialize a node
    def __init__(self, data):
        self.data = data
        self.next = None

# Singly Linked list class
class SLL:
    # constructor to initialize head node
    def __init__(self):
        self.head = None
    
    # insert node at the end of the linked list
    def insertEnd(self, newNode):
        # checking if the linked list is empty or not
        if self.head is None:
            # if the list is empty the we insert the first node
            self.head = newNode
        # if the list is not empty then we take the pointer to the last node
        else:
            lastNode = self.head
            # taking the pointer to the last node
            while lastNode.next is not None:
                lastNode = lastNode.next
            lastNode.next = newNode
        print("Node inserted")
    
    # insert node at the beginning of the linked list
    def insertBeginning(self, newNode):
        # checking if the list is empty or not
        if self.head is None:
            # if the list is empty then we insert the new node as the first node
            self.head = newNode
        # if the list is not empty then we need to insert new node
        # before the first node
        else:
            firstNode = newNode
            # connecting the new node to the first node and
            # making it the first node
            firstNode.next = self.head
            self.head = firstNode
        print("Node inserted")

    # insert node at a specific position in the linked list
    def insertPosition(self, newNode, position):
        # checking if the list is empty or not
        if self.head is None:
            # if the list is empty then we insert the new node
            # as the first node in the list
            self.head = newNode
        # if the user chooses position 0 then
        # we insert the node into the first place
        # and we exit out of the loop
        elif position == 0:
            firstNode = newNode
            firstNode.next = self.head
            self.head = firstNode
        # if the list is not empty then we move to the specified 
        # position and insert the node there by shifting the 
        # node present there by one position each
        else:
            count = 0
            currentNode = self.head
            while True:
                # checking if we have reached the specified 
                # position and inserting the node there and
                # breaking out of the loop
                if count == position:
                    previousNode.next = newNode
                    newNode.next = currentNode
                    break
                # if we haven't reached the specified position
                # we move ahead in the list to the next node
                # and increase count by one
                previousNode = currentNode
                currentNode = currentNode.next
                count = count + 1
        print("Node inserted")

    # delete node from the end of the list
    def deleteEnd(self):
        # checking if the list is empty or not
        if self.head is None:
            return
        # if the list is not empty we move to the last node
        # and delete it
        lastNode = self.head
        while lastNode.next.next is not None:
            lastNode = lastNode.next
        temp = lastNode.next
        lastNode.next = None
        print("Deleted", lastNode.data)
        del temp

    # delete node from the beginning of the list
    def deleteBeginning(self):
        # checking if the list is empty or not
        if self.head is None:
            return
        # if the list is not empty then we delete the first
        # node and make the second one the head
        firstNode = self.head
        self.head = firstNode.next
        print("Deleted", firstNode.data)
        del firstNode

    # delete node at a specified position in the list
    def deletePostion(self, position):
        # checking if the list is empty or not
        if self.head is None:
            return
        # if the list is not empty we move to the specified 
        # position and shift the nodes and delete the
        # node present on that position
        currentNode = self.head
        count = 0
        while True:
            # if the position is the first one then we assign
            # the head position to the next node
            if position == 0:
                self.head = currentNode.next
                break
            # if we reach the specified position then we assign
            # the position of the node to be deleted to the next 
            # node in the list
            elif count == position:
                previousNode.next = currentNode.next
                break
            previousNode = currentNode
            currentNode = currentNode.next
            count = count + 1
        print("Deleted", currentNode.data)
        del currentNode

    # reversing the linked list
    def reverse(self):
        # checking if the list is empty or not
        if self.head is None:
            # we print that the list is empty and exit the function
            print("The list is empty")
            return
        # else we start reversing the list
        else:
            currentNode = self.head
            previousNode = None
            nextNode = None
            # we change the positions of the nodes as we go from head to 
            # the last node in the list and make the last node 
            # head of the list 
            while currentNode is not None:
                nextNode = currentNode.next
                currentNode.next = previousNode
                previousNode = currentNode
                currentNode = nextNode
            self.head = previousNode
            print("The list has been reversed")

    # printing the linked list
    def printList(self):
        # checking if the list is empty or not
        if self.head is None:
            # if the list is empty then we return to the main menu
            print("The list is empty")
            return
        # else we print the list
        currentNode = self.head
        while True:
            if currentNode is None:
                print(None)
                break
            print(currentNode.data, end=' -> ')
            currentNode = currentNode.next

# function to print menu
def printMenu():
    print("\n1. Insert into the linked list\n"+
            "2. Delete node from the linked list\n"+
            "3. View the linked list\n"+
            "4. Reverse the linked list\n"+
            "5. Exit")

# Main function to enable the functionality of the code
def main():
    print("Singly Linked List implementation in Python")
    sll = SLL()
    exit = False
    while exit is not True:
        printMenu()
        choice = int(input("Enter your choice: "))

        # insert a node
        if choice == 1: 
            data = input("Enter data value: ")
            newNode = Node(data)
            print("\n1. Insert in the end\n"+
                    "2. Insert in the beginning\n"+
                    "3. Insert at a specific position")
            choice1 = int(input("Enter your choice: "))

            # passing nodes

            # insert at the end of the list
            if choice1 == 1:
                sll.insertEnd(newNode)
            # insert at the beginning of the list
            elif choice1 == 2:
                sll.insertBeginning(newNode)
            # insert at a specified position
            elif choice1 == 3:
                position = int(input("Enter the position: "))
                sll.insertPosition(newNode, position)

        # delete a node
        elif choice == 2:
            print("\n1. Delete at the end\n"+
                    "2. Delete from the beginning\n"+
                    "3. Delete from a specific position")
            choice2 = int(input("Enter your choice: "))

            # calling functions to delete the node

            # delete at the end of the list
            if choice2 == 1:
                sll.deleteEnd()
            # delete from the beginning of the list
            elif choice2 == 2:
                sll.deleteBeginning()
            # delete from a specific position
            elif choice2 == 3:
                position = int(input("Enter the position: "))
                sll.deletePostion(position)
        
        # print the list
        elif choice == 3:
            sll.printList()

        # reverse the linked list
        elif choice == 4:
            sll.reverse()

        # exit
        elif choice == 5:
            exit = True

if __name__ == "__main__":
    main()