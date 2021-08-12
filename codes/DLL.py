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