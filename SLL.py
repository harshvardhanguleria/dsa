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
    #def insertingPosition(self, newNode, position):
        # checking if the list is empty or not
        #if self.head is None:
            # if the list is empty then we insert the new node
            # as the first node in the list
        #    self.head = newNode
        # if the list is not empty then we move to the specified 
        # position and insert the node there by shifting the 
        # next node by one position each
        #else:
        #    count = 0
        #    positionNode = self.head
            # moving to the position one less than the given position
        #    while count is not position - 1:
        #        positionNode = positionNode.next
        #        count = count + 1
        #   print(positionNode.data)
        #    newNode.next = positionNode.next
        #    positionNode.next = newNode
            # shifting and inserting node
            # newNode.next = positionNode.next.next
        #    positionNode = newNode
        #print("Node inserted")

    # delete node from the end of the list
    def deleteEnd(self):
        # checking if the list is empty or not
        if self.head is None:
            return
        # if the list is not empty we move to the last node
        # and delete it
        lastNode = self.head
        while lastNode.next is not None:
            lastNode = lastNode.next
        print("Deleted", lastNode.data)
        del lastNode

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
        positionNode = self.head
        count = 0
        while count is not position - 1:
            positionNode = positionNode.next
            count = count + 1
        temp = positionNode.next
        positionNode.next = temp.next
        print("Deleted", temp.data)
        del temp

    # printing the linked list
    def printList(self):
        # checking of the list is empty or not
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
            "4. Exit")

# main function to run the code
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
                sll.insertingPosition(newNode, position)

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

        # exit
        elif choice == 4:
            exit = True

if __name__ == "__main__":
    main()