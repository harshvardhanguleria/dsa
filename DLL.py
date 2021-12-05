# !/usr/bin/python3

# Doubly Linked List

# Node class
class Node:
    # constructor to initialize a node
    def __init(self, data):
        self.data = data
        self.prev = None
        self.next = None
    
# Doubly Linked List class
class DLL:
    # constructor to initialize head node
    def __init(self):
        self.head = None

    # insert node at the end of the list
    def insertEnd(self, newNode):
        if self.node is None:
            self.head = newNode
        else:
            lastNode = self.head
            while lastNode.next is not None:
                lastNode = lastNode.next
            lastNode.next = newNode
            newNode.prev = lastNode
        print("Node inserted")
    
    # insert node at the beginning of the list
    def insertBeginning(self, newNode):
        if self.head is None:
            self.head = newNode
        else:
            firstNode = newNode
            firstNode.next = self.head
            self.head.prev = firstNode
        print("Node inserted")
    
    # insert node at a specific position in the list
    def insertAtPosition(self, newNode, position):
        if self.head is None:
            self.head = newNode
        elif position == 0:
            firstNode = newNode
            firstNode.next = self.head
            self.head.prev = firstNode
            self.head = firstNode
        else:
            count = 0
            currentNode = self.head
            while True:
                if count == position:
                    previousNode.next = newNode
                    newNode.next = currentNode
                    currentNode.prev = newNode
                    break
                previousNode = currentNode
                currentNode = currentNode.next
                count = count + 1
        print("Node inserted")
    
    # delete node from the end of the list
    def deleteEnd(self):
        if self.head is None:
            return
        lastNode = self.head
        while lastNode.next.next is not None:
            lastNode = lastNode.next
        temp = lastNode.next
        lastNode.next = None
        print("Deleted", lastNode.data)
        del temp

    # delete node from the beginning of the list
    def deleteBeginning(self):
        if self.head is None:
            return
        firstNode = self.head
        self.head = firstNode.next
        self.head.prev = None
        print("Deleted", firstNode.data)
        del firstNode

# Function to print action menu
def printMenu():
    print("\n1. Insert into the linked list\n"+
            "2. Delete node from the linked list\n"+
            "3. View the linked list\n"+
            "4. Reverse the linked list\n"+
            "5. Exit")

# Main function to enable the functionality of the code
def main():
    printMenu()

if __name__ == "__main__":
    main()