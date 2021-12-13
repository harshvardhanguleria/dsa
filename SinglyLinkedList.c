#include<stdio.h>

struct Node {
    int data;
    struct Node *next;
};

void menu() {
    printf("\n1. View the linked list");
    printf("\n2. Insert into the linked list");
    printf("\n3. Delete from the linked list");
    printf("\n4. Exit");
    printf("\nEnter your choice: ");
}

int main() {
    struct Node *head;
    while (1) {
        menu();
    }
    return 0;
}