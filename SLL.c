#include<stdio.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void menu() {
    printf("\n1. View the linked list");
    printf("\n2. Insert into the linked list");
    printf("\n3. Delete from the linked list");
    printf("\n4. Exit");
    printf("\nEnter your choice: ");
}

int insertBeginning(struct Node **current, struct Node *newNode) {
    struct Node *temp;
    if (temp == NULL) {
        temp = newNode;
        *current = temp;
        return 1;
    } else {
        newNode->next = *current;
        head = newNode;
        return 1;
    }
    return -1;
}

int insertEnd(struct Node **current, struct Node *newNode) {
    struct Node *temp;
    if (temp == NULL) {
        temp = newNode;
        *current = temp;
        return 1;
    } else {
        while (temp->next != NULL)
            temp = temp->next;
        temp->next = newNode;
        return 1;
    }
    return -1;
}

void insertPosition(struct Node **current, struct Node *newNode,
                        int position) {
        struct Node *temp, *temp1;
        int count = 0;
        if (temp == NULL) {
            temp = newNode;
            head = temp;
            return 1;
        } else if (position == 0) {
            temp = newNode;
            temp.next = *current;
            *current = temp;
            return 1;
        } else {
            temp = *current;
            while (1) {
                if (count == position) {
                    temp1.next = newNode;
                    newNode.next = temp;
                    return 1;
                }
                temp1 = temp;
                temp = temp.next;
                count = count + 1;
            }
            return 1;
        }
        return -1;
    }

int main() {
    struct Node *head = NULL;
    int choice;
    while (1) {
        menu();
        switch(choice) {
            case 1:
                break;
            default:
                printf("\nWrong choice");
        }
    }
    return 0;
}
