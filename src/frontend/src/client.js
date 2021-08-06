// perform all http request from backend
import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

// get all students
export const getAllStudents = () =>
    //since we proxy through the request in package.json
    fetch("api/v1/students")
        .then(checkStatus);

export const addNewStudent = student =>
    fetch("api/v1/students",{
        headers:{
            'Content-Type':'application/json'
        },
        method: 'POST',
        body: JSON.stringify(student)
        }
    ).then(checkStatus)

export const deleteStudent = studentId =>
    fetch(`api/v1/students/${studentId}`, {
        method: 'DELETE'
    }).then(checkStatus);