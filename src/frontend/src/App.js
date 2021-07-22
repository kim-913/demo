// import {
//     Button,
//     Radio
// }
//     from "antd";

import { useState, useEffect} from "react";
import {getAllStudents} from "./client";
import {Layout, Menu, Breadcrumb} from 'antd';
import {
    DesktopOutlined,
    PieChartOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined,
} from '@ant-design/icons';

import './App.css';
const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;

function App() {
    const[students, setStudents] = useState([]);
    const [collapsed, setCollapsed] = useState(false);

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

    // error handling if no students
    if (students.length <= 0){
        return "No student.";
    }

    return <Layout style={{ minHeight: '100vh' }}>
        <Sider collapsible collapsed={collapsed}
               onCollapse={setCollapsed}>
            <div className="logo" />
            <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                <Menu.Item key="1" icon={<PieChartOutlined />}>
                    Option 1
                </Menu.Item>
                <Menu.Item key="2" icon={<DesktopOutlined />}>
                    Option 2
                </Menu.Item>
                <SubMenu key="sub1" icon={<UserOutlined />} title="User">
                    <Menu.Item key="3">Tom</Menu.Item>
                    <Menu.Item key="4">Bill</Menu.Item>
                    <Menu.Item key="5">Alex</Menu.Item>
                </SubMenu>
                <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
                    <Menu.Item key="6">Team 1</Menu.Item>
                    <Menu.Item key="8">Team 2</Menu.Item>
                </SubMenu>
                <Menu.Item key="9" icon={<FileOutlined />}>
                    Files
                </Menu.Item>
            </Menu>
        </Sider>
        <Layout className="site-layout">
            <Header className="site-layout-background" style={{ padding: 0 }} />
            <Content style={{ margin: '0 16px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>User</Breadcrumb.Item>
                    <Breadcrumb.Item>Bill</Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
                    Bill is a cat.
                </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>KimKe ©2021 Created by Ant UED</Footer>
        </Layout>
    </Layout>
    // return students.map((student, index) => {
    //     return <p key={index}>{student.id} {student.name}</p>
    // });
}

export default App;
