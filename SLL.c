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

int insertEnd(struct Node *current, int data) {
	struct Node *temp = current;
	if (temp->next == NULL) {
		temp->data = data;
		temp->next = NULL;
	} else {
		while (temp->next != NULL) 
			temp = temp->next;
		
	}    
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
