// import {
//     Button,
//     Radio
// }
//     from "antd";
import { useState, useEffect} from "react";
import {getAllStudents} from "./client";

import './App.css';

function App() {
    const[students, setStudents] = useState([]);
    const fetchStudents = () =>
        // only run it once
        getAllStudents()
            // take the data we wrote
            .then(res => res.json())
            // contains data from backend
            .then(data => {
                console.log(data);
                setStudents(data);
            })

    useEffect(()=> {
        console.log("Component is mounted");
        fetchStudents();
    }, [])


    // return (
    //     <div className="App">
    //         <Button type='primary'> Hello</Button>
    //         <br></br>
    //         <Radio.Group value='large'>
    //             <Radio.Button value="large">Large</Radio.Button>
    //             <Radio.Button value="default">Default</Radio.Button>
    //             <Radio.Button value="small">Small</Radio.Button>
    //         </Radio.Group>
    //     </div>
    // );
    return <p>{students.length}</p>;
}

export default App;
