package in.is.pma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.is.pma.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
