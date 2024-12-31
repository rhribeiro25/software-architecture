package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.models.Employee;

import java.util.Arrays;

public class SortedEmployee {

    public void mergeSort(Employee[] employeeList) {

        if (employeeList.length < 2) {
            return;
        }

        int mid = employeeList.length / 2;
        Employee[] left = Arrays.copyOfRange(employeeList, 0, mid);
        Employee[] right = Arrays.copyOfRange(employeeList, mid, employeeList.length);

        mergeSort(left);
        mergeSort(right);

        merge(employeeList, left, right);
    }

    private void merge(Employee[] employeeList, Employee[] left, Employee[] right) {

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].getName().compareTo(right[j].getName()) <= 0) {
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
    }

    public void bubbleSort(Employee[] employeeList) {

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
    }

    public void selectionSort(Employee[] employeeList) {
    
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
    }
}