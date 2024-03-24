package com.example.cw_java;

class FoodQueue {
    private int maxCustomers;
    private Customer[] queue;
    private int length;

    public FoodQueue(int maxCustomers) {
        this.maxCustomers = maxCustomers;
        this.queue = new Customer[maxCustomers];
        this.length = 0;
    }

    public boolean isFull() {
        return length == maxCustomers;
    }

    public void addCustomer(Customer customer) {
        if (isFull()) {
            System.out.println("Queue is full. Customer cannot be added.");
        } else {
            queue[length] = customer;
            length++;
        }
    }

    public Customer removeCustomer() {
        if (length > 0) {
            Customer customer = queue[0];
            // Shift the remaining customers to the left
            for (int i = 1; i < length; i++) {
                queue[i - 1] = queue[i];
            }
            length--;
            queue[length] = null;
            return customer;
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }

    public int getLength() {
        return length;
    }

    public boolean containsCustomer(Customer customer) {
        for (int i = 0; i < length; i++) {
            if (queue[i] == customer) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(queue[i]).append("\n");
        }
        return sb.toString();
    }
}