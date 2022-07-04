import { useState } from "react"

function AddEmployee() {

    const [employee, setEmployee] = useState({
        firstName:"",
        lastName:"",
        emailId:""
    })

    function handleChange(event)  {
        const {name, value} = event.target
        setEmployee(prev => {
            return {
                ...prev,
                [name]: value
            }
        })
    }
    // console.log(employee)

    function handleSubmit(event) {
        event.preventDefault()
        fetch("http://localhost:8080/api/v1/employees/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                firstName: employee.firstName,
                lastName: employee.lastName,
                emailId: employee.emailId
            })
        })
        .then(console.log("post"))
    }

  return (
    <form onSubmit={handleSubmit}>
        <div className="mb-3">
            <label className="form-label" htmlFor="firstName">First Name</label>
            <input 
                type="text"
                className="form-control"
                id="firstName"
                value={employee.firstName}
                name="firstName"
                onChange={handleChange}
            />
        </div>
        <div className="mb-3">
            <label className="form-label" htmlFor="lastName">Last Name</label>
            <input 
                type="text"
                className="form-control"
                id="lastName"
                name="lastName"
                value={employee.lastName}
                onChange={handleChange}
            />
        </div>
        <div className="mb-3">
            <label className="form-label" htmlFor="email">Email</label>
            <input 
                type="email"
                className="form-control"
                id="emailId"
                name="emailId"
                value={employee.emailId}
                onChange={handleChange}
            />
        </div>
        <div className="">
            <button type="submit" className="btn btn-primary">Submit</button>
        </div>
    </form>
  )
}

export default AddEmployee