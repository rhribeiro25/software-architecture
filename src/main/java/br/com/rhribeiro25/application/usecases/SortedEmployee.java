package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.models.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class SortedEmployee {

    public Employee[] mergeSort(Employee[] employeeList, Comparator<Employee> comparator) {
        if (employeeList.length < 2) {
            return employeeList;
        }

        int mid = employeeList.length / 2;
        Employee[] left = Arrays.copyOfRange(employeeList, 0, mid);
        Employee[] right = Arrays.copyOfRange(employeeList, mid, employeeList.length);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        return merge(employeeList, left, right, comparator);
    }

    private Employee[] merge(Employee[] employeeList, Employee[] left, Employee[] right, Comparator<Employee> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {

            if (comparator.compare(left[i], right[j]) <= 0) {
                employeeList[k++] = left[i++];
            } else {
                employeeList[k++] = right[j++];
            }
        }

        while (i < left.length) {
            employeeList[k++] = left[i++];
        }
        while (j < right.length) {
            employeeList[k++] = right[j++];
        }

        return employeeList;
    }

    public Employee[] bubbleSort(Employee[] employeeList) {

        int length = employeeList.length - 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (employeeList[j].getName().compareTo(employeeList[j + 1].getName()) > 0) {
                    Employee temp = employeeList[j];
                    employeeList[j] = employeeList[j + 1];
                    employeeList[j + 1] = temp;
                }
            }
        }
        return employeeList;
    }

    public Employee[] selectionSort(Employee[] employeeList) {
    
        int length = employeeList.length -1;
        for (int i = 0; i < length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < length; j++) {
                if (employeeList[j].getName().compareTo(employeeList[j + 1].getName()) > 0) {
                    minPosition = j;
                }
            }
            Employee tempPage = employeeList[i];
            employeeList[i] = employeeList[minPosition];
            employeeList[minPosition] = tempPage;
        }
        return employeeList;
    }
}