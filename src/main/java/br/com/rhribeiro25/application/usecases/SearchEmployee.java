package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.models.Employee;

public class SearchEmployee {

    private final SortedEmployee sortedEmployee;

    public SearchEmployee(SortedEmployee sortedEmployee) {
        this.sortedEmployee = sortedEmployee;
    }


    public Employee binarySearchEmployee(Employee[] employeeList, String name) {

        sortedEmployee.mergeSort(employeeList);

        int low = 0;
        int high = employeeList.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparison = employeeList[mid].getName().trim().compareTo(name.trim());

            if (comparison == 0) {
                return employeeList[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public Employee[] linearSearchByRole(Employee[] employeeList, int role, int index) {

        if (index >= employeeList.length) {
            return new Employee[0];
        }

        if (employeeList[index].getRole().getKey() == role) {
            Employee[] result = linearSearchByRole(employeeList, role, index + 1);
            Employee[] newResult = new Employee[result.length + 1];
            newResult[0] = employeeList[index];
            System.arraycopy(result, 0, newResult, 1, result.length);
            return newResult;
        } else {
            return linearSearchByRole(employeeList, role, index + 1);
        }
    }

    public Employee[] linearSearchByDepartment(Employee[] employeeList, int depKey, int index) {

        if (index >= employeeList.length) {
            return new Employee[0];
        }

//        if (DepartmentCodeEnum.valueOf(employeeList[index].getDepartment().getName()).getKey() == depKey) {
//            Employee[] result = linearSearchByDepartment(employeeList, depKey, index + 1);
//            Employee[] newResult = new Employee[result.length + 1];
//            newResult[0] = employeeList[index];
//            System.arraycopy(result, 0, newResult, 1, result.length);
//            return newResult;
//        } else {
//            return linearSearchByDepartment(employeeList, depKey, index + 1);
//        }
        return null;
    }

}