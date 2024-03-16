import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { api_url } from '../../constants';
import Nav from '../Nav';
import { Col, Row, Table } from 'antd';

const GetAppointments = () => {
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    getAllApoinments();
  }, []);

  const getAllApoinments = async () => {
    await axios.get(api_url+"Appointments/AllAppointments").then((response)=>{
      console.log(response)
      setAppointments(response.data);
    }).catch((error)=>{
      console.error('Error fetching appointments:', error);
    })

  };

  const deleteAppointment = async (UserID) => {
  console.log(UserID)
      await axios.delete(api_url+`Appointments/DeleteAppointment/${UserID}`).then((response)=>{
        getAllApoinments();
        alert("Appointment deleted successfully"); 
      }).catch((error)=>{
        console.error('Error deleting appointment:', error);
      });
 
  };
  const columns = [
    {
      title: 'Name',
      dataIndex: 'clientName',
      key: 'name',
    },
    {
      title: 'Email',
      dataIndex: 'clientEmail',
      key: 'clientEmail',
    },
    {
      title: 'Phone',
      dataIndex: 'clientPhone',
      key: 'clientPhone',
    },
    {
      title: 'Appointment Date',
      dataIndex: 'appDate',
      key: 'appDate',
    },
    {
      title: 'Date & Time',
      dataIndex: 'dateTime',
      key: 'dateTime',
    },
    {
      title: 'Checking Type',
      dataIndex: 'checkingType',
      key: 'checkingType',
    },
    {
      title: 'Actions',
    render:(_,record)=>{return ( <button type="button" className="btn btn-danger" onClick={() => deleteAppointment(_.userID)}>Reject</button>
    )},
      key: 'address',
    },
  ];
  return (
    <div>
     <Nav></Nav>
      <br />
      <div style={{marginLeft:"20px",marginRight:"20px"}}>
      <Table columns={columns} dataSource={appointments}/>
      </div>
     

    </div>
  );
};

export default GetAppointments;
