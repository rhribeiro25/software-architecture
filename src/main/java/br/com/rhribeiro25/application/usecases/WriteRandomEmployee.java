package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.shared.enums.DepartmentCodeEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WriteRandomEmployee {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public WriteRandomEmployee(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeResponse> writeRandomly() {
        List<Employee> employeeList = new ArrayList<>();
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

            String departmentCode = DepartmentCodeEnum.values()[random.nextInt(DepartmentCodeEnum.values().length)].name();

            Employee employee = new Employee.Builder()
                    .name(name)
                    .role(role)
                    .salary(BigDecimal.valueOf(2000.00))
                    .departmentCode(departmentCode)
                    .build();

            employeeList.add(repository.save(employee));
        }
        return mapper.toDtoList(employeeList);
    }

}