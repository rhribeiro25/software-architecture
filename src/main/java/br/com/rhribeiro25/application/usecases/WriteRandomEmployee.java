package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.gateways.EmployeeRepository;
import br.com.rhribeiro25.domain.Department;
import br.com.rhribeiro25.domain.Employee;
import br.com.rhribeiro25.domain.enums.DepartmentEnum;
import br.com.rhribeiro25.domain.enums.RoleEnum;

import java.util.Random;

public class WriteRandomEmployee {

    private EmployeeRepository employeeRepository;

    public WriteRandomEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void writeRandomly(String pathFile) {
        String[] names = {
                "Fergus O'Riley", "Nora Kavanagh", "Patrick Sweeney", "Imelda Farrell", "Owen Quigley",
                "Bernadette McBride", "Ciarán O'Shea", "Aine Walsh", "Eimear Mullan", "Cillian Hughes",
                "Rosaleen Murphy", "Niall Keenan", "Eoghan O'Callaghan", "Dónal Doyle", "Clodagh Brennan",
                "Fiona McKenna", "Aisling Cleary", "Tadhg Healy", "Máire Quinn", "Darragh Keane",
                "Aodhán Malone", "Roisin O'Neill", "Shane Callaghan", "Niamh Reilly", "Ciara Ní Chonchúir",
                "Seán Finn", "Máire Ní Bhraonáin", "Eilis Ní Dhonnchadha", "Rory Gallagher", "Nollaig Lynch",
                "Fionn McCarthy", "Siobhan Ní Mhuirí", "Caitríona O'Brien", "Aidan O'Malley", "Seamus O'Rourke",
                "Liam Morrissey", "Úna Ní Mhórdha", "Deirdre Kavanagh", "Aoife Dunne", "Fergal Byrne",
                "Claire Keane", "Declan Flynn", "Brian O'Mahony", "Orla McDonald", "Ciara Fitzpatrick",
                "Maeve O'Connell", "Lorcan O'Donnell", "Grainne Walsh", "Pádraig Larkin", "Caitlin O'Callaghan"
        };

        Random random = new Random();

        for (int i = 0; i < names.length; i++) {
            String name = names[random.nextInt(names.length)];

            RoleEnum role = RoleEnum.values()[random.nextInt(RoleEnum.values().length)];

            String departmentName = DepartmentEnum.values()[random.nextInt(DepartmentEnum.values().length)].name();

            Employee employee = new Employee.Builder()
                    .role(role)
                    .department(new Department.Builder()
                            .name(departmentName)
                            .build())
                    .build();

            System.out.println("Generated random employee: " + employee.getName() + ", Role: " + employee.getRole() + ", Department: " + employee.getDepartment().getName());

            employeeRepository.write(employee, pathFile);
        }
    }

}