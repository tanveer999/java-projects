import { useEffect, useState } from "react"

function ListEmployees() {

    const [employees, setEmployees] = useState([])

    useEffect(function () {
        fetch("http://localhost:8080/api/v1/employees")
            .then(response => response.json())
            .then(data => setEmployees(data))
    }, [])

    return (
        <div className="">
            <h2 className="text-center">Employees List</h2>
            <div className="row">
                <div className="table-responsive">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                employees.map((employee) => {
                                    return (
                                        <tr key={employee.id}>
                                            <th scopt="row">{employee.id}</th>
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
        </div>
    )
}

export default ListEmployees

