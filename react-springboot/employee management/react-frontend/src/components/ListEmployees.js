import { useEffect, useState } from "react"

function ListEmployees() {

    const [employees, setEmployees] = useState([])

    useEffect(function() {
        fetch("http://localhost:8080/api/v1/employees")
        .then(response => response.json())
        .then(data => setEmployees(data))
    }, [])

    return (
        <div className="">
            <h2 className="text-center">Employees List</h2>
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            employees.map((employee) => {
                                return (
                                    <tr key={employee.id}>
                                        <td>{employee.firstName}</td>
                                        <td>{employee.lastName}</td>
                                        <td>{employee.emailId}</td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ListEmployees

